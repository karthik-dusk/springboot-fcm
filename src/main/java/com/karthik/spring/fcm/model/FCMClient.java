package com.karthik.spring.fcm.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FCMClient
{
  private String registrationTokens;
  private String firebaseApiUrl;
  private String firebaseServerKey;
  private String platform;
  private String data;
  private String instance;

  public List<String> getRegistrationTokens()
  {
    String[] tokens = this.registrationTokens.split(",");
    List<String> tokensList = new ArrayList<String>(Arrays.asList(tokens));
    return tokensList;
  }

  public String getFirebaseApiUrl()
  {
    return firebaseApiUrl;
  }

  public String getFirebaseServerKey()
  {
    return firebaseServerKey;
  }

  public String getPlatform()
  {
    return platform;
  }

  public String getData()
  {
    return data;
  }

  public String getInstance()
  {
    return instance;
  }
}
