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
 * @author Karcsi
 * 
 */
@Entity
public class Rating implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7834717990858215899L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId")
	@NotNull
	private User user;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@NotNull
	private Movie movie;

	private Integer audio;

	private Integer video;

	private Integer summa;

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
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
