package hu.bme.dtt.torusalbum.util.search.model.item.pagemap;

import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.JsonElement;

/**
 * Contains PageMap information for this search result.
 * 
 * @author Shazak
 * 
 */
public class Pagemap {
	/**
	 * Map containing the objects found inside tha pagemap JSON element.
	 */
	private Map<String, JsonElement> content;

	/**
	 * @param content
	 *            Map containing the objects found inside tha pagemap JSON
	 *            element.
	 */
	public void setContent(Map<String, JsonElement> content) {
		this.content = content;
	}

	/**
	 * @return Map containing the objects found inside tha pagemap JSON element.
	 */
	public Map<String, JsonElement> getContent() {
		return content;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Type: Pagemap \n##### PAGEMAP #####");
		for (Entry<String, JsonElement> entry : content.entrySet()) {
			builder.append("\n" + entry.getKey() + "=" + entry.getValue());
		}
		builder.append("\n##### PAGEMAP #####");
		return builder.toString();
	}
}
