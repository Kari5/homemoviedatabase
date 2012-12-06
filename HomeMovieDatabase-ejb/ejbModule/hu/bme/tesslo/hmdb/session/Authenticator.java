package hu.bme.tesslo.hmdb.session;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import hu.bme.tesslo.hmdb.dao.UserDao;
import hu.bme.tesslo.hmdb.model.Role;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;
import org.jboss.seam.security.management.IdentityManager;

@Name("authenticator")
public class Authenticator {
	@Logger
	private Log log;

	@In
	Identity identity;
	@In
	Credentials credentials;
	@In
	IdentityManager identityManager;
	
	UserDao userDao;
	
	public boolean authenticate() {
		log.info("authenticating {0}", credentials.getUsername());
		if (identityManager.authenticate(credentials.getUsername(),
				credentials.getPassword())) {
			if(userDao==null){
				try {
					userDao=InitialContext.doLookup("HomeMovieDatabase-ear/userDao/local");
				} catch (NamingException e) {
					identity.addRole("user");
					return true;
				}
			}
			for(Role role:userDao.getUser(credentials.getUsername()).getRoles()){
				identity.addRole(role.getName());
			}
			return true;
		}
		return false;
	}

}
