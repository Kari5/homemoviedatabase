package hu.bme.dtt.torusalbum.util.search.model.information;

/**
 * Encapsulates all information about the search.
 * 
 * @author Shazak
 * 
 */
public class SearchInformation {
	/**
	 * The time taken for the server to return search results.
	 */
	private Double searchTime;
	/**
	 * The time taken for the server to return search results, formatted
	 * according to locale style.
	 */
	private String formattedSearchTime;
	/**
	 * The total number of search results returned by the query.
	 */
	private Long totalResults;
	/**
	 * The total number of search results, formatted according to locale style.
	 */
	private String formattedTotalResults;

	/**
	 * @return The time taken for the server to return search results.
	 */
	public Double getSearchTime() {
		return searchTime;
	}

	/**
	 * @param searchTime
	 *            The time taken for the server to return search results.
	 */
	public void setSearchTime(Double searchTime) {
		this.searchTime = searchTime;
	}

	/**
	 * @return The time taken for the server to return search results, formatted
	 *         according to locale style.
	 */
	public String getFormattedSearchTime() {
		return formattedSearchTime;
	}

	/**
	 * @param formattedSearchTime
	 *            The time taken for the server to return search results,
	 *            formatted according to locale style.
	 */
	public void setFormattedSearchTime(String formattedSearchTime) {
		this.formattedSearchTime = formattedSearchTime;
	}

	/**
	 * @return The total number of search results returned by the query.
	 */
	public Long getTotalResults() {
		return totalResults;
	}

	/**
	 * @param totalResults
	 *            The total number of search results returned by the query.
	 */
	public void setTotalResults(Long totalResults) {
		this.totalResults = totalResults;
	}

	/**
	 * @return The total number of search results, formatted according to locale
	 *         style.
	 */
	public String getFormattedTotalResults() {
		return formattedTotalResults;
	}

	/**
	 * @param formattedTotalResults
	 *            The total number of search results, formatted according to
	 *            locale style.
	 */
	public void setFormattedTotalResults(String formattedTotalResults) {
		this.formattedTotalResults = formattedTotalResults;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Type: SearchInformation \n##### SEARCHINFORMATION #####\nsearchTime=");
		builder.append(searchTime);
		builder.append(",\nformattedSearchTime=");
		builder.append(formattedSearchTime);
		builder.append(",\ntotalResults=");
		builder.append(totalResults);
		builder.append(",\nformattedTotalResults=");
		builder.append(formattedTotalResults);
		builder.append("\n##### SEARCHINFORMATION #####");
		return builder.toString();
	}
}
