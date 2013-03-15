package hu.bme.dtt.torusalbum.util;

import hu.bme.dtt.torusalbum.dao.AlbumDao;
import hu.bme.dtt.torusalbum.entity.Album;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.logging.Logger;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

/**
 * Factory oszt�ly.
 * 
 * @author Karcsi
 * 
 */
@Name("factoryUtil")
@Scope(ScopeType.EVENT)
public class FactoryUtil {

	private static final Logger logger = Logger.getLogger(FactoryUtil.class);

	/**
	 * A kiv�lasztot album stateHolder factory-ja. Conversation scope-ban van,
	 * mert az eg�sz conversation alatt sz�ks�g van r�.
	 * 
	 * @return selectedAlbumStateHolder
	 */
	@Factory(value = "selectedAlbumStateHolder", scope = ScopeType.CONVERSATION)
	public StateHolder<Album> selectedAlbumFactory() {
		return new StateHolder<Album>();
	}

	/**
	 * Az �sszes el�rhet� albumot tartalmaz� lista factoy-ja. Page scope-ban
	 * van, mert csak a Home page-en van r� sz�ks�g.
	 * 
	 * @return allAlbumStateContainer
	 */
	@Factory(value = "allAlbumStateContainer", scope = ScopeType.PAGE)
	public StateContainer<Album> allAlbumFactory() {
		try {
			List<Album> albums = ((AlbumDao) InitialContext
					.doLookup("TorusAlbum-ear/AlbumDao/local")).getAllAlbum();
			return new StateContainer<Album>(albums);
		} catch (NamingException e) {
			logger.error("Albumok lek�rdez�se nem siker�lt!", e);
			return new StateContainer<Album>();
		}
	}

}
