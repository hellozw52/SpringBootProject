package com.imooc.demo.domain;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 支付宝交易记录表
 * </p>
 *
 * @author hellozw
 * @since 2020-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "AlibabaTradingRecord对象", description = "支付宝交易记录表")
public class AlibabaTradingRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "交易号")
    private String tradeNumber;

    @ApiModelProperty(value = "外部交易号")
    private String outerTradeNumber;

    @ApiModelProperty(value = "创建日期")
    private Date createDate;

    @ApiModelProperty(value = "交易来源")
    private String tradeSource;

    @ApiModelProperty(value = "交易状态")
    private String tradeState;

    @ApiModelProperty(value = "买家ID")
    private String buyerId;

    @ApiModelProperty(value = "买家登录号")
    private String buyerLoginNumber;

    @ApiModelProperty(value = "买家姓名")
    private String buyerName;

    @ApiModelProperty(value = "买家昵称")
    private String buyerNickname;

    @ApiModelProperty(value = "卖家ID")
    private String sellerId;

    @ApiModelProperty(value = "卖家登录号")
    private String sellerLoginNumber;

    @ApiModelProperty(value = "卖家姓名")
    private String sellerName;

    @ApiModelProperty(value = "卖家昵称")
    private String sellerNickname;

    @ApiModelProperty(value = "交易商品名称")
    private String commodityName;

    @ApiModelProperty(value = "交易总金额(元)")
    private BigDecimal tradeTotalAmount;

    @ApiModelProperty(value = "支付方式")
    private String payMode;

    @ApiModelProperty(value = "交易创建IP")
    private String tradeCreateIp;

    @ApiModelProperty(value = "交易付款IP")
    private String tradePayIp;

    @ApiModelProperty(value = "确认收货IP")
    private String confirmReceiveIp;

    @ApiModelProperty(value = "买家付款日期")
    private Date buyerPayDate;

    @ApiModelProperty(value = "确认付款日期")
    private Date confirmPayDate;

    @ApiModelProperty(value = "收货人姓名")
    private String receiverName;

    @ApiModelProperty(value = "收货手机")
    private String receiverPhone;

    @ApiModelProperty(value = "收货固话")
    private String receiverFixedPhone;

    @ApiModelProperty(value = "收货地址")
    private String receiverAddress;

    @ApiModelProperty(value = "所属案件编号")
    private String caseNumber;


}
