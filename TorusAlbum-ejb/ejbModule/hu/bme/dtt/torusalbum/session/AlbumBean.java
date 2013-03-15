package hu.bme.dtt.torusalbum.session;

import hu.bme.dtt.torusalbum.dao.AlbumDao;
import hu.bme.dtt.torusalbum.entity.Album;
import hu.bme.dtt.torusalbum.util.StateHolder;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.logging.Logger;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

@Name("AlbumBean")
@Scope(ScopeType.EVENT)
public class AlbumBean {

	private String newPictureURL;

	/**
	 * A kiválasztott album stateHoldere.
	 */
	@In(create = true)
	private StateHolder<Album> selectedAlbumStateHolder;

	private static final Logger logger = Logger.getLogger(AlbumBean.class);

	public void addPicture() {
		if (newPictureURL.isEmpty()) {
			logger.warn("Nem lett megadva url!");
			return;
		}
		logger.info("Kép hozzáadása: " + newPictureURL);
		try {
			((AlbumDao) InitialContext
					.doLookup("TorusAlbum-ear/AlbumDao/local")).addPicture(
					selectedAlbumStateHolder.getSelected(), newPictureURL);
		} catch (NamingException e) {
			logger.error("Kép mentése nem sikerült!" + e);
		}
		refresh();
		logger.info("Kép hozzáadása sikerült!");
	}

	private void refresh() {
		// :D
		try {
			this.selectedAlbumStateHolder
					.setSelected(((AlbumDao) InitialContext
							.doLookup("TorusAlbum-ear/AlbumDao/local"))
							.findByPrimaryKey(selectedAlbumStateHolder
									.getSelected().getId()));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the newPictureURL
	 */
	public String getNewPictureURL() {
		return newPictureURL;
	}

	/**
	 * @param newPictureURL
	 *            the newPictureURL to set
	 */
	public void setNewPictureURL(String newPictureURL) {
		this.newPictureURL = newPictureURL;
	}

}
