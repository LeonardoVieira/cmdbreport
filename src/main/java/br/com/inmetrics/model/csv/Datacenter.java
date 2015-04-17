package br.com.inmetrics.model.csv;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "DATACENTER")
public class Datacenter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OBJECT_ID")
	private Long objectId;			//Object ID

	@Column(name = "VM")
	private String vm;					//VM
	
	@Column(name = "DNS_NAME")
	private String dnsName; 			//DNS Name
	
	@Column(name = "POWER_STATE")
	private String powerState;			//Powerstate
	
	@Column(name = "CONNECTION_STATE")
	private String connectionState; 	//Connection state
	
	@Column(name = "GUEST_STATE")
	private String guestState; 			//Guest state
	
	@Column(name = "HEART_BEAT")
	private String heartBeat; 			//Heartbeat
	
	@Column(name = "CONSOLIDATION_NEEDED")
	private String consolidationNeeded;	//Consolidation Needed
	
	@Column(name = "POWER_ON")
	private String powerOn;				//PowerOn
	
	@Column(name = "SUSPEND_TIME")
	private String suspendTime;			//Suspend time
	
	@Column(name = "CPU")
	private String cpu;					//CPUs
	
	@Column(name = "MEMORY")
	private String memory;				//Memory
	
	@Column(name = "NIC")
	private String nic;					//NICs
	
	@Column(name = "DISK")
	private String disk;				//Disks
	
	@Column(name = "NETWORK_ONE")
	private String networkOne;			//Network #1
	
	@Column(name = "NETWORK_TWO")
	private String networkTwo;			//Network #2
	
	@Column(name = "NETWORK_THREE")
	private String networkThree;		//Network #3
	
	@Column(name = "NETWORK_FOUR")
	private String networkFour;			//Network #4
	
	@Column(name = "RESOURCE_POOL")
	private String resourcePool;		//Resource pool
	
	@Column(name = "FOLDER")
	private String folder;				//Folder
	
	@Column(name = "V_APP")
	private String vApp;				//vApp
	
	@Column(name = "DAS_PROTECTION")
	private String dasProtection;		//DAS protection
	
	@Column(name = "FT_STATE")
	private String ftState;				//FT State
	
	@Column(name = "FT_LATENCY")
	private String ftLatency;			//FT Latency
	
	@Column(name = "FT_BANDWIDTH")
	private String ftBandwidth;			//FT Bandwidth
	
	@Column(name = "FT_SEC_LATENCY")
	private String ftSecLatency;		//FT Sec. Latency
	
	@Column(name = "PROVISIONER_MB")
	private String provisionerMb;		//Provisioned MB
	
	@Column(name = "IN_USE_MB")
	private String inUseMb;				//In Use MB
	
	@Column(name = "UNSHARED_MB")
	private String unsharedMb;			//Unshared MB
	
	@Column(name = "HARESTART_PRIORITY")
	private String haRestartPriority;	//HA Restart Priority
	
	@Column(name = "HAISOLATION_RESPONDE")
	private String haIsolationResponde;	//HA Isolation Response
	
	@Column(name = "CLUSTER_RULE")
	private String clusterRule;			//Cluster rule(s)
	
	@Column(name = "CLUSTER_RULENAME")
	private String clusterRulename;		//Cluster rule name(s)
	
	@Column(name = "BOOT_REQUIRED")
	private String bootRequired;		//Boot Required
	
	@Column(name = "BOOT_DELAY")
	private String bootDelay;			//Boot delay
	
	@Column(name = "BOOT_RETRY_DELAY")
	private String bootRetryDelay;		//Boot retry delay
	
	@Column(name = "BOOT_RETRY_ENABLED")
	private String bootRetryenabled;	//Boot retry enabled
	
	@Column(name = "BOOTBIOSSETUP")
	private String bootBiosSetup; 		//Boot BIOS setup
	
	@Column(name = "FIRMWARE")
	private String firmware;			//Firmware
	
	@Column(name = "HW_VERSION")
	private String hwVersion;			//HW version
	
	@Column(name = "HW_UPGRADE_STATUS")
	private String hwUpgradeStatus;		//HW upgrade status
	
	@Column(name = "HW_UPGRADE_POLICY")
	private String hwUpgradePolicy;		//HW upgrade policy
	
	@Column(name = "HW_TARGET")
	private String hwtarget;			//HW target
	
	@Column(name = "PATH")
	private String path;				//Path
	
	@Column(name = "ANNOTATION")
	private String annotation;			//Annotation
	
	@Column(name = "DATACENTER")
	private String datacenter;			//Datacenter
	
	@Column(name = "CLUSTER")
	private String cluster;				//Cluster
	
	@Column(name = "HOST")
	private String host;				//Host
	
	@Column(name = "OS")
	private String os;					//OS
	
	@Column(name = "UUID")
	private String uuid; 				//UUID

	public String getVm() {
		return vm;
	}

	public void setVm(String vm) {
		this.vm = vm;
	}

	public String getDnsName() {
		return dnsName;
	}

	public void setDnsName(String dnsName) {
		this.dnsName = dnsName;
	}

	public String getPowerState() {
		return powerState;
	}

	public void setPowerState(String powerState) {
		this.powerState = powerState;
	}

	public String getConnectionState() {
		return connectionState;
	}

	public void setConnectionState(String connectionState) {
		this.connectionState = connectionState;
	}

	public String getGuestState() {
		return guestState;
	}

	public void setGuestState(String guestState) {
		this.guestState = guestState;
	}

	public String getHeartBeat() {
		return heartBeat;
	}

	public void setHeartBeat(String heartBeat) {
		this.heartBeat = heartBeat;
	}

	public String getConsolidationNeeded() {
		return consolidationNeeded;
	}

	public void setConsolidationNeeded(String consolidationNeeded) {
		this.consolidationNeeded = consolidationNeeded;
	}

	public String getPowerOn() {
		return powerOn;
	}

	public void setPowerOn(String powerOn) {
		this.powerOn = powerOn;
	}

	public String getSuspendTime() {
		return suspendTime;
	}

	public void setSuspendTime(String suspendTime) {
		this.suspendTime = suspendTime;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getDisk() {
		return disk;
	}

	public void setDisk(String disk) {
		this.disk = disk;
	}

	public String getNetworkOne() {
		return networkOne;
	}

	public void setNetworkOne(String networkOne) {
		this.networkOne = networkOne;
	}

	public String getNetworkTwo() {
		return networkTwo;
	}

	public void setNetworkTwo(String networkTwo) {
		this.networkTwo = networkTwo;
	}

	public String getNetworkThree() {
		return networkThree;
	}

	public void setNetworkThree(String networkThree) {
		this.networkThree = networkThree;
	}

	public String getNetworkFour() {
		return networkFour;
	}

	public void setNetworkFour(String networkFour) {
		this.networkFour = networkFour;
	}

	public String getResourcePool() {
		return resourcePool;
	}

	public void setResourcePool(String resourcePool) {
		this.resourcePool = resourcePool;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public String getvApp() {
		return vApp;
	}

	public void setvApp(String vApp) {
		this.vApp = vApp;
	}

	public String getDasProtection() {
		return dasProtection;
	}

	public void setDasProtection(String dasProtection) {
		this.dasProtection = dasProtection;
	}

	public String getFtState() {
		return ftState;
	}

	public void setFtState(String ftState) {
		this.ftState = ftState;
	}

	public String getFtLatency() {
		return ftLatency;
	}

	public void setFtLatency(String ftLatency) {
		this.ftLatency = ftLatency;
	}

	public String getFtBandwidth() {
		return ftBandwidth;
	}

	public void setFtBandwidth(String ftBandwidth) {
		this.ftBandwidth = ftBandwidth;
	}

	public String getFtSecLatency() {
		return ftSecLatency;
	}

	public void setFtSecLatency(String ftSecLatency) {
		this.ftSecLatency = ftSecLatency;
	}

	public String getProvisionerMb() {
		return provisionerMb;
	}

	public void setProvisionerMb(String provisionerMb) {
		this.provisionerMb = provisionerMb;
	}

	public String getInUseMb() {
		return inUseMb;
	}

	public void setInUseMb(String inUseMb) {
		this.inUseMb = inUseMb;
	}

	public String getUnsharedMb() {
		return unsharedMb;
	}

	public void setUnsharedMb(String unsharedMb) {
		this.unsharedMb = unsharedMb;
	}

	public String getHaRestartPriority() {
		return haRestartPriority;
	}

	public void setHaRestartPriority(String haRestartPriority) {
		this.haRestartPriority = haRestartPriority;
	}

	public String getHaIsolationResponde() {
		return haIsolationResponde;
	}

	public void setHaIsolationResponde(String haIsolationResponde) {
		this.haIsolationResponde = haIsolationResponde;
	}

	public String getClusterRule() {
		return clusterRule;
	}

	public void setClusterRule(String clusterRule) {
		this.clusterRule = clusterRule;
	}

	public String getClusterRulename() {
		return clusterRulename;
	}

	public void setClusterRulename(String clusterRulename) {
		this.clusterRulename = clusterRulename;
	}

	public String getBootRequired() {
		return bootRequired;
	}

	public void setBootRequired(String bootRequired) {
		this.bootRequired = bootRequired;
	}

	public String getBootDelay() {
		return bootDelay;
	}

	public void setBootDelay(String bootDelay) {
		this.bootDelay = bootDelay;
	}

	public String getBootRetryDelay() {
		return bootRetryDelay;
	}

	public void setBootRetryDelay(String bootRetryDelay) {
		this.bootRetryDelay = bootRetryDelay;
	}

	public String getBootRetryenabled() {
		return bootRetryenabled;
	}

	public void setBootRetryenabled(String bootRetryenabled) {
		this.bootRetryenabled = bootRetryenabled;
	}

	public String getBootBiosSetup() {
		return bootBiosSetup;
	}

	public void setBootBiosSetup(String bootBiosSetup) {
		this.bootBiosSetup = bootBiosSetup;
	}

	public String getFirmware() {
		return firmware;
	}

	public void setFirmware(String firmware) {
		this.firmware = firmware;
	}

	public String getHwVersion() {
		return hwVersion;
	}

	public void setHwVersion(String hwVersion) {
		this.hwVersion = hwVersion;
	}

	public String getHwUpgradeStatus() {
		return hwUpgradeStatus;
	}

	public void setHwUpgradeStatus(String hwUpgradeStatus) {
		this.hwUpgradeStatus = hwUpgradeStatus;
	}

	public String getHwUpgradePolicy() {
		return hwUpgradePolicy;
	}

	public void setHwUpgradePolicy(String hwUpgradePolicy) {
		this.hwUpgradePolicy = hwUpgradePolicy;
	}

	public String getHwtarget() {
		return hwtarget;
	}

	public void setHwtarget(String hwtarget) {
		this.hwtarget = hwtarget;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

	public String getDatacenter() {
		return datacenter;
	}

	public void setDatacenter(String datacenter) {
		this.datacenter = datacenter;
	}

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}
}