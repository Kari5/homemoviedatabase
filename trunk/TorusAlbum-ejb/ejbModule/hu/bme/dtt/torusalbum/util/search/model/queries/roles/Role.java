package hu.bme.dtt.torusalbum.util.search.model.queries.roles;

/**
 * 
 * @author Shazak
 * 
 */
public class Role {
	/**
	 * A description of the query.
	 */
	private String title;
	/**
	 * Estimated number of total search results. May not be accurate.
	 */
	private Long totalResults;
	/**
	 * The search terms entered by the user.
	 */
	private String searchTerms;
	/**
	 * Number of search results returned in this set.
	 */
	private Integer count;
	/**
	 * The index of the current set of search results into the total set of
	 * results, where the index of the first result is 1.
	 */
	private Integer startIndex;
	/**
	 * The page number of this set of results, where the page length is set by
	 * the count property.
	 */
	private Integer startPage;
	/**
	 * The language of the search results.
	 */
	private String language;
	/**
	 * The character encoding supported for search requests.
	 */
	private String inputEncoding;
	/**
	 * The character encoding supported for search results.
	 */
	private String outputEncoding;
	/**
	 * Specifies the SafeSearch level used for filtering out adult results. This
	 * is a custom property not defined in the OpenSearch spec. Valid parameter
	 * values are:
	 * <ul>
	 * <li>off: Disable SafeSearch (default)
	 * <li>medium: Enable SafeSearch
	 * <li>high: Enable a stricter version of SafeSearch
	 */
	private String safe;
	/**
	 * The identifier of a custom search engine created using the Custom Search
	 * Control Panel, if specified in request. This is a custom property not
	 * defined in the OpenSearch spec.
	 */
	private String cx;
	/**
	 * A URL pointing to the definition of a linked custom search engine, if
	 * specified in request. This is a custom property not defined in the
	 * OpenSearch spec.
	 */
	private String cref;
	/**
	 * Specifies that results should be sorted according to the specified
	 * expression. For example, sort by date.
	 */
	private String sort;
	/**
	 * <p>
	 * Activates or deactivates the automatic filtering of Google search
	 * results. See Automatic Filtering for more information about Google's
	 * search results filters.
	 * </p>
	 * <p>
	 * The default value for the filter parameter is 1, which indicates that the
	 * feature is enabled. Valid values for this parameter are:
	 * <ul>
	 * <li>0: Disabled
	 * <li>1: Enabled
	 * </ul>
	 * </p>
	 * <p>
	 * Note: By default, Google applies filtering to all search results to
	 * improve the quality of those results.
	 * </p>
	 */
	private String filter;
	/**
	 * <p>
	 * Boosts search results whose country of origin matches the parameter
	 * value. See Country Codes for a list of valid values.
	 * </p>
	 * <p>
	 * Specifying a gl parameter value in WebSearch requests should improve the
	 * relevance of results. This is particularly true for international
	 * customers and, even more specifically, for customers in English-speaking
	 * countries other than the United States.
	 * </p>
	 */
	private String gl;
	/**
	 * <p>
	 * Restricts search results to documents originating in a particular
	 * country. You may use Boolean operators in the cr parameter's value.
	 * </p>
	 * <p>
	 * Google WebSearch determines the country of a document by analyzing the
	 * following:
	 * <ul>
	 * <li>
	 * The top-level domain (TLD) of the document's URL.
	 * <li>
	 * The geographic location of the web server's IP address.
	 * </ul>
	 * </p>
	 * <p>
	 * </p>
	 * See Country (cr) Parameter Values for a list of valid values for this
	 * parameter.
	 */
	private String cr;
	/**
	 * Specifies the Google domain (for example, google.com, google.de, or
	 * google.fr) to which the search should be limited.
	 */
	private String googleHost;
	/**
	 * <p>
	 * Enables or disables the Simplified and Traditional Chinese Search
	 * feature.
	 * </p>
	 * <p>
	 * Supported values are:
	 * <ul>
	 * <li>
	 * 0: enabled (default)
	 * <li>
	 * 1: disabled
	 * </p>
	 */
	private String disableCnTwTransition;
	/**
	 * Appends the specified query terms to the query, as if they were combined
	 * with a logical AND operator.
	 */
	private String hq;
	/**
	 * <p>
	 * Specifies the interface language (host language) of your user interface.
	 * Explicitly setting this parameter improves the performance and the
	 * quality of your search results.
	 * </p>
	 * <p>
	 * See the Interface Languages section of Internationalizing Queries and
	 * Results Presentation for more information, and Supported Interface
	 * Languages for a list of supported languages.
	 * </p>
	 */
	private String hl;
	/**
	 * Restricts results to URLs from a specified site.
	 */
	private String siteSearch;
	/**
	 * Specifies whether to include or exclude results from the site named in
	 * the sitesearch parameter. Supported values are:
	 * <ul>
	 * <li>
	 * i: include content from site
	 * <li>
	 * e: exclude content from site
	 */
	private String siteSearchFilter;
	/**
	 * Identifies a phrase that all documents in the search results must
	 * contain.
	 */
	private String exactTerms;
	/**
	 * Identifies a word or phrase that should not appear in any documents in
	 * the search results.
	 */
	private String excludeTerms;
	/**
	 * Specifies that all results should contain a link to a specific URL.
	 */
	private String linkSite;
	/**
	 * Provides additional search terms to check for in a document, where each
	 * document in the search results must contain at least one of the
	 * additional search terms. You can also use the Boolean OR query term for
	 * this type of query.
	 */
	private String orTerms;
	/**
	 * Specifies that all search results should be pages that are related to the
	 * specified URL. The parameter value should be a URL.
	 */
	private String relatedSite;
	/**
	 * Restricts results to URLs based on date. Supported values include:
	 * <ul>
	 * <li>
	 * d[number]: requests results from the specified number of past days.
	 * <li>
	 * w[number]: requests results from the specified number of past weeks.
	 * <li>
	 * m[number]: requests results from the specified number of past months.
	 * <li>
	 * y[number]: requests results from the specified number of past years.
	 */
	private String dateRestrict;
	/**
	 * Specifies the starting value for a search range.<br>
	 * Use cse:lowRange and cse:highrange to append an inclusive search range of
	 * lowRange...highRange to the query.
	 */
	private String lowRange;
	/**
	 * Specifies the ending value for a search range.<br>
	 * Use cse:lowRange and cse:highrange to append an inclusive search range of
	 * lowRange...highRange to the query.
	 */
	private String highRange;
	/**
	 * <p>
	 * Restricts results to files of a specified extension. Filetypes supported
	 * by Google include:
	 * <ul>
	 * <li>Adobe Portable Document Format (pdf)
	 * <li>
	 * Adobe PostScript (ps)
	 * <li>
	 * Lotus 1-2-3 (wk1, wk2, wk3, wk4, wk5, wki, wks, wku)
	 * <li>
	 * Lotus WordPro (lwp)
	 * <li>
	 * Macwrite (mw)
	 * <li>
	 * Microsoft Excel (xls)
	 * <li>
	 * Microsoft PowerPoint (ppt)
	 * <li>
	 * Microsoft Word (doc)
	 * <li>
	 * Microsoft Works (wks, wps, wdb)
	 * <li>
	 * Microsoft Write (wri)
	 * <li>
	 * Rich Text Format (rtf)
	 * <li>
	 * Shockwave Flash (swf)
	 * <li>
	 * Text (ans, txt).
	 * </ul>
	 * </p>
	 * <p>
	 * Additional filetypes may be added in the future. An up-to-date list can
	 * always be found in Google's file type FAQ.
	 * </p>
	 */
	private String fileType;
	/**
	 * Filters based on licensing. Supported values include:
	 * <ul>
	 * <li>
	 * cc_publicdomain
	 * <li>
	 * cc_attribute
	 * <li>
	 * cc_sharealike
	 * <li>
	 * cc_noncommercial
	 * <li>
	 * cc_nonderived
	 */
	private String rights;
	/**
	 * Allowed values are web or image. If unspecified, results are limited to
	 * webpages.
	 */
	private String searchType;
	/**
	 * Restricts results to images of a specified size. Supported values are:
	 * <ul>
	 * <li>
	 * icon (small)
	 * <li>
	 * small|medium|large|xlarge (medium)
	 * <li>
	 * xxlarge (large)
	 * <li>
	 * huge (extra-large)
	 */
	private String imgSize;
	/**
	 * Restricts results to images of a specified type. Supported values are:
	 * <ul>
	 * <li>
	 * clipart (clipart)
	 * <li>
	 * face (face)
	 * <li>
	 * lineart (lineart)
	 * <li>
	 * news (news)
	 * <li>
	 * photo (photo)
	 */
	private String imgType;
	/**
	 * Restricts results to images of a specified color type. Supported values
	 * are:
	 * <ul>
	 * <li>
	 * mono (black and white)
	 * <li>
	 * gray (grayscale)
	 * <li>
	 * color (color)
	 */
	private String imgColorType;
	/**
	 * Restricts results to images with a specific dominant color. Supported
	 * values are:
	 * <ul>
	 * <li>
	 * yellow
	 * <li>
	 * green
	 * <li>
	 * teal
	 * <li>
	 * blue
	 * <li>
	 * purple
	 * <li>
	 * pink
	 * <li>
	 * white
	 * <li>
	 * gray
	 * <li>
	 * black
	 * <li>
	 * brown
	 */
	private String imgDominantColor;

	/**
	 * @return A description of the query.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            A description of the query.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return Estimated number of total search results. May not be accurate.
	 */
	public Long getTotalResults() {
		return totalResults;
	}

	/**
	 * @param totalResults
	 *            Estimated number of total search results. May not be accurate.
	 */
	public void setTotalResults(Long totalResults) {
		this.totalResults = totalResults;
	}

	/**
	 * @return The search terms entered by the user.
	 */
	public String getSearchTerms() {
		return searchTerms;
	}

	/**
	 * @param searchTerms
	 *            The search terms entered by the user.
	 */
	public void setSearchTerms(String searchTerms) {
		this.searchTerms = searchTerms;
	}

	/**
	 * @return Number of search results returned in this set.
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count
	 *            Number of search results returned in this set.
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * @return The index of the current set of search results into the total set
	 *         of results, where the index of the first result is 1.
	 */
	public Integer getStartIndex() {
		return startIndex;
	}

	/**
	 * @param startIndex
	 *            The index of the current set of search results into the total
	 *            set of results, where the index of the first result is 1.
	 */
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	/**
	 * @return The page number of this set of results, where the page length is
	 *         set by the count property.
	 */
	public Integer getStartPage() {
		return startPage;
	}

	/**
	 * @param startPage
	 *            The page number of this set of results, where the page length
	 *            is set by the count property.
	 */
	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

	/**
	 * @return The language of the search results.
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language
	 *            The language of the search results.
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return The character encoding supported for search requests.
	 */
	public String getInputEncoding() {
		return inputEncoding;
	}

	/**
	 * @param inputEncoding
	 *            The character encoding supported for search requests.
	 */
	public void setInputEncoding(String inputEncoding) {
		this.inputEncoding = inputEncoding;
	}

	/**
	 * @return The character encoding supported for search results.
	 */
	public String getOutputEncoding() {
		return outputEncoding;
	}

	/**
	 * @param outputEncoding
	 *            The character encoding supported for search results.
	 */
	public void setOutputEncoding(String outputEncoding) {
		this.outputEncoding = outputEncoding;
	}

	/**
	 * @return Specifies the SafeSearch level used for filtering out adult
	 *         results. This is a custom property not defined in the OpenSearch
	 *         spec. Valid parameter values are:
	 *         <ul>
	 *         <li>off: Disable SafeSearch (default)
	 *         <li>medium: Enable SafeSearch
	 *         <li>high: Enable a stricter version of SafeSearch
	 */
	public String getSafe() {
		return safe;
	}

	/**
	 * @param safe
	 *            Specifies the SafeSearch level used for filtering out adult
	 *            results. This is a custom property not defined in the
	 *            OpenSearch spec. Valid parameter values are:
	 *            <ul>
	 *            <li>off: Disable SafeSearch (default)
	 *            <li>medium: Enable SafeSearch
	 *            <li>high: Enable a stricter version of SafeSearch
	 */
	public void setSafe(String safe) {
		this.safe = safe;
	}

	/**
	 * @return The identifier of a custom search engine created using the Custom
	 *         Search Control Panel, if specified in request. This is a custom
	 *         property not defined in the OpenSearch spec.
	 */
	public String getCx() {
		return cx;
	}

	/**
	 * @param cx
	 *            The identifier of a custom search engine created using the
	 *            Custom Search Control Panel, if specified in request. This is
	 *            a custom property not defined in the OpenSearch spec.
	 */
	public void setCx(String cx) {
		this.cx = cx;
	}

	/**
	 * @return A URL pointing to the definition of a linked custom search
	 *         engine, if specified in request. This is a custom property not
	 *         defined in the OpenSearch spec.
	 */
	public String getCref() {
		return cref;
	}

	/**
	 * @param cref
	 *            A URL pointing to the definition of a linked custom search
	 *            engine, if specified in request. This is a custom property not
	 *            defined in the OpenSearch spec.
	 */
	public void setCref(String cref) {
		this.cref = cref;
	}

	/**
	 * @return Specifies that results should be sorted according to the
	 *         specified expression. For example, sort by date.
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * @param sort
	 *            Specifies that results should be sorted according to the
	 *            specified expression. For example, sort by date.
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	/**
	 * @return <p>
	 *         Activates or deactivates the automatic filtering of Google search
	 *         results. See Automatic Filtering for more information about
	 *         Google's search results filters.
	 *         </p>
	 *         <p>
	 *         The default value for the filter parameter is 1, which indicates
	 *         that the feature is enabled. Valid values for this parameter are:
	 *         <ul>
	 *         <li>0: Disabled
	 *         <li>1: Enabled
	 *         </ul>
	 *         </p>
	 *         <p>
	 *         Note: By default, Google applies filtering to all search results
	 *         to improve the quality of those results.
	 *         </p>
	 */
	public String getFilter() {
		return filter;
	}

	/**
	 * @param filter
	 *            <p>
	 *            Activates or deactivates the automatic filtering of Google
	 *            search results. See Automatic Filtering for more information
	 *            about Google's search results filters.
	 *            </p>
	 *            <p>
	 *            The default value for the filter parameter is 1, which
	 *            indicates that the feature is enabled. Valid values for this
	 *            parameter are:
	 *            <ul>
	 *            <li>0: Disabled
	 *            <li>1: Enabled
	 *            </ul>
	 *            </p>
	 *            <p>
	 *            Note: By default, Google applies filtering to all search
	 *            results to improve the quality of those results.
	 *            </p>
	 */
	public void setFilter(String filter) {
		this.filter = filter;
	}

	/**
	 * @return <p>
	 *         Boosts search results whose country of origin matches the
	 *         parameter value. See Country Codes for a list of valid values.
	 *         </p>
	 *         <p>
	 *         Specifying a gl parameter value in WebSearch requests should
	 *         improve the relevance of results. This is particularly true for
	 *         international customers and, even more specifically, for
	 *         customers in English-speaking countries other than the United
	 *         States.
	 *         </p>
	 */
	public String getGl() {
		return gl;
	}

	/**
	 * @param gl
	 *            <p>
	 *            Boosts search results whose country of origin matches the
	 *            parameter value. See Country Codes for a list of valid values.
	 *            </p>
	 *            <p>
	 *            Specifying a gl parameter value in WebSearch requests should
	 *            improve the relevance of results. This is particularly true
	 *            for international customers and, even more specifically, for
	 *            customers in English-speaking countries other than the United
	 *            States.
	 *            </p>
	 */
	public void setGl(String gl) {
		this.gl = gl;
	}

	/**
	 * @return <p>
	 *         Restricts search results to documents originating in a particular
	 *         country. You may use Boolean operators in the cr parameter's
	 *         value.
	 *         </p>
	 *         <p>
	 *         Google WebSearch determines the country of a document by
	 *         analyzing the following:
	 *         <ul>
	 *         <li>
	 *         The top-level domain (TLD) of the document's URL.
	 *         <li>
	 *         The geographic location of the web server's IP address.
	 *         </ul>
	 *         </p>
	 *         <p>
	 *         </p>
	 *         See Country (cr) Parameter Values for a list of valid values for
	 *         this parameter.
	 */
	public String getCr() {
		return cr;
	}

	/**
	 * @param cr
	 *            <p>
	 *            Restricts search results to documents originating in a
	 *            particular country. You may use Boolean operators in the cr
	 *            parameter's value.
	 *            </p>
	 *            <p>
	 *            Google WebSearch determines the country of a document by
	 *            analyzing the following:
	 *            <ul>
	 *            <li>
	 *            The top-level domain (TLD) of the document's URL.
	 *            <li>
	 *            The geographic location of the web server's IP address.
	 *            </ul>
	 *            </p>
	 *            <p>
	 *            </p>
	 *            See Country (cr) Parameter Values for a list of valid values
	 *            for this parameter.
	 */
	public void setCr(String cr) {
		this.cr = cr;
	}

	/**
	 * @return Specifies the Google domain (for example, google.com, google.de,
	 *         or google.fr) to which the search should be limited.
	 */
	public String getGoogleHost() {
		return googleHost;
	}

	/**
	 * @param googleHost
	 *            Specifies the Google domain (for example, google.com,
	 *            google.de, or google.fr) to which the search should be
	 *            limited.
	 */
	public void setGoogleHost(String googleHost) {
		this.googleHost = googleHost;
	}

	/**
	 * @return <p>
	 *         Enables or disables the Simplified and Traditional Chinese Search
	 *         feature.
	 *         </p>
	 *         <p>
	 *         Supported values are:
	 *         <ul>
	 *         <li>
	 *         0: enabled (default)
	 *         <li>
	 *         1: disabled
	 *         </p>
	 */
	public String getDisableCnTwTransition() {
		return disableCnTwTransition;
	}

	/**
	 * @param disableCnTwTransition
	 *            <p>
	 *            Enables or disables the Simplified and Traditional Chinese
	 *            Search feature.
	 *            </p>
	 *            <p>
	 *            Supported values are:
	 *            <ul>
	 *            <li>
	 *            0: enabled (default)
	 *            <li>
	 *            1: disabled
	 *            </p>
	 */
	public void setDisableCnTwTransition(String disableCnTwTransition) {
		this.disableCnTwTransition = disableCnTwTransition;
	}

	/**
	 * @return Appends the specified query terms to the query, as if they were
	 *         combined with a logical AND operator.
	 */
	public String getHq() {
		return hq;
	}

	/**
	 * @param hq
	 *            Appends the specified query terms to the query, as if they
	 *            were combined with a logical AND operator.
	 */
	public void setHq(String hq) {
		this.hq = hq;
	}

	/**
	 * @return <p>
	 *         Specifies the interface language (host language) of your user
	 *         interface. Explicitly setting this parameter improves the
	 *         performance and the quality of your search results.
	 *         </p>
	 *         <p>
	 *         See the Interface Languages section of Internationalizing Queries
	 *         and Results Presentation for more information, and Supported
	 *         Interface Languages for a list of supported languages.
	 *         </p>
	 */
	public String getHl() {
		return hl;
	}

	/**
	 * @param hl
	 *            <p>
	 *            Specifies the interface language (host language) of your user
	 *            interface. Explicitly setting this parameter improves the
	 *            performance and the quality of your search results.
	 *            </p>
	 *            <p>
	 *            See the Interface Languages section of Internationalizing
	 *            Queries and Results Presentation for more information, and
	 *            Supported Interface Languages for a list of supported
	 *            languages.
	 *            </p>
	 */
	public void setHl(String hl) {
		this.hl = hl;
	}

	/**
	 * @return Restricts results to URLs from a specified site.
	 */
	public String getSiteSearch() {
		return siteSearch;
	}

	/**
	 * @param siteSearch
	 *            Restricts results to URLs from a specified site.
	 */
	public void setSiteSearch(String siteSearch) {
		this.siteSearch = siteSearch;
	}

	/**
	 * @return Specifies whether to include or exclude results from the site
	 *         named in the sitesearch parameter. Supported values are:
	 *         <ul>
	 *         <li>
	 *         i: include content from site
	 *         <li>
	 *         e: exclude content from site
	 */
	public String getSiteSearchFilter() {
		return siteSearchFilter;
	}

	/**
	 * @param siteSearchFilter
	 *            Specifies whether to include or exclude results from the site
	 *            named in the sitesearch parameter. Supported values are:
	 *            <ul>
	 *            <li>
	 *            i: include content from site
	 *            <li>
	 *            e: exclude content from site
	 */
	public void setSiteSearchFilter(String siteSearchFilter) {
		this.siteSearchFilter = siteSearchFilter;
	}

	/**
	 * @return Identifies a phrase that all documents in the search results must
	 *         contain.
	 */
	public String getExactTerms() {
		return exactTerms;
	}

	/**
	 * @param exactTerms
	 *            Identifies a phrase that all documents in the search results
	 *            must contain.
	 */
	public void setExactTerms(String exactTerms) {
		this.exactTerms = exactTerms;
	}

	/**
	 * @return Identifies a word or phrase that should not appear in any
	 *         documents in the search results.
	 */
	public String getExcludeTerms() {
		return excludeTerms;
	}

	/**
	 * @param excludeTerms
	 *            Identifies a word or phrase that should not appear in any
	 *            documents in the search results.
	 */
	public void setExcludeTerms(String excludeTerms) {
		this.excludeTerms = excludeTerms;
	}

	/**
	 * @return Specifies that all results should contain a link to a specific
	 *         URL.
	 */
	public String getLinkSite() {
		return linkSite;
	}

	/**
	 * @param linkSite
	 *            Specifies that all results should contain a link to a specific
	 *            URL.
	 */
	public void setLinkSite(String linkSite) {
		this.linkSite = linkSite;
	}

	/**
	 * @return Provides additional search terms to check for in a document,
	 *         where each document in the search results must contain at least
	 *         one of the additional search terms. You can also use the Boolean
	 *         OR query term for this type of query.
	 */
	public String getOrTerms() {
		return orTerms;
	}

	/**
	 * @param orTerms
	 *            Provides additional search terms to check for in a document,
	 *            where each document in the search results must contain at
	 *            least one of the additional search terms. You can also use the
	 *            Boolean OR query term for this type of query.
	 */
	public void setOrTerms(String orTerms) {
		this.orTerms = orTerms;
	}

	/**
	 * @return Specifies that all search results should be pages that are
	 *         related to the specified URL. The parameter value should be a
	 *         URL.
	 */
	public String getRelatedSite() {
		return relatedSite;
	}

	/**
	 * @param relatedSite
	 *            Specifies that all search results should be pages that are
	 *            related to the specified URL. The parameter value should be a
	 *            URL.
	 */
	public void setRelatedSite(String relatedSite) {
		this.relatedSite = relatedSite;
	}

	/**
	 * @return Restricts results to URLs based on date. Supported values
	 *         include:
	 *         <ul>
	 *         <li>
	 *         d[number]: requests results from the specified number of past
	 *         days.
	 *         <li>
	 *         w[number]: requests results from the specified number of past
	 *         weeks.
	 *         <li>
	 *         m[number]: requests results from the specified number of past
	 *         months.
	 *         <li>
	 *         y[number]: requests results from the specified number of past
	 *         years.
	 */
	public String getDateRestrict() {
		return dateRestrict;
	}

	/**
	 * @param dateRestrict
	 *            Restricts results to URLs based on date. Supported values
	 *            include:
	 *            <ul>
	 *            <li>
	 *            d[number]: requests results from the specified number of past
	 *            days.
	 *            <li>
	 *            w[number]: requests results from the specified number of past
	 *            weeks.
	 *            <li>
	 *            m[number]: requests results from the specified number of past
	 *            months.
	 *            <li>
	 *            y[number]: requests results from the specified number of past
	 *            years.
	 */
	public void setDateRestrict(String dateRestrict) {
		this.dateRestrict = dateRestrict;
	}

	/**
	 * @return Specifies the starting value for a search range.<br>
	 *         Use cse:lowRange and cse:highrange to append an inclusive search
	 *         range of lowRange...highRange to the query.
	 */
	public String getLowRange() {
		return lowRange;
	}

	/**
	 * @param lowRange
	 *            Specifies the starting value for a search range.<br>
	 *            Use cse:lowRange and cse:highrange to append an inclusive
	 *            search range of lowRange...highRange to the query.
	 */
	public void setLowRange(String lowRange) {
		this.lowRange = lowRange;
	}

	/**
	 * @return Specifies the ending value for a search range.<br>
	 *         Use cse:lowRange and cse:highrange to append an inclusive search
	 *         range of lowRange...highRange to the query.
	 */
	public String getHighRange() {
		return highRange;
	}

	/**
	 * @param highRange
	 *            Specifies the ending value for a search range.<br>
	 *            Use cse:lowRange and cse:highrange to append an inclusive
	 *            search range of lowRange...highRange to the query.
	 */
	public void setHighRange(String highRange) {
		this.highRange = highRange;
	}

	/**
	 * @return <p>
	 *         Restricts results to files of a specified extension. Filetypes
	 *         supported by Google include:
	 *         <ul>
	 *         <li>Adobe Portable Document Format (pdf)
	 *         <li>
	 *         Adobe PostScript (ps)
	 *         <li>
	 *         Lotus 1-2-3 (wk1, wk2, wk3, wk4, wk5, wki, wks, wku)
	 *         <li>
	 *         Lotus WordPro (lwp)
	 *         <li>
	 *         Macwrite (mw)
	 *         <li>
	 *         Microsoft Excel (xls)
	 *         <li>
	 *         Microsoft PowerPoint (ppt)
	 *         <li>
	 *         Microsoft Word (doc)
	 *         <li>
	 *         Microsoft Works (wks, wps, wdb)
	 *         <li>
	 *         Microsoft Write (wri)
	 *         <li>
	 *         Rich Text Format (rtf)
	 *         <li>
	 *         Shockwave Flash (swf)
	 *         <li>
	 *         Text (ans, txt).
	 *         </ul>
	 *         </p>
	 *         <p>
	 *         Additional filetypes may be added in the future. An up-to-date
	 *         list can always be found in Google's file type FAQ.
	 *         </p>
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * @param fileType
	 *            <p>
	 *            Restricts results to files of a specified extension. Filetypes
	 *            supported by Google include:
	 *            <ul>
	 *            <li>Adobe Portable Document Format (pdf)
	 *            <li>
	 *            Adobe PostScript (ps)
	 *            <li>
	 *            Lotus 1-2-3 (wk1, wk2, wk3, wk4, wk5, wki, wks, wku)
	 *            <li>
	 *            Lotus WordPro (lwp)
	 *            <li>
	 *            Macwrite (mw)
	 *            <li>
	 *            Microsoft Excel (xls)
	 *            <li>
	 *            Microsoft PowerPoint (ppt)
	 *            <li>
	 *            Microsoft Word (doc)
	 *            <li>
	 *            Microsoft Works (wks, wps, wdb)
	 *            <li>
	 *            Microsoft Write (wri)
	 *            <li>
	 *            Rich Text Format (rtf)
	 *            <li>
	 *            Shockwave Flash (swf)
	 *            <li>
	 *            Text (ans, txt).
	 *            </ul>
	 *            </p>
	 *            <p>
	 *            Additional filetypes may be added in the future. An up-to-date
	 *            list can always be found in Google's file type FAQ.
	 *            </p>
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	/**
	 * @return Filters based on licensing. Supported values include:
	 *         <ul>
	 *         <li>
	 *         cc_publicdomain
	 *         <li>
	 *         cc_attribute
	 *         <li>
	 *         cc_sharealike
	 *         <li>
	 *         cc_noncommercial
	 *         <li>
	 *         cc_nonderived
	 */
	public String getRights() {
		return rights;
	}

	/**
	 * @param rights
	 *            Filters based on licensing. Supported values include:
	 *            <ul>
	 *            <li>
	 *            cc_publicdomain
	 *            <li>
	 *            cc_attribute
	 *            <li>
	 *            cc_sharealike
	 *            <li>
	 *            cc_noncommercial
	 *            <li>
	 *            cc_nonderived
	 */
	public void setRights(String rights) {
		this.rights = rights;
	}

	/**
	 * @return Allowed values are web or image. If unspecified, results are
	 *         limited to webpages.
	 */
	public String getSearchType() {
		return searchType;
	}

	/**
	 * @param searchType
	 *            Allowed values are web or image. If unspecified, results are
	 *            limited to webpages.
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	/**
	 * @return Restricts results to images of a specified size. Supported values
	 *         are:
	 *         <ul>
	 *         <li>
	 *         icon (small)
	 *         <li>
	 *         small|medium|large|xlarge (medium)
	 *         <li>
	 *         xxlarge (large)
	 *         <li>
	 *         huge (extra-large)
	 */
	public String getImgSize() {
		return imgSize;
	}

	/**
	 * @param imgSize
	 *            Restricts results to images of a specified size. Supported
	 *            values are:
	 *            <ul>
	 *            <li>
	 *            icon (small)
	 *            <li>
	 *            small|medium|large|xlarge (medium)
	 *            <li>
	 *            xxlarge (large)
	 *            <li>
	 *            huge (extra-large)
	 */
	public void setImgSize(String imgSize) {
		this.imgSize = imgSize;
	}

	/**
	 * @return Restricts results to images of a specified type. Supported values
	 *         are:
	 *         <ul>
	 *         <li>
	 *         clipart (clipart)
	 *         <li>
	 *         face (face)
	 *         <li>
	 *         lineart (lineart)
	 *         <li>
	 *         news (news)
	 *         <li>
	 *         photo (photo)
	 */
	public String getImgType() {
		return imgType;
	}

	/**
	 * @param imgType
	 *            Restricts results to images of a specified type. Supported
	 *            values are:
	 *            <ul>
	 *            <li>
	 *            clipart (clipart)
	 *            <li>
	 *            face (face)
	 *            <li>
	 *            lineart (lineart)
	 *            <li>
	 *            news (news)
	 *            <li>
	 *            photo (photo)
	 */
	public void setImgType(String imgType) {
		this.imgType = imgType;
	}

	/**
	 * @return Restricts results to images of a specified color type. Supported
	 *         values are:
	 *         <ul>
	 *         <li>
	 *         mono (black and white)
	 *         <li>
	 *         gray (grayscale)
	 *         <li>
	 *         color (color)
	 */
	public String getImgColorType() {
		return imgColorType;
	}

	/**
	 * @param imgColorType
	 *            Restricts results to images of a specified color type.
	 *            Supported values are:
	 *            <ul>
	 *            <li>
	 *            mono (black and white)
	 *            <li>
	 *            gray (grayscale)
	 *            <li>
	 *            color (color)
	 */
	public void setImgColorType(String imgColorType) {
		this.imgColorType = imgColorType;
	}

	/**
	 * @return Restricts results to images with a specific dominant color.
	 *         Supported values are:
	 *         <ul>
	 *         <li>
	 *         yellow
	 *         <li>
	 *         green
	 *         <li>
	 *         teal
	 *         <li>
	 *         blue
	 *         <li>
	 *         purple
	 *         <li>
	 *         pink
	 *         <li>
	 *         white
	 *         <li>
	 *         gray
	 *         <li>
	 *         black
	 *         <li>
	 *         brown
	 */
	public String getImgDominantColor() {
		return imgDominantColor;
	}

	/**
	 * @param imgDominantColor
	 *            Restricts results to images with a specific dominant color.
	 *            Supported values are:
	 *            <ul>
	 *            <li>
	 *            yellow
	 *            <li>
	 *            green
	 *            <li>
	 *            teal
	 *            <li>
	 *            blue
	 *            <li>
	 *            purple
	 *            <li>
	 *            pink
	 *            <li>
	 *            white
	 *            <li>
	 *            gray
	 *            <li>
	 *            black
	 *            <li>
	 *            brown
	 */
	public void setImgDominantColor(String imgDominantColor) {
		this.imgDominantColor = imgDominantColor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Type: Role \ntitle=");
		builder.append(title);
		builder.append(",\ntotalResults=");
		builder.append(totalResults);
		builder.append(",\nsearchTerms=");
		builder.append(searchTerms);
		builder.append(",\ncount=");
		builder.append(count);
		builder.append(",\nstartIndex=");
		builder.append(startIndex);
		builder.append(",\nstartPage=");
		builder.append(startPage);
		builder.append(",\nlanguage=");
		builder.append(language);
		builder.append(",\ninputEncoding=");
		builder.append(inputEncoding);
		builder.append(",\noutputEncoding=");
		builder.append(outputEncoding);
		builder.append(",\nsafe=");
		builder.append(safe);
		builder.append(",\ncx=");
		builder.append(cx);
		builder.append(",\ncref=");
		builder.append(cref);
		builder.append(",\nsort=");
		builder.append(sort);
		builder.append(",\nfilter=");
		builder.append(filter);
		builder.append(",\ngl=");
		builder.append(gl);
		builder.append(",\ncr=");
		builder.append(cr);
		builder.append(",\ngoogleHost=");
		builder.append(googleHost);
		builder.append(",\ndisableCnTwTransition=");
		builder.append(disableCnTwTransition);
		builder.append(",\nhq=");
		builder.append(hq);
		builder.append(",\nhl=");
		builder.append(hl);
		builder.append(",\nsiteSearch=");
		builder.append(siteSearch);
		builder.append(",\nsiteSearchFilter=");
		builder.append(siteSearchFilter);
		builder.append(",\nexactTerms=");
		builder.append(exactTerms);
		builder.append(",\nexcludeTerms=");
		builder.append(excludeTerms);
		builder.append(",\nlinkSite=");
		builder.append(linkSite);
		builder.append(",\norTerms=");
		builder.append(orTerms);
		builder.append(",\nrelatedSite=");
		builder.append(relatedSite);
		builder.append(",\ndateRestrict=");
		builder.append(dateRestrict);
		builder.append(",\nlowRange=");
		builder.append(lowRange);
		builder.append(",\nhighRange=");
		builder.append(highRange);
		builder.append(",\nfileType=");
		builder.append(fileType);
		builder.append(",\nrights=");
		builder.append(rights);
		builder.append(",\nsearchType=");
		builder.append(searchType);
		builder.append(",\nimgSize=");
		builder.append(imgSize);
		builder.append(",\nimgType=");
		builder.append(imgType);
		builder.append(",\nimgColorType=");
		builder.append(imgColorType);
		builder.append(",\nimgDominantColor=");
		builder.append(imgDominantColor);
		return builder.toString();
	}

}
