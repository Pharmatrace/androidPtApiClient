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

package org.openapitools.client.model;

import java.util.*;
import org.openapitools.client.model.Pharmaceutical;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class PharmaceuticalList {
  
  @SerializedName("products")
  private List<Pharmaceutical> products = null;

  /**
   * Contains the list of products
   **/
  @ApiModelProperty(value = "Contains the list of products")
  public List<Pharmaceutical> getProducts() {
    return products;
  }
  public void setProducts(List<Pharmaceutical> products) {
    this.products = products;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PharmaceuticalList pharmaceuticalList = (PharmaceuticalList) o;
    return (this.products == null ? pharmaceuticalList.products == null : this.products.equals(pharmaceuticalList.products));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.products == null ? 0: this.products.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class PharmaceuticalList {\n");
    
    sb.append("  products: ").append(products).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
