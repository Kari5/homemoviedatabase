/**
 * 
 */
package hu.bme.tesslo.hmdb.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.validator.NotNull;

/**
 * Egy értékelést reprezentáló entitás.
 * 
 * @author Karcsi
 * 
 */
@Entity
public class Rating implements Serializable {

	/**
	 * Sorosíthatósághoz azonosító.
	 */
	private static final long serialVersionUID = -7834717990858215899L;

	/**
	 * Azonosító.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * A felhasználó, aki felvette az értékelést.
	 */
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId")
	@NotNull
	private User user;

	/**
	 * A film, amihez tartozik az értékelés.
	 */
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@NotNull
	private Movie movie;

	/**
	 * Hang minõség.
	 */
	private Integer audio;

	/**
	 * Videó minõség.
	 */
	private Integer video;

	/**
	 * Összesített érték.
	 */
	private Integer summa;

	/**
	 * Szöveges összefoglaló, comment.
	 */
	@Column(length = 8000)
	private String summary;

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
	 * @return the movie
	 */
	public Movie getMovie() {
		return movie;
	}

	/**
	 * @param movie
	 *            the movie to set
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	/**
	 * @return the audio
	 */
	public Integer getAudio() {
		return audio;
	}

	/**
	 * @param audio
	 *            the audio to set
	 */
	public void setAudio(Integer audio) {
		this.audio = audio;
	}

	/**
	 * @return the video
	 */
	public Integer getVideo() {
		return video;
	}

	/**
	 * @param video
	 *            the video to set
	 */
	public void setVideo(Integer video) {
		this.video = video;
	}

	/**
	 * @return the summa
	 */
	public Integer getSumma() {
		return summa;
	}

	/**
	 * @param summa
	 *            the summa to set
	 */
	public void setSumma(Integer summa) {
		this.summa = summa;
	}

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary
	 *            the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
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
				+ ((getMovie() == null) ? 0 : getMovie().hashCode());
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
		Rating other = (Rating) obj;
		if (getMovie() == null) {
			if (other.getMovie() != null)
				return false;
		} else if (!getMovie().equals(other.getMovie()))
			return false;
		if (getUser() == null) {
			if (other.getUser() != null)
				return false;
		} else if (!getUser().equals(other.getUser()))
			return false;
		return true;
	}

}
