package io.kwamz.coronavirustracker.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.kwamz.coronavirustracker.models.LocationStats;
import io.kwamz.coronavirustracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/")
    public String home(Model model) throws JsonProcessingException {
        List<LocationStats> allStats = coronaVirusDataService.getAllStats();
        List<String> allSeries = coronaVirusDataService.getTimeToSeries();
        int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalNewCases", totalNewCases);
        //model.addAttribute("confirmedCases", confirmedCases);
        //model.addAttribute("timeSeries", allSeries);
        model.addAttribute("timeSeries", "[{\"state\":3, \"country\":6, \"latestTotalCases\":38129, \"confirmedCases\":0}]");
        return "home";
    }
}
