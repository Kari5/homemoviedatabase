package hu.bme.tesslo.hmdb.session;

import hu.bme.tesslo.hmdb.model.User;

import org.jboss.logging.Logger;
import org.jboss.seam.Component;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.management.IdentityStore;
import org.jboss.seam.security.management.JpaIdentityStore;

@Name("registrationBackBean")
@Scope(ScopeType.PAGE)
public class Registration {

	@In
	private Credentials credentials;

	private IdentityStore identityStore;

	private String passwordVerify;

	private User newUser;

	private static final Logger LOGGER = Logger.getLogger(Authenticator.class);

	@Create
	public void init() {
		newUser = new User();
		identityStore = (IdentityStore) Component.getInstance(
				JpaIdentityStore.class, true);
	}

	public User getNewUser() {
		return newUser;
	}

	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}

	/**
	 * @return the passwordVerify
	 */
	public String getPasswordVerify() {
		return passwordVerify;
	}

	/**
	 * @param passwordVerify
	 *            the passwordVerify to set
	 */
	public void setPasswordVerify(String passwordVerify) {
		this.passwordVerify = passwordVerify;
	}

	public String saveNewUser() {
		if (credentials.getUsername().isEmpty()
				|| credentials.getPassword().isEmpty()) {
			FacesMessages.instance().add(
					"Adj meg egy felhasználónevet és jelszót!");
			LOGGER.info("Felhasználónév vagy jelszó nem lett megadva!");
			return "#";
		}
		if (identityStore.userExists(credentials.getUsername())) {
			FacesMessages.instance().add(
					"Felhasználó: #{credentials.username} már létezik!");
			LOGGER.info("Felhasználónév már létezik!");
			return "#";
		}
		if (!credentials.getPassword().equals(passwordVerify)) {
			FacesMessages.instance().add(
					"A megadott jelszó nem egyezik a megerõsítõ jelszóval!");
			LOGGER.info("A megadott jelszó nem egyezik a megerõsítõ jelszóval!");
			return "#";
		}

		newUser.setUserName(credentials.getUsername());
		newUser.setPassword(credentials.getPassword());
		if (identityStore.createUser(newUser.getUserName(),
				newUser.getPassword(), newUser.getFirstName(),
				newUser.getLastName())) {
			FacesMessages.instance().add("Sikeres mentés!");
			LOGGER.info("Sikeres mentés!");
			return "home";
		}
		FacesMessages.instance().add("Váratlan hiba!");
		LOGGER.info("Váratlan hiba!");
		return "#";
	}

}
