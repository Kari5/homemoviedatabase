package hu.bme.dtt.torusalbum.util.search.model;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * The object representing a search HTTP request.
 * 
 * @author Shazak
 * 
 */
public class Request {
	/**
	 * The URL for the Google Custom Search API.
	 */
	private static final String GOOGLE_URL = "https://www.googleapis.com/customsearch/v1?";
	/**
	 * Query. REQUIRED!
	 */
	private String q;
	/**
	 * Your API key. REQUIRED!
	 */
	private String key;
	/**
	 * Data format for the response.
	 * <ul>
	 * <li>Valid values: json, atom
	 * <li>Default value: json
	 */
	private String alt;
	/**
	 * OAuth 2.0 token for the current user.
	 */
	private String access_token;
	/**
	 * IP address of the end user for whom the API call is being made.
	 */
	private String userIp;
	/**
	 * Turns off the translation between zh-CN and zh-TW.
	 */
	private String c2coff;
	/**
	 * Country restrict(s).
	 */
	private String cr;
	/**
	 * The URL of a linked custom search engine. This or the cx parameter
	 * REQUIRED!
	 */
	private String cref;
	/**
	 * The custom search engine ID to scope this search query. This or the cref
	 * parameter REQUIRED!
	 */
	private String cx;
	/**
	 * Specifies all search results are from a time period.
	 */
	private String dateRestrict;
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
	 * Returns images of a specified type. Some of the allowed values are: bmp,
	 * gif, png, jpg, svg, pdf ...
	 */
	private String fileType;
	/**
	 * <p>
	 * Controls turning on or off the duplicate content filter.
	 * </p>
	 * <p>
	 * Acceptable values are:
	 * <ul>
	 * <li>
	 * "0" - Turns off duplicate content filter.
	 * <li>
	 * "1" - Turns on duplicate content filter.
	 * </ul>
	 * </p>
	 */
	private String filter;
	/**
	 * Geolocation of end user.
	 */
	private String gl;
	/**
	 * The local Google domain to use to perform the search.
	 */
	private String googlehost;
	/**
	 * Creates a range in form as_nlo value..as_nhi. value and attempts to
	 * append it to query
	 */
	private String highRange;
	/**
	 * Sets the user interface language.
	 */
	private String hl;
	/**
	 * Appends the extra query terms to the query.
	 */
	private String hq;
	/**
	 * <p>
	 * Returns black and white, grayscale, or color images: mono, gray, and
	 * color.
	 * </p>
	 * <p>
	 * Acceptable values are:
	 * <ul>
	 * <li>
	 * "color" - color
	 * <li>
	 * "gray" - gray
	 * <li>
	 * "mono" - mono
	 * </ul>
	 * </p>
	 */
	private String imgColorType;
	/**
	 * <p>
	 * Returns images of a specific dominant color: yellow, green, teal, blue,
	 * purple, pink, white, gray, black, or brown.
	 * </p>
	 * <p>
	 * Acceptable values are:
	 * <ul>
	 * <li>
	 * "black" - black
	 * <li>
	 * "blue" - blue
	 * <li>
	 * "brown" - brown
	 * <li>
	 * "gray" - gray
	 * <li>
	 * "green" - green
	 * <li>
	 * "pink" - pink
	 * <li>
	 * "purple" - purple
	 * <li>
	 * "teal" - teal
	 * <li>
	 * "white" - white
	 * <li>
	 * "yellow" - yellow
	 * </ul>
	 * </p>
	 */
	private String imgDominantColor;
	/**
	 * <p>
	 * Returns images of a specified size, where size can be one of: icon,
	 * small, medium, large, xlarge, xxlarge, or huge.
	 * </p>
	 * <p>
	 * Acceptable values are:
	 * <ul>
	 * <li>
	 * "huge" - huge
	 * <li>
	 * "icon" - icon
	 * <li>
	 * "large" - large
	 * <li>
	 * "medium" - medium
	 * <li>
	 * "small" - small
	 * <li>
	 * "xlarge" - xlarge
	 * <li>
	 * "xxlarge" - xxlarge
	 * </ul>
	 * </p>
	 */
	private String imgSize;
	/**
	 * <p>
	 * Returns images of a type, which can be one of: clipart, face, lineart,
	 * news, and photo.
	 * </p>
	 * <p>
	 * Acceptable values are:
	 * <ul>
	 * <li>
	 * "clipart" - clipart
	 * <li>
	 * "face" - face
	 * <li>
	 * "lineart" - lineart
	 * <li>
	 * "news" - news
	 * <li>
	 * "photo" - photo
	 * </ul>
	 * </p>
	 */
	private String imgType;
	/**
	 * Specifies that all search results should contain a link to a particular
	 * URL
	 */
	private String linkSite;
	/**
	 * Creates a range in form as_nlo value..as_nhi value and attempts to append
	 * it to query.
	 */
	private String lowRange;
	/**
	 * <p>
	 * The language restriction for the search results.
	 * </p>
	 * <p>
	 * Acceptable values are:
	 * <ul>
	 * <li>
	 * "lang_ar" - Arabic
	 * <li>
	 * "lang_bg" - Bulgarian
	 * <li>
	 * "lang_ca" - Catalan
	 * <li>
	 * "lang_cs" - Czech
	 * <li>
	 * "lang_da" - Danish
	 * <li>
	 * "lang_de" - German
	 * <li>
	 * "lang_el" - Greek
	 * <li>
	 * "lang_en" - English
	 * <li>
	 * "lang_es" - Spanish
	 * <li>
	 * "lang_et" - Estonian
	 * <li>
	 * "lang_fi" - Finnish
	 * <li>
	 * "lang_fr" - French
	 * <li>
	 * "lang_hr" - Croatian
	 * <li>
	 * "lang_hu" - Hungarian
	 * <li>
	 * "lang_id" - Indonesian
	 * <li>
	 * "lang_is" - Icelandic
	 * <li>
	 * "lang_it" - Italian
	 * <li>
	 * "lang_iw" - Hebrew
	 * <li>
	 * "lang_ja" - Japanese
	 * <li>
	 * "lang_ko" - Korean
	 * <li>
	 * "lang_lt" - Lithuanian
	 * <li>
	 * "lang_lv" - Latvian
	 * <li>
	 * "lang_nl" - Dutch
	 * <li>
	 * "lang_no" - Norwegian
	 * <li>
	 * "lang_pl" - Polish
	 * <li>
	 * "lang_pt" - Portuguese
	 * <li>
	 * "lang_ro" - Romanian
	 * <li>
	 * "lang_ru" - Russian
	 * <li>
	 * "lang_sk" - Slovak
	 * <li>
	 * "lang_sl" - Slovenian
	 * <li>
	 * "lang_sr" - Serbian
	 * <li>
	 * "lang_sv" - Swedish
	 * <li>
	 * "lang_tr" - Turkish
	 * <li>
	 * "lang_zh-CN" - Chinese (Simplified)
	 * <li>
	 * "lang_zh-TW" - Chinese (Traditional)
	 * </ul>
	 * </p>
	 */
	private String lr;
	/**
	 * Number of search results to return. (unsigned int)
	 */
	private Integer num;
	/**
	 * Provides additional search terms to check for in a document, where each
	 * document in the search results must contain at least one of the
	 * additional search terms.
	 */
	private String orTerms;
	/**
	 * Specifies that all search results should be pages that are related to the
	 * specified URL.
	 */
	private String relatedSite;
	/**
	 * Filters based on licensing. Supported values include: cc_publicdomain,
	 * cc_attribute, cc_sharealike, cc_noncommercial, cc_nonderived, and
	 * combinations of these.
	 */
	private String rights;
	/**
	 * <p>
	 * Search safety level.
	 * </p>
	 * <p>
	 * Acceptable values are:
	 * <ul>
	 * <li>
	 * "high" - Enables highest level of SafeSearch filtering.
	 * <li>
	 * "medium" - Enables moderate SafeSearch filtering.
	 * <li>
	 * "off" - Disables SafeSearch filtering. (default)
	 * </ul>
	 * </p>
	 */
	private String safe;
	/**
	 * <p>
	 * Specifies the search type: image.
	 * </p>
	 * <p>
	 * Acceptable values are:
	 * <ul>
	 * <li>
	 * "image" - custom image search.
	 * </ul>
	 * </p>
	 */
	private String searchType;
	/**
	 * Specifies all search results should be pages from a given site.
	 */
	private String siteSearch;
	/**
	 * <p>
	 * Controls whether to include or exclude results from the site named in the
	 * as_sitesearch parameter.
	 * </p>
	 * <p>
	 * Acceptable values are:
	 * <ul>
	 * <li>
	 * "e" - exclude
	 * <li>
	 * "i" - include
	 * </ul>
	 * </p>
	 */
	private String siteSearchFilter;
	/**
	 * The sort expression to apply to the results.
	 */
	private String sort;
	/**
	 * The index of the first result to return. (unsigned int)
	 */
	private Integer start;

	/**
	 * @return Query. REQUIRED!
	 */
	public String getQ() {
		return q;
	}

	/**
	 * @param q
	 *            Query. REQUIRED!
	 */
	public void setQ(String q) {
		this.q = q;
	}

	/**
	 * @param key
	 *            Your API key. REQUIRED!
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return Your API key. REQUIRED!
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @return Turns off the translation between zh-CN and zh-TW.
	 */
	public String getC2coff() {
		return c2coff;
	}

	/**
	 * @param c2coff
	 *            Turns off the translation between zh-CN and zh-TW.
	 */
	public void setC2coff(String c2coff) {
		this.c2coff = c2coff;
	}

	/**
	 * @return Country restrict(s).
	 */
	public String getCr() {
		return cr;
	}

	/**
	 * @param cr
	 *            Country restrict(s).
	 */
	public void setCr(String cr) {
		this.cr = cr;
	}

	/**
	 * @param cref
	 *            The URL of a linked custom search engine.
	 */
	public void setCref(String cref) {
		this.cref = cref;
	}

	/**
	 * @return The URL of a linked custom search engine.
	 */
	public String getCref() {
		return cref;
	}

	/**
	 * @param cx
	 *            The custom search engine ID to scope this search query.
	 */
	public void setCx(String cx) {
		this.cx = cx;
	}

	/**
	 * @return The custom search engine ID to scope this search query.
	 */
	public String getCx() {
		return cx;
	}

	/**
	 * @return Specifies all search results are from a time period.
	 */
	public String getDateRestrict() {
		return dateRestrict;
	}

	/**
	 * @param dateRestrict
	 *            Specifies all search results are from a time period.
	 */
	public void setDateRestrict(String dateRestrict) {
		this.dateRestrict = dateRestrict;
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
	 * @return Returns images of a specified type. Some of the allowed values
	 *         are: bmp, gif, png, jpg, svg, pdf ...
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * @param fileType
	 *            Returns images of a specified type. Some of the allowed values
	 *            are: bmp, gif, png, jpg, svg, pdf ...
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	/**
	 * @return <p>
	 *         Controls turning on or off the duplicate content filter.
	 *         </p>
	 *         <p>
	 *         Acceptable values are:
	 *         <ul>
	 *         <li>
	 *         "0" - Turns off duplicate content filter.
	 *         <li>
	 *         "1" - Turns on duplicate content filter.
	 *         </ul>
	 *         </p>
	 */
	public String getFilter() {
		return filter;
	}

	/**
	 * @param filter
	 *            <p>
	 *            Controls turning on or off the duplicate content filter.
	 *            </p>
	 *            <p>
	 *            Acceptable values are:
	 *            <ul>
	 *            <li>
	 *            "0" - Turns off duplicate content filter.
	 *            <li>
	 *            "1" - Turns on duplicate content filter.
	 *            </ul>
	 *            </p>
	 */
	public void setFilter(String filter) {
		this.filter = filter;
	}

	/**
	 * @return Geolocation of end user.
	 */
	public String getGl() {
		return gl;
	}

	/**
	 * @param gl
	 *            Geolocation of end user.
	 */
	public void setGl(String gl) {
		this.gl = gl;
	}

	/**
	 * @return The local Google domain to use to perform the search.
	 */
	public String getGooglehost() {
		return googlehost;
	}

	/**
	 * @param googlehost
	 *            The local Google domain to use to perform the search.
	 */
	public void setGooglehost(String googlehost) {
		this.googlehost = googlehost;
	}

	/**
	 * @return Creates a range in form as_nlo value..as_nhi. value and attempts
	 *         to append it to query
	 */
	public String getHighRange() {
		return highRange;
	}

	/**
	 * @param highRange
	 *            Creates a range in form as_nlo value..as_nhi. value and
	 *            attempts to append it to query
	 */
	public void setHighRange(String highRange) {
		this.highRange = highRange;
	}

	/**
	 * @return Sets the user interface language.
	 */
	public String getHl() {
		return hl;
	}

	/**
	 * @param hl
	 *            Sets the user interface language.
	 */
	public void setHl(String hl) {
		this.hl = hl;
	}

	/**
	 * @return Appends the extra query terms to the query.
	 */
	public String getHq() {
		return hq;
	}

	/**
	 * @param hq
	 *            Appends the extra query terms to the query.
	 */
	public void setHq(String hq) {
		this.hq = hq;
	}

	/**
	 * @return <p>
	 *         Returns black and white, grayscale, or color images: mono, gray,
	 *         and color.
	 *         </p>
	 *         <p>
	 *         Acceptable values are:
	 *         <ul>
	 *         <li>
	 *         "color" - color
	 *         <li>
	 *         "gray" - gray
	 *         <li>
	 *         "mono" - mono
	 *         </ul>
	 *         </p>
	 */
	public String getImgColorType() {
		return imgColorType;
	}

	/**
	 * @param imgColorType
	 *            <p>
	 *            Returns black and white, grayscale, or color images: mono,
	 *            gray, and color.
	 *            </p>
	 *            <p>
	 *            Acceptable values are:
	 *            <ul>
	 *            <li>
	 *            "color" - color
	 *            <li>
	 *            "gray" - gray
	 *            <li>
	 *            "mono" - mono
	 *            </ul>
	 *            </p>
	 */
	public void setImgColorType(String imgColorType) {
		this.imgColorType = imgColorType;
	}

	/**
	 * @return <p>
	 *         Returns images of a specific dominant color: yellow, green, teal,
	 *         blue, purple, pink, white, gray, black, or brown.
	 *         </p>
	 *         <p>
	 *         Acceptable values are:
	 *         <ul>
	 *         <li>
	 *         "black" - black
	 *         <li>
	 *         "blue" - blue
	 *         <li>
	 *         "brown" - brown
	 *         <li>
	 *         "gray" - gray
	 *         <li>
	 *         "green" - green
	 *         <li>
	 *         "pink" - pink
	 *         <li>
	 *         "purple" - purple
	 *         <li>
	 *         "teal" - teal
	 *         <li>
	 *         "white" - white
	 *         <li>
	 *         "yellow" - yellow
	 *         </ul>
	 *         </p>
	 */
	public String getImgDominantColor() {
		return imgDominantColor;
	}

	/**
	 * @param imgDominantColor
	 *            <p>
	 *            Returns images of a specific dominant color: yellow, green,
	 *            teal, blue, purple, pink, white, gray, black, or brown.
	 *            </p>
	 *            <p>
	 *            Acceptable values are:
	 *            <ul>
	 *            <li>
	 *            "black" - black
	 *            <li>
	 *            "blue" - blue
	 *            <li>
	 *            "brown" - brown
	 *            <li>
	 *            "gray" - gray
	 *            <li>
	 *            "green" - green
	 *            <li>
	 *            "pink" - pink
	 *            <li>
	 *            "purple" - purple
	 *            <li>
	 *            "teal" - teal
	 *            <li>
	 *            "white" - white
	 *            <li>
	 *            "yellow" - yellow
	 *            </ul>
	 *            </p>
	 */
	public void setImgDominantColor(String imgDominantColor) {
		this.imgDominantColor = imgDominantColor;
	}

	/**
	 * @return <p>
	 *         Returns images of a specified size, where size can be one of:
	 *         icon, small, medium, large, xlarge, xxlarge, or huge.
	 *         </p>
	 *         <p>
	 *         Acceptable values are:
	 *         <ul>
	 *         <li>
	 *         "huge" - huge
	 *         <li>
	 *         "icon" - icon
	 *         <li>
	 *         "large" - large
	 *         <li>
	 *         "medium" - medium
	 *         <li>
	 *         "small" - small
	 *         <li>
	 *         "xlarge" - xlarge
	 *         <li>
	 *         "xxlarge" - xxlarge
	 *         </ul>
	 *         </p>
	 */
	public String getImgSize() {
		return imgSize;
	}

	/**
	 * @param imgSize
	 *            <p>
	 *            Returns images of a specified size, where size can be one of:
	 *            icon, small, medium, large, xlarge, xxlarge, or huge.
	 *            </p>
	 *            <p>
	 *            Acceptable values are:
	 *            <ul>
	 *            <li>
	 *            "huge" - huge
	 *            <li>
	 *            "icon" - icon
	 *            <li>
	 *            "large" - large
	 *            <li>
	 *            "medium" - medium
	 *            <li>
	 *            "small" - small
	 *            <li>
	 *            "xlarge" - xlarge
	 *            <li>
	 *            "xxlarge" - xxlarge
	 *            </ul>
	 *            </p>
	 */
	public void setImgSize(String imgSize) {
		this.imgSize = imgSize;
	}

	/**
	 * @return <p>
	 *         Returns images of a type, which can be one of: clipart, face,
	 *         lineart, news, and photo.
	 *         </p>
	 *         <p>
	 *         Acceptable values are:
	 *         <ul>
	 *         <li>
	 *         "clipart" - clipart
	 *         <li>
	 *         "face" - face
	 *         <li>
	 *         "lineart" - lineart
	 *         <li>
	 *         "news" - news
	 *         <li>
	 *         "photo" - photo
	 *         </ul>
	 *         </p>
	 */
	public String getImgType() {
		return imgType;
	}

	/**
	 * @param imgType
	 *            <p>
	 *            Returns images of a type, which can be one of: clipart, face,
	 *            lineart, news, and photo.
	 *            </p>
	 *            <p>
	 *            Acceptable values are:
	 *            <ul>
	 *            <li>
	 *            "clipart" - clipart
	 *            <li>
	 *            "face" - face
	 *            <li>
	 *            "lineart" - lineart
	 *            <li>
	 *            "news" - news
	 *            <li>
	 *            "photo" - photo
	 *            </ul>
	 *            </p>
	 */
	public void setImgType(String imgType) {
		this.imgType = imgType;
	}

	/**
	 * @return Specifies that all search results should contain a link to a
	 *         particular URL
	 */
	public String getLinkSite() {
		return linkSite;
	}

	/**
	 * @param linkSite
	 *            Specifies that all search results should contain a link to a
	 *            particular URL
	 */
	public void setLinkSite(String linkSite) {
		this.linkSite = linkSite;
	}

	/**
	 * @return Creates a range in form as_nlo value..as_nhi value and attempts
	 *         to append it to query.
	 */
	public String getLowRange() {
		return lowRange;
	}

	/**
	 * @param lowRange
	 *            Creates a range in form as_nlo value..as_nhi value and
	 *            attempts to append it to query.
	 */
	public void setLowRange(String lowRange) {
		this.lowRange = lowRange;
	}

	/**
	 * @return <p>
	 *         The language restriction for the search results.
	 *         </p>
	 *         <p>
	 *         Acceptable values are:
	 *         <ul>
	 *         <li>
	 *         "lang_ar" - Arabic
	 *         <li>
	 *         "lang_bg" - Bulgarian
	 *         <li>
	 *         "lang_ca" - Catalan
	 *         <li>
	 *         "lang_cs" - Czech
	 *         <li>
	 *         "lang_da" - Danish
	 *         <li>
	 *         "lang_de" - German
	 *         <li>
	 *         "lang_el" - Greek
	 *         <li>
	 *         "lang_en" - English
	 *         <li>
	 *         "lang_es" - Spanish
	 *         <li>
	 *         "lang_et" - Estonian
	 *         <li>
	 *         "lang_fi" - Finnish
	 *         <li>
	 *         "lang_fr" - French
	 *         <li>
	 *         "lang_hr" - Croatian
	 *         <li>
	 *         "lang_hu" - Hungarian
	 *         <li>
	 *         "lang_id" - Indonesian
	 *         <li>
	 *         "lang_is" - Icelandic
	 *         <li>
	 *         "lang_it" - Italian
	 *         <li>
	 *         "lang_iw" - Hebrew
	 *         <li>
	 *         "lang_ja" - Japanese
	 *         <li>
	 *         "lang_ko" - Korean
	 *         <li>
	 *         "lang_lt" - Lithuanian
	 *         <li>
	 *         "lang_lv" - Latvian
	 *         <li>
	 *         "lang_nl" - Dutch
	 *         <li>
	 *         "lang_no" - Norwegian
	 *         <li>
	 *         "lang_pl" - Polish
	 *         <li>
	 *         "lang_pt" - Portuguese
	 *         <li>
	 *         "lang_ro" - Romanian
	 *         <li>
	 *         "lang_ru" - Russian
	 *         <li>
	 *         "lang_sk" - Slovak
	 *         <li>
	 *         "lang_sl" - Slovenian
	 *         <li>
	 *         "lang_sr" - Serbian
	 *         <li>
	 *         "lang_sv" - Swedish
	 *         <li>
	 *         "lang_tr" - Turkish
	 *         <li>
	 *         "lang_zh-CN" - Chinese (Simplified)
	 *         <li>
	 *         "lang_zh-TW" - Chinese (Traditional)
	 *         </ul>
	 *         </p>
	 */
	public String getLr() {
		return lr;
	}

	/**
	 * @param lr
	 *            <p>
	 *            The language restriction for the search results.
	 *            </p>
	 *            <p>
	 *            Acceptable values are:
	 *            <ul>
	 *            <li>
	 *            "lang_ar" - Arabic
	 *            <li>
	 *            "lang_bg" - Bulgarian
	 *            <li>
	 *            "lang_ca" - Catalan
	 *            <li>
	 *            "lang_cs" - Czech
	 *            <li>
	 *            "lang_da" - Danish
	 *            <li>
	 *            "lang_de" - German
	 *            <li>
	 *            "lang_el" - Greek
	 *            <li>
	 *            "lang_en" - English
	 *            <li>
	 *            "lang_es" - Spanish
	 *            <li>
	 *            "lang_et" - Estonian
	 *            <li>
	 *            "lang_fi" - Finnish
	 *            <li>
	 *            "lang_fr" - French
	 *            <li>
	 *            "lang_hr" - Croatian
	 *            <li>
	 *            "lang_hu" - Hungarian
	 *            <li>
	 *            "lang_id" - Indonesian
	 *            <li>
	 *            "lang_is" - Icelandic
	 *            <li>
	 *            "lang_it" - Italian
	 *            <li>
	 *            "lang_iw" - Hebrew
	 *            <li>
	 *            "lang_ja" - Japanese
	 *            <li>
	 *            "lang_ko" - Korean
	 *            <li>
	 *            "lang_lt" - Lithuanian
	 *            <li>
	 *            "lang_lv" - Latvian
	 *            <li>
	 *            "lang_nl" - Dutch
	 *            <li>
	 *            "lang_no" - Norwegian
	 *            <li>
	 *            "lang_pl" - Polish
	 *            <li>
	 *            "lang_pt" - Portuguese
	 *            <li>
	 *            "lang_ro" - Romanian
	 *            <li>
	 *            "lang_ru" - Russian
	 *            <li>
	 *            "lang_sk" - Slovak
	 *            <li>
	 *            "lang_sl" - Slovenian
	 *            <li>
	 *            "lang_sr" - Serbian
	 *            <li>
	 *            "lang_sv" - Swedish
	 *            <li>
	 *            "lang_tr" - Turkish
	 *            <li>
	 *            "lang_zh-CN" - Chinese (Simplified)
	 *            <li>
	 *            "lang_zh-TW" - Chinese (Traditional)
	 *            </ul>
	 *            </p>
	 */
	public void setLr(String lr) {
		this.lr = lr;
	}

	/**
	 * @return Number of search results to return. (unsigned int)
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 * @param num
	 *            Number of search results to return. (unsigned int)
	 */
	public void setNum(Integer num) {
		if (num < 0) {
			throw new IllegalArgumentException(
					"Parameter num must be non negative!");
		}
		this.num = num;
	}

	/**
	 * @return Provides additional search terms to check for in a document,
	 *         where each document in the search results must contain at least
	 *         one of the additional search terms.
	 */
	public String getOrTerms() {
		return orTerms;
	}

	/**
	 * @param orTerms
	 *            Provides additional search terms to check for in a document,
	 *            where each document in the search results must contain at
	 *            least one of the additional search terms.
	 */
	public void setOrTerms(String orTerms) {
		this.orTerms = orTerms;
	}

	/**
	 * @return Specifies that all search results should be pages that are
	 *         related to the specified URL.
	 */
	public String getRelatedSite() {
		return relatedSite;
	}

	/**
	 * @param relatedSite
	 *            Specifies that all search results should be pages that are
	 *            related to the specified URL.
	 */
	public void setRelatedSite(String relatedSite) {
		this.relatedSite = relatedSite;
	}

	/**
	 * @return Filters based on licensing. Supported values include:
	 *         cc_publicdomain, cc_attribute, cc_sharealike, cc_noncommercial,
	 *         cc_nonderived, and combinations of these.
	 */
	public String getRights() {
		return rights;
	}

	/**
	 * @param rights
	 *            Filters based on licensing. Supported values include:
	 *            cc_publicdomain, cc_attribute, cc_sharealike,
	 *            cc_noncommercial, cc_nonderived, and combinations of these.
	 */
	public void setRights(String rights) {
		this.rights = rights;
	}

	/**
	 * @return <p>
	 *         Search safety level.
	 *         </p>
	 *         <p>
	 *         Acceptable values are:
	 *         <ul>
	 *         <li>
	 *         "high" - Enables highest level of SafeSearch filtering.
	 *         <li>
	 *         "medium" - Enables moderate SafeSearch filtering.
	 *         <li>
	 *         "off" - Disables SafeSearch filtering. (default)
	 *         </ul>
	 *         </p>
	 */
	public String getSafe() {
		return safe;
	}

	/**
	 * @param safe
	 *            <p>
	 *            Search safety level.
	 *            </p>
	 *            <p>
	 *            Acceptable values are:
	 *            <ul>
	 *            <li>
	 *            "high" - Enables highest level of SafeSearch filtering.
	 *            <li>
	 *            "medium" - Enables moderate SafeSearch filtering.
	 *            <li>
	 *            "off" - Disables SafeSearch filtering. (default)
	 *            </ul>
	 *            </p>
	 */
	public void setSafe(String safe) {
		this.safe = safe;
	}

	/**
	 * @return <p>
	 *         Specifies the search type: image.
	 *         </p>
	 *         <p>
	 *         Acceptable values are:
	 *         <ul>
	 *         <li>
	 *         "image" - custom image search.
	 *         </ul>
	 *         </p>
	 */
	public String getSearchType() {
		return searchType;
	}

	/**
	 * @param searchType
	 *            <p>
	 *            Specifies the search type: image.
	 *            </p>
	 *            <p>
	 *            Acceptable values are:
	 *            <ul>
	 *            <li>
	 *            "image" - custom image search.
	 *            </ul>
	 *            </p>
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	/**
	 * @return Specifies all search results should be pages from a given site.
	 */
	public String getSiteSearch() {
		return siteSearch;
	}

	/**
	 * @param siteSearch
	 *            Specifies all search results should be pages from a given
	 *            site.
	 */
	public void setSiteSearch(String siteSearch) {
		this.siteSearch = siteSearch;
	}

	/**
	 * @return <p>
	 *         Controls whether to include or exclude results from the site
	 *         named in the as_sitesearch parameter.
	 *         </p>
	 *         <p>
	 *         Acceptable values are:
	 *         <ul>
	 *         <li>
	 *         "e" - exclude
	 *         <li>
	 *         "i" - include
	 *         </ul>
	 *         </p>
	 */
	public String getSiteSearchFilter() {
		return siteSearchFilter;
	}

	/**
	 * @param siteSearchFilter
	 *            <p>
	 *            Controls whether to include or exclude results from the site
	 *            named in the as_sitesearch parameter.
	 *            </p>
	 *            <p>
	 *            Acceptable values are:
	 *            <ul>
	 *            <li>
	 *            "e" - exclude
	 *            <li>
	 *            "i" - include
	 *            </ul>
	 *            </p>
	 */
	public void setSiteSearchFilter(String siteSearchFilter) {
		this.siteSearchFilter = siteSearchFilter;
	}

	/**
	 * @return The sort expression to apply to the results.
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * @param sort
	 *            The sort expression to apply to the results.
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	/**
	 * @return The index of the first result to return. (unsigned int)
	 */
	public Integer getStart() {
		return start;
	}

	/**
	 * @param start
	 *            The index of the first result to return. (unsigned int)
	 */
	public void setStart(Integer start) {
		if (start < 0) {
			throw new IllegalArgumentException(
					"Parameter start must be non negative!");
		}
		this.start = start;
	}

	/**
	 * Sets the parameters given in the Map object.
	 * 
	 * @param params
	 *            The parameters to set. (param name - param value) The param
	 *            name must be equal to the class field name.
	 * @throws IllegalArgumentException
	 *             if an unwrapping conversion fails.
	 * @throws IllegalAccessException
	 *             if the underlying field is either inaccessible or final.
	 */
	public void setParameters(Map<String, Object> params)
			throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (params.containsKey(field.getName())) {
				field.set(this, params.get(field.getName()));
			}
		}
	}

	/**
	 * 
	 * @return The request URL created from the parameters.
	 */
	public String createRequestURL() {
		if (q == null) {
			throw new IllegalArgumentException("The 'q' parameter is NULL!");
		}
		if (key == null) {
			throw new IllegalArgumentException("The 'key' parameter is NULL!");
		}
		if ((cx == null) && (cref == null)) {
			throw new IllegalArgumentException(
					"The 'cr' and 'cref' parameters are both NULL!");
		}
		StringBuilder requestURL = new StringBuilder(GOOGLE_URL);
		requestURL.append("q=");
		requestURL.append(q);
		requestURL.append("&key=");
		requestURL.append(key);
		if (cx != null) {
			requestURL.append("&cx=");
			requestURL.append(cx);
		}
		if (cref != null) {
			requestURL.append("&cref=");
			requestURL.append(cref);
		}
		if(userIp != null){
			requestURL.append("&userIp=");
			requestURL.append(userIp);
		}
		if (c2coff != null) {
			requestURL.append("&c2coff=");
			requestURL.append(c2coff);
		}
		if (cr != null) {
			requestURL.append("&cr=");
			requestURL.append(cr);
		}
		if (dateRestrict != null) {
			requestURL.append("&dateRestrict=");
			requestURL.append(dateRestrict);
		}
		if (exactTerms != null) {
			requestURL.append("&exactTerms=");
			requestURL.append(exactTerms);
		}
		if (excludeTerms != null) {
			requestURL.append("&excludeTerms=");
			requestURL.append(excludeTerms);
		}
		if (fileType != null) {
			requestURL.append("&fileType=");
			requestURL.append(fileType);
		}
		if (filter != null) {
			requestURL.append("&filter=");
			requestURL.append(filter);
		}
		if (gl != null) {
			requestURL.append("&gl=");
			requestURL.append(gl);
		}
		if (googlehost != null) {
			requestURL.append("&googlehost=");
			requestURL.append(googlehost);
		}
		if (highRange != null) {
			requestURL.append("&highRange=");
			requestURL.append(highRange);
		}
		if (hl != null) {
			requestURL.append("&hl=");
			requestURL.append(hl);
		}
		if (hq != null) {
			requestURL.append("&hq=");
			requestURL.append(hq);
		}
		if (imgColorType != null) {
			requestURL.append("&imgColorType=");
			requestURL.append(imgColorType);
		}
		if (imgDominantColor != null) {
			requestURL.append("&imgDominantColor=");
			requestURL.append(imgDominantColor);
		}
		if (imgSize != null) {
			requestURL.append("&imgSize=");
			requestURL.append(imgSize);
		}
		if (imgType != null) {
			requestURL.append("&imgType=");
			requestURL.append(imgType);
		}
		if (linkSite != null) {
			requestURL.append("&linkSite=");
			requestURL.append(linkSite);
		}
		if (lowRange != null) {
			requestURL.append("&lowRange=");
			requestURL.append(lowRange);
		}
		if (lr != null) {
			requestURL.append("&lr=");
			requestURL.append(lr);
		}
		if (num != null) {
			requestURL.append("&num=");
			requestURL.append(num);
		}
		if (orTerms != null) {
			requestURL.append("&orTerms=");
			requestURL.append(orTerms);
		}
		if (relatedSite != null) {
			requestURL.append("&relatedSite=");
			requestURL.append(relatedSite);
		}
		if (rights != null) {
			requestURL.append("&rights=");
			requestURL.append(rights);
		}
		if (safe != null) {
			requestURL.append("&safe=");
			requestURL.append(safe);
		}
		if (searchType != null) {
			requestURL.append("&searchType=");
			requestURL.append(searchType);
		}
		if (siteSearch != null) {
			requestURL.append("&siteSearch=");
			requestURL.append(siteSearch);
		}
		if (siteSearchFilter != null) {
			requestURL.append("&siteSearchFilter=");
			requestURL.append(siteSearchFilter);
		}
		if (sort != null) {
			requestURL.append("&sort=");
			requestURL.append(sort);
		}
		if (start != null) {
			requestURL.append("&start=");
			requestURL.append(start);
		}
		return requestURL.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Type: Request \n##### REQUEST #####\nq=");
		builder.append(q);
		builder.append(",\nkey=");
		builder.append(key);
		builder.append(",\nuserIp=");
		builder.append(userIp);
		builder.append(",\nc2coff=");
		builder.append(c2coff);
		builder.append(",\ncr=");
		builder.append(cr);
		builder.append(",\ncref=");
		builder.append(cref);
		builder.append(",\ncx=");
		builder.append(cx);
		builder.append(",\ndateRestrict=");
		builder.append(dateRestrict);
		builder.append(",\nexactTerms=");
		builder.append(exactTerms);
		builder.append(",\nexcludeTerms=");
		builder.append(excludeTerms);
		builder.append(",\nfileType=");
		builder.append(fileType);
		builder.append(",\nfilter=");
		builder.append(filter);
		builder.append(",\ngl=");
		builder.append(gl);
		builder.append(",\ngooglehost=");
		builder.append(googlehost);
		builder.append(",\nhighRange=");
		builder.append(highRange);
		builder.append(",\nhl=");
		builder.append(hl);
		builder.append(",\nhq=");
		builder.append(hq);
		builder.append(",\nimgColorType=");
		builder.append(imgColorType);
		builder.append(",\nimgDominantColor=");
		builder.append(imgDominantColor);
		builder.append(",\nimgSize=");
		builder.append(imgSize);
		builder.append(",\nimgType=");
		builder.append(imgType);
		builder.append(",\nlinkSite=");
		builder.append(linkSite);
		builder.append(",\nlowRange=");
		builder.append(lowRange);
		builder.append(",\nlr=");
		builder.append(lr);
		builder.append(",\nnum=");
		builder.append(num);
		builder.append(",\norTerms=");
		builder.append(orTerms);
		builder.append(",\nrelatedSite=");
		builder.append(relatedSite);
		builder.append(",\nrights=");
		builder.append(rights);
		builder.append(",\nsafe=");
		builder.append(safe);
		builder.append(",\nsearchType=");
		builder.append(searchType);
		builder.append(",\nsiteSearch=");
		builder.append(siteSearch);
		builder.append(",\nsiteSearchFilter=");
		builder.append(siteSearchFilter);
		builder.append(",\nsort=");
		builder.append(sort);
		builder.append(",\nstart=");
		builder.append(start);
		builder.append("\n##### REQUEST #####");
		return builder.toString();
	}

	/**
	 * @param alt
	 *            Data format for the response.
	 *            <ul>
	 *            <li>Valid values: json, atom
	 *            <li>Default value: json
	 */
	public void setAlt(String alt) {
		this.alt = alt;
	}

	/**
	 * @return Data format for the response.
	 *         <ul>
	 *         <li>Valid values: json, atom
	 *         <li>Default value: json
	 */
	public String getAlt() {
		return alt;
	}

	/**
	 * @param access_token
	 *            OAuth 2.0 token for the current user.
	 */
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	/**
	 * @return OAuth 2.0 token for the current user.
	 */
	public String getAccess_token() {
		return access_token;
	}

	/**
	 * 
	 * @return IP address of the end user for whom the API call is being made.
	 */
	public String getUserIp() {
		return userIp;
	}

	/**
	 * 
	 * @param userIp
	 *            IP address of the end user for whom the API call is being
	 *            made.
	 */
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
}
