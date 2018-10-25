/**
 * PharmaTrace Supply Chain Information Network API
 * The PharmaTrace SCIN API provides network members a resource and process oriented access to the blockchain backed market and inventory information. It represents a layer of abstraction above the Hyperledger network to facilitate a business focused development of clients and integration systems without the need to directly connect to Hyperledger nodes.
 *
 * OpenAPI spec version: 0.0.1
 * Contact: api@pharmatrace.io
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package io.pharmatrace.api.scin.public;

import com.android.volley.Cache;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ResponseDelivery;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.HttpStack;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.NoCache;
import com.android.volley.toolbox.RequestFuture;
import com.google.gson.JsonParseException;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import io.pharmatrace.api.scin.public.auth.Authentication;
import io.pharmatrace.api.scin.public.auth.ApiKeyAuth;
import io.pharmatrace.api.scin.public.auth.HttpBasicAuth;
import io.pharmatrace.api.scin.public.request.GetRequest;
import io.pharmatrace.api.scin.public.request.PostRequest;
import io.pharmatrace.api.scin.public.request.PutRequest;
import io.pharmatrace.api.scin.public.request.DeleteRequest;
import io.pharmatrace.api.scin.public.request.PatchRequest;

public class ApiInvoker {
  private static ApiInvoker INSTANCE;
  private Map<String, String> defaultHeaderMap = new HashMap<String, String>();

  private RequestQueue mRequestQueue;

  private Map<String, Authentication> authentications;

  private int connectionTimeout;

  /** Content type "text/plain" with UTF-8 encoding. */
  public static final ContentType TEXT_PLAIN_UTF8 = ContentType.create("text/plain", Consts.UTF_8);

  /**
   * ISO 8601 date time format.
   * @see https://en.wikipedia.org/wiki/ISO_8601
   */
  public static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

  /**
   * ISO 8601 date format.
   * @see https://en.wikipedia.org/wiki/ISO_8601
   */
  public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

  static {
    // Use UTC as the default time zone.
    DATE_TIME_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
    DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
  }

  public static void setUserAgent(String userAgent) {
    INSTANCE.addDefaultHeader("User-Agent", userAgent);
  }

  public static Date parseDateTime(String str) {
    try {
      return DATE_TIME_FORMAT.parse(str);
    } catch (java.text.ParseException e) {
      throw new RuntimeException(e);
    }
  }

  public static Date parseDate(String str) {
    try {
      return DATE_FORMAT.parse(str);
    } catch (java.text.ParseException e) {
      throw new RuntimeException(e);
    }
  }

  public static String formatDateTime(Date datetime) {
    return DATE_TIME_FORMAT.format(datetime);
  }

  public static String formatDate(Date date) {
    return DATE_FORMAT.format(date);
  }

  public static String parameterToString(Object param) {
    if (param == null) {
      return "";
    } else if (param instanceof Date) {
      return formatDateTime((Date) param);
    } else if (param instanceof Collection) {
      StringBuilder b = new StringBuilder();
      for(Object o : (Collection)param) {
        if(b.length() > 0) {
          b.append(",");
        }
        b.append(String.valueOf(o));
      }
      return b.toString();
    } else {
      return String.valueOf(param);
    }
  }

  /*
    Format to {@code Pair} objects.
  */
  public static List<Pair> parameterToPairs(String collectionFormat, String name, Object value){
    List<Pair> params = new ArrayList<Pair>();

    // preconditions
    if (name == null || name.isEmpty() || value == null) return params;

    Collection valueCollection = null;
    if (value instanceof Collection) {
      valueCollection = (Collection) value;
    } else {
      params.add(new Pair(name, parameterToString(value)));
      return params;
    }

    if (valueCollection.isEmpty()){
      return params;
    }

    // get the collection format
    collectionFormat = (collectionFormat == null || collectionFormat.isEmpty() ? "csv" : collectionFormat); // default: csv

    // create the params based on the collection format
    if (collectionFormat.equals("multi")) {
      for (Object item : valueCollection) {
        params.add(new Pair(name, parameterToString(item)));
      }

      return params;
    }

    String delimiter = ",";

    if (collectionFormat.equals("csv")) {
      delimiter = ",";
    } else if (collectionFormat.equals("ssv")) {
      delimiter = " ";
    } else if (collectionFormat.equals("tsv")) {
      delimiter = "\t";
    } else if (collectionFormat.equals("pipes")) {
      delimiter = "|";
    }

    StringBuilder sb = new StringBuilder() ;
    for (Object item : valueCollection) {
      sb.append(delimiter);
      sb.append(parameterToString(item));
    }

    params.add(new Pair(name, sb.substring(1)));

    return params;
  }

  public static void initializeInstance() {
    initializeInstance(null);
  }

  public static void initializeInstance(Cache cache) {
    initializeInstance(cache, null, 0, null, 30);
  }

  public static void initializeInstance(Cache cache, Network network, int threadPoolSize, ResponseDelivery delivery, int connectionTimeout) {
    INSTANCE = new ApiInvoker(cache, network, threadPoolSize, delivery, connectionTimeout);
    setUserAgent("OpenAPI-Generator/0.0.1/android");

    // Setup authentications (key: authentication name, value: authentication).
    INSTANCE.authentications = new HashMap<String, Authentication>();
    INSTANCE.authentications.put("apikey", new ApiKeyAuth("query", "server_token"));
    // Prevent the authentications from being modified.
    INSTANCE.authentications = Collections.unmodifiableMap(INSTANCE.authentications);
  }

  private ApiInvoker(Cache cache, Network network, int threadPoolSize, ResponseDelivery delivery, int connectionTimeout) {
    if(cache == null) cache = new NoCache();
    if(network == null) {
       HttpStack stack = new HurlStack();
       network = new BasicNetwork(stack);
    }

    if(delivery == null) {
       initConnectionRequest(cache, network);
    } else {
       initConnectionRequest(cache, network, threadPoolSize, delivery);
    }
    this.connectionTimeout = connectionTimeout;
  }

  public static ApiInvoker getInstance() {
    if (INSTANCE == null) initializeInstance();
    return INSTANCE;
  }

  public void addDefaultHeader(String key, String value) {
    defaultHeaderMap.put(key, value);
  }

  public String escapeString(String str) {
    try {
      return URLEncoder.encode(str, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      return str;
    }
  }

  public static Object deserialize(String json, String containerType, Class cls) throws ApiException {
    try{
      if("list".equalsIgnoreCase(containerType) || "array".equalsIgnoreCase(containerType)) {
        return JsonUtil.deserializeToList(json, cls);
      }
      else if(String.class.equals(cls)) {
        if(json != null && json.startsWith("\"") && json.endsWith("\"") && json.length() > 1)
          return json.substring(1, json.length() - 1);
        else
          return json;
      }
      else {
        return JsonUtil.deserializeToObject(json, cls);
      }
    }
    catch (JsonParseException e) {
      throw new ApiException(500, e.getMessage());
    }
  }

  public static String serialize(Object obj) throws ApiException {
    try {
      if (obj != null)
        return JsonUtil.serialize(obj);
      else
        return null;
    }
    catch (Exception e) {
      throw new ApiException(500, e.getMessage());
    }
  }

  /**
   * Get authentications (key: authentication name, value: authentication).
   */
  public Map<String, Authentication> getAuthentications() {
    return authentications;
  }

  /**
   * Get authentication for the given name.
   *
   * @param authName The authentication name
   * @return The authentication, null if not found
   */
  public Authentication getAuthentication(String authName) {
    return authentications.get(authName);
  }

  /**
   * Helper method to set username for the first HTTP basic authentication.
   */
  public void setUsername(String username) {
    for (Authentication auth : authentications.values()) {
       if (auth instanceof HttpBasicAuth) {
           ((HttpBasicAuth) auth).setUsername(username);
           return;
       }
    }
    throw new RuntimeException("No HTTP basic authentication configured!");
  }

  /**
   * Helper method to set password for the first HTTP basic authentication.
   */
  public void setPassword(String password) {
    for (Authentication auth : authentications.values()) {
       if (auth instanceof HttpBasicAuth) {
          ((HttpBasicAuth) auth).setPassword(password);
          return;
       }
    }
    throw new RuntimeException("No HTTP basic authentication configured!");
  }

  /**
   * Helper method to set API key value for the first API key authentication.
   */
  public void setApiKey(String apiKey) {
    for (Authentication auth : authentications.values()) {
      if (auth instanceof ApiKeyAuth) {
        ((ApiKeyAuth) auth).setApiKey(apiKey);
        return;
      }
    }
    throw new RuntimeException("No API key authentication configured!");
  }

  /**
   * Helper method to set API key prefix for the first API key authentication.
   */
  public void setApiKeyPrefix(String apiKeyPrefix) {
    for (Authentication auth : authentications.values()) {
      if (auth instanceof ApiKeyAuth) {
        ((ApiKeyAuth) auth).setApiKeyPrefix(apiKeyPrefix);
        return;
      }
    }
    throw new RuntimeException("No API key authentication configured!");
  }

  public void setConnectionTimeout(int connectionTimeout){
    this.connectionTimeout = connectionTimeout;
  }

  public int getConnectionTimeout() {
    return connectionTimeout;
  }

  /**
   * Update query and header parameters based on authentication settings.
   *
   * @param authNames The authentications to apply
   */
  private void updateParamsForAuth(String[] authNames, List<Pair> queryParams, Map<String, String> headerParams) {
    for (String authName : authNames) {
      Authentication auth = authentications.get(authName);
      if (auth == null) throw new RuntimeException("Authentication undefined: " + authName);
        auth.applyToParams(queryParams, headerParams);
    }
  }

  public String invokeAPI(String host, String path, String method, List<Pair> queryParams, Object body, Map<String, String> headerParams, Map<String, String> formParams, String contentType, String[] authNames) throws ApiException, InterruptedException, ExecutionException, TimeoutException {
    try {
      RequestFuture<String> future = RequestFuture.newFuture();
      Request request = createRequest(host, path, method, queryParams, body, headerParams, formParams, contentType, authNames, future, future);
      if(request != null) {
         mRequestQueue.add(request);
         return future.get(connectionTimeout, TimeUnit.SECONDS);
      } else {
        return "no data";
      }
    } catch (UnsupportedEncodingException ex) {
      throw new ApiException(0, "UnsupportedEncodingException");
    }
  }

  public void invokeAPI(String host, String path, String method, List<Pair> queryParams, Object body, Map<String, String> headerParams, Map<String, String> formParams, String contentType, String[] authNames, Response.Listener<String> stringRequest, Response.ErrorListener errorListener) throws ApiException {
    try {
      Request request = createRequest(host, path, method, queryParams, body, headerParams, formParams, contentType, authNames, stringRequest, errorListener);
      if (request != null) {
        mRequestQueue.add(request);
      }
    } catch (UnsupportedEncodingException ex) {
      throw new ApiException(0, "UnsupportedEncodingException");
    }
  }

  public Request<String> createRequest(String host, String path, String method, List<Pair> queryParams, Object body, Map<String, String> headerParams, Map<String, String> formParams, String contentType, String[] authNames, Response.Listener<String> stringRequest, Response.ErrorListener errorListener) throws ApiException, UnsupportedEncodingException {
    StringBuilder b = new StringBuilder();
    b.append("?");

    updateParamsForAuth(authNames, queryParams, headerParams);

    if (queryParams != null){
      for (Pair queryParam : queryParams){
        if (!queryParam.getName().isEmpty()) {
          b.append(escapeString(queryParam.getName()));
          b.append("=");
          b.append(escapeString(queryParam.getValue()));
          b.append("&");
        }
      }
    }

    String querystring = b.substring(0, b.length() - 1);
    String url = host + path + querystring;

    HashMap<String, String> headers = new HashMap<String, String>();

    for(String key : headerParams.keySet()) {
      headers.put(key, headerParams.get(key));
    }

    for(String key : defaultHeaderMap.keySet()) {
      if(!headerParams.containsKey(key)) {
        headers.put(key, defaultHeaderMap.get(key));
      }
    }
    headers.put("Accept", "application/json");

    // URL encoded string from form parameters
    String formParamStr = null;

    // for form data
    if ("application/x-www-form-urlencoded".equals(contentType)) {
      StringBuilder formParamBuilder = new StringBuilder();

      // encode the form params
      for (String key : formParams.keySet()) {
        String value = formParams.get(key);
        if (value != null && !"".equals(value.trim())) {
          if (formParamBuilder.length() > 0) {
            formParamBuilder.append("&");
          }
          try {
            formParamBuilder.append(URLEncoder.encode(key, "utf8")).append("=").append(URLEncoder.encode(value, "utf8"));
          }
          catch (Exception e) {
            // move on to next
          }
        }
      }
      formParamStr = formParamBuilder.toString();
    }
    Request request = null;

    if ("GET".equals(method)) {
      request = new GetRequest(url, headers, null, stringRequest, errorListener);
    }
    else if ("POST".equals(method)) {
       request = null;
       if (formParamStr != null) {
          request = new PostRequest(url, headers, contentType, new StringEntity(formParamStr, "UTF-8"), stringRequest, errorListener);
       } else if (body != null) {
          if (body instanceof HttpEntity) {
          request = new PostRequest(url, headers, null, (HttpEntity) body, stringRequest, errorListener);
          } else {
             request = new PostRequest(url, headers, contentType, new StringEntity(serialize(body), "UTF-8"), stringRequest, errorListener);
          }
       } else {
         request = new PostRequest(url, headers, null, null, stringRequest, errorListener);
       }
    }
    else if ("PUT".equals(method)) {
       request = null;
       if (formParamStr != null) {
          request = new PutRequest(url, headers, contentType, new StringEntity(formParamStr, "UTF-8"), stringRequest, errorListener);
       } else if (body != null) {
          if (body instanceof HttpEntity) {
             request = new PutRequest(url, headers, null, (HttpEntity) body, stringRequest, errorListener);
          } else {
             request = new PutRequest(url, headers, contentType, new StringEntity(serialize(body), "UTF-8"), stringRequest, errorListener);
          }
       } else {
          request = new PutRequest(url, headers, null, null, stringRequest, errorListener);
       }
    }
    else if ("DELETE".equals(method)) {
       request = null;
          if (formParamStr != null) {
           request = new DeleteRequest(url, headers, contentType, new StringEntity(formParamStr, "UTF-8"), stringRequest, errorListener);
          } else if (body != null) {
          if (body instanceof HttpEntity) {
             request = new DeleteRequest(url, headers, null, (HttpEntity) body, stringRequest, errorListener);
          } else {
             request = new DeleteRequest(url, headers, contentType, new StringEntity(serialize(body), "UTF-8"), stringRequest, errorListener);
          }
       } else {
          request = new DeleteRequest(url, headers, null, null, stringRequest, errorListener);
       }
    }
    else if ("PATCH".equals(method)) {
       request = null;
          if (formParamStr != null) {
             request = new PatchRequest(url, headers, contentType, new StringEntity(formParamStr, "UTF-8"), stringRequest, errorListener);
          } else if (body != null) {
             if (body instanceof HttpEntity) {
                request = new PatchRequest(url, headers, null, (HttpEntity) body, stringRequest, errorListener);
             } else {
                request = new PatchRequest(url, headers, contentType, new StringEntity(serialize(body), "UTF-8"), stringRequest, errorListener);
             }
          } else {
             request = new PatchRequest(url, headers, null, null, stringRequest, errorListener);
          }
    }

    if (request != null) {
        request.setRetryPolicy(new DefaultRetryPolicy((int)TimeUnit.SECONDS.toMillis(this.connectionTimeout), DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }

    return request;
  }

  private void initConnectionRequest(Cache cache, Network network) {
    mRequestQueue = new RequestQueue(cache, network);
    mRequestQueue.start();
  }

  private void initConnectionRequest(Cache cache, Network network, int threadPoolSize, ResponseDelivery delivery) {
    mRequestQueue = new RequestQueue(cache, network, threadPoolSize, delivery);
    mRequestQueue.start();
  }

  public void stopQueue() {
    mRequestQueue.stop();
  }
}
