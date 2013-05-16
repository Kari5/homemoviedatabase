package hu.bme.dtt.torusalbum.util;

import hu.bme.dtt.torusalbum.dao.SearchEngineDao;
import hu.bme.dtt.torusalbum.entity.Album;
import hu.bme.dtt.torusalbum.entity.Picture;
import hu.bme.dtt.torusalbum.entity.SearchEngine;
import hu.bme.dtt.torusalbum.util.search.Search;
import hu.bme.dtt.torusalbum.util.search.model.Response;
import hu.bme.dtt.torusalbum.util.search.model.item.Item;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.codehaus.jettison.json.JSONArray;
import org.jboss.logging.Logger;

import com.google.gson.JsonElement;

public class TitleFactory {
	private static final Logger LOGGER = Logger.getLogger(TitleFactory.class);

	public static List<Tag> getPictureMetaTags(List<Item> items) {
		List<Tag> resultTags = new ArrayList<Tag>();
		if (items != null) {
			for (Item item : items) {
				String title = item.getTitle();
				if (title != null) {
					for (String s : title.split(" ")) {
						if (!s.isEmpty() && !s.equals("...") && !s.equals("-")) {
							resultTags.add(new Tag(s));
						}
					}
				}
				String snippet = item.getAsnippet();
				if (snippet != null) {
					for (String s : snippet.split(" ")) {
						if (!s.isEmpty() && !s.equals("...") && !s.equals("-")) {
							resultTags.add(new Tag(s));
						}
					}
				}
			}
		}
		return resultTags;
	}

	public static List<Tag> getWebPageNames(List<Item> items) {
		List<Tag> resultTags = new ArrayList<Tag>();
		if (items != null) {
			for (Item item : items) {
				resultTags.add(new Tag(item.getDisplayLink()));
			}
		}
		return resultTags;
	}

	public static List<Tag> getWebMetaTags(List<Item> items) {
		List<Tag> resultTags = new ArrayList<Tag>();
		if (items != null) {
			for (Item item : items) {
				try {
					JsonElement metatags = item.getPagemap().getContent().get("metatags");
					if (metatags != null) {
						JSONArray jsonArray = new JSONArray(metatags.toString());
						for (int i = 0; i < jsonArray.length(); i++) {
							JSONArray names = jsonArray.getJSONObject(i).names();
							for (int j = 0; j < names.length(); j++) {
								String string = jsonArray.getJSONObject(i).getString(
										names.getString(j));
								String[] split = string.split(" ");
								for (String s : split) {
									if (!s.isEmpty() && !s.equals("...") && !s.equals("-")) {
										resultTags.add(new Tag(s));
									}
								}
							}
						}
					}
				} catch (Exception e) {
					LOGGER.error(e.getMessage(), e);
				}
			}
		}
		return resultTags;
	}

	public static List<Tag> unioTagLists(List<List<Tag>> webMetaTagLists) {
		List<Tag> resultTags = new ArrayList<Tag>();
		for (List<Tag> tagList : webMetaTagLists) {
			for (Tag t : tagList) {
				boolean exists = false;
				for (Tag resultTag : resultTags) {
					if (t.getName().equals(resultTag.getName())) {
						resultTag.raisCounter();
						exists = true;
					}
				}
				if (!exists) {
					resultTags.add(t);
				}
			}
		}
		Collections.sort(resultTags);
		return resultTags;
	}

	public static List<Tag> getTags(Album album) {
		List<Tag> result = new ArrayList<Tag>();
		if (album == null) {
			return result;
		}
		List<List<Tag>> picutreTags = new ArrayList<List<Tag>>();
		List<List<Tag>> webPageTags = new ArrayList<List<Tag>>();
		List<List<Tag>> webPageNameTags = new ArrayList<List<Tag>>();
		for (Picture p : album.getPictures()) {
			try {
				SearchEngine searchEngine = ((SearchEngineDao) InitialContext
						.doLookup("TorusAlbum-ear/searchEngineDao/local")).getSearchEngine("Torus");
				Search search = new Search();
				Map<String, Object> searchParams = new HashMap<String, Object>();
				String[] split = p.getUrl().split("/");
				String query = split[split.length - 1];
				searchParams.put("q", URLEncoder.encode(query, "UTF-8"));
				searchParams.put("key", searchEngine.getApiKey());
				searchParams.put("cx", searchEngine.getCxKey());
				searchParams.put("alt", "json");

				try {
					Response response = search.executeSearch(searchParams);
					LOGGER.info(response);
					List<Tag> pictureTagList = getPictureMetaTags(response.getItems());
					List<Tag> webTagList = getWebMetaTags(response.getItems());
					List<Tag> webNameTagList = getWebPageNames(response.getItems());
					picutreTags.add(pictureTagList);
					webPageTags.add(webTagList);
					webPageNameTags.add(webNameTagList);
				} catch (IllegalArgumentException e) {
					LOGGER.error(e.getMessage(), e);
				} catch (IllegalAccessException e) {
					LOGGER.error(e.getMessage(), e);
				} catch (IOException e) {
					LOGGER.error(e.getMessage(), e);
				}
			} catch (NamingException e) {
				LOGGER.error(e.getMessage(), e);
			} catch (UnsupportedEncodingException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
		List<Tag> pictureTag = unioTagLists(picutreTags);
		List<Tag> webPageTag = unioTagLists(webPageTags);
		List<Tag> webPageNameTag = unioTagLists(webPageNameTags);

		result.addAll(webPageNameTag);
		result.addAll(webPageTag);
		result.addAll(pictureTag);

		Collections.sort(result);
		LOGGER.info("Found tags:");
		for (Tag tag : result) {
			if (tag.getCounter() > 1) {
				LOGGER.info(tag);
			}
		}
		return result;
	}
}
