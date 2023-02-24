package com.pmttms.service;

import com.pmttms.entity.CompanyAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pmttms.form.RuleForm;
import com.pmttms.form.SearchForm;
import com.pmttms.vo.PageVO;
import com.pmttms.vo.ResultVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2023-02-24
 */
public interface CompanyAdminService extends IService<CompanyAdmin> {
    public Boolean saveAnimal(CompanyAdmin companyAdmin);
    public ResultVO login(RuleForm ruleForm);
    public PageVO list(Integer page, Integer size);
    public PageVO search(SearchForm searchForm);
    public Boolean agree(Integer id);
    public Boolean refuse(Integer id);
}
