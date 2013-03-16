package hu.bme.dtt.torusalbum.util.search.model.url;

/**
 * The OpenSearch URL element that defines the template for this API.
 * 
 * @author Shazak
 * 
 */
public class Url {
	/**
	 * The MIME type of the OpenSearch URL template for the Custom Search API.
	 */
	private String type;
	/**
	 * The actual OpenSearch template for this API.
	 */
	private String template;

	/**
	 * @return The MIME type of the OpenSearch URL template for the Custom
	 *         Search API.
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            The MIME type of the OpenSearch URL template for the Custom
	 *            Search API.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return The actual OpenSearch template for this API.
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * @param template
	 *            The actual OpenSearch template for this API.
	 */
	public void setTemplate(String template) {
		this.template = template;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Type: Url \n##### URL #####\ntype=");
		builder.append(type);
		builder.append(",\ntemplate=");
		builder.append(template);
		builder.append("\n##### URL #####");
		return builder.toString();
	}
}
