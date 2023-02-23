package com.pmttms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
    public class Equipmentbaseinfo implements Serializable {

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

    @TableField("Install_Date")
    private String installDate;

    @TableField("Zone_Number")
    private Integer zoneNumber;

    @TableField("Pig_gery")
    private String pigGery;


}
