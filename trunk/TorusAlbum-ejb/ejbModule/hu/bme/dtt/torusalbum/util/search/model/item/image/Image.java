package hu.bme.dtt.torusalbum.util.search.model.item.image;

/**
 * Encapsulates all information about an image returned in search results.
 * 
 * @author Shazak
 * 
 */
public class Image {
	/**
	 * A URL pointing to the webpage hosting the image.
	 */
	private String contextLink;
	/**
	 * The height of the image, in pixels.
	 */
	private Integer height;
	/**
	 * The width of the image, in pixels.
	 */
	private Integer width;
	/**
	 * The size of the image, in pixels.
	 */
	private Integer byteSize;
	/**
	 * A URL to the thumbnail image.
	 */
	private String thumbnailLink;
	/**
	 * The height of the thumbnail image, in pixels.
	 */
	private Integer thumbnailHeight;
	/**
	 * The width of the thumbnail image, in pixels.
	 */
	private Integer thumbnailWidth;

	/**
	 * @return A URL pointing to the webpage hosting the image.
	 */
	public String getContextLink() {
		return contextLink;
	}

	/**
	 * @param contextLink
	 *            A URL pointing to the webpage hosting the image.
	 */
	public void setContextLink(String contextLink) {
		this.contextLink = contextLink;
	}

	/**
	 * @return The height of the image, in pixels.
	 */
	public Integer getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            The height of the image, in pixels.
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}

	/**
	 * @return The width of the image, in pixels.
	 */
	public Integer getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            The width of the image, in pixels.
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}

	/**
	 * @return The size of the image, in pixels.
	 */
	public Integer getByteSize() {
		return byteSize;
	}

	/**
	 * @param byteSize
	 *            The size of the image, in pixels.
	 */
	public void setByteSize(Integer byteSize) {
		this.byteSize = byteSize;
	}

	/**
	 * @return A URL to the thumbnail image.
	 */
	public String getThumbnailLink() {
		return thumbnailLink;
	}

	/**
	 * @param thumbnailLink
	 *            A URL to the thumbnail image.
	 */
	public void setThumbnailLink(String thumbnailLink) {
		this.thumbnailLink = thumbnailLink;
	}

	/**
	 * @return The height of the thumbnail image, in pixels.
	 */
	public Integer getThumbnailHeight() {
		return thumbnailHeight;
	}

	/**
	 * @param thumbnailHeight
	 *            The height of the thumbnail image, in pixels.
	 */
	public void setThumbnailHeight(Integer thumbnailHeight) {
		this.thumbnailHeight = thumbnailHeight;
	}

	/**
	 * @return The width of the thumbnail image, in pixels.
	 */
	public Integer getThumbnailWidth() {
		return thumbnailWidth;
	}

	/**
	 * @param thumbnailWidth
	 *            The width of the thumbnail image, in pixels.
	 */
	public void setThumbnailWidth(Integer thumbnailWidth) {
		this.thumbnailWidth = thumbnailWidth;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Type: Image \ncontextLink=");
		builder.append(contextLink);
		builder.append(",\nheight=");
		builder.append(height);
		builder.append(",\nwidth=");
		builder.append(width);
		builder.append(",\nbyteSize=");
		builder.append(byteSize);
		builder.append(",\nthumbnailLink=");
		builder.append(thumbnailLink);
		builder.append(",\nthumbnailHeight=");
		builder.append(thumbnailHeight);
		builder.append(",\nthumbnailWidth=");
		builder.append(thumbnailWidth);
		return builder.toString();
	}
}
