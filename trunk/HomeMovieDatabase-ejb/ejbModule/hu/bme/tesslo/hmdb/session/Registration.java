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
					"Adj meg egy felhaszn�l�nevet �s jelsz�t!");
			LOGGER.info("Felhaszn�l�n�v vagy jelsz� nem lett megadva!");
			return "#";
		}
		if (identityStore.userExists(credentials.getUsername())) {
			FacesMessages.instance().add(
					"Felhaszn�l�: #{credentials.username} m�r l�tezik!");
			LOGGER.info("Felhaszn�l�n�v m�r l�tezik!");
			return "#";
		}
		if (!credentials.getPassword().equals(passwordVerify)) {
			FacesMessages.instance().add(
					"A megadott jelsz� nem egyezik a meger�s�t� jelsz�val!");
			LOGGER.info("A megadott jelsz� nem egyezik a meger�s�t� jelsz�val!");
			return "#";
		}

		newUser.setUserName(credentials.getUsername());
		newUser.setPassword(credentials.getPassword());
		if (identityStore.createUser(newUser.getUserName(),
				newUser.getPassword(), newUser.getFirstName(),
				newUser.getLastName())) {
			FacesMessages.instance().add("Sikeres ment�s!");
			LOGGER.info("Sikeres ment�s!");
			return "home";
		}
		FacesMessages.instance().add("V�ratlan hiba!");
		LOGGER.info("V�ratlan hiba!");
		return "#";
	}

}
