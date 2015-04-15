package br.com.inmetrics.model.csv;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "HYPERVISOR")
public class Hypervisor {

	@Id
	@Column(name = "HYP_ID")
	private String id;

	@Column(name = "HYP_NAME")
	private String name;

	@Column(name = "HYP_COMPANY")
	private String company;

	@Column(name = "HYP_DELIVERY")
	private String delivery;

	@Column(name = "HYP_VDC")
	private String vdc;

	@Column(name = "HYP_DISTR_NTW")
	private String distrNtw;

	@Column(name = "HYP_ENV")
	private String enviroment;

	@Column(name = "HYP_STATUS")
	private String status;

	@Column(name = "HYP_CATEGORY")
	private String category;

	@Column(name = "HYP_TYPE")
	private String type;

	@Column(name = "HYP_ITEM")
	private String item;

	@Column(name = "HYP_ADMVE_FQDN")
	private String fqdn;

	@Column(name = "REL_CS_HYP")
	private String csHyp;

	@Column(name = "CS_TYPE")
	private String csType;

	@Column(name = "CS_NAME")
	private String csname;

	@Column(name = "CS_ID")
	private String csId;

	@Column(name = "CS_COMPANY")
	private String csCompany;

	@Column(name = "CS_DELIVERY")
	private String csDelivery;

	@Column(name = "CS_ENV")
	private String csEnviroment;

	@Column(name = "CS_STATUS")
	private String csStatus;

	@Column(name = "REL_HYP_CLU")
	private String hyperCluster;

	@Column(name = "CLU_NAME")
	private String cluName;

	@Column(name = "CLU_ID")
	private String cluId;

	@Column(name = "CLU_COMPANY")
	private String cluCompany;

	@Column(name = "CLU_DELIVERY")
	private String cluDelivery;

	@Column(name = "CLU_ENV")
	private String cluEnviroment;

	@Column(name = "CLU_STATUS")
	private String cluStatus;

	@Column(name = "Rel_LS")
	private String relLs;

	@Column(name = "LS_NAME")
	private String lsName;

	@Column(name = "LS_ID")
	private String lsId;

	@Column(name = "LS_COMPANY")
	private String lsCompany;

	@Column(name = "LS_DELIVERY")
	private String lsDelivery;

	@Column(name = "LS_ENV")
	private String lsEnviroment;

	@Column(name = "LS_STATUS")
	private String lsStatus;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public String getVdc() {
		return vdc;
	}

	public void setVdc(String vdc) {
		this.vdc = vdc;
	}

	public String getDistrNtw() {
		return distrNtw;
	}

	public void setDistrNtw(String distrNtw) {
		this.distrNtw = distrNtw;
	}

	public String getEnviroment() {
		return enviroment;
	}

	public void setEnviroment(String enviroment) {
		this.enviroment = enviroment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getFqdn() {
		return fqdn;
	}

	public void setFqdn(String fqdn) {
		this.fqdn = fqdn;
	}

	public String getCsHyp() {
		return csHyp;
	}

	public void setCsHyp(String csHyp) {
		this.csHyp = csHyp;
	}

	public String getCdType() {
		return csType;
	}

	public void setCsType(String csType) {
		this.csType = csType;
	}

	public String getCsname() {
		return csname;
	}

	public void setCsname(String csname) {
		this.csname = csname;
	}

	public String getCsId() {
		return csId;
	}

	public void setCsId(String csId) {
		this.csId = csId;
	}

	public String getCsCompany() {
		return csCompany;
	}

	public void setCsCompany(String csCompany) {
		this.csCompany = csCompany;
	}

	public String getCsDelivery() {
		return csDelivery;
	}

	public void setCsDelivery(String csDelivery) {
		this.csDelivery = csDelivery;
	}

	public String getCsEnviroment() {
		return csEnviroment;
	}

	public void setCsEnviroment(String csEnviroment) {
		this.csEnviroment = csEnviroment;
	}

	public String getCsStatus() {
		return csStatus;
	}

	public void setCsStatus(String csStatus) {
		this.csStatus = csStatus;
	}

	public String getHyperCluster() {
		return hyperCluster;
	}

	public void setHyperCluster(String hyperCluster) {
		this.hyperCluster = hyperCluster;
	}

	public String getCluName() {
		return cluName;
	}

	public void setCluName(String cluName) {
		this.cluName = cluName;
	}

	public String getCluId() {
		return cluId;
	}

	public void setCluId(String cluId) {
		this.cluId = cluId;
	}

	public String getCluCompany() {
		return cluCompany;
	}

	public void setCluCompany(String cluCompany) {
		this.cluCompany = cluCompany;
	}

	public String getCluDelivery() {
		return cluDelivery;
	}

	public void setCluDelivery(String cluDelivery) {
		this.cluDelivery = cluDelivery;
	}

	public String getCluEnviroment() {
		return cluEnviroment;
	}

	public void setCluEnviroment(String cluEnviroment) {
		this.cluEnviroment = cluEnviroment;
	}

	public String getCluStatus() {
		return cluStatus;
	}

	public void setCluStatus(String cluStatus) {
		this.cluStatus = cluStatus;
	}

	public String getRelLs() {
		return relLs;
	}

	public void setRelLs(String relLs) {
		this.relLs = relLs;
	}

	public String getLsName() {
		return lsName;
	}

	public void setLsName(String lsName) {
		this.lsName = lsName;
	}

	public String getLsId() {
		return lsId;
	}

	public void setLsId(String lsId) {
		this.lsId = lsId;
	}

	public String getLsCompany() {
		return lsCompany;
	}

	public void setLsCompany(String lsCompany) {
		this.lsCompany = lsCompany;
	}

	public String getLsDelivery() {
		return lsDelivery;
	}

	public void setLsDelivery(String lsDelivery) {
		this.lsDelivery = lsDelivery;
	}

	public String getLsEnviroment() {
		return lsEnviroment;
	}

	public void setLsEnviroment(String lsEnviroment) {
		this.lsEnviroment = lsEnviroment;
	}

	public String getLsStatus() {
		return lsStatus;
	}

	public void setLsStatus(String lsStatus) {
		this.lsStatus = lsStatus;
	}
}