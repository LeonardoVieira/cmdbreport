package br.com.inmetrics.model;

import java.util.ArrayList;
import java.util.List;

public class Type {

	private String name;

	private List<Datacenter> datacenters = new ArrayList<Datacenter>();

	public Type() {
		super();
	}

	public Type(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Datacenter> getDatacenters() {
		return datacenters;
	}

	public void setDatacenters(List<Datacenter> datacenters) {
		this.datacenters = datacenters;
	}
}