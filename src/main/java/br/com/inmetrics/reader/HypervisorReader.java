package br.com.inmetrics.reader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.inmetrics.dao.HypervisorDAO;
import br.com.inmetrics.model.csv.Datacenter;
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
	
	public void updateDatacenter() throws FileNotFoundException {
		List<Datacenter> datacenters = new ArrayList<Datacenter>();
		List<String> readCsv = cmdbReader.readCsv("smb://bsbrsp3791/compartilhamento/CMDB/BR_INFO_VCENTER_NORTE.csv");
		readCsv.remove(0);

		datacenters.addAll(createDatacenterObjectList(readCsv));

		readCsv = cmdbReader.readCsv("smb://bsbrsp3791/compartilhamento/CMDB/BR_INFO_VCENTER_SUL.csv");
		readCsv.remove(0);

		datacenters.addAll(createDatacenterObjectList(readCsv));

		hypervisorDAO.updateDatacenter(datacenters);
	}

	private List<Datacenter> createDatacenterObjectList(List<String> stringList) {
		List<Datacenter> datacenters = new ArrayList<Datacenter>();

		for (String line : stringList) {
			String[] split = line.split(",");
			Datacenter datacenter = new Datacenter();

			datacenter.setVm(split[0]);
//			datacenter.setDnsName(split[1]);
			datacenter.setPowerState(split[2]);
			datacenter.setConnectionState(split[3]);
			datacenter.setGuestState(split[4]);
//			datacenter.setHeartBeat(split[5]);
//			datacenter.setConsolidationNeeded(split[6]);
			datacenter.setPowerOn(split[7]);
//			datacenter.setSuspendTime(split[8]);
			datacenter.setCpu(split[9]);
			datacenter.setMemory(split[10]);
			datacenter.setNic(split[11]);
			datacenter.setDisk(split[12]);
			datacenter.setNetworkOne(split[13]);
			datacenter.setNetworkTwo(split[14]);
			datacenter.setNetworkThree(split[15]);
			datacenter.setNetworkFour(split[16]);
//			datacenter.setResourcePool(split[17]);
//			datacenter.setFolder(split[18]);
			datacenter.setvApp(split[19]);
			datacenter.setDasProtection(split[20]);
			datacenter.setFtState(split[21]);
			datacenter.setFtLatency(split[22]);
			datacenter.setFtBandwidth(split[23]);
			datacenter.setFtSecLatency(split[24]);
			datacenter.setProvisionerMb(split[25]);
			datacenter.setInUseMb(split[26]);
			datacenter.setUnsharedMb(split[27]);
			datacenter.setHaRestartPriority(split[28]);
			datacenter.setHaIsolationResponde(split[29]);
			datacenter.setClusterRule(split[30]);
			datacenter.setClusterRulename(split[31]);
			datacenter.setBootRequired(split[32]);
			datacenter.setBootDelay(split[33]);
			datacenter.setBootRetryDelay(split[34]);
			datacenter.setBootRetryenabled(split[35]);
			datacenter.setBootBiosSetup(split[36]);
			datacenter.setFirmware(split[37]);
			datacenter.setHwVersion(split[38]);
			datacenter.setHwUpgradeStatus(split[39]);
			datacenter.setHwUpgradePolicy(split[40]);
			datacenter.setHwtarget(split[41]);
//			datacenter.setPath(split[42]);
//			datacenter.setAnnotation(split[43]);
			datacenter.setDatacenter(split[44]);
			datacenter.setCluster(split[45]);
			datacenter.setHost(split[46]);
			datacenter.setOs(split[47]);
//			datacenter.setUuid(split[48]);

			datacenters.add(datacenter);
		}

		return datacenters;
	}

}