package com.pmttms.service;

import com.pmttms.entity.Hradmin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pmttms.form.CompanySearchForm;
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
 * @since 2023-03-01
 */
public interface HradminService extends IService<Hradmin> {
    public ResultVO login(RuleForm ruleForm);
    public Boolean saveHr(Hradmin hradmin);
    public PageVO list(Integer page, Integer size, Integer id);
    public PageVO search(CompanySearchForm companySearchForm);
    public Boolean update(Hradmin hradmin);
}
