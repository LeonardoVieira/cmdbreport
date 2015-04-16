package br.com.inmetrics.model;

import java.util.List;

public class Cluster {

	private String name;

	private List<Type> types;

	public Cluster() {
		super();
	}

	public Cluster(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Type> getTypes() {
		return types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}
}