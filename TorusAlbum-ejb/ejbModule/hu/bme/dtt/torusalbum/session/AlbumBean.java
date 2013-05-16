package hu.bme.dtt.torusalbum.session;

import hu.bme.dtt.torusalbum.dao.AlbumDao;
import hu.bme.dtt.torusalbum.entity.Album;
import hu.bme.dtt.torusalbum.util.StateHolder;
import hu.bme.dtt.torusalbum.util.Tag;
import hu.bme.dtt.torusalbum.util.TitleFactory;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.logging.Logger;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;

@Name("AlbumBean")
@Scope(ScopeType.PAGE)
public class AlbumBean {

	private String newPictureURL;

	/**
	 * A kiv�lasztott album stateHoldere.
	 */
	@In(create = true)
	private StateHolder<Album> selectedAlbumStateHolder;

	private List<SelectItem> optionalAlbumTitles;

	/**
	 * A kiv�lasztott nevek.
	 */
	private List<String> selectedTitles;

	private static final Logger logger = Logger.getLogger(AlbumBean.class);

	@Create
	public void onCreate() {
		optionalAlbumTitles = new ArrayList<SelectItem>();
		optionalAlbumTitles.add(new SelectItem("N�vtelen Album", "N�vtelen Album"));
	}

	public void addPicture() {
		if (newPictureURL.isEmpty() || (newPictureURL.length() < 7)) {
			logger.warn("Nem lett megadva url!");
			FacesMessages.instance().add("Nem lett URL megadva!");
			return;
		}
		logger.info("K�p hozz�ad�sa: " + newPictureURL);
		try {
			getAlbumDao().addPicture(selectedAlbumStateHolder.getSelected(), newPictureURL);
		} catch (NamingException e) {
			logger.error("K�p ment�se nem siker�lt!" + e);
		}
		refresh();
		logger.info("K�p hozz�ad�sa siker�lt!");
	}

	private void refresh() {
		try {
			selectedAlbumStateHolder.setSelected(getAlbumDao().findByPrimaryKey(
					selectedAlbumStateHolder.getSelected().getId()));
		} catch (NamingException e) {
			logger.error("AlbumDao beh�z�sa nem siekr�lt!" + e.getMessage());
			FacesMessages.instance().add("V�ratlan hiba t�rt�nt, k�rj�k pr�b�lkozzon �jra!");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			FacesMessages.instance().add("V�ratlan hiba t�rt�nt, k�rj�k pr�b�lkozzon �jra!");
		}
	}

	/**
	 * Inicializ�lja az AlbumDao-t.
	 * 
	 * @return
	 * @throws NamingException
	 */
	private AlbumDao getAlbumDao() throws NamingException {
		return (AlbumDao) InitialContext.doLookup("TorusAlbum-ear/AlbumDao/local");
	}

	public void gatherOptionalAlbumTitles() {
		optionalAlbumTitles = new ArrayList<SelectItem>();
		List<Tag> rawResult = TitleFactory.getTags(selectedAlbumStateHolder.getSelected());
		List<SelectItem> dummy = new ArrayList<SelectItem>();
		while ((dummy.size() < 7) && (dummy.size() < rawResult.size())) {
			SelectItem si = new SelectItem(rawResult.get(dummy.size()).getName(), rawResult.get(
					dummy.size()).getName()
					+ "(" + rawResult.get(dummy.size()).getCounter() + ")");
			dummy.add(si);
		}
		// if (rawResult.size() > 0) {
		// SelectItem si1 = new SelectItem(rawResult.get(0).getName(),
		// rawResult.get(0).getName());
		// dummy.add(si1);
		// if (rawResult.size() > 1) {
		// SelectItem si2 = new SelectItem(rawResult.get(1).getName(),
		// rawResult.get(1)
		// .getName());
		// dummy.add(si2);
		// if (rawResult.size() > 2) {
		// SelectItem si3 = new SelectItem(rawResult.get(2).getName(),
		// rawResult.get(2)
		// .getName());
		// dummy.add(si3);
		// if (rawResult.size() > 3) {
		// SelectItem si4 = new SelectItem(rawResult.get(3).getName(), rawResult
		// .get(3).getName());
		// dummy.add(si4);
		// if (rawResult.size() > 4) {
		// SelectItem si5 = new SelectItem(rawResult.get(4).getName(), rawResult
		// .get(4).getName());
		// dummy.add(si5);
		// }
		// }
		// }
		// }
		// }
		if (dummy.size() == 0) {
			dummy.add(new SelectItem("N�vtelen Album", "N�vtelen Album"));
		}
		optionalAlbumTitles = dummy;

	}

	public List<SelectItem> getOptionalAlbumTitles() {
		return optionalAlbumTitles;
	}

	/**
	 * Elmenti a kiv�lasztott neveket.
	 */
	public void saveNewTitle() {
		StringBuilder title = new StringBuilder();
		for (int i = 0; i < selectedTitles.size() - 1; i++) {
			title.append(selectedTitles.get(i) + ", ");
		}
		if (selectedTitles.size() > 0) {
			title.append(selectedTitles.get(selectedTitles.size() - 1));
		}
		selectedAlbumStateHolder.getSelected().setTitle(title.toString());
		try {
			getAlbumDao().changeAlbumTitle(selectedAlbumStateHolder.getSelected().getId(),
					title.toString());
		} catch (NamingException e) {
			logger.error("AlbumDao beh�z�sa nem siekr�lt!" + e.getMessage());
			FacesMessages.instance().add("V�ratlan hiba t�rt�nt, k�rj�k pr�b�lkozzon �jra!");
		}
	}

	public List<String> getSelectedTitles() {
		return selectedTitles;
	}

	public void setSelectedTitles(List<String> selectedTitles) {
		this.selectedTitles = selectedTitles;
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
