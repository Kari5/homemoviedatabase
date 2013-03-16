package hu.bme.dtt.torusalbum.util.search.model.spelling;

/**
 * Encapsulates a corrected query.
 * 
 * @author Shazak
 * 
 */
public class Spelling {
	/**
	 * The corrected query.
	 */
	private String correctedQuery;
	/**
	 * The corrected query, formatted in HTML.
	 */
	private String htmlCorrectedQuery;

	/**
	 * @return The corrected query.
	 */
	public String getCorrectedQuery() {
		return correctedQuery;
	}

	/**
	 * @param correctedQuery
	 *            The corrected query.
	 */
	public void setCorrectedQuery(String correctedQuery) {
		this.correctedQuery = correctedQuery;
	}

	/**
	 * @return The corrected query, formatted in HTML.
	 */
	public String getHtmlCorrectedQuery() {
		return htmlCorrectedQuery;
	}

	/**
	 * @param htmlCorrectedQuery
	 *            The corrected query, formatted in HTML.
	 */
	public void setHtmlCorrectedQuery(String htmlCorrectedQuery) {
		this.htmlCorrectedQuery = htmlCorrectedQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Type: Spelling \n##### SPELLING #####\ncorrectedQuery=");
		builder.append(correctedQuery);
		builder.append(",\nhtmlCorrectedQuery=");
		builder.append(htmlCorrectedQuery);
		builder.append("\n##### SPELLING #####");
		return builder.toString();
	}
}
