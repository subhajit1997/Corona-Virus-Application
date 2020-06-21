package com.tracker.coronaviruslivetracker.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.tracker.coronaviruslivetracker.response.VirusDataRepo;

@Service
public class CoronaVirusDataService {

  private List<VirusDataRepo> allStateIndia = new ArrayList<>();

  public List<VirusDataRepo> getAllState() {
    return allStateIndia;
  }

  @PostConstruct
  @Scheduled(cron = "* * 1 * * *")
  public void CoronaTrack() {
    List<VirusDataRepo> newState = new ArrayList<>();

    try {
      turnOffSslChecking();
    } catch (KeyManagementException | NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    try {
      URL url = new URL("https://api.covid19india.org/data.json"); // URL to Parse
      URLConnection urlConnection = url.openConnection();
      BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
      StringBuilder sb = new StringBuilder();
      String inputLine;
      while ((inputLine = in.readLine()) != null) {
        sb.append(inputLine);
      }
      System.out.println(sb);
      JSONParser parser1 = new JSONParser();
      JSONObject json = (JSONObject) parser1.parse(sb.toString());
      JSONArray lineItem = (JSONArray) json.get("statewise");
      int totalStateCount = lineItem.size();

      JSONObject stateJson;
      for (int i = 0; i < totalStateCount; i++) {
        VirusDataRepo virusDataRepo = new VirusDataRepo();

        stateJson = (JSONObject) lineItem.get(i);
        virusDataRepo.setStateData(stateJson.get("state").toString());
        virusDataRepo.setActiveAllCases(stateJson.get("active").toString());
        virusDataRepo.setConfirmedAllCases(stateJson.get("confirmed").toString());
        virusDataRepo.setDeathsAllCases(stateJson.get("deaths").toString());
        newState.add(virusDataRepo);
      }
      this.allStateIndia = newState;

    } catch (Exception e1) {
      e1.printStackTrace();
    }
  }



  private static final TrustManager[] UNQUESTIONING_TRUST_MANAGER =
      new TrustManager[] {new X509TrustManager() {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
          return null;
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {}

        public void checkServerTrusted(X509Certificate[] certs, String authType) {}
      }};

  public void turnOffSslChecking() throws NoSuchAlgorithmException, KeyManagementException {
    final SSLContext sc = SSLContext.getInstance("SSL");
    sc.init(null, UNQUESTIONING_TRUST_MANAGER, null);
    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
  }

  public void turnOnSslChecking() throws KeyManagementException, NoSuchAlgorithmException {
    SSLContext.getInstance("SSL").init(null, null, null);
  }


}
