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
    public class Manualregulationrecord implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "AdjustRecord_Number", type = IdType.AUTO)
      private Integer adjustrecordNumber;

    @TableField("Alarm_Number")
    private Integer alarmNumber;

    @TableField("Zone_Number")
    private Integer zoneNumber;

    @TableField("Equipment_Number")
    private Integer equipmentNumber;

    @TableField("Job_ID")
    private Integer jobId;

    @TableField("Exception_Parameters")
    private String exceptionParameters;

    @TableField("Regulation_Data")
    private LocalDate regulationData;

    @TableField("YesOrNo_Recover")
    private String yesornoRecover;

    @TableField("Notes")
    private String Notes;


}
