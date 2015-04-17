package br.com.inmetrics.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.inmetrics.dao.HypervisorDAO;
import br.com.inmetrics.model.csv.Datacenter;
import br.com.inmetrics.model.csv.Hypervisor;

@Repository
@Transactional
public class HypervisorDaoImpl implements HypervisorDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void deleteAll() {
		Query createNativeQuery = em.createNativeQuery("DELETE FROM HYPERVISOR");
		createNativeQuery.executeUpdate();
	}

	@Override
	public void update(List<Hypervisor> hypervisors) {
		deleteAll();
		for (Hypervisor hypervisor : hypervisors) {
			em.persist(hypervisor);
		}
	}

	@Override
	public void updateDatacenter(List<Datacenter> datacenters) {
		deleteDatacenter();
		for (Datacenter datacenter : datacenters) {
			em.persist(datacenter);
		}
	}

	public void deleteDatacenter() {
		Query createNativeQuery = em.createNativeQuery("DELETE FROM DATACENTER");
		createNativeQuery.executeUpdate();
	}
}