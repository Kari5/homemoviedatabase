/**
 * 
 */
package hu.bme.tesslo.hmdb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.jboss.seam.annotations.security.management.UserFirstName;
import org.jboss.seam.annotations.security.management.UserLastName;
import org.jboss.seam.annotations.security.management.UserPassword;
import org.jboss.seam.annotations.security.management.UserPrincipal;
import org.jboss.seam.annotations.security.management.UserRoles;

/**
 * Egy felhasználót reprezentáló entitás.
 * 
 * @author Karcsi
 * 
 */
@Entity(name = "User_")
public class User implements Serializable {

	/**
	 * Sorosíthatósághoz azonosító.
	 */
	private static final long serialVersionUID = -6105056252666418484L;

	/**
	 * Azonosító.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * Felhasználónév.
	 */
	@Column(nullable = false)
	@UserPrincipal
	private String userName;

	/**
	 * Jelszó. (Adatbázisban md5 hash-elt formában tárolódik.)
	 */
	@Column(nullable = false)
	@UserPassword(hash = "md5")
	private String password;

	/**
	 * Keresztnév.
	 */
	@UserFirstName
	private String firstName;

	/**
	 * Vezetéknév.
	 */
	@UserLastName
	private String lastName;

	/**
	 * Felhasználóhoz rendelt szabályok.
	 */
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "Role_User", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	@UserRoles
	private List<Role> roles;

	/**
	 * Felhasználó kedvenc filmjei.
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Movie> favoriteMovies;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Movie> getFavoriteMovies() {
		return favoriteMovies;
	}

	public void setFavoriteMovies(List<Movie> favoriteMovies) {
		this.favoriteMovies = favoriteMovies;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((getUserName() == null) ? 0 : getUserName().hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (getUserName() == null) {
			if (other.getUserName() != null)
				return false;
		} else if (!getUserName().equals(other.getUserName()))
			return false;
		return true;
	}

}
