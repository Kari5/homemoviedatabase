package hu.bme.tesslo.hmdb.session;

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

	public boolean authenticate() {
		log.info("authenticating {0}", credentials.getUsername());
		if (identityManager.authenticate(credentials.getUsername(),
				credentials.getPassword())) {
			return true;
		}
		return false;
	}

}
