package com.petstore.models;

public class DatosRequest {

  private String url;
  private String path;
  private String payLoad;

  public DatosRequest() {
    /* TODO document why this constructor is empty */
  }

  public String getPayLoad() {
    return payLoad;
  }

  public void setPayLoad(String payLoad) {
    this.payLoad = payLoad;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
