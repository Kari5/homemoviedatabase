/**
 * 
 */
package hu.bme.tesslo.hmdb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 * Elõzmények osztály. Tárolja egy felhasználó által megtekintett filmeket.
 * 
 * @author Karcsi
 * 
 */
@Entity
public class Antecendents implements Serializable {

	/**
	 * Sorosíthatósághoz azonosító.
	 */
	private static final long serialVersionUID = 4340882746130458731L;

	/**
	 * Azonosító.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * Felhasználó.
	 */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_antecendents_id")
	private User user;

	/**
	 * Felhasználó elõzményei.
	 */
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "MoviesAntecendent")
	private List<Movie> movies;

	/**
	 * Default konstruktor.
	 */
	public Antecendents() {
		super();
	}

	/**
	 * Konstruktor értékátadással.
	 * 
	 * @param user
	 * @param movies
	 */
	public Antecendents(User user, List<Movie> movies) {
		super();
		this.user = user;
		this.movies = movies;
	}

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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the movies
	 */
	public List<Movie> getMovies() {
		return movies;
	}

	/**
	 * @param movies
	 *            the movies to set
	 */
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
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
				+ ((getUser() == null) ? 0 : getUser().hashCode());
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
		Antecendents other = (Antecendents) obj;
		if (getUser() == null) {
			if (other.getUser() != null)
				return false;
		} else if (!getUser().equals(other.getUser()))
			return false;
		return true;
	}

}
