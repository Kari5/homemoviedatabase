package hu.bme.dtt.torusalbum.util.search.model.promotion;

import hu.bme.dtt.torusalbum.util.search.model.promotion.body.BodyLine;
import hu.bme.dtt.torusalbum.util.search.model.promotion.image.Image;

import java.util.List;

/**
 * Promotion for the given query.
 * 
 * @author Shazak
 * 
 */
public class Promotion {
	/**
	 * The title of the promotion.
	 */
	private String title;
	/**
	 * The URL of the promotion.
	 */
	private String link;
	/**
	 * An abridged version of this search's result URL, e.g. www.example.com.
	 */
	private String displayLink;
	/**
	 * An array of block objects for this promotion. See Google WebSearch
	 * Protocol reference for more information.
	 */
	private List<BodyLine> bodyLines;
	/**
	 * Image associated with this promotion, if there is one.
	 */
	private Image image;
	/**
	 * The title of the promotion, in HTML
	 */
	private String htmlTitle;

	/**
	 * @return The title of the promotion.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            The title of the promotion.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return The URL of the promotion.
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link
	 *            The URL of the promotion.
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * @return An abridged version of this search's result URL, e.g.
	 *         www.example.com.
	 */
	public String getDisplayLink() {
		return displayLink;
	}

	/**
	 * @param displayLink
	 *            An abridged version of this search's result URL, e.g.
	 *            www.example.com.
	 */
	public void setDisplayLink(String displayLink) {
		this.displayLink = displayLink;
	}

	/**
	 * @return An array of block objects for this promotion. See Google
	 *         WebSearch Protocol reference for more information.
	 */
	public List<BodyLine> getBodyLines() {
		return bodyLines;
	}

	/**
	 * @param bodyLines
	 *            An array of block objects for this promotion. See Google
	 *            WebSearch Protocol reference for more information.
	 */
	public void setBodyLines(List<BodyLine> bodyLines) {
		this.bodyLines = bodyLines;
	}

	/**
	 * @return Image associated with this promotion, if there is one.
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * @param image
	 *            Image associated with this promotion, if there is one.
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	/**
	 * @param htmlTitle
	 *            The title of the promotion, in HTML
	 */
	public void setHtmlTitle(String htmlTitle) {
		this.htmlTitle = htmlTitle;
	}

	/**
	 * @return The title of the promotion, in HTML
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
		builder.append("Type: Promotion \n##### PROMOTION #####\ntitle=");
		builder.append(title);
		builder.append(",\nlink=");
		builder.append(link);
		builder.append(",\ndisplayLink=");
		builder.append(displayLink);
		builder.append(",\nbodyLines=");
		builder.append(bodyLines);
		builder.append(",\nimage=");
		builder.append(image);
		builder.append(",\nhtmlTitle=");
		builder.append(htmlTitle);
		builder.append("\n##### PROMOTION #####");
		return builder.toString();
	}
}
