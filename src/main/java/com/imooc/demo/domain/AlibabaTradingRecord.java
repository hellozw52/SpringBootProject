package com.imooc.demo.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AlibabaTradingRecord implements Serializable {
    private Integer id;

    private String userId;

    private String tradeNumber;

    private String outerTradeNumber;

    private Date createDate;

    private String tradeSource;

    private String tradeState;

    private String buyerId;

    private String buyerLoginNumber;

    private String buyerName;

    private String buyerNickname;

    private String sellerId;

    private String sellerLoginNumber;

    private String sellerName;

    private String sellerNickname;

    private String commodityName;

    private BigDecimal tradeTotalAmount;

    private String payMode;

    private String tradeCreateIp;

    private String tradePayIp;

    private String confirmReceiveIp;

    private Date buyerPayDate;

    private Date confirmPayDate;

    private String receiverName;

    private String receiverPhone;

    private String receiverFixedPhone;

    private String receiverAddress;

    private String caseNumber;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getTradeNumber() {
        return tradeNumber;
    }

    public void setTradeNumber(String tradeNumber) {
        this.tradeNumber = tradeNumber == null ? null : tradeNumber.trim();
    }

    public String getOuterTradeNumber() {
        return outerTradeNumber;
    }

    public void setOuterTradeNumber(String outerTradeNumber) {
        this.outerTradeNumber = outerTradeNumber == null ? null : outerTradeNumber.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getTradeSource() {
        return tradeSource;
    }

    public void setTradeSource(String tradeSource) {
        this.tradeSource = tradeSource == null ? null : tradeSource.trim();
    }

    public String getTradeState() {
        return tradeState;
    }

    public void setTradeState(String tradeState) {
        this.tradeState = tradeState == null ? null : tradeState.trim();
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId == null ? null : buyerId.trim();
    }

    public String getBuyerLoginNumber() {
        return buyerLoginNumber;
    }

    public void setBuyerLoginNumber(String buyerLoginNumber) {
        this.buyerLoginNumber = buyerLoginNumber == null ? null : buyerLoginNumber.trim();
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName == null ? null : buyerName.trim();
    }

    public String getBuyerNickname() {
        return buyerNickname;
    }

    public void setBuyerNickname(String buyerNickname) {
        this.buyerNickname = buyerNickname == null ? null : buyerNickname.trim();
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    public String getSellerLoginNumber() {
        return sellerLoginNumber;
    }

    public void setSellerLoginNumber(String sellerLoginNumber) {
        this.sellerLoginNumber = sellerLoginNumber == null ? null : sellerLoginNumber.trim();
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName == null ? null : sellerName.trim();
    }

    public String getSellerNickname() {
        return sellerNickname;
    }

    public void setSellerNickname(String sellerNickname) {
        this.sellerNickname = sellerNickname == null ? null : sellerNickname.trim();
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName == null ? null : commodityName.trim();
    }

    public BigDecimal getTradeTotalAmount() {
        return tradeTotalAmount;
    }

    public void setTradeTotalAmount(BigDecimal tradeTotalAmount) {
        this.tradeTotalAmount = tradeTotalAmount;
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode == null ? null : payMode.trim();
    }

    public String getTradeCreateIp() {
        return tradeCreateIp;
    }

    public void setTradeCreateIp(String tradeCreateIp) {
        this.tradeCreateIp = tradeCreateIp == null ? null : tradeCreateIp.trim();
    }

    public String getTradePayIp() {
        return tradePayIp;
    }

    public void setTradePayIp(String tradePayIp) {
        this.tradePayIp = tradePayIp == null ? null : tradePayIp.trim();
    }

    public String getConfirmReceiveIp() {
        return confirmReceiveIp;
    }

    public void setConfirmReceiveIp(String confirmReceiveIp) {
        this.confirmReceiveIp = confirmReceiveIp == null ? null : confirmReceiveIp.trim();
    }

    public Date getBuyerPayDate() {
        return buyerPayDate;
    }

    public void setBuyerPayDate(Date buyerPayDate) {
        this.buyerPayDate = buyerPayDate;
    }

    public Date getConfirmPayDate() {
        return confirmPayDate;
    }

    public void setConfirmPayDate(Date confirmPayDate) {
        this.confirmPayDate = confirmPayDate;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone == null ? null : receiverPhone.trim();
    }

    public String getReceiverFixedPhone() {
        return receiverFixedPhone;
    }

    public void setReceiverFixedPhone(String receiverFixedPhone) {
        this.receiverFixedPhone = receiverFixedPhone == null ? null : receiverFixedPhone.trim();
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress == null ? null : receiverAddress.trim();
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber == null ? null : caseNumber.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", tradeNumber=").append(tradeNumber);
        sb.append(", outerTradeNumber=").append(outerTradeNumber);
        sb.append(", createDate=").append(createDate);
        sb.append(", tradeSource=").append(tradeSource);
        sb.append(", tradeState=").append(tradeState);
        sb.append(", buyerId=").append(buyerId);
        sb.append(", buyerLoginNumber=").append(buyerLoginNumber);
        sb.append(", buyerName=").append(buyerName);
        sb.append(", buyerNickname=").append(buyerNickname);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", sellerLoginNumber=").append(sellerLoginNumber);
        sb.append(", sellerName=").append(sellerName);
        sb.append(", sellerNickname=").append(sellerNickname);
        sb.append(", commodityName=").append(commodityName);
        sb.append(", tradeTotalAmount=").append(tradeTotalAmount);
        sb.append(", payMode=").append(payMode);
        sb.append(", tradeCreateIp=").append(tradeCreateIp);
        sb.append(", tradePayIp=").append(tradePayIp);
        sb.append(", confirmReceiveIp=").append(confirmReceiveIp);
        sb.append(", buyerPayDate=").append(buyerPayDate);
        sb.append(", confirmPayDate=").append(confirmPayDate);
        sb.append(", receiverName=").append(receiverName);
        sb.append(", receiverPhone=").append(receiverPhone);
        sb.append(", receiverFixedPhone=").append(receiverFixedPhone);
        sb.append(", receiverAddress=").append(receiverAddress);
        sb.append(", caseNumber=").append(caseNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}