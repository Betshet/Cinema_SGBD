package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Clap;
import model.Scene;
import model.Setup;

public class DAOManager {

	
	private EntityManager em;
	
	public DAOManager(String managerName)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(managerName);
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
	}
	
	public EntityManager getEm() {
		return em;
	}

	private void setEm(EntityManager em) {
		this.em = em;
	}

	public void endConnection()
	{
		getEm().close();
	}
	
	public void prepareToInsert(Object objectToInsert)
	{
		getEm().persist(objectToInsert);
	}
	
	public void prepareListScene(List<Scene> list)
	{
		for(Object current : list)
		{
			getEm().persist(current);
		}
	}
	
	public void prepareListSetup(List<Setup> list)
	{
		for(Object current : list)
		{
			getEm().persist(current);
		}
	}
	
	public void prepareListClap(List<Clap> list)
	{
		for(Object current : list)
		{
			getEm().persist(current);
		}
	}
	public void insertIntoDB()
	{
		getEm().getTransaction().commit();
	}

	
	
}
