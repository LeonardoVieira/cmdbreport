package br.com.inmetrics.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.inmetrics.dao.FilterDAO;
import br.com.inmetrics.model.Filter;
import br.com.inmetrics.model.Result;
import br.com.inmetrics.model.ValueObject;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class FilterDAOImpl implements FilterDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Result> getByFilters(Filter filter) {
		List<Result> resultList = new ArrayList<Result>();

		try {
			final StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("select ");
			stringBuilder.append("type.TYPE AS TYPE, ");
			stringBuilder.append("type.NAME AS INSTANCENAME, ");
			stringBuilder.append("cmdb.NM_SRVD AS HOSTNAME, ");
			stringBuilder.append("hyper.CLU_NAME AS DATACENTER, ");
			stringBuilder.append("bs_cmdb.nm_busi_srvc_cmdb AS BUSINESSSERVICE, ");
			stringBuilder.append("ts_cmdb.nm_tecn_srvc_cmdb AS TECHNICALSERVICE, ");
			stringBuilder.append("sc_cmdb.nm_srvc_comp_cmdb AS SERVICECOMPONENT, ");
			stringBuilder.append("cmdb.NM_REDE_DIST AS REDE, ");
			stringBuilder.append("cmdb.CD_HYPE_GRUP AS HYPENAME, ");
			stringBuilder.append("cmdb.NM_SRVD_PLAT AS CLUSTER ");
			stringBuilder.append("from tb_cmdb cmdb ");
			stringBuilder.append("left join HYPERVISOR hyper ");
			stringBuilder.append("ON hyper.hyp_id = cmdb.cd_hype ");
			stringBuilder.append("left join cmdb_type_br type on type.lserver_assetid = cmdb.cd_srvd ");
			stringBuilder.append("LEFT JOIN TB_SERVIDOR_CMDB servidor_cmdb ");
			stringBuilder.append("ON TX_HOST = NM_SRVD ");
			stringBuilder.append("LEFT JOIN dbo.TB_BUSINESS_SERVICE_CMDB bs_cmdb ");
			stringBuilder.append("ON servidor_cmdb.nr_sequ_busi_srvc_cmdb = bs_cmdb.nr_sequ_busi_srvc_cmdb ");
			stringBuilder.append("LEFT JOIN dbo.TB_TECHNICAL_SERVICE_CMDB ts_cmdb ");
			stringBuilder.append("ON servidor_cmdb.nr_sequ_tecn_srvc_cmdb = ts_cmdb.nr_sequ_tecn_srvc_cmdb ");
			stringBuilder.append("LEFT JOIN dbo.TB_SERVICE_COMPONENT_CMDB sc_cmdb ");
			stringBuilder.append("ON servidor_cmdb.nr_sequ_srvc_comp_cmdb = sc_cmdb.nr_sequ_srvc_comp_cmdb ");
			stringBuilder.append("where cmdb.NM_SRVD LIKE '" + filter.getHostname() + "' ");
			stringBuilder.append("AND bs_cmdb.nm_busi_srvc_cmdb LIKE '" + filter.getBusinessService() + "' ");
			stringBuilder.append("AND ts_cmdb.nm_tecn_srvc_cmdb LIKE '" + filter.getTechnicalService() + "' ");
			stringBuilder.append("AND sc_cmdb.nm_srvc_comp_cmdb LIKE '" + filter.getServiceComponent() + "' ");
			stringBuilder.append("AND cmdb.NM_REDE_DIST LIKE '" + filter.getNetwordDistribution() + "' ");
			stringBuilder.append("AND cmdb.NM_HYPE_GRUP LIKE '" + filter.getDatacenter() + "' ");
			stringBuilder.append("group by cmdb.NM_SRVD, ");
			stringBuilder.append("type.TYPE, ");
			stringBuilder.append("type.NAME, ");
			stringBuilder.append("hyper.CLU_NAME, ");
			stringBuilder.append("bs_cmdb.nm_busi_srvc_cmdb, ");
			stringBuilder.append("ts_cmdb.nm_tecn_srvc_cmdb, ");
			stringBuilder.append("sc_cmdb.nm_srvc_comp_cmdb, ");
			stringBuilder.append("cmdb.NM_REDE_DIST, ");
			stringBuilder.append("cmdb.CD_HYPE_GRUP, ");
			stringBuilder.append("cmdb.NM_SRVD_PLAT ");
			stringBuilder.append("ORDER BY type.TYPE DESC ");

			Query createNativeQuery = em.createNativeQuery(stringBuilder.toString());
			List<Object> queryResult = createNativeQuery.getResultList();

			@SuppressWarnings("rawtypes")
			Iterator it = queryResult.iterator();

			while (it.hasNext()) {
				Result result = new Result();
				Object[] resultObject = (Object[]) it.next();

				result.setType(getString(resultObject[0]));
				result.setInstanceName(getString(resultObject[1]));
				result.setHostname(getString(resultObject[2]));

				if(!StringUtils.isEmpty(getString(resultObject[3]))) {
					if(getString(resultObject[3]).contains("_")) {
						result.setDatacenter(getString(resultObject[3]).substring(0, getString(resultObject[3]).indexOf("_")));
					} else if(getString(resultObject[3]).contains(" ")) {
						result.setDatacenter(getString(resultObject[3]).substring(0, getString(resultObject[3]).indexOf(" ")));
					}
				}

				result.setBusinessService(getString(resultObject[4]));
				result.setTechnicalService(getString(resultObject[5]));
				result.setServiceComponent(getString(resultObject[6]));
				result.setRede(getString(resultObject[7]));
				
				getClusterName(result, resultObject);

				resultList.add(result);
			}
			
			return resultList;
		} catch (NonUniqueResultException e) {
			return null;
		} catch (NoResultException e) {
			return null;
		}
	}

	private void getClusterName(Result result, Object[] resultObject) {
		if(!StringUtils.isEmpty(getString(resultObject[8]))) {
			result.setCluster("ESX Local");
		} else {
			result.setCluster(getString(resultObject[9]));
		}
	}

	private String getString(Object obj) {
		if (obj == null) {
			return null;
		}

		if (obj instanceof String) {
			return (String) obj;
		}

		return null;
	}

	@Override
	public List<ValueObject> getDatacenters(Filter filter) {
		Set<String> datacenterlist = new TreeSet<String>();
		List<ValueObject> list = new ArrayList<ValueObject>();

		Query createNativeQuery = em.createNativeQuery(createQueryString("cmdb.nm_hype_grup", filter));
		List<String> queryResult = createNativeQuery.getResultList();

		for (String string : queryResult) {
			if(!StringUtils.isEmpty(string)) {
				if(string.contains("_")) {
					datacenterlist.add(string.substring(0, string.indexOf("_")));
				} else if(string.contains(" ")) {
					datacenterlist.add(string.substring(0, string.indexOf(" ")));
				}
			} else {
				datacenterlist.add(string);
			}
		}

		for (String string : datacenterlist) {
			ValueObject e = new ValueObject();
			
			e.setLabel(string);
			e.setValue(string);
			
			list.add(e);
		}

		return list;
	}

	@Override
	public List<ValueObject> getNetworks(Filter filter) {
		return getValueObjectlist(createQueryString("cmdb.nm_rede_dist", filter));
	}

	@Override
	public List<ValueObject> getBusinessService(Filter filter) {
		return getValueObjectlist(createQueryString("bs_cmdb.nm_busi_srvc_cmdb", filter));
	}

	@Override
	public List<ValueObject> getTechnicalService(Filter filter) {
		return getValueObjectlist(createQueryString("ts_cmdb.nm_tecn_srvc_cmdb", filter));
	}

	@Override
	public List<ValueObject> getServiceComponent(Filter filter) {
		return getValueObjectlist(createQueryString("sc_cmdb.nm_srvc_comp_cmdb", filter));
	}

	public String createQueryString(String colunmName, Filter filter) {
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("select ");
		stringBuilder.append("distinct("+ colunmName + ") ");
		stringBuilder.append("from tb_cmdb cmdb ");
		stringBuilder.append("left join cmdb_type_br type on type.lserver_assetid = cmdb.cd_srvd ");
		stringBuilder.append("LEFT JOIN TB_SERVIDOR_CMDB servidor_cmdb ");
		stringBuilder.append("ON TX_HOST = NM_SRVD ");
		stringBuilder.append("LEFT JOIN dbo.TB_BUSINESS_SERVICE_CMDB bs_cmdb ");
		stringBuilder.append("ON servidor_cmdb.nr_sequ_busi_srvc_cmdb = bs_cmdb.nr_sequ_busi_srvc_cmdb ");
		stringBuilder.append("LEFT JOIN dbo.TB_TECHNICAL_SERVICE_CMDB ts_cmdb ");
		stringBuilder.append("ON servidor_cmdb.nr_sequ_tecn_srvc_cmdb = ts_cmdb.nr_sequ_tecn_srvc_cmdb ");
		stringBuilder.append("LEFT JOIN dbo.TB_SERVICE_COMPONENT_CMDB sc_cmdb ");
		stringBuilder.append("ON servidor_cmdb.nr_sequ_srvc_comp_cmdb = sc_cmdb.nr_sequ_srvc_comp_cmdb ");
		stringBuilder.append("where cmdb.NM_SRVD LIKE '" + filter.getHostname() + "' ");
		stringBuilder.append("AND bs_cmdb.nm_busi_srvc_cmdb LIKE '" + filter.getBusinessService() + "' ");
		stringBuilder.append("AND ts_cmdb.nm_tecn_srvc_cmdb LIKE '" + filter.getTechnicalService() + "' ");
		stringBuilder.append("AND sc_cmdb.nm_srvc_comp_cmdb LIKE '" + filter.getServiceComponent() + "' ");
		stringBuilder.append("AND cmdb.NM_REDE_DIST LIKE '" + filter.getNetwordDistribution() + "' ");
		stringBuilder.append("AND cmdb.NM_HYPE_GRUP LIKE '" + filter.getDatacenter() + "' ");
		stringBuilder.append("ORDER BY " + colunmName);
		
		return stringBuilder.toString();
	}

	public List<ValueObject> getValueObjectlist(String query) {
		List<ValueObject> list = new ArrayList<ValueObject>();
		
		Query createNativeQuery = em.createNativeQuery(query);
		List<String> queryResult = createNativeQuery.getResultList();

		for (String string : queryResult) {
			ValueObject e = new ValueObject();
			
			e.setLabel(string);
			e.setValue(string);
			
			list.add(e);
		}

		return list;
	}
}