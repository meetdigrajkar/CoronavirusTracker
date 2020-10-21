package io.digrajkarmeetprojects.coronavirustrackingapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.digrajkarmeetprojects.coronavirustrackingapp.CoronaVirusDataService;
import io.digrajkarmeetprojects.coronavirustrackingapp.models.LocationsStats;


@Controller
public class HomeController {
	
	@Autowired
	CoronaVirusDataService coronavirusdataservice;
	
	@GetMapping("/home")
    public String home(Model model) {
		List<LocationsStats> allStats = coronavirusdataservice.getAllStats();
		int totalCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
		int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
		
		model.addAttribute("locationStats", allStats);
		model.addAttribute("totalReportedCases", totalCases);
		model.addAttribute("totalNewCases", totalNewCases);
		
		return "home";
    }
}
