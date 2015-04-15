package br.com.inmetrics.model.csv;

public class LDAP {

	private String assetid; 		// PRB_LDAP_ASSETID;
	private String name; 			// PRB_LDAP_NAME;
	private String status; 			// PRB_LDAP_STATUS;
	private String description; 	// PRB_LDAP_DESCRIPTION;
	private String delivery; 		// PRB_LDAP_DELIVERY;
	private String virtualDc; 		// PRB_LDAP_VIRTUALDC;
	private String enviroment; 		// PRB_LDAP_ENVIRONMENT;
	private String fqdn; 			// PRB_LDAP_SERVICE_FQDN;
	private String servicePort; 	// PRB_LDAP_SERVICE_PORT;
	private String lserverAssetid; 	// PRB_LDAP_LSERVER_ASSETID;
	private String lservername; 	// PRB_LDAP_LSERVER_NAME;
	private String lserverStatus; 	// PRB_LDAP_LSERVER_STATUS;
	private String lserverAdmFqdn; 	// PRB_LDAP_LSERVER_ADM_FQDN;

	public String getAssetid() {
		return assetid;
	}

	public void setAssetid(String assetid) {
		this.assetid = assetid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public String getVirtualDc() {
		return virtualDc;
	}

	public void setVirtualDc(String virtualDc) {
		this.virtualDc = virtualDc;
	}

	public String getEnviroment() {
		return enviroment;
	}

	public void setEnviroment(String enviroment) {
		this.enviroment = enviroment;
	}

	public String getFqdn() {
		return fqdn;
	}

	public void setFqdn(String fqdn) {
		this.fqdn = fqdn;
	}

	public String getServicePort() {
		return servicePort;
	}

	public void setServicePort(String servicePort) {
		this.servicePort = servicePort;
	}

	public String getLserverAssetid() {
		return lserverAssetid;
	}

	public void setLserverAssetid(String lserverAssetid) {
		this.lserverAssetid = lserverAssetid;
	}

	public String getLservername() {
		return lservername;
	}

	public void setLservername(String lservername) {
		this.lservername = lservername;
	}

	public String getLserverStatus() {
		return lserverStatus;
	}

	public void setLserverStatus(String lserverStatus) {
		this.lserverStatus = lserverStatus;
	}

	public String getLserverAdmFqdn() {
		return lserverAdmFqdn;
	}

	public void setLserverAdmFqdn(String lserverAdmFqdn) {
		this.lserverAdmFqdn = lserverAdmFqdn;
	}
}