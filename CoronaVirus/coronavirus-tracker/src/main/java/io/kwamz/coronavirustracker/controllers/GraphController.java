package io.kwamz.coronavirustracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class GraphController {

    @GetMapping("/displayTimeSeries")
    public String timeSeries(Model model) {
        Map<String, Integer> confirmedCases =  new LinkedHashMap<>();
        confirmedCases.put("Test", 40);
        confirmedCases.put("Tester", 15);
        confirmedCases.put("Testing", 20);
        confirmedCases.put("Rona", 20);
        confirmedCases.put("Blah", 50);
        model.addAttribute("confirmedCases", confirmedCases);
        return "timeSeries";
    }


}
