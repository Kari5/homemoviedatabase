package hu.bme.dtt.torusalbum.util.search.model.promotion.image;

/**
 * Image associated with a promotion.
 * 
 * @author Shazak
 * 
 */
public class Image {
	/**
	 * URL of the image for this promotion link.
	 */
	private String source;
	/**
	 * Image width in pixels.
	 */
	private Integer width;
	/**
	 * Image height in pixels.
	 */
	private Integer height;

	/**
	 * @return URL of the image for this promotion link.
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source
	 *            URL of the image for this promotion link.
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return Image width in pixels.
	 */
	public Integer getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            Image width in pixels.
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}

	/**
	 * @return Image height in pixels.
	 */
	public Integer getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            Image height in pixels.
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Type: Image \nsource=");
		builder.append(source);
		builder.append(",\nwidth=");
		builder.append(width);
		builder.append(",\nheight=");
		builder.append(height);
		return builder.toString();
	}
}
