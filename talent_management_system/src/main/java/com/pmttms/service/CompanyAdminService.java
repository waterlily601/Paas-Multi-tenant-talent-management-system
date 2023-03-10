package com.pmttms.service;

import com.pmttms.entity.Companyadmin;
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
 * @since 2023-03-01
 */
public interface CompanyadminService extends IService<Companyadmin> {
    public ResultVO saveAdmin(Companyadmin companyAdmin);
    public ResultVO login(RuleForm ruleForm);
    public PageVO list(Integer page, Integer size);
    public PageVO search(SearchForm searchForm);
    public Boolean agree(Integer id);
    public Boolean refuse(Integer id);
    public PageVO listRecord(Integer page, Integer size);
    public PageVO searchRecord(SearchForm searchForm);
    public PageVO listAll(Integer page, Integer size);
    public PageVO searchAll(SearchForm searchForm);
}

