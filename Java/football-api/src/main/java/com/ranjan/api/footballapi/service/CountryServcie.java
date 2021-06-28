package com.ranjan.api.footballapi.service;

import com.ranjan.api.footballapi.model.Country;
import com.ranjan.api.footballapi.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class CountryServcie {
    private static final Logger _LOGGER = LoggerFactory.getLogger(CountryServcie.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private JsonUtils jsonUtils;


    public void fetchAvailAbleCountries() {
        Set<Country> countries = new HashSet<>();
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("X-Auth-Token", "dae4c70b961f47c5b8c31437a851a744");
        String restResponse = getRestResponse("http://api.football-data.org/v2/competitions", headerMap);
        Map<String, Object> responseMap = jsonUtils.getMapFromJsonString(restResponse);
        if(responseMap!=null && !responseMap.isEmpty()) {
            List<Map<String, Object>> competitions = (List<Map<String, Object>>) responseMap.get("competitions");
            competitions.forEach(eachCompetition -> {
                Map<String, Object> areaMap = (Map<String, Object>) eachCompetition.get("area");
                countries.add(new Country(Long.valueOf(getValueFromMap(areaMap, "id")), getValueFromMap(areaMap, "name"), getValueFromMap(areaMap, "countryCode"), getValueFromMap(areaMap, "ensignUrl")));
            });
        }
    }

    private String getRestResponse(String url, Map<String, String> headerMap) {
        HttpHeaders headers = new HttpHeaders();
        headerMap.forEach((key, value) -> headers.add(key, value));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return restTemplate.getForObject(url, String.class);
    }

    private String getValueFromMap(Map<String, Object> map, String key) {
        String value = null;
        if(map!=null && !map.isEmpty() && map.containsKey(key)) {
            value = String.valueOf(map.get(key));
        }
        return value;
    }
}
