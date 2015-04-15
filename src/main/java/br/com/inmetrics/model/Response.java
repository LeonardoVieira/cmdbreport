package br.com.inmetrics.model;

import java.util.List;

public class Response {

	private String name;
	
	private Integer quantity;

	private Integer hostname;
	
	private Integer instanceName;
	
	private List<Result> results;

	private boolean show;

	public Integer getHostname() {
		return hostname;
	}

	public void setHostname(Integer hostname) {
		this.hostname = hostname;
	}

	public Integer getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(Integer instanceName) {
		this.instanceName = instanceName;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}
}