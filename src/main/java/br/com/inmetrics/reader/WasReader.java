package br.com.inmetrics.reader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.inmetrics.model.csv.WAS;

@Service
public class WasReader {

	public List<WAS> readWasCsv(List<String> list) throws FileNotFoundException {
		List<WAS> wasList = new ArrayList<WAS>();

		for (String line : list) {
			String[] split = line.split("\\|");
			
			WAS was = new WAS();

			was.setAssetid(split[0]);
			was.setCiName(split[1]);
			was.setInstanceName(split[2]);
			was.setStatus(split[3]);
			was.setDelivery(split[4]);
			was.setVirtualDc(split[5]);
			was.setEnviroment(split[6]);
			was.setManufacturer(split[7]);
			was.setProductName(split[8]);
			was.setProductVersion(split[9]);
			was.setItem(split[10]);
			was.setCell(split[11]);
			was.setServiceIp(split[12]);
			was.setServicePort(split[13]);
			was.setInstallationDirectory(split[14]);
			was.setLserverAssetid(split[15]);
			was.setLserverName(split[16]);
			was.setLserverStatus(split[17]);
			was.setLserverAdmFqdn(split[18]);

			//desconsiderado por nao ser utilizado e dava erro de index quando nulo
			//was.setLserverServiceFqdn(split[19]);

			wasList.add(was);
        }

	    return wasList;
	}
}