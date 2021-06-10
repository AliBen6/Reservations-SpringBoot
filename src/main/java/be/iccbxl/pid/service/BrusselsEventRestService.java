package be.iccbxl.pid.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@Service
public class BrusselsEventRestService {


    public String consume() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer 1830f45e-f6a6-3b57-8d5a-d59ec174261a");

        HttpEntity<String> entity = new HttpEntity<>("page", headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("https://api.brussels:443/api/agenda/0.0.1/events/{id}", HttpMethod.GET, entity, String.class,"1");

        String response = responseEntity.getBody();
        return response;
    }
}
