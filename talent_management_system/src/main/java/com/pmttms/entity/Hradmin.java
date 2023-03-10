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
    public class Hradmin implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "hrID", type = IdType.AUTO)
      private Integer hrID;

    private String hrname;

    private String username;

    private String password;

    @TableField("companyID")
    private Integer companyID;


}
