package hu.bme.dtt.util;

public class Result implements Comparable<Result> {
	private String name;
	private String url;
	private String snippet;
	private Boolean relevant;
	private Double position;

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

	/**
	 * @return the relevant
	 */
	public Boolean getRelevant() {
		return relevant;
	}

	/**
	 * @param relevant the relevant to set
	 */
	public void setRelevant(Boolean relevant) {
		this.relevant = relevant;
	}
	
	public Double getPosition() {
		return position;
	}
	
	public void setPosition(double position) {
		this.position = position;
	}

	public int compareTo(Result o) {
		if(getPosition()<o.getPosition()){
			return -1;
		} else if(getPosition().equals(o.getPosition())) {
			return 0;
		} else {
			return 1;
		}
	}
	
}
