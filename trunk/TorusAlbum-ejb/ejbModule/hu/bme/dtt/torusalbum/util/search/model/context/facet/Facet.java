package hu.bme.dtt.torusalbum.util.search.model.context.facet;

/**
 * A facet object (refinement) you can use for refining a search.
 * 
 * @author Shazak
 * 
 */
public class Facet {
	/**
	 * The label of the given facet item, which you can use to refine your
	 * search.
	 */
	private String label;
	/**
	 * The displayable name of the item, which you should use when displaying
	 * the item to a human.
	 */
	private String anchor;

	/**
	 * @return The label of the given facet item, which you can use to refine
	 *         your search.
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label
	 *            The label of the given facet item, which you can use to refine
	 *            your search.
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return The displayable name of the item, which you should use when
	 *         displaying the item to a human.
	 */
	public String getAnchor() {
		return anchor;
	}

	/**
	 * @param anchor
	 *            The displayable name of the item, which you should use when
	 *            displaying the item to a human.
	 */
	public void setAnchor(String anchor) {
		this.anchor = anchor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Type: Facet \nlabel=");
		builder.append(label);
		builder.append(",\nanchor=");
		builder.append(anchor);
		return builder.toString();
	}
}
