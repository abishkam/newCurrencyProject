package com.example.currencyproject.controller;

import com.example.currencyproject.api.CommonCurrencyAPI;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Set;

@Controller
public class ApiController {

    @GetMapping("/curr")
    public String currencyPage(ModelMap map) throws IOException, ParseException {

        CommonCurrencyAPI api = new CommonCurrencyAPI();

        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(api.fullListOfCurrencies());
        obj = (JSONObject) obj.get("currencies");
        Set<String> a = obj.keySet();
        map.addAttribute("allRoles", a);

        return "currency";
    }

    @PostMapping("/currencyList")
    public String currencyList(@ModelAttribute("first_curr") String confirm1,
                               @RequestParam("second_curr") String[] confirm2,
                               ModelMap model) throws IOException {
        CommonCurrencyAPI api = new CommonCurrencyAPI();
        System.out.println(api.timeframe(confirm1, confirm2));
        model.addAttribute("poser", api.timeframe(confirm1, confirm2));
        return "currencyList";
    }
}
