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
    public class Alarmrecord implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    @TableField("Alarm_Number")
    private Integer alarmNumber;

    @TableField("Zone_Number")
    private Integer zoneNumber;

    @TableField("Equipment_Number")
    private Integer equipmentNumber;

    @TableField("Exception_Parameters")
    private String exceptionParameters;

    @TableField("Alarm_Data")
    private LocalDate alarmData;

    @TableField("YesOrNo_AutomaticFailure")
    private String yesornoAutomaticfailure;

    @TableField("Start_Time")
    private String startTime;

    @TableField("EndTime")
    private String EndTime;

    @TableField("YesOrNo_Recover")
    private String yesornoRecover;

    @TableField("Notes")
    private String Notes;


}
