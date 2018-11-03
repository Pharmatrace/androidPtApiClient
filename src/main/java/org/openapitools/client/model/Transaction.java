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

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class Transaction {
  
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
    Transaction transaction = (Transaction) o;
    return (this.timestamp == null ? transaction.timestamp == null : this.timestamp.equals(transaction.timestamp)) &&
        (this.txUid == null ? transaction.txUid == null : this.txUid.equals(transaction.txUid)) &&
        (this.termsId == null ? transaction.termsId == null : this.termsId.equals(transaction.termsId)) &&
        (this.transactionChannel == null ? transaction.transactionChannel == null : this.transactionChannel.equals(transaction.transactionChannel));
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
    sb.append("class Transaction {\n");
    
    sb.append("  timestamp: ").append(timestamp).append("\n");
    sb.append("  txUid: ").append(txUid).append("\n");
    sb.append("  termsId: ").append(termsId).append("\n");
    sb.append("  transactionChannel: ").append(transactionChannel).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}