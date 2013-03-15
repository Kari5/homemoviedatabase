package hu.bme.dtt.torusalbum.session;

import hu.bme.dtt.torusalbum.dao.AlbumDao;
import hu.bme.dtt.torusalbum.entity.Album;
import hu.bme.dtt.torusalbum.entity.Picture;
import hu.bme.dtt.torusalbum.util.StateHolder;

import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

@Name("HomeBean")
@Scope(ScopeType.EVENT)
public class HomeBean {

	/**
	 * A kiv�lasztott album stateHoldere.
	 */
	@In(create = true)
	private StateHolder<Album> selectedAlbumStateHolder;

	/**
	 * A param�terk�nt megkapott albumot �l�tja be a kiv�lasztottnak.
	 * 
	 * @param album
	 */
	public String changeSelectedAlbum(Album album) {
		this.selectedAlbumStateHolder.setSelected(album);
		return "albumPage";
	}

	/**
	 * L�terhoz egy �j, �res albumot, �s elmenti
	 */
	public String addNewAlbum() {
		Album album = new Album();
		album.setPictures(new ArrayList<Picture>());
		try {
			((AlbumDao) InitialContext
					.doLookup("TorusAlbum-ear/AlbumDao/local")).save(album);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "home";
	}
}
