package hu.bme.dtt.util;

public class Result {
	private String name;
	private String url;
	private String snippet;

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Result [\nname=" + name + ",\n url=" + url + ",\n snippet=" + snippet + "\n]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSnippet() {
		return snippet;
	}

	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}
}
