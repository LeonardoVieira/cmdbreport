package br.com.inmetrics.model;

public class Filter {

	private String hostname;

	private String businessService;

	private String technicalService;

	private String serviceComponent;

	private String networdDistribution;

	private String datacenter;

	private Boolean show;

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getBusinessService() {
		return businessService;
	}

	public void setBusinessService(String businessService) {
		this.businessService = businessService;
	}

	public String getTechnicalService() {
		return technicalService;
	}

	public void setTechnicalService(String technicalService) {
		this.technicalService = technicalService;
	}

	public String getServiceComponent() {
		return serviceComponent;
	}

	public void setServiceComponent(String serviceComponent) {
		this.serviceComponent = serviceComponent;
	}

	public String getNetwordDistribution() {
		return networdDistribution;
	}

	public void setNetwordDistribution(String networdDistribution) {
		this.networdDistribution = networdDistribution;
	}

	public String getDatacenter() {
		return datacenter;
	}

	public void setDatacenter(String datacenter) {
		this.datacenter = datacenter;
	}

	public Boolean getShow() {
		return show;
	}

	public void setShow(Boolean show) {
		this.show = show;
	}
}