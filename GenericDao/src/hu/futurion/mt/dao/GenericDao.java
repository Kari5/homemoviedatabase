package hu.futurion.mt.dao;

import java.util.List;

import javax.persistence.EntityManager;

/**
 * Generikus DAO interf�sz.
 * 
 * @author Windisch.Karoly
 * @param <T>
 *            tipiz�l�shoz v�ltoz�, egy entit�s oszt�lyt v�r
 */
public interface GenericDao<T> {

	/**
	 * Visszaadja az entityManager-t. Minden oszt�ly, aki megval�s�tja
	 * k�telez�en implement�lja ezt a met�dust, ez �ltal lehet injekt�lni az
	 * EntityManager-t
	 * 
	 * @return the entityManager
	 */
	EntityManager getEntityManager();

	/**
	 * Visszaadja a generikus param�ter (T) oszt�ly�t.
	 * 
	 * @return T parameter oszt�lya
	 */
	Class<T> getEntityClass();

	/**
	 * Entit�s perzisztens� t�tele. Lementi az adott entit�st az adtab�zisba
	 * 
	 * @param obj
	 *            Elmentend� objektum
	 * @return true -> sikeres volt a ment�s, false -> sikertelen volt
	 */
	boolean save(final T obj);

	/**
	 * M�dos�tja az adott entit�st. Az �tadott objektuomt update-eli.
	 * 
	 * @param obj
	 *            M�dos�tand� entit�s
	 * @return A m�dosult entit�s
	 * @throws Exception
	 *             m�dis�t�si hiba
	 */
	T update(T obj) throws Exception;

	/**
	 * Entit�s t�rl�se. T�rli az �tadott entit�st.
	 * 
	 * @param obj
	 *            t�rlend� entit�s
	 * @return true -> siekres t�rl�s, false -> sikertelen t�rl�s
	 */
	boolean remove(T obj);

	/**
	 * Ellen�rzi, hogy adott entit�s benne van-e az adatb�zisban.
	 * 
	 * @param obj
	 *            Ellen�rizend� entit�s
	 * @return true-> benne van, false -> nincs benne
	 */
	boolean contains(T obj);

	// /**
	// * Perzisztensk�nt visszaadja az entit�st az els�dleges kuclsa alapj�n.
	// *
	// * @param id els�dleges kulcs
	// * @return a megtal�lt entit�s
	// */
	// T load(Object id);

	/**
	 * Entit�s lek�rdez�se els�dleges kulcs alapj�n.
	 * 
	 * @param pk
	 *            els�dleges kulcs
	 * @return A megtal�lt entit�s
	 * @throws Exception
	 *             kiv�tel
	 */
	T findByPrimaryKey(Object pk) throws Exception;

	/**
	 * V�grehajt egy egy eredm�nyt visszaad� "neves�tett" lek�rdez�st.
	 * 
	 * @param namedQuery
	 *            A lek�rdez�s
	 * @param params
	 *            A lek�rdez�s param�terei
	 * @return A lek�rdez�s eredm�nye
	 */
	Object executeNamedQuerySingleResult(String namedQuery, Object... params);

	/**
	 * T�bb eredm�nyt visszaad� "neves�tett" lek�rdez�s.
	 * 
	 * @param namedQuery
	 *            A lek�rdez�s
	 * @param params
	 *            A lek�rdez�s param�terei
	 * @return Eredm�ny lista
	 */
	List<?> executeNamedQueryMultipleResult(String namedQuery, Object... params);

	/**
	 * V�grehajt egy egy eredm�nyt visszaad� lek�rdez�st.
	 * 
	 * @param namedQuery
	 *            A lek�rdez�s
	 * @param params
	 *            A lek�rdez�s param�terei
	 * @return A lek�rdez�s eredm�nye
	 */
	Object executeQuerySingleResult(String namedQuery, Object... params);

	/**
	 * T�bb eredm�nyt visszaad� lek�rdez�s.
	 * 
	 * @param namedQuery
	 *            A lek�rdez�s
	 * @param params
	 *            A lek�rdez�s param�terei
	 * @return Eredm�ny lista
	 */
	List<?> executeQueryMultipleResult(String namedQuery, Object... params);

	/**
	 * M�dos�t�s m�veletet v�grehajt� met�dus.
	 * 
	 * @param queryString
	 *            A lek�rdez�s
	 * @param params
	 *            A lek�rdez�s param�terei - opcion�lis
	 * @return m�dos�t�s eredm�nye
	 */
	int executeUpdate(String queryString, Object... params);
}
