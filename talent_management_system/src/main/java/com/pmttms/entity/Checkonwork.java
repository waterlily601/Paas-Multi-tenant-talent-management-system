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
 * @since 2023-03-08
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Checkonwork implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("employeeID")
    private Integer employeeID;

    private String month;

    private Integer fullday;

    private Integer abscentday;

    private Integer dayoff;

      @TableId(value = "checkID", type = IdType.AUTO)
      private Integer checkID;

    @TableField("companyID")
    private Integer companyID;


}
