package br.com.inmetrics.dao;

import java.util.List;

import br.com.inmetrics.model.Filter;
import br.com.inmetrics.model.Result;
import br.com.inmetrics.model.ValueObject;

public interface FilterDAO {

	List<Result> getByFilters(Filter filter);

	List<ValueObject> getDatacenters(Filter filter);

	List<ValueObject> getNetworks(Filter filter);

	List<ValueObject> getTechnicalService(Filter filter);

	List<ValueObject> getBusinessService(Filter filter);

	List<ValueObject> getServiceComponent(Filter filter);

}
