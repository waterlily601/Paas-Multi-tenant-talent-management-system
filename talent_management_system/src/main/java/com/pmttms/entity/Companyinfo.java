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
 * @since 2023-03-01
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Companyinfo implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "companyID", type = IdType.AUTO)
      private Integer companyID;

    private String companyname;

    private String legalperson;

    private String address;

    private String telephone;

    private String email;


}
