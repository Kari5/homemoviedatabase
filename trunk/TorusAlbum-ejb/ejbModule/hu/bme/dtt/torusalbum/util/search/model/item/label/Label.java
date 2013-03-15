package hu.bme.dtt.torusalbum.util.search.model.item.label;

/**
 * A refinement label that you can use to filter the search results that you
 * receive.
 * 
 * @author Shazak
 * 
 */
public class Label {
	/**
	 * The name of a refinement label, which you can use to refine searches.
	 * Don't display this in your user interface; instead, use displayName.
	 */
	private String name;
	/**
	 * The display name of a refinement label. This is the name you should
	 * display in your user interface.
	 */
	private String displayName;

	/**
	 * @return The name of a refinement label, which you can use to refine
	 *         searches. Don't display this in your user interface; instead, use
	 *         displayName.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            The name of a refinement label, which you can use to refine
	 *            searches. Don't display this in your user interface; instead,
	 *            use displayName.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return The display name of a refinement label. This is the name you
	 *         should display in your user interface.
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName
	 *            The display name of a refinement label. This is the name you
	 *            should display in your user interface.
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Type: Label \nname=");
		builder.append(name);
		builder.append(",\ndisplayName=");
		builder.append(displayName);
		return builder.toString();
	}

}
