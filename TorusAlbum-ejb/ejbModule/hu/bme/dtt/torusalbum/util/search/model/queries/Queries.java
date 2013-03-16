package hu.bme.dtt.torusalbum.util.search.model.queries;

import hu.bme.dtt.torusalbum.util.search.model.queries.roles.Role;

import java.util.List;

/**
 * Contains one or more sets of query metadata, keyed by role name. The possible
 * role names are defined by the OpenSearch query roles and by two custom roles:
 * nextPage and previousPage.
 * 
 * @author Shazak
 * 
 */
public class Queries {
	/**
	 * An array of metadata query objects describing possible roles. The
	 * "request" role is always present and has exactly one object, representing
	 * the current request. The "correction" role might provide several possible
	 * alternatives.
	 */
	private List<Role> roles;

	/**
	 * @param roles
	 *            An array of metadata query objects describing possible roles.
	 *            The "request" role is always present and has exactly one
	 *            object, representing the current request. The "correction"
	 *            role might provide several possible alternatives.
	 */
	public void setMetadata(List<Role> roles) {
		this.roles = roles;
	}

	/**
	 * @return An array of metadata query objects describing possible roles. The
	 *         "request" role is always present and has exactly one object,
	 *         representing the current request. The "correction" role might
	 *         provide several possible alternatives.
	 */
	public List<Role> getMetadata() {
		return roles;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Type: Queries \n##### QUERIES #####\nroles=");
		builder.append(roles);
		builder.append("\n##### QUERIES #####");
		return builder.toString();
	}
}
