package br.com.inmetrics.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.inmetrics.reader.CmdbReader;
import br.com.inmetrics.reader.HypervisorReader;

@Controller
public class CmdbReaderController {

	@Autowired
	private CmdbReader cmdbReader;

	@Autowired
	private HypervisorReader hypervisorReader;

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void update() throws FileNotFoundException {
		cmdbReader.update();
	}

	@RequestMapping(value = "/updateHyper", method = RequestMethod.GET)
	public void hyper() throws FileNotFoundException {
		hypervisorReader.update();
	}
}