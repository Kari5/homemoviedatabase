/**
 * 
 */
package hu.bme.tesslo.hmdb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Egy filmet reprezentáló entitás.
 * 
 * @author Karcsi
 * 
 */
@Entity
public class Movie implements Serializable {

	/**
	 * Sorosíthatósághoz azonosító.
	 */
	private static final long serialVersionUID = 7414878086887048639L;

	/** Egyedi azonosító. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/** Cím. */
	@Column(nullable = false)
	private String title;

	/** Megjelenés éve. */
	private Integer year;

	/** Hossza. */
	private String runtime;

	/** Mûfaj. */
	private String genere;

	/** Rendezõ. */
	private String director;

	/** Író. */
	private String writer;

	/** Szereplõk. */
	@Column(length = 8000)
	private String actors;

	/** Összefoglaló. */
	@Column(length = 8000)
	private String plot;

	/** Poster képe. */
	private String posterUrl;

	/** Imdb értékelése. */
	private Double imdbRating;

	/** Imdb azonosítója. */
	private String imdbID;

	/** Helyi elérési útvonala. */
	private String localUrl;

	/**
	 * Default konstruktor.
	 */
	public Movie() {
		super();
	}

	/**
	 * Konstruktor értékátadással.
	 * 
	 * @param title
	 * @param year
	 * @param runtime
	 * @param genere
	 * @param director
	 * @param writer
	 * @param actors
	 * @param plot
	 * @param posterUrl
	 * @param imdbRating
	 * @param imdbID
	 * @param localUrl
	 */

	public Movie(String title, Integer year, String runtime, String genere,
			String director, String writer, String actors, String plot,
			String posterUrl, Double imdbRating, String imdbID, String localUrl) {
		super();
		this.title = title;
		this.year = year;
		this.runtime = runtime;
		this.genere = genere;
		this.director = director;
		this.writer = writer;
		this.actors = actors;
		this.plot = plot;
		this.posterUrl = posterUrl;
		this.imdbRating = imdbRating;
		this.imdbID = imdbID;
		this.localUrl = localUrl;
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
	 * @return the year
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * @return the runtime
	 */
	public String getRuntime() {
		return runtime;
	}

	/**
	 * @param runtime
	 *            the runtime to set
	 */
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	/**
	 * @return the genere
	 */
	public String getGenere() {
		return genere;
	}

	/**
	 * @param genere
	 *            the genere to set
	 */
	public void setGenere(String genere) {
		this.genere = genere;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @param director
	 *            the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * @return the writer
	 */
	public String getWriter() {
		return writer;
	}

	/**
	 * @param writer
	 *            the writer to set
	 */
	public void setWriter(String writer) {
		this.writer = writer;
	}

	/**
	 * @return the actors
	 */
	public String getActors() {
		return actors;
	}

	/**
	 * @param actors
	 *            the actors to set
	 */
	public void setActors(String actors) {
		this.actors = actors;
	}

	/**
	 * @return the plot
	 */
	public String getPlot() {
		return plot;
	}

	/**
	 * @param plot
	 *            the plot to set
	 */
	public void setPlot(String plot) {
		this.plot = plot;
	}

	/**
	 * @return the posterUrl
	 */
	public String getPosterUrl() {
		return posterUrl;
	}

	/**
	 * @param posterUrl
	 *            the posterUrl to set
	 */
	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}

	/**
	 * @return the imdbRating
	 */
	public Double getImdbRating() {
		return imdbRating;
	}

	/**
	 * @param imdbRating
	 *            the imdbRating to set
	 */
	public void setImdbRating(Double imdbRating) {
		this.imdbRating = imdbRating;
	}

	/**
	 * @return the imdbID
	 */
	public String getImdbID() {
		return imdbID;
	}

	/**
	 * @param imdbID
	 *            the imdbID to set
	 */
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	/**
	 * @return the localUrl
	 */
	public String getLocalUrl() {
		return localUrl;
	}

	/**
	 * @param localUrl
	 *            the localUrl to set
	 */
	public void setLocalUrl(String localUrl) {
		this.localUrl = localUrl;
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
				+ ((getActors() == null) ? 0 : getActors().hashCode());
		result = prime * result
				+ ((director == null) ? 0 : director.hashCode());
		result = prime * result + ((genere == null) ? 0 : genere.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imdbID == null) ? 0 : imdbID.hashCode());
		result = prime * result
				+ ((imdbRating == null) ? 0 : imdbRating.hashCode());
		result = prime * result
				+ ((localUrl == null) ? 0 : localUrl.hashCode());
		result = prime * result + ((plot == null) ? 0 : plot.hashCode());
		result = prime * result
				+ ((posterUrl == null) ? 0 : posterUrl.hashCode());
		result = prime * result + ((runtime == null) ? 0 : runtime.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((writer == null) ? 0 : writer.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		Movie other = (Movie) obj;

		if (getImdbID() == null) {
			if (other.getImdbID() != null)
				return false;
		} else if (!getImdbID().equals(other.getImdbID()))
			return false;

		if (getLocalUrl() == null) {
			if (other.getLocalUrl() != null)
				return false;
		} else if (!getLocalUrl().equals(other.getLocalUrl()))
			return false;

		if (getTitle() == null) {
			if (other.getTitle() != null)
				return false;
		} else if (!getTitle().equals(other.getTitle()))
			return false;

		if (getYear() == null) {
			if (other.getYear() != null)
				return false;
		} else if (!getYear().equals(other.getYear()))
			return false;
		return true;
	}

}
