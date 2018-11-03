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

import io.pharmatrace.api.scin.public.model.Transaction;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class InformationQuery extends Transaction {
  
  @SerializedName("timestamp")
  private Long timestamp = null;
  @SerializedName("tx_uid")
  private String txUid = null;
  @SerializedName("terms_id")
  private String termsId = null;
  @SerializedName("transaction_channel")
  private String transactionChannel = null;

  /**
   * GMT, Unix Epoch
   **/
  @ApiModelProperty(value = "GMT, Unix Epoch")
  public Long getTimestamp() {
    return timestamp;
  }
  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  /**
   * unique id hash of the transaction
   **/
  @ApiModelProperty(value = "unique id hash of the transaction")
  public String getTxUid() {
    return txUid;
  }
  public void setTxUid(String txUid) {
    this.txUid = txUid;
  }

  /**
   * id reference to the terms and conditions for this transaction
   **/
  @ApiModelProperty(value = "id reference to the terms and conditions for this transaction")
  public String getTermsId() {
    return termsId;
  }
  public void setTermsId(String termsId) {
    this.termsId = termsId;
  }

  /**
   * hyperledger channel the transaction has been executed in
   **/
  @ApiModelProperty(value = "hyperledger channel the transaction has been executed in")
  public String getTransactionChannel() {
    return transactionChannel;
  }
  public void setTransactionChannel(String transactionChannel) {
    this.transactionChannel = transactionChannel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InformationQuery informationQuery = (InformationQuery) o;
    return (this.timestamp == null ? informationQuery.timestamp == null : this.timestamp.equals(informationQuery.timestamp)) &&
        (this.txUid == null ? informationQuery.txUid == null : this.txUid.equals(informationQuery.txUid)) &&
        (this.termsId == null ? informationQuery.termsId == null : this.termsId.equals(informationQuery.termsId)) &&
        (this.transactionChannel == null ? informationQuery.transactionChannel == null : this.transactionChannel.equals(informationQuery.transactionChannel));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.timestamp == null ? 0: this.timestamp.hashCode());
    result = 31 * result + (this.txUid == null ? 0: this.txUid.hashCode());
    result = 31 * result + (this.termsId == null ? 0: this.termsId.hashCode());
    result = 31 * result + (this.transactionChannel == null ? 0: this.transactionChannel.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class InformationQuery {\n");
    sb.append("  " + super.toString()).append("\n");
    sb.append("  timestamp: ").append(timestamp).append("\n");
    sb.append("  txUid: ").append(txUid).append("\n");
    sb.append("  termsId: ").append(termsId).append("\n");
    sb.append("  transactionChannel: ").append(transactionChannel).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
