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
    public class Equipmentpurchaseapply implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("Equipment_Name")
    private String equipmentName;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    @TableField("ApplyForm_Number")
    private Integer applyformNumber;

    @TableField("Job_ID")
    private Integer jobId;

    @TableField("EquipmentPurchase_Reason")
    private String equipmentpurchaseReason;

    @TableField("SameType_Amount")
    private Integer sametypeAmount;

    @TableField("Apply_Date")
    private LocalDate applyDate;

    @TableField("Apply_Price")
    private BigDecimal applyPrice;

    @TableField("ApplySameTypeTotal_Price")
    private BigDecimal applysametypetotalPrice;

    private String status;


}
