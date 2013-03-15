package hu.bme.dtt.torusalbum.dao;

import hu.bme.dtt.torusalbum.entity.Album;
import hu.futurion.mt.dao.GenericDaoImpl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

@Stateless(name = "AlbumDao")
public class AlbumDaoImpl extends GenericDaoImpl<Album> implements AlbumDao {

	@PersistenceContext(unitName = "TorusAlbum")
	EntityManager entityManager;

	private static final Logger logger = Logger.getLogger(AlbumDaoImpl.class);

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
