/**
 * 
 */
package hu.bme.dtt.torusalbum.dao;

import hu.bme.dtt.torusalbum.entity.Picture;
import hu.futurion.mt.dao.GenericDaoImpl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

/**
 * @author Karcsi
 * 
 */

@Stateless(name = "PictureDao")
public class PictureDaoImpl extends GenericDaoImpl<Picture> implements
		PictureDao {

	@PersistenceContext(unitName = "TorusAlbum")
	EntityManager entityManager;

	private static final Logger logger = Logger.getLogger(PictureDaoImpl.class);

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
