/**
 * 
 */
package hu.bme.dtt.torusalbum.util;

import org.richfaces.component.Sortable;
import org.richfaces.model.SortOrder;

/**
 * @author windisch.karoly
 * 
 */
public class Tag implements Comparable<Tag> {

	String name;

	int counter;

	public Tag(String name) {
		this.name = name;
		this.counter = 1;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the counter
	 */
	public int getCounter() {
		return counter;
	}

	/**
	 * @param counter
	 *            the counter to set
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}

	public void raisCounter() {
		this.counter++;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tag other = (Tag) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public int compareTo(Tag o) {
		if (this.counter > o.counter) {
			return 1;
		} else if (this.counter == o.counter) {
			return 0;
		}
		return -1;
	}

}
