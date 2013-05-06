/**
 * 
 */
package hu.bme.dtt.torussearch.session;

import hu.bme.dtt.util.Result;

import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

/**
 * @author windisch.karoly
 *
 */
@Name("searchBackBean")
@Scope(ScopeType.PAGE)
public class SearchBackBean {

	private List<Result> resultList;
	
	public List<Result> getResultList() {
		return resultList;
	}
	
	public void setResultList(List<Result> resultList) {
		this.resultList = resultList;
	}
	
}
