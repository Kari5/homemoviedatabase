/**
 * 
 */
package hu.bme.dtt.torussearch.session;

import hu.bme.dtt.torussearch.googlesearch.GoogleSearch;
import hu.bme.dtt.torussearch.searchco.SearchCo;
import hu.bme.dtt.util.LevenshteinDistance;
import hu.bme.dtt.util.Result;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
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

	private boolean isLangugage;

	private boolean isExtension;

	private boolean isTutorial;

	private boolean isRepo;

	private String langugageS;

	private String extensionS;

	private String tutorialS;

	private String repoS;

	private static final Logger LOGGER = Logger.getLogger(SearchBackBean.class);

	@Create
	public void init() {
		// SearchCo sc=new SearchCo();
		// resultList=sc.searchCode("java", null, null, null, null);
	}

	public void search() {
		SearchCo sc = new SearchCo();
		GoogleSearch gs = new GoogleSearch();
		String scQuery = query + " " + evRep();
		String gsQuery = query;
		List<Result> googleResultList;
		List<Result> searchCodeResultList;
		List<Result> result = new ArrayList<Result>();
		if (query != null) {
			googleResultList = gs.executeSearch(gsQuery, evExt(), evTut(),
					evLan());
			searchCodeResultList = sc.searchCode(scQuery, evExt(), evLan(),
					null, evRep());
		} else {
			return;
		}
		if (isTutorial && !isRepo) {
			result.addAll(googleResultList);
			result.addAll(searchCodeResultList);
		} else if (!isTutorial && isRepo) {
			result.addAll(searchCodeResultList);
			result.addAll(googleResultList);
		} else {
			for (Result res1 : googleResultList) {
				result.add(modifyPosition(
						query + " " + extensionS + " " + langugageS, res1));
			}
			for (Result res2 : searchCodeResultList) {
				result.add(modifyPosition(
						query + " " + extensionS + " " + langugageS, res2));
			}
			Collections.sort(result);
		}
		this.resultList = result;
	}

	private Result modifyPosition(String query, Result result) {
		String splittedQuery[] = query.split(" ");
		String splittedResult[] = result.getSnippet().split(" ");
		double counter = 0.0;
		LOGGER.info(result.getName() + "-> splittedQuery: "
				+ splittedQuery.length + " splittedResult: "
				+ splittedResult.length);
		for (int i = 0; i < splittedResult.length; i++) {
			for (int j = 0; j < splittedQuery.length; j++) {
				int levenResult = LevenshteinDistance
						.computeLevenshteinDistance(splittedResult[i],
								splittedQuery[j]);
				LOGGER.info(splittedQuery[j] + " + " + splittedResult[i]
						+ " -> " + levenResult);
				if (levenResult < 3) {
					counter += 1.0;
				}
			}
		}
		if (counter > 0.0) {
			double newPosition = result.getPosition() + (1.0 / counter);
			result.setPosition(newPosition);
		}
		return result;
	}

	private String evLan() {
		if (isLangugage)
			return langugageS;
		return null;
	}

	private String evExt() {
		if (isExtension)
			return extensionS;
		return null;
	}

	private String evTut() {
		if (isTutorial)
			return tutorialS;
		return null;
	}

	private String evRep() {
		if (isRepo)
			return repoS;
		return null;
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

	/**
	 * @return the isLangugage
	 */
	public boolean isLangugage() {
		return isLangugage;
	}

	/**
	 * @param isLangugage
	 *            the isLangugage to set
	 */
	public void setLangugage(boolean isLangugage) {
		this.isLangugage = isLangugage;
	}

	/**
	 * @return the isExtension
	 */
	public boolean isExtension() {
		return isExtension;
	}

	/**
	 * @param isExtension
	 *            the isExtension to set
	 */
	public void setExtension(boolean isExtension) {
		this.isExtension = isExtension;
	}

	/**
	 * @return the isTutorial
	 */
	public boolean isTutorial() {
		return isTutorial;
	}

	/**
	 * @param isTutorial
	 *            the isTutorial to set
	 */
	public void setTutorial(boolean isTutorial) {
		this.isTutorial = isTutorial;
	}

	/**
	 * @return the isRepo
	 */
	public boolean isRepo() {
		return isRepo;
	}

	/**
	 * @param isRepo
	 *            the isRepo to set
	 */
	public void setRepo(boolean isRepo) {
		this.isRepo = isRepo;
	}

	/**
	 * @return the langugageS
	 */
	public String getLangugageS() {
		return langugageS;
	}

	/**
	 * @param langugageS
	 *            the langugageS to set
	 */
	public void setLangugageS(String langugageS) {
		this.langugageS = langugageS;
	}

	/**
	 * @return the extensionS
	 */
	public String getExtensionS() {
		return extensionS;
	}

	/**
	 * @param extensionS
	 *            the extensionS to set
	 */
	public void setExtensionS(String extensionS) {
		this.extensionS = extensionS;
	}

	/**
	 * @return the tutorialS
	 */
	public String getTutorialS() {
		return tutorialS;
	}

	/**
	 * @param tutorialS
	 *            the tutorialS to set
	 */
	public void setTutorialS(String tutorialS) {
		this.tutorialS = tutorialS;
	}

	/**
	 * @return the repoS
	 */
	public String getRepoS() {
		return repoS;
	}

	/**
	 * @param repoS
	 *            the repoS to set
	 */
	public void setRepoS(String repoS) {
		this.repoS = repoS;
	}

}
