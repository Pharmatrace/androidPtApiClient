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

package io.pharmatrace.api.scin.public.model;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

/**
 * Global system message from PT node operators / Newsfeed
 **/
@ApiModel(description = "Global system message from PT node operators / Newsfeed")
public class SystemInformation {
  
  @SerializedName("uuid")
  private String uuid = null;
  @SerializedName("language")
  private String language = null;
  @SerializedName("header")
  private String header = null;
  @SerializedName("message")
  private String message = null;

  /**
   * Unique identifier for the system information.
   **/
  @ApiModelProperty(value = "Unique identifier for the system information.")
  public String getUuid() {
    return uuid;
  }
  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  /**
   * Iso Language code, e.g. en_us.
   **/
  @ApiModelProperty(value = "Iso Language code, e.g. en_us.")
  public String getLanguage() {
    return language;
  }
  public void setLanguage(String language) {
    this.language = language;
  }

  /**
   * Message header.
   **/
  @ApiModelProperty(value = "Message header.")
  public String getHeader() {
    return header;
  }
  public void setHeader(String header) {
    this.header = header;
  }

  /**
   * message body.
   **/
  @ApiModelProperty(value = "message body.")
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemInformation systemInformation = (SystemInformation) o;
    return (this.uuid == null ? systemInformation.uuid == null : this.uuid.equals(systemInformation.uuid)) &&
        (this.language == null ? systemInformation.language == null : this.language.equals(systemInformation.language)) &&
        (this.header == null ? systemInformation.header == null : this.header.equals(systemInformation.header)) &&
        (this.message == null ? systemInformation.message == null : this.message.equals(systemInformation.message));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.uuid == null ? 0: this.uuid.hashCode());
    result = 31 * result + (this.language == null ? 0: this.language.hashCode());
    result = 31 * result + (this.header == null ? 0: this.header.hashCode());
    result = 31 * result + (this.message == null ? 0: this.message.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInformation {\n");
    
    sb.append("  uuid: ").append(uuid).append("\n");
    sb.append("  language: ").append(language).append("\n");
    sb.append("  header: ").append(header).append("\n");
    sb.append("  message: ").append(message).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}