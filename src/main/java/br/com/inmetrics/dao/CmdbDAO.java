package br.com.inmetrics.dao;

import java.util.List;

import br.com.inmetrics.model.CmdbTypeBr;

public interface CmdbDAO {
	
	void deleteAll();

	void update(List<CmdbTypeBr> cmdbTypeBrs);
}