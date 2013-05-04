package hu.bme.dtt.torusalbum.session;

import hu.bme.dtt.torusalbum.dao.AlbumDao;
import hu.bme.dtt.torusalbum.entity.Album;
import hu.bme.dtt.torusalbum.util.StateHolder;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.logging.Logger;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;

@Name("AlbumBean")
@Scope(ScopeType.EVENT)
public class AlbumBean {

	private String newPictureURL;

	/**
	 * A kiválasztott album stateHoldere.
	 */
	@In(create = true)
	private StateHolder<Album> selectedAlbumStateHolder;

	/**
	 * A kiválasztott nevek.
	 */
	private List<String> selectedTitles;

	private static final Logger logger = Logger.getLogger(AlbumBean.class);

	public void addPicture() {
		if (newPictureURL.isEmpty() || newPictureURL.length() < 7) {
			logger.warn("Nem lett megadva url!");
			FacesMessages.instance().add("Nem lett URL megadva!");
			return;
		}
		logger.info("Kép hozzáadása: " + newPictureURL);
		try {
			getAlbumDao().addPicture(selectedAlbumStateHolder.getSelected(),
					newPictureURL);
		} catch (NamingException e) {
			logger.error("Kép mentése nem sikerült!" + e);
		}
		refresh();
		logger.info("Kép hozzáadása sikerült!");
	}

	private void refresh() {
		try {
			this.selectedAlbumStateHolder.setSelected(getAlbumDao()
					.findByPrimaryKey(
							selectedAlbumStateHolder.getSelected().getId()));
		} catch (NamingException e) {
			logger.error("AlbumDao behúzása nem siekrült!" + e.getMessage());
			FacesMessages.instance().add(
					"Váratlan hiba történt, kérjük próbálkozzon újra!");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			FacesMessages.instance().add(
					"Váratlan hiba történt, kérjük próbálkozzon újra!");
		}
	}

	/**
	 * Inicializálja az AlbumDao-t.
	 * 
	 * @return
	 * @throws NamingException
	 */
	private AlbumDao getAlbumDao() throws NamingException {
		return (AlbumDao) InitialContext
				.doLookup("TorusAlbum-ear/AlbumDao/local");
	}

	/**
	 * Lefuttatja a keresést, és az elsõ 10 eredményt egy SelectItem listaként
	 * visszaadja.
	 * 
	 * @return
	 */
	public List<SelectItem> getOptinalAlbumTitles() {
		// TODO: Ez a függvény fogja majd visszaadni a lehetséges neveket.
		// Egyelõre dummy adatokkal feltöltöm, hogy a felületet meg tudjam
		// csinálni.
		SelectItem si1 = new SelectItem("Forradalom", "Forradalom");
		SelectItem si2 = new SelectItem("Szabadságharc", "Szabadságharc");
		SelectItem si3 = new SelectItem("Március 15.", "Március 15.");
		SelectItem si4 = new SelectItem("Nemzeti ünnep", "Nemzeti ünnep");
		List<SelectItem> dummy = new ArrayList<SelectItem>();
		dummy.add(si1);
		dummy.add(si2);
		dummy.add(si3);
		dummy.add(si4);
		return dummy;

	}

	/**
	 * Elmenti a kiválasztott neveket.
	 */
	public void saveNewTitle() {
		StringBuilder title = new StringBuilder();
		for (int i = 0; i < selectedTitles.size() - 1; i++) {
			title.append(selectedTitles.get(i) + ", ");
		}
		title.append(selectedTitles.get(selectedTitles.size() - 1));
		this.selectedAlbumStateHolder.getSelected().setTitle(title.toString());
		try {
			getAlbumDao().changeAlbumTitle(
					this.selectedAlbumStateHolder.getSelected().getId(),
					title.toString());
		} catch (NamingException e) {
			logger.error("AlbumDao behúzása nem siekrült!" + e.getMessage());
			FacesMessages.instance().add(
					"Váratlan hiba történt, kérjük próbálkozzon újra!");
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
