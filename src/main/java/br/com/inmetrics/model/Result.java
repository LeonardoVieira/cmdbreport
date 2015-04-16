package br.com.inmetrics.model;


public class Result {

	private String type;
	
	private String instanceName;
	
	private String hostname;
	
	private String datacenter;
	
	private String serviceComponent;
	
	private String technicalService;
	
	private String businessService;
	
	private String rede;

	private String cluster;

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getDatacenter() {
		return datacenter;
	}

	public void setDatacenter(String datacenter) {
		this.datacenter = datacenter;
	}

	public String getServiceComponent() {
		return serviceComponent;
	}

	public void setServiceComponent(String serviceComponent) {
		this.serviceComponent = serviceComponent;
	}

	public String getTechnicalService() {
		return technicalService;
	}

	public void setTechnicalService(String technicalService) {
		this.technicalService = technicalService;
	}

	public String getBusinessService() {
		return businessService;
	}

	public void setBusinessService(String businessService) {
		this.businessService = businessService;
	}

	public String getRede() {
		return rede;
	}

	public void setRede(String rede) {
		this.rede = rede;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}
}