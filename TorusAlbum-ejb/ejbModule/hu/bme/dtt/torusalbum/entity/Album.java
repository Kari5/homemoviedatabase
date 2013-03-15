/**
 * 
 */
package hu.bme.dtt.torusalbum.entity;

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

import org.jboss.seam.annotations.security.management.UserRoles;

/**
 * @author Karcsi
 * 
 */
@Entity
public class Album implements Serializable {

	/**
	 * Sorosíthatósághoz azonosító.
	 */
	private static final long serialVersionUID = -596380081468869442L;

	/** Egyedi azonosító. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/** Cím. */
	private String title;

	/**
	 * Albumban lévõ képek.
	 */
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "Picture_Album", joinColumns = @JoinColumn(name = "ALBUM_ID"), inverseJoinColumns = @JoinColumn(name = "PICTURE_ID"))
	@UserRoles
	private List<Picture> pictures;

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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the pictures
	 */
	public List<Picture> getPictures() {
		return pictures;
	}

	/**
	 * @param pictures
	 *            the pictures to set
	 */
	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
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
				+ ((getPictures() == null) ? 0 : getPictures().hashCode());
		result = prime * result
				+ ((getTitle() == null) ? 0 : getTitle().hashCode());
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
		Album other = (Album) obj;
		if (getPictures() == null) {
			if (other.getPictures() != null)
				return false;
		} else if (!getPictures().equals(other.getPictures()))
			return false;
		if (getTitle() == null) {
			if (other.getTitle() != null)
				return false;
		} else if (!getTitle().equals(other.getTitle()))
			return false;
		return true;
	}

}
