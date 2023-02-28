package com.pmttms.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2023-02-28
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class DepartmentInformation implements Serializable {

    private static final long serialVersionUID=1L;
  @TableId(type = IdType.AUTO)
    private int departmentid;

    private String departmentname;

    private String telephone;

    private String company;

}
