package hu.bme.tesslo.hmdb.session;

import hu.bme.tesslo.hmdb.dao.UserDao;
import hu.bme.tesslo.hmdb.model.Role;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;
import org.jboss.seam.security.management.IdentityManager;

/**
 * Felhaszn�l� azonos�t�s��rt felel�s oszt�ly.
 * 
 * @author Karcsi
 * 
 */
@Name("authenticator")
public class Authenticator {
	/**
	 * Logol�shoz logger.
	 */
	@Logger
	private Log log;

	/**
	 * Azonos�t�shoz identity.
	 */
	@In
	Identity identity;

	/**
	 * Felhaszn�l� adatai.
	 */
	@In
	Credentials credentials;

	/**
	 * IdentityManager.
	 */
	@In
	IdentityManager identityManager;

	/**
	 * User_ t�bl�hoz val� hozz�f�r�s.
	 */
	UserDao userDao;

	/**
	 * Autentik�ci�s f�ggv�ny. Az identityManager be�p�tett authenticate
	 * f�ggv�ny�t haszn�lja. A felhaszn�l�hoz tartoz� role-okat a userDao-n
	 * kereszt�l k�rdezi le.
	 * 
	 * @return
	 */
	public boolean authenticate() {
		log.info("authenticating {0}", credentials.getUsername());
		if (identityManager.authenticate(credentials.getUsername(),
				credentials.getPassword())) {
			if (userDao == null) {
				try {
					userDao = InitialContext
							.doLookup("HomeMovieDatabase-ear/userDao/local");
				} catch (NamingException e) {
					identity.addRole("user");
					return true;
				}
			}
			for (Role role : userDao.getUser(credentials.getUsername())
					.getRoles()) {
				identity.addRole(role.getName());
			}
			return true;
		}
		return false;
	}

}
