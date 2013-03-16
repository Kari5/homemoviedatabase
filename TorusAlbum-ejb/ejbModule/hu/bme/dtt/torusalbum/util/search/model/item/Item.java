package hu.bme.dtt.torusalbum.util.search.model.item;

import hu.bme.dtt.torusalbum.util.search.model.item.image.Image;
import hu.bme.dtt.torusalbum.util.search.model.item.label.Label;
import hu.bme.dtt.torusalbum.util.search.model.item.pagemap.Pagemap;

import java.util.List;

/**
 * Encapsulates a search result.
 * 
 * @author Shazak
 * 
 */
public class Item {
	/**
	 * A unique identifier for the type of current object. For this API, it is
	 * customsearch#result.
	 */
	private String kind;
	/**
	 * The title of the search result, in plain text.
	 */
	private String title;
	/**
	 * The title of the search result, in plain text.
	 */
	private String htmlTitle;
	/**
	 * The full URL to which the search result is pointing, e.g.
	 * http://www.example.com/foo/bar.
	 */
	private String link;
	/**
	 * An abridged version of this search result’s URL, e.g. www.example.com.
	 */
	private String displayLink;
	/**
	 * The snippet of the search result, in plain text.
	 */
	private String snippet;
	/**
	 * The snippet of the search result, in HTML.
	 */
	private String htmlSnippet;
	/**
	 * Indicates the ID of Google's cached version of the search result.
	 */
	private String cacheId;
	/**
	 * The MIME type of the search result.
	 */
	private String mime;
	/**
	 * The URL displayed after the snippet for each search result.
	 */
	private String formattedUrl;
	/**
	 * The HTML-formatted URL displayed after the snippet for each search
	 * result.
	 */
	private String htmlFormattedUrl;
	/**
	 * Contains PageMap information for this search result.
	 */
	private Pagemap pagemap;
	/**
	 * Encapsulates all information about refinement labels.
	 */
	private List<Label> labels;
	/**
	 * Encapsulates all information about an image returned in search results.
	 */
	private Image image;

	/**
	 * @return A unique identifier for the type of current object. For this API,
	 *         it is customsearch#result.
	 */
	public String getKind() {
		return kind;
	}

	/**
	 * @param kind
	 *            A unique identifier for the type of current object. For this
	 *            API, it is customsearch#result.
	 */
	public void setKind(String kind) {
		this.kind = kind;
	}

	/**
	 * @return The title of the search result, in plain text.
	 */
	public String getHtmlTitle() {
		return htmlTitle;
	}

	/**
	 * @param htmlTitle
	 *            The title of the search result, in plain text.
	 */
	public void setHtmlTitle(String htmlTitle) {
		this.htmlTitle = htmlTitle;
	}

	/**
	 * @return The full URL to which the search result is pointing, e.g.
	 *         http://www.example.com/foo/bar.
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link
	 *            The full URL to which the search result is pointing, e.g.
	 *            http://www.example.com/foo/bar.
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * @return An abridged version of this search result’s URL, e.g.
	 *         www.example.com.
	 */
	public String getDisplayLink() {
		return displayLink;
	}

	/**
	 * @param displayLink
	 *            An abridged version of this search result’s URL, e.g.
	 *            www.example.com.
	 */
	public void setDisplayLink(String displayLink) {
		this.displayLink = displayLink;
	}

	/**
	 * @return The snippet of the search result, in plain text.
	 */
	public String getAsnippet() {
		return snippet;
	}

	/**
	 * @param asnippet
	 *            The snippet of the search result, in plain text.
	 */
	public void setAsnippet(String asnippet) {
		snippet = asnippet;
	}

	/**
	 * @return The snippet of the search result, in HTML.
	 */
	public String getHtmlSnippet() {
		return htmlSnippet;
	}

	/**
	 * @param htmlSnippet
	 *            The snippet of the search result, in HTML.
	 */
	public void setHtmlSnippet(String htmlSnippet) {
		this.htmlSnippet = htmlSnippet;
	}

	/**
	 * @return Indicates the ID of Google's cached version of the search result.
	 */
	public String getCacheId() {
		return cacheId;
	}

	/**
	 * @param cacheId
	 *            Indicates the ID of Google's cached version of the search
	 *            result.
	 */
	public void setCacheId(String cacheId) {
		this.cacheId = cacheId;
	}

	/**
	 * @return The MIME type of the search result.
	 */
	public String getMime() {
		return mime;
	}

	/**
	 * @param mime
	 *            The MIME type of the search result.
	 */
	public void setMime(String mime) {
		this.mime = mime;
	}

	/**
	 * @return The URL displayed after the snippet for each search result.
	 */
	public String getFormattedUrl() {
		return formattedUrl;
	}

	/**
	 * @param formattedUrl
	 *            The URL displayed after the snippet for each search result.
	 */
	public void setFormattedUrl(String formattedUrl) {
		this.formattedUrl = formattedUrl;
	}

	/**
	 * @return The HTML-formatted URL displayed after the snippet for each
	 *         search result.
	 */
	public String getHtmlFormattedUrl() {
		return htmlFormattedUrl;
	}

	/**
	 * @param htmlFormattedUrl
	 *            The HTML-formatted URL displayed after the snippet for each
	 *            search result.
	 */
	public void setHtmlFormattedUrl(String htmlFormattedUrl) {
		this.htmlFormattedUrl = htmlFormattedUrl;
	}

	/**
	 * @return Contains PageMap information for this search result.
	 */
	public Pagemap getPagemap() {
		return pagemap;
	}

	/**
	 * @param pagemap
	 *            Contains PageMap information for this search result.
	 */
	public void setPagemap(Pagemap pagemap) {
		this.pagemap = pagemap;
	}

	/**
	 * @return Encapsulates all information about refinement labels.
	 */
	public List<Label> getLabels() {
		return labels;
	}

	/**
	 * @param labels
	 *            Encapsulates all information about refinement labels.
	 */
	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}

	/**
	 * @return Encapsulates all information about an image returned in search
	 *         results.
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * @param image
	 *            Encapsulates all information about an image returned in search
	 *            results.
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	/**
	 * @param title
	 *            The title of the search result, in plain text.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return The title of the search result, in plain text.
	 */
	public String getTitle() {
		return title;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Type: Item \n##### ITEM #####\nkind=");
		builder.append(kind);
		builder.append(",\ntitle=");
		builder.append(title);
		builder.append(",\nhtmlTitle=");
		builder.append(htmlTitle);
		builder.append(",\nlink=");
		builder.append(link);
		builder.append(",\ndisplayLink=");
		builder.append(displayLink);
		builder.append(",\nasnippet=");
		builder.append(snippet);
		builder.append(",\nhtmlSnippet=");
		builder.append(htmlSnippet);
		builder.append(",\ncacheId=");
		builder.append(cacheId);
		builder.append(",\nmime=");
		builder.append(mime);
		builder.append(",\nformattedUrl=");
		builder.append(formattedUrl);
		builder.append(",\nhtmlFormattedUrl=");
		builder.append(htmlFormattedUrl);
		builder.append(",\npagemap=");
		builder.append(pagemap);
		builder.append(",\nlabels=");
		builder.append(labels);
		builder.append(",\nimage=");
		builder.append(image);
		builder.append("\n##### ITEM #####");
		return builder.toString();
	}
}
