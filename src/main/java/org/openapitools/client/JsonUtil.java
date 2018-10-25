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

package org.openapitools.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Date;
import org.openapitools.client.model.*;

public class JsonUtil {
  public static GsonBuilder gsonBuilder;

  static {
    gsonBuilder = new GsonBuilder();
    gsonBuilder.serializeNulls();
    gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    gsonBuilder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
      public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return new Date(json.getAsJsonPrimitive().getAsLong());
      }
    });
  }

  public static Gson getGson() {
    return gsonBuilder.create();
  }

  public static String serialize(Object obj){
    return getGson().toJson(obj);
  }

  public static <T> T deserializeToList(String jsonString, Class cls){
    return getGson().fromJson(jsonString, getListTypeForDeserialization(cls));
  }

  public static <T> T deserializeToObject(String jsonString, Class cls){
    return getGson().fromJson(jsonString, getTypeForDeserialization(cls));
  }

  public static Type getListTypeForDeserialization(Class cls) {
    String className = cls.getSimpleName();
    
    if ("Activities".equalsIgnoreCase(className)) {
      return new TypeToken<List<Activities>>(){}.getType();
    }
    
    if ("Activity".equalsIgnoreCase(className)) {
      return new TypeToken<List<Activity>>(){}.getType();
    }
    
    if ("Container".equalsIgnoreCase(className)) {
      return new TypeToken<List<Container>>(){}.getType();
    }
    
    if ("Containers".equalsIgnoreCase(className)) {
      return new TypeToken<List<Containers>>(){}.getType();
    }
    
    if ("Error".equalsIgnoreCase(className)) {
      return new TypeToken<List<Error>>(){}.getType();
    }
    
    if ("InformationQuery".equalsIgnoreCase(className)) {
      return new TypeToken<List<InformationQuery>>(){}.getType();
    }
    
    if ("InformationQueryResponse".equalsIgnoreCase(className)) {
      return new TypeToken<List<InformationQueryResponse>>(){}.getType();
    }
    
    if ("LegalTxTerms".equalsIgnoreCase(className)) {
      return new TypeToken<List<LegalTxTerms>>(){}.getType();
    }
    
    if ("Location".equalsIgnoreCase(className)) {
      return new TypeToken<List<Location>>(){}.getType();
    }
    
    if ("Locations".equalsIgnoreCase(className)) {
      return new TypeToken<List<Locations>>(){}.getType();
    }
    
    if ("Pharmaceutical".equalsIgnoreCase(className)) {
      return new TypeToken<List<Pharmaceutical>>(){}.getType();
    }
    
    if ("PharmaceuticalList".equalsIgnoreCase(className)) {
      return new TypeToken<List<PharmaceuticalList>>(){}.getType();
    }
    
    if ("Profile".equalsIgnoreCase(className)) {
      return new TypeToken<List<Profile>>(){}.getType();
    }
    
    if ("Repackage".equalsIgnoreCase(className)) {
      return new TypeToken<List<Repackage>>(){}.getType();
    }
    
    if ("Stakeholder".equalsIgnoreCase(className)) {
      return new TypeToken<List<Stakeholder>>(){}.getType();
    }
    
    if ("SystemInformation".equalsIgnoreCase(className)) {
      return new TypeToken<List<SystemInformation>>(){}.getType();
    }
    
    if ("SystemInformations".equalsIgnoreCase(className)) {
      return new TypeToken<List<SystemInformations>>(){}.getType();
    }
    
    if ("Trade".equalsIgnoreCase(className)) {
      return new TypeToken<List<Trade>>(){}.getType();
    }
    
    if ("Transaction".equalsIgnoreCase(className)) {
      return new TypeToken<List<Transaction>>(){}.getType();
    }
    
    if ("Transport".equalsIgnoreCase(className)) {
      return new TypeToken<List<Transport>>(){}.getType();
    }
    
    if ("Wallet".equalsIgnoreCase(className)) {
      return new TypeToken<List<Wallet>>(){}.getType();
    }
    
    return new TypeToken<List<Object>>(){}.getType();
  }

  public static Type getTypeForDeserialization(Class cls) {
    String className = cls.getSimpleName();
    
    if ("Activities".equalsIgnoreCase(className)) {
      return new TypeToken<Activities>(){}.getType();
    }
    
    if ("Activity".equalsIgnoreCase(className)) {
      return new TypeToken<Activity>(){}.getType();
    }
    
    if ("Container".equalsIgnoreCase(className)) {
      return new TypeToken<Container>(){}.getType();
    }
    
    if ("Containers".equalsIgnoreCase(className)) {
      return new TypeToken<Containers>(){}.getType();
    }
    
    if ("Error".equalsIgnoreCase(className)) {
      return new TypeToken<Error>(){}.getType();
    }
    
    if ("InformationQuery".equalsIgnoreCase(className)) {
      return new TypeToken<InformationQuery>(){}.getType();
    }
    
    if ("InformationQueryResponse".equalsIgnoreCase(className)) {
      return new TypeToken<InformationQueryResponse>(){}.getType();
    }
    
    if ("LegalTxTerms".equalsIgnoreCase(className)) {
      return new TypeToken<LegalTxTerms>(){}.getType();
    }
    
    if ("Location".equalsIgnoreCase(className)) {
      return new TypeToken<Location>(){}.getType();
    }
    
    if ("Locations".equalsIgnoreCase(className)) {
      return new TypeToken<Locations>(){}.getType();
    }
    
    if ("Pharmaceutical".equalsIgnoreCase(className)) {
      return new TypeToken<Pharmaceutical>(){}.getType();
    }
    
    if ("PharmaceuticalList".equalsIgnoreCase(className)) {
      return new TypeToken<PharmaceuticalList>(){}.getType();
    }
    
    if ("Profile".equalsIgnoreCase(className)) {
      return new TypeToken<Profile>(){}.getType();
    }
    
    if ("Repackage".equalsIgnoreCase(className)) {
      return new TypeToken<Repackage>(){}.getType();
    }
    
    if ("Stakeholder".equalsIgnoreCase(className)) {
      return new TypeToken<Stakeholder>(){}.getType();
    }
    
    if ("SystemInformation".equalsIgnoreCase(className)) {
      return new TypeToken<SystemInformation>(){}.getType();
    }
    
    if ("SystemInformations".equalsIgnoreCase(className)) {
      return new TypeToken<SystemInformations>(){}.getType();
    }
    
    if ("Trade".equalsIgnoreCase(className)) {
      return new TypeToken<Trade>(){}.getType();
    }
    
    if ("Transaction".equalsIgnoreCase(className)) {
      return new TypeToken<Transaction>(){}.getType();
    }
    
    if ("Transport".equalsIgnoreCase(className)) {
      return new TypeToken<Transport>(){}.getType();
    }
    
    if ("Wallet".equalsIgnoreCase(className)) {
      return new TypeToken<Wallet>(){}.getType();
    }
    
    return new TypeToken<Object>(){}.getType();
  }

};
