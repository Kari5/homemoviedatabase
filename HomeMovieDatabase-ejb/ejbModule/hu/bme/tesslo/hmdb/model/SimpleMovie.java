package hu.bme.tesslo.hmdb.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)            
@XmlType
public class SimpleMovie {
	
	/** Cím. */
	private String title;

	/** Megjelenés éve. */
	private Integer year;

	/** Hossza. */
	private String runtime;

	/** Mûfaj. */
	private String genre;

	/** Rendezõ. */
	private String director;

	/** Író. */
	private String writer;

	/** Szereplõk. */
	private String actors;

	/** Összefoglaló. */
	private String plot;

	/** Imdb értékelése. */
	private Double imdbRating;

	/** Imdb azonosítója. */
	private String imdbID;
	
	/** A film nyelve. */
	private String language;
	/**
	 * Default konstruktor.
	 */
	public SimpleMovie() {
		super();
	}
	
	/**
	 * Konstruktor egy film átadásával.
	 * A filmbõl létrehozza az egyszerûsített film objektumot.
	 * @param movie film
	 */
	public SimpleMovie(Movie movie) {
		this.title=movie.getTitle();
		this.actors=movie.getActors();
		this.director=movie.getActors();
		this.genre=movie.getActors();
		this.imdbID=movie.getImdbID();
		this.imdbRating=movie.getImdbRating();
		this.language=movie.getLanguage();
		this.plot=movie.getPlot();
		this.runtime=movie.getRuntime();
		this.writer=movie.getWriter();
		this.year=movie.getYear();
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
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
	 * @param year the year to set
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
	 * @param runtime the runtime to set
	 */
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @param director the director to set
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
	 * @param writer the writer to set
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
	 * @param actors the actors to set
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
	 * @param plot the plot to set
	 */
	public void setPlot(String plot) {
		this.plot = plot;
	}

	/**
	 * @return the imdbRating
	 */
	public Double getImdbRating() {
		return imdbRating;
	}

	/**
	 * @param imdbRating the imdbRating to set
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
	 * @param imdbID the imdbID to set
	 */
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
}
