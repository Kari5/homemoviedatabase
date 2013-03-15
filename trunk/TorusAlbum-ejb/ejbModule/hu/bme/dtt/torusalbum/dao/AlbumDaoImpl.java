package hu.bme.dtt.torusalbum.dao;

import hu.bme.dtt.torusalbum.entity.Album;
import hu.bme.dtt.torusalbum.entity.Picture;
import hu.futurion.mt.dao.GenericDaoImpl;

import java.util.List;

import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

@Stateless(name = "AlbumDao")
public class AlbumDaoImpl extends GenericDaoImpl<Album> implements AlbumDao {

	@PersistenceContext(unitName = "TorusAlbum")
	EntityManager entityManager;

	private static final Logger logger = Logger.getLogger(AlbumDaoImpl.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Album> getAllAlbum() {
		return (List<Album>) executeQueryMultipleResult("FROM Album");
	}

	/**
	 * {@inheritDoc}
	 */
	public void addPicture(Album album, String url) {
		Picture picture = new Picture(url);
		Album attachedAlbum;
		try {
			attachedAlbum = findByPrimaryKey(album.getId());
		} catch (Exception e1) {
			logger.error("Album beolvaása közben hiba történt!", e1);
			return;
		}
		try {
			((PictureDao) InitialContext
					.doLookup("TorusAlbum-ear/PictureDao/local")).save(picture);
		} catch (NamingException e) {
			logger.error("Kép elmentése nem sikerült!", e);
			return;
		}
		attachedAlbum.getPictures().add(picture);

	}

}
