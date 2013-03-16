package hu.bme.dtt.torusalbum.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Table for storing sensitive Search Engine data.
 * 
 * @author Shazak
 * 
 */
@Entity
public class SearchEngine {
	/**
	 * Primary key.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;
	/**
	 * The name of the SearchEngine.
	 */
	@Column(name = "ENGINE_NAME")
	private String engineName;
	/**
	 * The API key.
	 */
	@Column(name = "API_KEY")
	private String apiKey;
	/**
	 * The custom search engine ID to scope this search query.
	 */
	@Column(name = "CX_KEY")
	private String cxKey;
	/**
	 * The URL of a linked custom search engine.
	 */
	@Column(name = "CREF_KEY")
	private String crefKey;

	/**
	 * @return Primary key.
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            Primary key.
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return The name of the SearchEngine.
	 */
	public String getEngineName() {
		return engineName;
	}

	/**
	 * @param engineName
	 *            The name of the SearchEngine.
	 */
	public void setEngineName(String engineName) {
		this.engineName = engineName;
	}

	/**
	 * @return The API key.
	 */
	public String getApiKey() {
		return apiKey;
	}

	/**
	 * @param apiKey
	 *            The API key.
	 */
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	/**
	 * @return The custom search engine ID to scope this search query.
	 */
	public String getCxKey() {
		return cxKey;
	}

	/**
	 * @param cxKey
	 *            The custom search engine ID to scope this search query.
	 */
	public void setCxKey(String cxKey) {
		this.cxKey = cxKey;
	}

	/**
	 * @return The URL of a linked custom search engine.
	 */
	public String getCrefKey() {
		return crefKey;
	}

	/**
	 * @param crefKey
	 *            The URL of a linked custom search engine.
	 */
	public void setCrefKey(String crefKey) {
		this.crefKey = crefKey;
	}
}
