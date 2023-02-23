package com.pmttms.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2023-02-23
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Equipmentpurchaserecord implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "Equipment_Number", type = IdType.AUTO)
      private Integer equipmentNumber;

    @TableField("ApplyForm_Number")
    private Integer applyformNumber;

    @TableField("Equipment_Name")
    private String equipmentName;

    @TableField("Equipment_Model")
    private String equipmentModel;

    @TableField("SameType_Amount")
    private Integer sametypeAmount;

    @TableField("Manufacturer")
    private String Manufacturer;

    @TableField("Job_ID")
    private Integer jobId;

    @TableField("Purchase_Date")
    private LocalDate purchaseDate;

    @TableField("Price")
    private BigDecimal Price;

    @TableField("SameTypeTotalPrice")
    private BigDecimal SameTypeTotalPrice;

    @TableField("Install_Date")
    private LocalDate installDate;

    @TableField("Zone_Number")
    private Integer zoneNumber;

    @TableField("Pig_gery")
    private String pigGery;


}
