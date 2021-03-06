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

@ApiModel(description = "")
public class Stakeholder {
  
  @SerializedName("trade_id")
  private String tradeId = null;
  @SerializedName("trade_id_type")
  private String tradeIdType = null;
  @SerializedName("display_name")
  private String displayName = null;
  @SerializedName("stakeholder_role")
  private String stakeholderRole = null;
  @SerializedName("wallet_id")
  private String walletId = null;

  /**
   * unique official register entry, e.g. Handelsregistereintrag, court number, ...
   **/
  @ApiModelProperty(value = "unique official register entry, e.g. Handelsregistereintrag, court number, ...")
  public String getTradeId() {
    return tradeId;
  }
  public void setTradeId(String tradeId) {
    this.tradeId = tradeId;
  }

  /**
   * type of the official register that has issued the trade id
   **/
  @ApiModelProperty(value = "type of the official register that has issued the trade id")
  public String getTradeIdType() {
    return tradeIdType;
  }
  public void setTradeIdType(String tradeIdType) {
    this.tradeIdType = tradeIdType;
  }

  /**
   * display name visible to other network members
   **/
  @ApiModelProperty(value = "display name visible to other network members")
  public String getDisplayName() {
    return displayName;
  }
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  /**
   * one of Manufacturer, Distributor, Pharmacy, Regulator, Hospital, MedicalPractice, CareProvider, DisposalFirm, Insurance, Patient, LawEnforcement
   **/
  @ApiModelProperty(value = "one of Manufacturer, Distributor, Pharmacy, Regulator, Hospital, MedicalPractice, CareProvider, DisposalFirm, Insurance, Patient, LawEnforcement")
  public String getStakeholderRole() {
    return stakeholderRole;
  }
  public void setStakeholderRole(String stakeholderRole) {
    this.stakeholderRole = stakeholderRole;
  }

  /**
   * id of the main wallet, which the stakeholder uses for PT token transactions with other stakeholders
   **/
  @ApiModelProperty(value = "id of the main wallet, which the stakeholder uses for PT token transactions with other stakeholders")
  public String getWalletId() {
    return walletId;
  }
  public void setWalletId(String walletId) {
    this.walletId = walletId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Stakeholder stakeholder = (Stakeholder) o;
    return (this.tradeId == null ? stakeholder.tradeId == null : this.tradeId.equals(stakeholder.tradeId)) &&
        (this.tradeIdType == null ? stakeholder.tradeIdType == null : this.tradeIdType.equals(stakeholder.tradeIdType)) &&
        (this.displayName == null ? stakeholder.displayName == null : this.displayName.equals(stakeholder.displayName)) &&
        (this.stakeholderRole == null ? stakeholder.stakeholderRole == null : this.stakeholderRole.equals(stakeholder.stakeholderRole)) &&
        (this.walletId == null ? stakeholder.walletId == null : this.walletId.equals(stakeholder.walletId));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.tradeId == null ? 0: this.tradeId.hashCode());
    result = 31 * result + (this.tradeIdType == null ? 0: this.tradeIdType.hashCode());
    result = 31 * result + (this.displayName == null ? 0: this.displayName.hashCode());
    result = 31 * result + (this.stakeholderRole == null ? 0: this.stakeholderRole.hashCode());
    result = 31 * result + (this.walletId == null ? 0: this.walletId.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Stakeholder {\n");
    
    sb.append("  tradeId: ").append(tradeId).append("\n");
    sb.append("  tradeIdType: ").append(tradeIdType).append("\n");
    sb.append("  displayName: ").append(displayName).append("\n");
    sb.append("  stakeholderRole: ").append(stakeholderRole).append("\n");
    sb.append("  walletId: ").append(walletId).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
