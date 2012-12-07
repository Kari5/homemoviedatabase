package hu.bme.tesslo.hmdb.session;

import hu.bme.tesslo.hmdb.dao.AntecendentsDao;
import hu.bme.tesslo.hmdb.dao.AntecendentsDaoImpl;
import hu.bme.tesslo.hmdb.model.Antecendents;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.logging.Logger;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.security.Credentials;

/**
 * El�zm�nyekhez tartoz� backBean.
 * 
 * @author Karcsi
 * 
 */
@Name("AntecendentsBackBean")
@Scope(ScopeType.EVENT)
public class AntecendentsBackBean {

	/**
	 * El�zm�nyek.
	 */
	private Antecendents antecendents;

	/**
	 * Felhaszn�l� adatai.
	 */
	@In
	private Credentials credentials;

	/**
	 * Logol�shoz logger.
	 */
	private static final Logger logger = Logger
			.getLogger(AntecendentsDaoImpl.class);

	/**
	 * Inicializ�l� f�ggv�ny, lek�rdezi a felhaszn�l� el�zm�nyeit.
	 */
	@Create
	public void init() {
		AntecendentsDao antecendentsDao;
		try {
			antecendentsDao = (AntecendentsDao) InitialContext
					.doLookup("HomeMovieDatabase-ear/AntecendentsDao/local");
		} catch (NamingException e) {
			logger.error(e.getMessage());
			return;
		}
		antecendents = antecendentsDao.getAntecendents(credentials
				.getUsername());
	}

	/**
	 * @return the antecendents
	 */
	public Antecendents getAntecendents() {
		return antecendents;
	}

	/**
	 * @param antecendents
	 *            the antecendents to set
	 */
	public void setAntecendents(Antecendents antecendents) {
		this.antecendents = antecendents;
	}

}
