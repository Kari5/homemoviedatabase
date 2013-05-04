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
	 * A kiv�lasztott album stateHoldere.
	 */
	@In(create = true)
	private StateHolder<Album> selectedAlbumStateHolder;

	/**
	 * A kiv�lasztott nevek.
	 */
	private List<String> selectedTitles;

	private static final Logger logger = Logger.getLogger(AlbumBean.class);

	public void addPicture() {
		if (newPictureURL.isEmpty() || newPictureURL.length() < 7) {
			logger.warn("Nem lett megadva url!");
			FacesMessages.instance().add("Nem lett URL megadva!");
			return;
		}
		logger.info("K�p hozz�ad�sa: " + newPictureURL);
		try {
			getAlbumDao().addPicture(selectedAlbumStateHolder.getSelected(),
					newPictureURL);
		} catch (NamingException e) {
			logger.error("K�p ment�se nem siker�lt!" + e);
		}
		refresh();
		logger.info("K�p hozz�ad�sa siker�lt!");
	}

	private void refresh() {
		try {
			this.selectedAlbumStateHolder.setSelected(getAlbumDao()
					.findByPrimaryKey(
							selectedAlbumStateHolder.getSelected().getId()));
		} catch (NamingException e) {
			logger.error("AlbumDao beh�z�sa nem siekr�lt!" + e.getMessage());
			FacesMessages.instance().add(
					"V�ratlan hiba t�rt�nt, k�rj�k pr�b�lkozzon �jra!");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			FacesMessages.instance().add(
					"V�ratlan hiba t�rt�nt, k�rj�k pr�b�lkozzon �jra!");
		}
	}

	/**
	 * Inicializ�lja az AlbumDao-t.
	 * 
	 * @return
	 * @throws NamingException
	 */
	private AlbumDao getAlbumDao() throws NamingException {
		return (AlbumDao) InitialContext
				.doLookup("TorusAlbum-ear/AlbumDao/local");
	}

	/**
	 * Lefuttatja a keres�st, �s az els� 10 eredm�nyt egy SelectItem listak�nt
	 * visszaadja.
	 * 
	 * @return
	 */
	public List<SelectItem> getOptinalAlbumTitles() {
		// TODO: Ez a f�ggv�ny fogja majd visszaadni a lehets�ges neveket.
		// Egyel�re dummy adatokkal felt�lt�m, hogy a fel�letet meg tudjam
		// csin�lni.
		SelectItem si1 = new SelectItem("Forradalom", "Forradalom");
		SelectItem si2 = new SelectItem("Szabads�gharc", "Szabads�gharc");
		SelectItem si3 = new SelectItem("M�rcius 15.", "M�rcius 15.");
		SelectItem si4 = new SelectItem("Nemzeti �nnep", "Nemzeti �nnep");
		List<SelectItem> dummy = new ArrayList<SelectItem>();
		dummy.add(si1);
		dummy.add(si2);
		dummy.add(si3);
		dummy.add(si4);
		return dummy;

	}

	/**
	 * Elmenti a kiv�lasztott neveket.
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
			logger.error("AlbumDao beh�z�sa nem siekr�lt!" + e.getMessage());
			FacesMessages.instance().add(
					"V�ratlan hiba t�rt�nt, k�rj�k pr�b�lkozzon �jra!");
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
