package com.pmttms.entity;

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
    public class Equipmentscraprecord implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "Equipment_Number", type = IdType.AUTO)
      private Integer equipmentNumber;

    @TableField("Equipment_Name")
    private String equipmentName;

    @TableField("Equipment_Model")
    private String equipmentModel;

    @TableField("SameType_Amount")
    private Integer sametypeAmount;

    @TableField("Manufacturer")
    private String Manufacturer;

    @TableField("Scrap_Date")
    private LocalDate scrapDate;

    @TableField("Scrap_Reason")
    private String scrapReason;

    @TableField("Job_ID")
    private Integer jobId;

    @TableField("Final_Destination")
    private String finalDestination;


}
