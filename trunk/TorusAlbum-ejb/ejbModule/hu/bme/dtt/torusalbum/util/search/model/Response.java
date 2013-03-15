package hu.bme.dtt.torusalbum.util.search.model;

import hu.bme.dtt.torusalbum.util.search.model.context.Context;
import hu.bme.dtt.torusalbum.util.search.model.information.SearchInformation;
import hu.bme.dtt.torusalbum.util.search.model.item.Item;
import hu.bme.dtt.torusalbum.util.search.model.promotion.Promotion;
import hu.bme.dtt.torusalbum.util.search.model.queries.Queries;
import hu.bme.dtt.torusalbum.util.search.model.spelling.Spelling;
import hu.bme.dtt.torusalbum.util.search.model.url.Url;

import java.util.List;

/**
 * The query response from the search API.
 * 
 * @author Shazak
 * 
 */
public class Response {
	/**
	 * Unique identifier for the type of current object.
	 */
	private String kind;
	/**
	 * The OpenSearch URL element that defines the template for this API.
	 */
	private Url url;
	/**
	 * Contains one or more sets of query metadata, keyed by role name. The
	 * possible role names are defined by the OpenSearch query roles and by two
	 * custom roles: nextPage and previousPage.
	 */
	private Queries queries;
	/**
	 * The set of promotions. Present only if the custom search engine's
	 * configuration files define any promotions for the given query.
	 */
	private List<Promotion> promotions;
	/**
	 * Metadata about the particular search engine that was used for performing
	 * the search query.
	 */
	private Context context;
	/**
	 * Encapsulates all information about the search.
	 */
	private SearchInformation searchInformation;
	/**
	 * The current set of custom search results.
	 */
	private List<Item> items;
	/**
	 * Encapsulates a corrected query.
	 */
	private Spelling spelling;

	/**
	 * @return Unique identifier for the type of current object.
	 */
	public String getKind() {
		return kind;
	}

	/**
	 * @param kind
	 *            Unique identifier for the type of current object.
	 */
	public void setKind(String kind) {
		this.kind = kind;
	}

	/**
	 * @return The OpenSearch URL element that defines the template for this
	 *         API.
	 */
	public Url getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            The OpenSearch URL element that defines the template for this
	 *            API.
	 */
	public void setUrl(Url url) {
		this.url = url;
	}

	/**
	 * @param queries
	 *            The object which contains one or more sets of query metadata,
	 *            keyed by role name. The possible role names are defined by the
	 *            OpenSearch query roles and by two custom roles: nextPage and
	 *            previousPage.
	 */
	public void setQueries(Queries queries) {
		this.queries = queries;
	}

	/**
	 * @return The object which contains one or more sets of query metadata,
	 *         keyed by role name. The possible role names are defined by the
	 *         OpenSearch query roles and by two custom roles: nextPage and
	 *         previousPage.
	 */
	public Queries getQueries() {
		return queries;
	}

	/**
	 * @param promotions
	 *            The set of promotions. Present only if the custom search
	 *            engine's configuration files define any promotions for the
	 *            given query.
	 */
	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}

	/**
	 * @return The set of promotions. Present only if the custom search engine's
	 *         configuration files define any promotions for the given query.
	 */
	public List<Promotion> getPromotions() {
		return promotions;
	}

	/**
	 * @param context
	 *            Metadata about the particular search engine that was used for
	 *            performing the search query.
	 */
	public void setContext(Context context) {
		this.context = context;
	}

	/**
	 * @return Metadata about the particular search engine that was used for
	 *         performing the search query.
	 */
	public Context getContext() {
		return context;
	}

	/**
	 * @param searchInformation
	 *            Encapsulates all information about the search.
	 */
	public void setSearchInformation(SearchInformation searchInformation) {
		this.searchInformation = searchInformation;
	}

	/**
	 * @return Encapsulates all information about the search.
	 */
	public SearchInformation getSearchInformation() {
		return searchInformation;
	}

	/**
	 * @param items
	 *            The current set of custom search results.
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}

	/**
	 * @return The current set of custom search results.
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * @param spelling
	 *            Encapsulates a corrected query.
	 */
	public void setSpelling(Spelling spelling) {
		this.spelling = spelling;
	}

	/**
	 * @return Encapsulates a corrected query.
	 */
	public Spelling getSpelling() {
		return spelling;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Type: Response \nkind=");
		builder.append(kind);
		builder.append(",\nurl=");
		builder.append(url);
		builder.append(",\nqueries=");
		builder.append(queries);
		builder.append(",\npromotions=");
		builder.append(promotions);
		builder.append(",\ncontext=");
		builder.append(context);
		builder.append(",\nsearchInformation=");
		builder.append(searchInformation);
		builder.append(",\nitems=");
		builder.append(items);
		builder.append(",\nspelling=");
		builder.append(spelling);
		return builder.toString();
	}

}
