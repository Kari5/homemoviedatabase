package hu.bme.dtt.torusalbum.util.search.model.item.pagemap;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

/**
 * Deserializer class for parsing the pagemap JSON element.
 * 
 * @author Shazak
 * 
 */
public class PagemapDeserializer implements JsonDeserializer<Pagemap> {
	/**
	 * Deserializes the JSON element to a pagemap object.
	 * 
	 * @param json
	 *            The JSON element to deserialize.
	 * @param typeOfT
	 *            The type of the object to deserialize to.
	 * @param context
	 *            The current gson context.
	 * @return The Pagemap object.
	 * @throws JsonParseException
	 *             If json is not in the expected format of typeofT
	 * 
	 */
	public Pagemap deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		JsonObject object = (JsonObject) json;
		Map<String, JsonElement> content = new HashMap<String, JsonElement>();
		for (Entry<String, JsonElement> entry : object.entrySet()) {
			content.put(entry.getKey(), entry.getValue());
		}
		Pagemap pagemap = new Pagemap();
		pagemap.setContent(content);
		return pagemap;
	}

}
