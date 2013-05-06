package hu.bme.dtt.torussearch.searchco;

public class QueryBuilder {
	public static String buildQuery(String query, String ext, String lang,
			String repo, String url) {
		String result = query;
		if (ext != null) {
			result += " ext:" + ext;
		}
		if (lang != null) {
			result += " lang:" + lang;
		}
		if (repo != null) {
			result += " repo:" + repo;
		}
		if (url != null) {
			result += " url:" + url;
		}
		return result;
	}
}
