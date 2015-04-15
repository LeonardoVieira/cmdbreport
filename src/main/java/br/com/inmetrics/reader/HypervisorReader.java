package br.com.inmetrics.reader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.inmetrics.dao.HypervisorDAO;
import br.com.inmetrics.model.csv.Hypervisor;

@Service
public class HypervisorReader {

	@Autowired
	private CmdbReader cmdbReader;

	@Autowired
	private HypervisorDAO hypervisorDAO;

	public void update() throws FileNotFoundException {
		List<String> readCsv = cmdbReader.readCsv("smb://bsbrsp3791/compartilhamento/CMDB/hypervisor.csv");
		readCsv.remove(0);

		hypervisorDAO.update(createHypervisorObjectList(readCsv));
	}

	public List<Hypervisor> createHypervisorObjectList(List<String> stringList) throws FileNotFoundException {
		List<Hypervisor> hypervisors = new ArrayList<Hypervisor>();

		for (String line : stringList) {
			String[] split = line.split(";");
			Hypervisor hypervisor = new Hypervisor();

			hypervisor.setName(split[0]);
			hypervisor.setId(split[1]);
			hypervisor.setCompany(split[2]);
			hypervisor.setDelivery(split[3]);
			hypervisor.setVdc(split[4]);
			hypervisor.setDistrNtw(split[5]);
			hypervisor.setEnviroment(split[6]);
			hypervisor.setStatus(split[7]);
			hypervisor.setCategory(split[8]);
			hypervisor.setType(split[9]);
			hypervisor.setItem(split[10]);
			hypervisor.setFqdn(split[11]);
			hypervisor.setCsHyp(split[12]);
			hypervisor.setCsType(split[13]);
			hypervisor.setCsname(split[14]);
			hypervisor.setCsId(split[15]);
			hypervisor.setCsCompany(split[16]);
			hypervisor.setCsDelivery(split[17]);
			hypervisor.setCsEnviroment(split[18]);
			hypervisor.setCsStatus(split[19]);
			hypervisor.setHyperCluster(split[20]);
			hypervisor.setCluName(split[21]);
			hypervisor.setCluId(split[22]);
			hypervisor.setCluCompany(split[23]);
			hypervisor.setCluDelivery(split[24]);
			hypervisor.setCluEnviroment(split[25]);
			hypervisor.setCluStatus(split[26]);
			hypervisor.setRelLs(split[27]);
			hypervisor.setLsName(split[28]);
			hypervisor.setLsId(split[29]);
			hypervisor.setLsCompany(split[30]);
			hypervisor.setDelivery(split[31]);
			hypervisor.setLsEnviroment(split[32]);

			hypervisors.add(hypervisor);
		}

		return hypervisors;
	}
}