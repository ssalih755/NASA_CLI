package org.example.service;

import org.example.model.NeoFeedResponse;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.client.RestTemplate;

public class NASAService {
    // this class will send requests to the NASA api and get back responses
    private RestTemplate restTemplate = new RestTemplate();
    private String API_URL = "https://api.nasa.gov/neo/rest/v1/feed?";

    private final String API_KEY=System.getenv("NASA_KEY");

    // Request to get all NEOs for a specific group of days
    public NeoFeedResponse getAllNeos(String startDate, String endDate){
        String url = "";
        if (endDate == null || endDate.trim().isEmpty()){
            url = API_URL + "start_date=" + startDate +
                    "&api_key=" + API_KEY;
        } else {
            url = API_URL + "start_date=" + startDate +
                    "&end_date=" + endDate +
                    "&api_key=" + API_KEY;
        }

        return restTemplate.getForObject(url, NeoFeedResponse.class);

    }
}
