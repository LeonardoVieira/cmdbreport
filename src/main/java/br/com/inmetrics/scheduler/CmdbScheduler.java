package br.com.inmetrics.scheduler;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.inmetrics.reader.CmdbReader;
import br.com.inmetrics.reader.HypervisorReader;

@Component
public class CmdbScheduler {

	@Autowired
	private CmdbReader cmdbReader;

	@Autowired
	private HypervisorReader hypervisorReader;

	@Scheduled(cron = "0 0 5 * * *")
	public void autoUpdate() throws FileNotFoundException {
		System.out.println("Rodou");
		cmdbReader.update();
	}

	@Scheduled(cron = "0 0 5 ? * TUE")
	public void autoUpdateHypervisor() throws FileNotFoundException {
		hypervisorReader.update();
	}
}