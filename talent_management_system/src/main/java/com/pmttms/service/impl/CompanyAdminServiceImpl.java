package com.pmttms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmttms.entity.CompanyAdmin;
import com.pmttms.entity.SystemAdmin;
import com.pmttms.form.RuleForm;
import com.pmttms.form.SearchForm;
import com.pmttms.mapper.CompanyAdminMapper;
import com.pmttms.mapper.SystemAdminMapper;
import com.pmttms.service.CompanyAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pmttms.vo.PageVO;
import com.pmttms.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2023-02-24
 */
@Service
public class CompanyAdminServiceImpl extends ServiceImpl<CompanyAdminMapper, CompanyAdmin> implements CompanyAdminService {

    @Autowired
    private CompanyAdminMapper companyAdminMapper;

    @Override
    public Boolean saveAnimal(CompanyAdmin companyAdmin) {
        int insert = this.companyAdminMapper.insert(companyAdmin);
        if(insert != 1) return false;
        return true;
    }

    @Override
    public ResultVO login(RuleForm ruleForm) {
        //1、判断用户名是否存在
        QueryWrapper<CompanyAdmin> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",ruleForm.getUsername());
        CompanyAdmin companyAdmin = this.companyAdminMapper.selectOne(queryWrapper);
        ResultVO resultVO=new ResultVO();
        if(companyAdmin==null||companyAdmin.getState().equals("待审批")){
            resultVO.setCode(-1);
        }else{
            //2、判断密码是否正确
            if(!companyAdmin.getPassword().equals(ruleForm.getPassword())){
                resultVO.setCode(-2);
            }else{
                resultVO.setCode(0);
                resultVO.setData(companyAdmin);
            }
        }
        return resultVO;
    }

    @Override
    public PageVO list(Integer page, Integer size) {
        QueryWrapper<CompanyAdmin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", "待审批");
        Page<CompanyAdmin> companyAdminPage = new Page<>(page, size);
        Page<CompanyAdmin> resultPage = this.companyAdminMapper.selectPage(companyAdminPage, queryWrapper);
        List<CompanyAdmin> companyAdminList = resultPage.getRecords();
        PageVO pageVO = new PageVO();
        pageVO.setData(companyAdminList);
        pageVO.setTotal(resultPage.getTotal());
        return pageVO;
    }

    @Override
    public PageVO search(SearchForm searchForm) {
        QueryWrapper<CompanyAdmin> queryWrapperT = new QueryWrapper<>();
        queryWrapperT.eq("state", "待审批");
        Page<CompanyAdmin> companyAdminPage = new Page<>(searchForm.getPage(), searchForm.getSize());
        Page<CompanyAdmin> resultPage = null;
        if(searchForm.getValue().equals("")){
            resultPage = this.companyAdminMapper.selectPage(companyAdminPage, queryWrapperT);
        } else {
            QueryWrapper<CompanyAdmin> queryWrapper = new QueryWrapper<>();
            queryWrapper.like(searchForm.getKey(), searchForm.getValue());
            resultPage = this.companyAdminMapper.selectPage(companyAdminPage, queryWrapper);
        }
        List<CompanyAdmin> companyAdminList = resultPage.getRecords();
        PageVO pageVO = new PageVO();
        pageVO.setData(companyAdminList);
        pageVO.setTotal(resultPage.getTotal());
        return pageVO;
    }

    @Override
    public Boolean agree(Integer id) {
        this.companyAdminMapper.agree(id);
        return true;
    }

    @Override
    public Boolean refuse(Integer id) {
        this.companyAdminMapper.refuse(id);
        return true;
    }
}
