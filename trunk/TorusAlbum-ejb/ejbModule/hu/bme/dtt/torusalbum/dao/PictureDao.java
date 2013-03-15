/**
 * 
 */
package hu.bme.dtt.torusalbum.dao;

import hu.bme.dtt.torusalbum.entity.Picture;
import hu.futurion.mt.dao.GenericDao;

import javax.ejb.Local;

/**
 * @author Karcsi
 * 
 */
@Local
public interface PictureDao extends GenericDao<Picture> {

}
