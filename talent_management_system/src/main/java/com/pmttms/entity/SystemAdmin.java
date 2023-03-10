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
 * @since 2023-03-01
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Systemadmin implements Serializable {

    private static final long serialVersionUID=1L;

    private String username;

    private String password;


}
