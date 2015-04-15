package br.com.inmetrics.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.inmetrics.dao.CmdbDAO;
import br.com.inmetrics.model.CmdbTypeBr;
import br.com.inmetrics.model.csv.DB;
import br.com.inmetrics.model.csv.LDAP;
import br.com.inmetrics.model.csv.WAS;
import br.com.inmetrics.model.csv.WEB;

@Service
public class CmdbReader {

	@Autowired
	private DbReader dbReader;

	@Autowired
	private LdapReader ldapReader;

	@Autowired
	private WasReader wasReader;

	@Autowired
	private WebReader webReader;

	@Autowired
	private CmdbDAO cmdbDAO;

	public void update() throws FileNotFoundException {
		List<CmdbTypeBr> cmdbTypeBrs = new ArrayList<CmdbTypeBr>();
		Date date = new Date();

		getDbObjects(cmdbTypeBrs, date);
		getLdapObjects(cmdbTypeBrs, date);
		getWasobjects(cmdbTypeBrs, date);
		getWebObjects(cmdbTypeBrs, date);

		cmdbDAO.update(cmdbTypeBrs);
	}

	private void getDbObjects(List<CmdbTypeBr> cmdbTypeBrs, Date date)
			throws FileNotFoundException {
		List<String> readCsv = readCsv("smb://bsbrsp3791/compartilhamento/CMDB/CMDB_DDBB_BR.csv");
		readCsv.remove(0);

		List<DB> readDbCsv = dbReader.createDbObjectList(readCsv);

		for (DB db : readDbCsv) {
			CmdbTypeBr cmdbTypeBr = new CmdbTypeBr();

			cmdbTypeBr.setType("DB");
			cmdbTypeBr.setAssetid(db.getServerAssetid());
			cmdbTypeBr.setName(db.getDbName());
			cmdbTypeBr.setManager(db.getDbManager());
			cmdbTypeBr.setInstancename(db.getDbInstanceName());
			cmdbTypeBr.setDbcCiName(db.getDbcCiName());
			cmdbTypeBr.setDbcDnc(db.getDbcDns());
			cmdbTypeBr.setDbcid(db.getDbcId());
			cmdbTypeBr.setDbcStatus(db.getDbcStatus());
			cmdbTypeBr.setDbiCiName(db.getDbiCiName());
			cmdbTypeBr.setDbiDns(db.getDbiDns());
			cmdbTypeBr.setDbiId(db.getDbiId());
			cmdbTypeBr.setDbiStatus(db.getDbiStatus());
			cmdbTypeBr.setPort(db.getDbPort());
			cmdbTypeBr.setLoginServer(db.getDbLoginServer());
			cmdbTypeBr.setDelivery(db.getDbDelivery());
			cmdbTypeBr.setVdc(db.getDbVdc());
			cmdbTypeBr.setEnviroment(db.getDbEnviroment());
			cmdbTypeBr.setPriority(db.getDbPriority());
			cmdbTypeBr.setDateUpdate(date);

			cmdbTypeBrs.add(cmdbTypeBr);
		}
	}

	private void getLdapObjects(List<CmdbTypeBr> cmdbTypeBrs, Date date) throws FileNotFoundException {
		List<String> readCsv = readCsv("smb://bsbrsp3791/compartilhamento/CMDB/CMDB_LDAP_BR.csv");
		readCsv.remove(0);

		List<LDAP> readLdapCsv = ldapReader.readLdapCsv(readCsv);

		for (LDAP ldap : readLdapCsv) {
			CmdbTypeBr cmdbTypeBr = new CmdbTypeBr();

			cmdbTypeBr.setType("LDAP");
			cmdbTypeBr.setAssetid(ldap.getAssetid());
			cmdbTypeBr.setName(ldap.getName());
			cmdbTypeBr.setStatus(ldap.getStatus());
			cmdbTypeBr.setDescription(ldap.getDescription());
			cmdbTypeBr.setDelivery(ldap.getDelivery());
			cmdbTypeBr.setVdc(ldap.getVirtualDc());
			cmdbTypeBr.setEnviroment(ldap.getEnviroment());
			cmdbTypeBr.setLserverAssetid(ldap.getLserverAssetid());
			cmdbTypeBr.setDateUpdate(date);

			cmdbTypeBrs.add(cmdbTypeBr);
		}
	}

	private void getWasobjects(List<CmdbTypeBr> cmdbTypeBrs, Date date) throws FileNotFoundException {
		List<String> readCsv = readCsv("smb://bsbrsp3791/compartilhamento/CMDB/CMDB_WAS_BR.csv");
		readCsv.remove(0);

		List<WAS> readWasCsv = wasReader.readWasCsv(readCsv);

		for (WAS was : readWasCsv) {
			CmdbTypeBr cmdbTypeBr = new CmdbTypeBr();

			cmdbTypeBr.setType("WAS");
			cmdbTypeBr.setAssetid(was.getAssetid());
			cmdbTypeBr.setName(was.getCiName());
			cmdbTypeBr.setStatus(was.getStatus());
			cmdbTypeBr.setInstancename(was.getInstanceName());
			cmdbTypeBr.setDelivery(was.getDelivery());
			cmdbTypeBr.setVdc(was.getVirtualDc());
			cmdbTypeBr.setEnviroment(was.getEnviroment());
			cmdbTypeBr.setCell(was.getCell());
			cmdbTypeBr.setLserverAssetid(was.getLserverAssetid());
			cmdbTypeBr.setDateUpdate(date);

			cmdbTypeBrs.add(cmdbTypeBr);
		}
	}

	private void getWebObjects(List<CmdbTypeBr> cmdbTypeBrs, Date date) throws FileNotFoundException {
		List<String> readCsv = readCsv("smb://bsbrsp3791/compartilhamento/CMDB/CMDB_WEB_BR.csv");
		readCsv.remove(0);
		List<WEB> readWebCsv = webReader.readWebCsv(readCsv);

		for (WEB web : readWebCsv) {
			CmdbTypeBr cmdbTypeBr = new CmdbTypeBr();

			cmdbTypeBr.setType("WEB");
			cmdbTypeBr.setAssetid(web.getAssetid());
			cmdbTypeBr.setName(web.getName());
			cmdbTypeBr.setStatus(web.getStatus());
			cmdbTypeBr.setDelivery(web.getDelivery());
			cmdbTypeBr.setVdc(web.getVirtualDc());
			cmdbTypeBr.setEnviroment(web.getEnviroment());
			cmdbTypeBr.setLserverAssetid(web.getLserverAssetid());
			cmdbTypeBr.setDateUpdate(date);

			cmdbTypeBrs.add(cmdbTypeBr);
		}
	}

	public List<String> readCsv(String path) {
		List<String> csvFileContent = new ArrayList<String>();

		try {
			NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("BSBR", "spitc0bx", "18z89jgt");

			SmbFile sFile = new SmbFile(path, auth);

			try {
				csvFileContent = readFileContent(sFile);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return csvFileContent;
	}

	private List<String> readFileContent(SmbFile sFile) {
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new InputStreamReader(new SmbFileInputStream(sFile)));
		} catch (SmbException ex) {
			System.out.println(ex);
		} catch (MalformedURLException ex) {
			System.out.println(ex);
		} catch (UnknownHostException ex) {
			System.out.println(ex);
		}

		String lineReader = null;
		List<String> csvLines = new ArrayList<String>();
		
		try {
			while ((lineReader = reader.readLine()) != null) {
				csvLines.add(lineReader);
			}
		} catch (IOException exception) {
			exception.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException ex) {
				System.out.println(ex);
			}
		}

		return csvLines;
	}
}