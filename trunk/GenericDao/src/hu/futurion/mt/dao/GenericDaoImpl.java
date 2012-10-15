package hu.futurion.mt.dao;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.logging.Logger;

/**
 * Generikus DAO Manager.
 * 
 * @author Windisch.Karoly
 * @param <T>
 *            tipiz�l�shoz, entit�s oszt�lyt v�r.
 */
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	/**
	 * {@inheritDoc}
	 */
	public abstract EntityManager getEntityManager();

	/** Statikus logger az oszt�lyhoz. */
	private static Logger LOGGER = Logger.getLogger(GenericDaoImpl.class);

	/** Publikus default konstruktor, ha injekt�lni akarjuk az entityManagert. */
	public GenericDaoImpl() {
	}

	/**
	 * Visszaadja a generikus param�ter (T) oszt�ly�t. (A logol�sn�l pl. ezzel
	 * iratom ki az aktu�lis entit�s oszt�ly�nak a nev�t.)
	 * 
	 * @return T parameter oszt�lya
	 */
	@SuppressWarnings("unchecked")
	public Class<T> getEntityClass() {
		final ParameterizedType ptype = (ParameterizedType) getClass()
				.getGenericSuperclass();
		return (Class<T>) ptype.getActualTypeArguments()[0];
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean save(final T obj) {
		getEntityManager().persist(obj);
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public T update(final T obj) {
		return getEntityManager().merge(obj);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean remove(final T obj) {
		getEntityManager().refresh(obj);
		getEntityManager().remove(obj);
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean contains(final T obj) {
		return getEntityManager().contains(obj);
	}

	/**
	 * {@inheritDoc}
	 */
	public T findByPrimaryKey(final Object pk) throws Exception {
		final T result = getEntityManager().find(getEntityClass(), pk);

		if (result == null) {
			LOGGER.debug(getEntityClass().getName()
					+ " - Keres�s nem adott eredm�nyt, "
					+ getEntityClass().getName() + " " + pk
					+ " els�dleges kulccsal nem tal�lhat�.");
			throw new SQLException(" - Keres�s nem adott eredm�nyt, "
					+ getEntityClass().getName() + " " + pk
					+ " els�dleges kulccsal nem tal�lhat�.");
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object executeNamedQuerySingleResult(final String namedQuery,
			final Object... params) {
		LOGGER.debug("Lek�rdez�s elindult!");
		LOGGER.debug(getEntityClass().getName() + " - entityManager is null: "
				+ (getEntityManager() == null));
		final Query query = getEntityManager().createNamedQuery(namedQuery);
		LOGGER.debug(getEntityClass().getName() + " - Query is null: "
				+ (query == null));
		LOGGER.debug(getEntityClass().getName() + " - Query is: " + namedQuery
				+ " " + query.toString());
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i + 1, params[i]);
			}
		}

		final Object result = query.getSingleResult();
		if (result == null) {
			LOGGER.debug(getEntityClass().getName()
					+ " - Keres�s nem adott eredm�nyt.");
		}

		LOGGER.debug("Lek�rdez�s rendben volt!");
		LOGGER.debug("Oszt�ly: " + result.getClass());

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<?> executeNamedQueryMultipleResult(final String namedQuery,
			final Object... params) {
		final Query query = getEntityManager().createNamedQuery(namedQuery);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i + 1, params[i]);
			}
		}
		return query.getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	public Object executeQuerySingleResult(final String queryString,
			final Object... params) {
		LOGGER.debug(getEntityClass().getName() + " - entityManager is null: "
				+ (getEntityManager() == null));

		final Query query = getEntityManager().createQuery(queryString);

		LOGGER.debug(getEntityClass().getName() + " - Query is: " + queryString);
		if (params != null) {
			final StringBuilder builder = new StringBuilder();
			builder.append("Az �tadott param�terek sz�ma: " + params.length);

			for (int i = 0; i < params.length; i++) {
				query.setParameter(i + 1, params[i]);
				builder.append("\n  \t params[" + i + "]=" + params[i]);
			}
			LOGGER.debug(builder.toString());
		} else {
			LOGGER.debug("Nincs �tadott param�ter.");
		}
		List<Object> result = null;
		try {
			result = query.getResultList();
		} catch (final Exception e) {
			LOGGER.debug(e.getMessage());
		}
		if (result == null || result.size() < 1) {
			LOGGER.debug(getEntityClass().getName()
					+ " - Keres�s nem adott eredm�nyt.");
			return null;
		}
		if (result.size() > 1) {
			LOGGER.debug(getEntityClass().getName()
					+ " - Keres�s t�bb eredm�nyt adott, eredm�nyek sz�ma: "
					+ result.size());
			return null;
		}

		LOGGER.debug("Lek�rdez�s rendben volt!");
		LOGGER.debug("Visszaadott " + result.get(0).getClass());

		return result.get(0);

	}

	/**
	 * {@inheritDoc}
	 */
	public List<?> executeQueryMultipleResult(final String queryString,
			final Object... params) {
		final Query query = getEntityManager().createQuery(queryString);
		LOGGER.debug(getEntityClass().getName() + " - Query is: " + queryString);
		LOGGER.debug("Vannak param�terek? - " + (params != null));
		if (params != null) {
			final StringBuilder builder = new StringBuilder();
			builder.append("Az �tadott param�terek sz�ma: " + params.length);

			for (int i = 0; i < params.length; i++) {
				query.setParameter(i + 1, params[i]);
				builder.append("\n \t params[" + i + "]=" + params[i]);
			}
			LOGGER.debug(builder.toString());
		} else {
			LOGGER.debug("Nincs �tadott param�ter.");
		}
		final List<?> result = query.getResultList();
		LOGGER.debug("A visszaadott lista hossza: " + result.size());
		return result;
	}

	/**
	 * M�dos�t�s m�veletet v�grehajt� met�dus.
	 * 
	 * @param queryString
	 *            A lek�rdez�s
	 * @param params
	 *            A lek�rdez�s param�terei - opcion�lis
	 * @return m�dos�t�s eredm�nye
	 */
	public int executeUpdate(final String queryString, final Object... params) {
		final Query query = getEntityManager().createQuery(queryString);
		if (params != null) {
			final StringBuilder builder = new StringBuilder();
			builder.append("Az �tadott param�terek sz�ma: " + params.length);

			for (int i = 0; i < params.length; i++) {
				query.setParameter(i + 1, params[i]);
				builder.append("\n \t params[" + i + "]=" + params[i]);
			}
			LOGGER.debug(builder.toString());
		} else {
			LOGGER.debug("Nincs �tadott param�ter.");
		}
		return query.executeUpdate();
	}

}
