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
 * @since 2023-02-24
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class CompanyAdmin implements Serializable {

    private static final long serialVersionUID=1L;

      private String username;

    private String password;

    private String companyName;

    private String state= "待审批";

  @TableId(type = IdType.AUTO)
  private Integer id;


}
