package com.pmttms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2023-03-09
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Companyadmin implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "companyID", type = IdType.AUTO)
      private Integer companyID;

    private String companyname;

    private String username;

    private String password;

    private String state="待审批";

    private String legalperson;

    private String address;

    private String telephone;

    private String email;


}
