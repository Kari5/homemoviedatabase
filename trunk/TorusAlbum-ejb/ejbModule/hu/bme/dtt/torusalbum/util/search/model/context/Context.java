package hu.bme.dtt.torusalbum.util.search.model.context;

import hu.bme.dtt.torusalbum.util.search.model.context.facet.Facet;

import java.util.List;

/**
 * Metadata about the particular search engine that was used for performing the
 * search query.
 * 
 * @author Shazak
 * 
 */
public class Context {
	/**
	 * The name of the search engine that was used for the query.
	 */
	private String title;
	/**
	 * A set of facet objects (refinements) you can use for refining a search.
	 */
	private List<Facet> facets;

	/**
	 * @return The name of the search engine that was used for the query.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            The name of the search engine that was used for the query.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return A set of facet objects (refinements) you can use for refining a
	 *         search.
	 */
	public List<Facet> getFacets() {
		return facets;
	}

	/**
	 * @param facets
	 *            A set of facet objects (refinements) you can use for refining
	 *            a search.
	 */
	public void setFacets(List<Facet> facets) {
		this.facets = facets;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Type: Context \ntitle=");
		builder.append(title);
		builder.append(",\nfacets=");
		builder.append(facets);
		return builder.toString();
	}
}
