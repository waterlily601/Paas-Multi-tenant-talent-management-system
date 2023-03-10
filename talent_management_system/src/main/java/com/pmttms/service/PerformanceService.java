package com.pmttms.service;

import com.pmttms.entity.Performance;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pmttms.form.CompanySearchForm;
import com.pmttms.form.SearchForm;
import com.pmttms.vo.PageVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2023-03-01
 */
public interface PerformanceService extends IService<Performance> {
    public PageVO list(Integer page, Integer size, Integer id);
    public PageVO search(CompanySearchForm companySearchForm);
}