package com.imooc.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 账户信息表
 * </p>
 *
 * @author hellozw
 * @since 2020-05-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "ZdPerson对象", description = "账户信息表")
public class ZdPerson implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "账单人员姓名")
    private String name;

    @ApiModelProperty(value = "本方账户")
    private String bfAccount;

    @ApiModelProperty(value = "账单所属案件编号")
    private String caseNum;

    @ApiModelProperty(value = "0未删除,1删除")
    private String deleteFlag;


}
