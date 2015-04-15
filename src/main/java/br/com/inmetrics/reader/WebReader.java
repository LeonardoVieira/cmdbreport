package br.com.inmetrics.reader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.inmetrics.model.csv.WEB;

@Service
public class WebReader {

	public List<WEB> readWebCsv(List<String> list) throws FileNotFoundException {
		List<WEB> webList = new ArrayList<WEB>();

		for (String line : list) {
			String[] split = line.split("\\|");

			WEB web = new WEB();

			web.setAssetid(split[0]);
			web.setName(split[1]);
			web.setStatus(split[2]);
			web.setDelivery(split[3]);
			web.setVirtualDc(split[4]);
			web.setEnviroment(split[5]);
			web.setConfigurationFile(split[6]);
			web.setLserverAssetid(split[7]);
			web.setLservername(split[8]);
			web.setLserverStatus(split[9]);
//			web.setLserverAdmFqdn(split[10]);
			
			webList.add(web);
		}

	    return webList;
	}
}
