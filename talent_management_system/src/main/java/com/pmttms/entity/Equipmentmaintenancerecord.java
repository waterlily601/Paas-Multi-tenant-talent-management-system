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
    public class Equipmentmaintenancerecord implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    @TableField("Equipment_Number")
    private Integer equipmentNumber;

    @TableField("Equipment_Name")
    private String equipmentName;

    @TableField("Equipment_Status")
    private String equipmentStatus;

    @TableField("Equipment_Model")
    private String equipmentModel;

    @TableField("SameType_Amount")
    private Integer sametypeAmount;

    @TableField("Manufacturer")
    private String Manufacturer;

    @TableField("Damage_Position")
    private String damagePosition;

    @TableField("Damage_Date")
    private LocalDate damageDate;

    @TableField("Job_ID")
    private Integer jobId;

    @TableField("Maintenance_Date")
    private LocalDate maintenanceDate;

    @TableField("Maintenance_Way")
    private String maintenanceWay;

    @TableField("MaintenanceCompletion_Date")
    private LocalDate maintenancecompletionDate;

    @TableField("Reason")
    private String Reason;

    private Integer inid;


}
