package br.com.inmetrics.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import br.com.inmetrics.dao.FilterDAO;
import br.com.inmetrics.model.Cluster;
import br.com.inmetrics.model.Datacenter;
import br.com.inmetrics.model.Filter;
import br.com.inmetrics.model.Response;
import br.com.inmetrics.model.Result;
import br.com.inmetrics.model.Type;
import br.com.inmetrics.model.ValueObject;

@Controller
public class FilterController {

	@Autowired
	private FilterDAO filterDao;

	private List<Response> responseList;

	public List<ValueObject> getDatacenter(Filter filter, String hostname) {
		filter.setHostname(StringUtils.isEmpty(hostname) ? "%" : hostname);
		return filterDao.getDatacenters(filter);
	}

	public List<ValueObject> getNetworks(Filter filter, String hostname) {
		filter.setHostname(StringUtils.isEmpty(hostname) ? "%" : hostname);
		return filterDao.getNetworks(filter);
	}

	public List<ValueObject> getServiceComponent(Filter filter, String hostname) {
		filter.setHostname(StringUtils.isEmpty(hostname) ? "%" : hostname);
		return filterDao.getServiceComponent(filter);
	}

	public List<ValueObject> getTechnicalService(Filter filter, String hostname) {
		filter.setHostname(StringUtils.isEmpty(hostname) ? "%" : hostname);
		return filterDao.getTechnicalService(filter);
	}

	public List<ValueObject> getBusinessService(Filter filter, String hostname) {
		filter.setHostname(StringUtils.isEmpty(hostname) ? "%" : hostname);
		return filterDao.getBusinessService(filter);
	}

	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	public ModelAndView makeFilter(@RequestParam(value = "businessService", required = false) String businessService,
			@RequestParam(value = "technicalService", required = false) String technicalService,
			@RequestParam(value = "serviceComponent", required = false) String serviceComponent,
			@RequestParam(value = "networdDistribution", required = false) String networdDistribution,
			@RequestParam(value = "datacenter", required = false) String datacenter,
			@RequestParam(value = "hostname", required = false) String hostname,
			@RequestParam(value = "show", required = false) Boolean show) {
		Filter filter = new Filter();

		filter.setBusinessService(StringUtils.isEmpty(businessService) ? "%" : businessService);
		filter.setTechnicalService(StringUtils.isEmpty(technicalService) ? "%" : technicalService);
		filter.setServiceComponent(StringUtils.isEmpty(serviceComponent) ? "%" : serviceComponent);
		filter.setNetwordDistribution(StringUtils.isEmpty(networdDistribution) ? "%" : networdDistribution);
		filter.setDatacenter(StringUtils.isEmpty(datacenter) ? "%" : datacenter);
		filter.setShow(show);

		ModelAndView modelAndView = new ModelAndView("filter", "command", filter);

		modelAndView.addObject("businessServiceList", getBusinessService(filter, hostname));
		modelAndView.addObject("technicalServiceList", getTechnicalService(filter, hostname));
		modelAndView.addObject("serviceComponentList", getServiceComponent(filter, hostname));
		modelAndView.addObject("datacenterList", getDatacenter(filter, hostname));
		modelAndView.addObject("networkList", getNetworks(filter, hostname));

		filter.setHostname("");

		return modelAndView;
	}

	@RequestMapping(value = "/exportCsv", method = RequestMethod.GET)
	public void teste(HttpServletRequest request, HttpServletResponse httpServletResponse) throws IOException {
		String csvFileName = "cmdb.csv";
		 
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", csvFileName);

        httpServletResponse.setContentType("text/csv");
        httpServletResponse.setHeader(headerKey, headerValue);
        
        ICsvBeanWriter csvWriter = new CsvBeanWriter(httpServletResponse.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);

        String[] header = {"type", "instanceName", "hostname", "datacenter", 
        		"serviceComponent", "technicalService", "businessService", "rede"};

        csvWriter.writeHeader(header);
        
        for(Response response : responseList) {
        	for(Result result : response.getResults()) {
        		csvWriter.write(result, header);
			}
        }

        csvWriter.close();
	}

	@RequestMapping(value = "/makeSearch", method = RequestMethod.POST)
	public String makeSearch(@ModelAttribute("SpringWeb") Filter filter, ModelMap model) {
		filter.setHostname(StringUtils.isEmpty(filter.getHostname()) ? "%" : filter.getHostname());
		filter.setBusinessService(StringUtils.isEmpty(filter.getBusinessService()) ? "%" : filter.getBusinessService());
		filter.setTechnicalService(StringUtils.isEmpty(filter.getTechnicalService()) ? "%" : filter.getTechnicalService());
		filter.setServiceComponent(StringUtils.isEmpty(filter.getServiceComponent()) ? "%" : filter.getServiceComponent());
		filter.setNetwordDistribution(StringUtils.isEmpty(filter.getNetwordDistribution()) ? "%" : filter.getNetwordDistribution());
		filter.setDatacenter(StringUtils.isEmpty(filter.getDatacenter()) ? "%" : filter.getDatacenter());

		List<Result> byFilters = filterDao.getByFilters(filter);
		Map<String, List<Result>> map = new LinkedHashMap<String, List<Result>>();
		Set<String> set = new HashSet<String>();
		Set<String> setInstanceName = new HashSet<String>();
		responseList = new ArrayList<Response>();

		for (Result result : byFilters) {
			String palavra = StringUtils.isEmpty(result.getType()) ? result.getServiceComponent() : result.getType(); 

			if (map.containsKey(palavra)) {
				map.get(palavra).add(result);
			} else {
				List<Result> list = new ArrayList<Result>();
				list.add(result);
				map.put(palavra, list);
			}

			set.add(result.getHostname());
			setInstanceName.add(result.getInstanceName());
		}

		Cluster cluster = new Cluster();
		cluster.setTypes(new ArrayList<Type>());

		for (Entry<String, List<Result>> entry : map.entrySet()) {
		    Response response = new Response();

		    response.setName(entry.getKey());
		    response.setQuantity(entry.getValue().size());

		    Set<String> hostnameSet = new HashSet<String>();
		    Set<String> instanceNameSet = new HashSet<String>();

		    Type type = new Type(entry.getKey());

		    Datacenter datacenterNorte = new Datacenter("Datacenter Norte");
		    Datacenter datacenterSul = new Datacenter("Datacenter Sul");
		    Datacenter datacenterPaulista = new Datacenter("Datacenter Paulista");
		    Datacenter datacenterCasaUm = new Datacenter("Datacenter Casa 1");
		    Datacenter datacenterExtendido = new Datacenter("Datacenter Extendido");
		    Datacenter noDatacenter = new Datacenter("Datacenter Não Encontrado");

		    for (Result result : entry.getValue()) {
				hostnameSet.add(result.getHostname());
				instanceNameSet.add(result.getInstanceName());

				if(StringUtils.isEmpty(result.getDatacenter())) {
					noDatacenter.getResults().add(result);
				} else if(result.getDatacenter().equalsIgnoreCase("dcn")) {
					datacenterNorte.getResults().add(result);
				} else if(result.getDatacenter().equalsIgnoreCase("dcs")) {
					datacenterSul.getResults().add(result);
				} else if(result.getDatacenter().equalsIgnoreCase("cs1")) {
					datacenterCasaUm.getResults().add(result);
				} else if(result.getDatacenter().equalsIgnoreCase("pta")) {
					datacenterPaulista.getResults().add(result);
				} else if(result.getDatacenter().equalsIgnoreCase("dce") || result.getDatacenter().equalsIgnoreCase("dcex")) {
					datacenterExtendido.getResults().add(result);
				}
			}

		    if(!noDatacenter.getResults().isEmpty()) {
		    	type.getDatacenters().add(noDatacenter);
		    }

		    if(!datacenterNorte.getResults().isEmpty()) {
		    	type.getDatacenters().add(datacenterNorte);
		    }

		    if(!datacenterSul.getResults().isEmpty()) {
		    	type.getDatacenters().add(datacenterSul);
		    }

		    if(!datacenterPaulista.getResults().isEmpty()) {
		    	type.getDatacenters().add(datacenterPaulista);
		    }

		    if(!datacenterCasaUm.getResults().isEmpty()) {
		    	type.getDatacenters().add(datacenterCasaUm);
		    }

		    if(!datacenterExtendido.getResults().isEmpty()) {
		    	type.getDatacenters().add(datacenterExtendido);
		    }

		    cluster.getTypes().add(type);

		    response.setHostname(hostnameSet.isEmpty() ? 0 : hostnameSet.size());
		    response.setInstanceName(instanceNameSet.isEmpty() ? 0 : instanceNameSet.size());
		    response.setResults(entry.getValue());

		    responseList.add(response);
		}

//		model.addAttribute("filterResult", byFilters);
		model.addAttribute("response", responseList);
		model.addAttribute("hostname", set.size());
		model.addAttribute("instanceName", setInstanceName.size());
		model.addAttribute("show", filter.getShow());

		return "result";
	}
}