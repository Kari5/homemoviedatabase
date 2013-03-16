package hu.bme.dtt.torusalbum.util.search.model.queries;

import hu.bme.dtt.torusalbum.util.search.model.queries.roles.Correction;
import hu.bme.dtt.torusalbum.util.search.model.queries.roles.Example;
import hu.bme.dtt.torusalbum.util.search.model.queries.roles.NextPage;
import hu.bme.dtt.torusalbum.util.search.model.queries.roles.PreviousPage;
import hu.bme.dtt.torusalbum.util.search.model.queries.roles.Related;
import hu.bme.dtt.torusalbum.util.search.model.queries.roles.Request;
import hu.bme.dtt.torusalbum.util.search.model.queries.roles.Subset;
import hu.bme.dtt.torusalbum.util.search.model.queries.roles.Superset;

import java.util.Arrays;

/**
 * An array of metadata query objects describing possible roles. The "request"
 * role is always present and has exactly one object, representing the current
 * request. The "correction" role might provide several possible alternatives.
 * 
 * @author Shazak
 * 
 */
public class Queries {
	/**
	 * Represents a search query that can be performed to improve the result
	 * set, such as with a spelling correction.
	 */
	private Correction[] correction;
	/**
	 * Represents a search query that can be performed to demonstrate the search
	 * engine.
	 */
	private Example[] example;
	/**
	 * Represents a search query that can be performed to retrieve the next page
	 * of the result list.
	 */
	private NextPage[] nextPage;
	/**
	 * Represents a search query that can be performed to retrieve the previous
	 * page of the result list.
	 */
	private PreviousPage[] previousPage;
	/**
	 * Represents a search query that can be performed to retrieve similar but
	 * different search results.
	 */
	private Related[] related;
	/**
	 * Represents the search query that can be performed to retrieve the same
	 * set of search results.
	 */
	private Request[] request;
	/**
	 * Represents a search query that will narrow the current set of search
	 * results.
	 */
	private Subset[] subset;
	/**
	 * Represents a search query that will broaden the current set of search
	 * results.
	 */
	private Superset[] superset;

	/**
	 * @return the correction
	 */
	public Correction[] getCorrection() {
		return correction;
	}

	/**
	 * @param correction
	 *            the correction to set
	 */
	public void setCorrection(Correction[] correction) {
		this.correction = correction;
	}

	/**
	 * @return the example
	 */
	public Example[] getExample() {
		return example;
	}

	/**
	 * @param example
	 *            the example to set
	 */
	public void setExample(Example[] example) {
		this.example = example;
	}

	/**
	 * @return the nextPage
	 */
	public NextPage[] getNextPage() {
		return nextPage;
	}

	/**
	 * @param nextPage
	 *            the nextPage to set
	 */
	public void setNextPage(NextPage[] nextPage) {
		this.nextPage = nextPage;
	}

	/**
	 * @return the previousPage
	 */
	public PreviousPage[] getPreviousPage() {
		return previousPage;
	}

	/**
	 * @param previousPage
	 *            the previousPage to set
	 */
	public void setPreviousPage(PreviousPage[] previousPage) {
		this.previousPage = previousPage;
	}

	/**
	 * @return the related
	 */
	public Related[] getRelated() {
		return related;
	}

	/**
	 * @param related
	 *            the related to set
	 */
	public void setRelated(Related[] related) {
		this.related = related;
	}

	/**
	 * @return the request
	 */
	public Request[] getRequest() {
		return request;
	}

	/**
	 * @param request
	 *            the request to set
	 */
	public void setRequest(Request[] request) {
		this.request = request;
	}

	/**
	 * @return the subset
	 */
	public Subset[] getSubset() {
		return subset;
	}

	/**
	 * @param subset
	 *            the subset to set
	 */
	public void setSubset(Subset[] subset) {
		this.subset = subset;
	}

	/**
	 * @return the superset
	 */
	public Superset[] getSuperset() {
		return superset;
	}

	/**
	 * @param superset
	 *            the superset to set
	 */
	public void setSuperset(Superset[] superset) {
		this.superset = superset;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Type: Queries \n##### QUERIES #####\ncorrection=");
		builder.append(Arrays.toString(correction));
		builder.append(",\nexample=");
		builder.append(Arrays.toString(example));
		builder.append(",\nnextPage=");
		builder.append(Arrays.toString(nextPage));
		builder.append(",\npreviousPage=");
		builder.append(Arrays.toString(previousPage));
		builder.append(",\nrelated=");
		builder.append(Arrays.toString(related));
		builder.append(",\nrequest=");
		builder.append(Arrays.toString(request));
		builder.append(",\nsubset=");
		builder.append(Arrays.toString(subset));
		builder.append(",\nsuperset=");
		builder.append(Arrays.toString(superset));
		builder.append("\n##### QUERIES #####");
		return builder.toString();
	}
}
