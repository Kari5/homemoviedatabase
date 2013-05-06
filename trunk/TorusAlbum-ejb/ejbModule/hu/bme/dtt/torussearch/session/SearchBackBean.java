/**
 * 
 */
package hu.bme.dtt.torussearch.session;

import hu.bme.dtt.torussearch.googlesearch.GoogleSearch;
import hu.bme.dtt.torussearch.searchco.SearchCo;
import hu.bme.dtt.util.Result;

import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Create;
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
	
	private String query;
	
	private boolean googleEanbled;
	
	
	@Create
	public void init(){
//		SearchCo sc=new SearchCo();
//		resultList=sc.searchCode("java", null, null, null, null);
	}
	
	public void search(){
		SearchCo sc=new SearchCo();
		GoogleSearch gs=new GoogleSearch();
		if(query!=null)
			if(googleEanbled){
				resultList = gs.executeSearch(query, null, null, null);
			} else {
		resultList=sc.searchCode(query, null, null, null, null);
			}
	}
	
	
	public List<Result> getResultList() {
		return resultList;
	}
	
	public void setResultList(List<Result> resultList) {
		this.resultList = resultList;
	}
	
	public String getQuery() {
		return query;
	}
	
	public void setQuery(String query) {
		this.query = query;
	}
	
	public boolean isGoogleEanbled() {
		return googleEanbled;
	}
	
	public void setGoogleEanbled(boolean googleEanbled) {
		this.googleEanbled = googleEanbled;
	}
	
}
