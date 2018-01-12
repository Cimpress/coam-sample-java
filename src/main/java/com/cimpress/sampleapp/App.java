package com.cimpress.sampleapp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Sample application
 *
 */
public class App
{
  public static final String PRINCIPAL="adfs|jdaviscooke@cimpress.com";
  public static final String RESOURCE_TYPE="merchants";
  public static final String RESOURCE_IDENTIFIER="vistaprint";

  public static void main( String[] args ) throws Exception {
    Properties prop = new Properties();
	  InputStream input = null;

    String clientId = null;
    String clientSecret = null;

    try {
      input = new FileInputStream("config.properties");
      prop.load(input);

      clientId = prop.getProperty("CLIENT_ID");
      clientSecret = prop.getProperty("CLIENT_SECRET");

    } catch (IOException ex) {
      ex.printStackTrace();
    } finally {
      if (input != null) {
        try {
				  input.close();
  			} catch (IOException e) {
  				e.printStackTrace();
  			}
      }
    }

    System.out.println("Retrieving access token for client ID " + clientId);

    HttpResponse<JsonNode> tokenResp = Unirest.post("https://cimpress.auth0.com/oauth/token")
      .header("content-type", "application/json")
      .body("{\"client_id\": \"" + clientId + "\", \"client_secret\": \"" + clientSecret + "\", \"audience\": \"https://api.cimpress.io/\", \"grant_type\": \"client_credentials\"}")
      .asJson();

    String accessToken = tokenResp.getBody().getObject().getString("access_token");

    System.out.println("Access token: " + accessToken + "\n");

    System.out.println("Retrieving COAM permissions for " + PRINCIPAL + " on "+ RESOURCE_TYPE + " " + RESOURCE_IDENTIFIER);

    HttpResponse<JsonNode> coamResp = Unirest.get("https://api.cimpress.io/auth/access-management/v1/principals/" + PRINCIPAL + "/permissions/" + RESOURCE_TYPE + "/" + RESOURCE_IDENTIFIER)
      .header("authorization", "Bearer " + accessToken)
      .asJson();

    System.out.println("===== RESPONSE =====");
    System.out.println(coamResp.getBody().getObject().toString(2));
  }
}
