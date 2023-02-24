package com.pmttms.entity;

import java.io.Serializable;
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
    public class SystemAdmin implements Serializable {

    private static final long serialVersionUID=1L;

      private String username;

    private String password;


}
