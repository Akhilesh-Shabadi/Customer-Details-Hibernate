package com.hibernetproject;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CustomerDAO {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("akhil");
	private EntityManager manager = factory.createEntityManager();
	private EntityTransaction transaction = manager.getTransaction();

	public void insert(Customer customer) {
		transaction.begin();
		manager.persist(customer);
		transaction.commit();
	}

	public Customer fetch(int id) {
		return manager.find(Customer.class, id);
	}

	public void update(Customer customer) {
		transaction.begin();
		manager.merge(customer);
		transaction.commit();
	}

	public void delete(Customer customer) {
		transaction.begin();
		manager.remove(customer);
		transaction.commit();
	}

	public List<Customer> fetchall() {
		List<Customer> a = manager.createQuery("select s from Customer s").getResultList();
		return a;
	}
}
