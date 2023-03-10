package com.pmttms.service;

import com.pmttms.entity.Checkonwork;
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
public interface CheckonworkService extends IService<Checkonwork> {
    public PageVO list(Integer page, Integer size, Integer id);
    public PageVO search(CompanySearchForm companySearchForm);
}
