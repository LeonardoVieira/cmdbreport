package br.com.inmetrics.model;

import java.util.ArrayList;
import java.util.List;

public class Datacenter {

	private String name;

	private List<Result> results = new ArrayList<Result>();

	public Datacenter() {
		super();
	}

	public Datacenter(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}
}