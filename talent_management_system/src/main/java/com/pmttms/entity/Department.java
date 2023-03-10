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
 * @since 2023-03-01
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Department implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "departmentID", type = IdType.AUTO)
      private Integer departmentID;

    private String departmentname;

    private String telephone;

    @TableField("companyID")
    private Integer companyID;


}
