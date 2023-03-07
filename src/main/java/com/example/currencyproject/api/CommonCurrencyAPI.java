package com.example.currencyproject.api;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CommonCurrencyAPI {

    public String timeframe(String source, String... currencies) throws IOException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();

        String link = "https://api.apilayer.com/currency_data/timeframe?start_date=" + dtf.format(now.minusDays(2)) +
                "&end_date=" + dtf.format(now) +
                "&currencies=" + Arrays.stream(currencies).collect(Collectors.joining(",")) +
                "&source=" + source;
        System.out.println(link);

        return ApiPatterns.allQueries(link).body().string();
    }

    public String fullListOfCurrencies() throws IOException {
        String link = "https://api.apilayer.com/currency_data/list";

        return ApiPatterns.allQueries(link).body().string();
    }



}
