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
 * Elõzményekhez tartozó backBean.
 * 
 * @author Karcsi
 * 
 */
@Name("AntecendentsBackBean")
@Scope(ScopeType.EVENT)
public class AntecendentsBackBean {

	/**
	 * Elõzmények.
	 */
	private Antecendents antecendents;

	/**
	 * Felhasználó adatai.
	 */
	@In
	private Credentials credentials;

	/**
	 * Logoláshoz logger.
	 */
	private static final Logger logger = Logger
			.getLogger(AntecendentsDaoImpl.class);

	/**
	 * Inicializáló függvény, lekérdezi a felhasználó elõzményeit.
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
