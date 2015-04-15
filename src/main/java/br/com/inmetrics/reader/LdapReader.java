package br.com.inmetrics.reader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.inmetrics.model.csv.LDAP;

@Service
public class LdapReader {

	public List<LDAP> readLdapCsv(List<String> stringList) throws FileNotFoundException {
		List<LDAP> ldapList = new ArrayList<LDAP>();

		for (String line : stringList) {
			String[] split = line.split("\\|");

			LDAP ldap = new LDAP();
			
			ldap.setAssetid(split[0]);
			ldap.setName(split[1]);
			ldap.setStatus(split[2]);
			ldap.setDescription(split[3]);
			ldap.setDelivery(split[4]);
			ldap.setVirtualDc(split[5]);
			ldap.setEnviroment(split[6]);
			ldap.setFqdn(split[7]);
			ldap.setServicePort(split[8]);
			ldap.setLserverAssetid(split[9]);
			ldap.setLservername(split[10]);
			ldap.setLserverStatus(split[11]);
//			ldap.setLserverAdmFqdn(split[12]);
			
			ldapList.add(ldap);
		}

	    return ldapList;
	}
}