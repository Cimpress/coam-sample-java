package com.cimpress.sampleapp;

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
  public static void main( String[] args ) throws UnirestException {
    HttpResponse<JsonNode> stack= Unirest.get("https://api.stackexchange.com/2.2/questions").
      header("accept",  "application/json").
      queryString("order","desc").
      queryString("sort", "creation").
      queryString("filter", "default").
      queryString("site", "stackoverflow").
      asJson();

    System.out.println(stack.getBody().getObject().toString(2));
  }
}
