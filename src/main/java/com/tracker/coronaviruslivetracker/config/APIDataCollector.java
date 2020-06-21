// package com.tracker.coronaviruslivetracker.config;
//
// import java.io.BufferedReader;
// import java.io.FileNotFoundException;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.net.URL;
// import java.net.URLConnection;
// import java.security.KeyManagementException;
// import java.security.NoSuchAlgorithmException;
// import java.security.cert.X509Certificate;
// import javax.net.ssl.HttpsURLConnection;
// import javax.net.ssl.SSLContext;
// import javax.net.ssl.TrustManager;
// import javax.net.ssl.X509TrustManager;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.stereotype.Component;
// import com.tracker.coronaviruslivetracker.response.VirusDataRepo;
//
// @Configuration
// @Component
// public class APIDataCollector {
//
//
// public String CoronaData() {
// VirusDataRepo virusDataRepo = new VirusDataRepo();
// StringBuilder sb = new StringBuilder();
// try {
// turnOffSslChecking();
// } catch (KeyManagementException | NoSuchAlgorithmException e) {
// e.printStackTrace();
// }
// String apiUrl = null;
// try {
//
// apiUrl = "https://api.covid19india.org/data.json";
//
// URL url = new URL(apiUrl); // URL to Parse
// URLConnection urlConnection = url.openConnection();
// BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
// String inputLine;
// while ((inputLine = in.readLine()) != null) {
// sb.append(inputLine);
// }
// } catch (FileNotFoundException e1) {
// e1.printStackTrace();
// } catch (IOException e11) {
// e11.printStackTrace();
// }
// System.out.println(sb.toString());
//
// return sb.toString();
// }
//
// private static final TrustManager[] UNQUESTIONING_TRUST_MANAGER =
// new TrustManager[] {new X509TrustManager() {
// public java.security.cert.X509Certificate[] getAcceptedIssuers() {
// return null;
// }
//
// public void checkClientTrusted(X509Certificate[] certs, String authType) {}
//
// public void checkServerTrusted(X509Certificate[] certs, String authType) {}
// }};
//
// public void turnOffSslChecking() throws NoSuchAlgorithmException, KeyManagementException {
// // Install the all-trusting trust manager
// final SSLContext sc = SSLContext.getInstance("SSL");
// sc.init(null, UNQUESTIONING_TRUST_MANAGER, null);
// HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
// }
//
// public void turnOnSslChecking() throws KeyManagementException, NoSuchAlgorithmException {
// // Return it to the initial state (discovered by reflection, now hardcoded)
// SSLContext.getInstance("SSL").init(null, null, null);
// }
//
//
// }
