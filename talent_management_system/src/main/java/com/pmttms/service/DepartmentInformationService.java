package com.pmttms.service;

import com.pmttms.entity.DepartmentInformation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pmttms.form.SearchForm;
import com.pmttms.vo.PageVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2023-02-28
 */
public interface DepartmentInformationService extends IService<DepartmentInformation> {
    public PageVO list(Integer page, Integer size);
    public PageVO search(SearchForm searchForm);
}
