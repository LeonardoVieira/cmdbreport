package br.com.inmetrics.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.inmetrics.dao.CmdbDAO;
import br.com.inmetrics.model.CmdbTypeBr;

@Repository
@Transactional
public class CmdbDAOImpl implements CmdbDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void deleteAll() {
		Query createNativeQuery = em.createNativeQuery("DELETE FROM CMDB_TYPE_BR");
		createNativeQuery.executeUpdate();
	}
	
	@Override
	public void update(List<CmdbTypeBr> cmdbTypeBrs) {
		deleteAll();

		for (CmdbTypeBr cmdbTypeBr : cmdbTypeBrs) {
			final StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("INSERT INTO ");
			
			stringBuilder.append("[dbo].[CMDB_TYPE_BR] ");
			stringBuilder.append("(TYPE, ");
			stringBuilder.append("ASSETID, ");
			stringBuilder.append("NAME, ");
			stringBuilder.append("STATUS, ");
			stringBuilder.append("DELIVERY, ");
			stringBuilder.append("VDC, ");
			stringBuilder.append("ENVIROMENT, ");
			stringBuilder.append("LSERVER_ASSETID, ");
			stringBuilder.append("DESCRIPTION, ");
			stringBuilder.append("CELL, ");
			stringBuilder.append("INSTANCE_NAME, ");
			stringBuilder.append("CI_NAME, ");
			stringBuilder.append("MANAGER, ");
			stringBuilder.append("DBC_CI_NAME, ");
			stringBuilder.append("DBC_DNC, ");
			stringBuilder.append("DBC_ID, ");
			stringBuilder.append("DBC_STATUS, ");
			stringBuilder.append("DBI_CI_NAME, ");
			stringBuilder.append("DBI_DNS, ");
			stringBuilder.append("DBI_ID, ");
			stringBuilder.append("DBI_STATUS, ");
			stringBuilder.append("PORT, ");
			stringBuilder.append("LOGIN_SERVER, ");
			stringBuilder.append("PRIORITY, ");
			stringBuilder.append("DATE_UPDATE) ");
			stringBuilder.append("VALUES (");
			stringBuilder.append("'" + cmdbTypeBr.getType() + "', ");
			stringBuilder.append((StringUtils.isEmpty(cmdbTypeBr.getAssetid()) ? "null, " : "'" + cmdbTypeBr.getAssetid() + "', "));
			stringBuilder.append((StringUtils.isEmpty(cmdbTypeBr.getName()) ? "null, " :"'" + cmdbTypeBr.getName() + "', "));
			stringBuilder.append((StringUtils.isEmpty(cmdbTypeBr.getStatus()) ? "null, " : "'" + cmdbTypeBr.getStatus() + "', "));
			stringBuilder.append((StringUtils.isEmpty(cmdbTypeBr.getDelivery()) ? "null, " : "'" + cmdbTypeBr.getDelivery() + "', "));
			stringBuilder.append((StringUtils.isEmpty(cmdbTypeBr.getVdc()) ? "null, " : "'" + cmdbTypeBr.getVdc() + "', "));
			stringBuilder.append((StringUtils.isEmpty(cmdbTypeBr.getEnviroment()) ? "null, " : "'" + cmdbTypeBr.getEnviroment() + "', "));
			stringBuilder.append((StringUtils.isEmpty(cmdbTypeBr.getLserverAssetid()) ? "null, " : "'" + cmdbTypeBr.getLserverAssetid() + "', "));
			stringBuilder.append((StringUtils.isEmpty(cmdbTypeBr.getDescription()) ? "null, " : "'" + cmdbTypeBr.getDescription() + "', "));
			stringBuilder.append((StringUtils.isEmpty(cmdbTypeBr.getCell()) ? "null, " : "'" + cmdbTypeBr.getCell() + "', "));
			stringBuilder.append((StringUtils.isEmpty(cmdbTypeBr.getInstancename()) ? "null, " : "'" + cmdbTypeBr.getInstancename() + "', "));
			stringBuilder.append((StringUtils.isEmpty(cmdbTypeBr.getCiName()) ? "null, " : "'" + cmdbTypeBr.getCiName() + "', "));
			stringBuilder.append((StringUtils.isEmpty(cmdbTypeBr.getManager()) ? "null, " : "'" + cmdbTypeBr.getManager() + "', "));
			stringBuilder.append((StringUtils.isEmpty(cmdbTypeBr.getDbcCiName()) ? "null, " : "'" + cmdbTypeBr.getDbcCiName() + "', "));
			stringBuilder.append((StringUtils.isEmpty(cmdbTypeBr.getDbcDnc()) ? "null, " : "'" + cmdbTypeBr.getDbcDnc() + "', "));
			stringBuilder.append((StringUtils.isEmpty(cmdbTypeBr.getDbcid()) ? "null, " : "'" + cmdbTypeBr.getDbcid() + "', "));
			stringBuilder.append((StringUtils.isEmpty(cmdbTypeBr.getDbcStatus()) ? "null, " : "'" + cmdbTypeBr.getDbcStatus() + "', "));
			stringBuilder.append((StringUtils.isEmpty(cmdbTypeBr.getDbiCiName()) ? "null, " : "'" + cmdbTypeBr.getDbiCiName() + "', "));
			stringBuilder.append((StringUtils.isEmpty(cmdbTypeBr.getDbiDns()) ? "null, " : "'" + cmdbTypeBr.getDbiDns() + "', "));
			stringBuilder.append((StringUtils.isEmpty(cmdbTypeBr.getDbiId()) ? "null, " : "'" + cmdbTypeBr.getDbiId() + "', "));
			stringBuilder.append((StringUtils.isEmpty(cmdbTypeBr.getDbiStatus()) ? "null, " : "'" + cmdbTypeBr.getDbiStatus() + "', "));
			stringBuilder.append(((StringUtils.isEmpty(cmdbTypeBr.getPort()) || cmdbTypeBr.getPriority().equalsIgnoreCase("null")) ? "null, " : "" + cmdbTypeBr.getPort() + ", "));
			stringBuilder.append(((StringUtils.isEmpty(cmdbTypeBr.getLoginServer()) || cmdbTypeBr.getLoginServer().equalsIgnoreCase("null")) ? "null, " : "'" + cmdbTypeBr.getLoginServer() + "', "));
			stringBuilder.append(((StringUtils.isEmpty(cmdbTypeBr.getPriority()) || cmdbTypeBr.getPriority().equalsIgnoreCase("null")) ? "null, " : "" + cmdbTypeBr.getPriority() + ", "));
			stringBuilder.append("" + cmdbTypeBr.getDateUpdate().getTime() + "");
			stringBuilder.append(")");

			//System.out.println(stringBuilder.toString());
			Query createNativeQuery = em.createNativeQuery(stringBuilder.toString());

			createNativeQuery.executeUpdate();
		}
	}

}