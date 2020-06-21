package com.tracker.coronaviruslivetracker.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class VirusDataRepo {
  private String stateData;
  private String activeAllCases;
  private String confirmedAllCases;
  private String deathsAllCases;
  private String coronaDataAPI;

  public String getCoronaDataAPI() {
    return coronaDataAPI;
  }

  public void setCoronaDataAPI(String coronaDataAPI) {
    this.coronaDataAPI = coronaDataAPI;
  }

  public String getStateData() {
    return stateData;
  }

  public void setStateData(String stateData) {
    this.stateData = stateData;
  }

  public String getActiveAllCases() {
    return activeAllCases;
  }

  public void setActiveAllCases(String string) {
    this.activeAllCases = string;
  }

  public String getConfirmedAllCases() {
    return confirmedAllCases;
  }

  public void setConfirmedAllCases(String confirmedAllCases) {
    this.confirmedAllCases = confirmedAllCases;
  }

  public String getDeathsAllCases() {
    return deathsAllCases;
  }

  public void setDeathsAllCases(String deathsAllCases) {
    this.deathsAllCases = deathsAllCases;
  }

  @Override
  public String toString() {
    return "VirusDataRepo [stateData=" + stateData + ", activeAllCases=" + activeAllCases
        + ", confirmedAllCases=" + confirmedAllCases + ", deathsAllCases=" + deathsAllCases + "]";
  }


}
