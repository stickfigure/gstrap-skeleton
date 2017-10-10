package com.voodoodyne.skeleton;

import com.voodoodyne.postguice.EM;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.EntityManager;
import java.util.Optional;

/**
 * The static dao() method provides a useful DAO at all times.
 */
@RequiredArgsConstructor
public class DAO {

	/**
	 */
	public static DAO dao() {
		return new DAO(EM.em());
	}

	/** */
	private final EntityManager em;

	/** */
	public Session session() {
		return em.unwrap(Session.class);
	}

	/** */
	public EntityManager em() { return em; }

	/** */
	public <E> Optional<E> load(final Class<E> entityClass, final Object primaryKey) {
		return Optional.ofNullable(em.find(entityClass, primaryKey));
	}

	/**
	 * Save a new thing.
	 * @return the thing saved
	 */
	public <E> E save(final E thing) {
		session().saveOrUpdate(thing);
		return thing;
	}

	/**
	 * Delete a thing
	 * @throws InUseException if deleting this thing would cause a constraint violation
	 */
	public void delete(final Object object) throws InUseException {
		try {
			session().delete(object);
			session().flush();
		} catch (RuntimeException e) {
			if (e.getCause() instanceof ConstraintViolationException) {
				throw new InUseException("Unable to delete " + object.getClass().getSimpleName() + " because it is still in use");
			} else {
				throw e;
			}
		}
	}
}
