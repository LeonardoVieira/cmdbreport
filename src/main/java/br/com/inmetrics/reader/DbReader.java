package br.com.inmetrics.reader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.inmetrics.model.csv.DB;

@Service
public class DbReader {

	public List<DB> createDbObjectList(List<String> stringList) throws FileNotFoundException {
		List<DB> dbList = new ArrayList<DB>();

		for (String line : stringList) {
			String[] split = line.split("\\|");

			DB db = new DB();
			
			db.setServerFqdn(split[0]);
			db.setServerAssetid(split[1]);
			db.setDbName(split[2]);
			db.setDbManager(split[3]);
			db.setDbInstanceName(split[4]);
			db.setDbcCiName(split[5]);
			db.setDbcDns(split[6]);
			db.setDbcId(split[7]);
			db.setDbcStatus(split[8]);
			db.setDbiCiName(split[8]);
			db.setDbiDns(split[10]);
			db.setDbiId(split[11]);
			db.setDbiStatus(split[12]);
			db.setDbPort(split[13]);
			db.setDbLoginServer(split[14]);
			db.setDbDelivery(split[15]);
			db.setDbVdc(split[16]);
			db.setDbEnviroment(split[17]);
			db.setDbPriority(split[18]);
			db.setDbVersion(split[19]);
			db.setDbRac(split[20]);
//			db.setNodoBl(split[21]);
			
			dbList.add(db);
		}

	    return dbList;
	}
}