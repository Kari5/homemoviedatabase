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
 * Felhasználó azonosításáért felelõs osztály.
 * 
 * @author Karcsi
 * 
 */
@Name("authenticator")
public class Authenticator {
	/**
	 * Logoláshoz logger.
	 */
	@Logger
	private Log log;

	/**
	 * Azonosításhoz identity.
	 */
	@In
	Identity identity;

	/**
	 * Felhasználó adatai.
	 */
	@In
	Credentials credentials;

	/**
	 * IdentityManager.
	 */
	@In
	IdentityManager identityManager;

	/**
	 * User_ táblához való hozzáférés.
	 */
	UserDao userDao;

	/**
	 * Autentikációs függvény. Az identityManager beépített authenticate
	 * függvényét használja. A felhasználóhoz tartozó role-okat a userDao-n
	 * keresztül kérdezi le.
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
