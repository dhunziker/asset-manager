package uk.co.hunziker.am.transaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TransactionalInvocationHandler<T> implements InvocationHandler {

	private EntityManager em;

	private T proxied;

	public TransactionalInvocationHandler(EntityManager em, T proxied) {
		this.em = em;
		this.proxied = proxied;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result;

		EntityTransaction trx = em.getTransaction();
		try {
			trx.begin();
			result = method.invoke(proxied, args);
			trx.commit();
		} catch (Exception e) {
			if (trx.isActive()) {
				trx.rollback();
			}

			throw e;
		}
		return result;
	}

}
