package br.com.inmetrics.model.csv;

public class WEB {

	private String assetid;				//PRB_WEB_ASSETID
	private String name;				//PRB_WEB_NAME
	private String status;				//PRB_WEB_STATUS
	private String delivery;			//PRB_WEB_DELIVERY
	private String virtualDc;			//PRB_WEB_VIRTUALDC
	private String enviroment;			//PRB_WEB_ENVIRONMENT
	private String configurationFile;	//PRB_WEB_CONFIGURATION_FILE
	private String lserverAssetid;		//PRB_WEB_LSERVER_ASSETID
	private String lservername;			//PRB_WEB_LSERVER_NAME
	private String lserverStatus;		//PRB_WEB_LSERVER_STATUS
	private String lserverAdmFqdn;		//PRB_WEB_LSERVER_ADM_FQDN

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

	public String getConfigurationFile() {
		return configurationFile;
	}

	public void setConfigurationFile(String configurationFile) {
		this.configurationFile = configurationFile;
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