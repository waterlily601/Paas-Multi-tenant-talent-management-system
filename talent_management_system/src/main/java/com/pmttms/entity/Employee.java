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
    public class Employee implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "employeeID", type = IdType.AUTO)
      private Integer employeeID;

    private String employeename;

    private String employeesex;

    @TableField("departmentID")
    private Integer departmentID;

    private String employeelevel;

    private String employeesalary;

    private String address;

    private String telephone;

    private String departmentname;

    @TableField("companyID")
    private Integer companyID;


}
