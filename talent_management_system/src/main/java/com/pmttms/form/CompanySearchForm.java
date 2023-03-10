package com.pmttms.form;

import lombok.Data;

@Data
public class CompanySearchForm {
    private String key;
    private String value;
    private Integer page;
    private Integer size;
    private Integer id;
}
