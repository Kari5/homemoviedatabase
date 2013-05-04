/**
 * 
 */
package hu.bme.dtt.torusalbum.dao;

import hu.bme.dtt.torusalbum.entity.Album;
import hu.futurion.mt.dao.GenericDao;

import java.util.List;

import javax.ejb.Local;

/**
 * @author Karcsi
 * 
 */
@Local
public interface AlbumDao extends GenericDao<Album> {

	/**
	 * Visszaadja az összes albumot.
	 * 
	 * @return albumok
	 */
	public List<Album> getAllAlbum();

	/**
	 * Hozzáad egy képet az albumhoz.
	 * 
	 * @param url
	 * @param album
	 */
	public void addPicture(Album album, String url);

	/**
	 * MMegváltoztatja egy album nevét.
	 * 
	 * @param id
	 * @param title
	 */
	public void changeAlbumTitle(Long id, String title);

}
