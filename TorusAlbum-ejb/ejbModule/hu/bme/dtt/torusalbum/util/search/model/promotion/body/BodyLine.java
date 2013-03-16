package hu.bme.dtt.torusalbum.util.search.model.promotion.body;

/**
 * Block object for a promotion.
 * 
 * @author Shazak
 * 
 */
public class BodyLine {
	/**
	 * The block object's text, if it has text.
	 */
	private String title;
	/**
	 * The URL of the block object's link, if it has one.
	 */
	private String url;
	/**
	 * The anchor text of the block object's link, if it has a link.
	 */
	private String link;
	/**
	 * The text of the promotion.
	 */
	private String htmlTitle;

	/**
	 * @return The block object's text, if it has text.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            The block object's text, if it has text.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return The URL of the block object's link, if it has one.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            The URL of the block object's link, if it has one.
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return The anchor text of the block object's link, if it has a link.
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link
	 *            The anchor text of the block object's link, if it has a link.
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * @param htmlTitle
	 *            The text of the promotion.
	 */
	public void setHtmlTitle(String htmlTitle) {
		this.htmlTitle = htmlTitle;
	}

	/**
	 * @return The text of the promotion.
	 */
	public String getHtmlTitle() {
		return htmlTitle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Type: BodyLine \n##### BODYLINE #####\ntitle=");
		builder.append(title);
		builder.append(",\nurl=");
		builder.append(url);
		builder.append(",\nlink=");
		builder.append(link);
		builder.append(",\nhtmlTitle=");
		builder.append(htmlTitle);
		builder.append("\n##### BODYLINE #####");
		return builder.toString();
	}
}
