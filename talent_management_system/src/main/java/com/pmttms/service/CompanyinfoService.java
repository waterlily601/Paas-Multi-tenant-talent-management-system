package com.pmttms.service;

import com.pmttms.entity.Companyadmin;
import com.pmttms.entity.Companyinfo;
import com.baomidou.mybatisplus.extension.service.IService;
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
public interface CompanyinfoService extends IService<Companyinfo> {
    public Boolean saveInfo(Companyinfo companyInfo);
    public PageVO list(Integer page, Integer size);
    public PageVO search(SearchForm searchForm);
}
