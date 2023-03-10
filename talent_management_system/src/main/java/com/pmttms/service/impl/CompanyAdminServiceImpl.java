package com.pmttms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmttms.entity.Companyadmin;
import com.pmttms.form.RuleForm;
import com.pmttms.form.SearchForm;
import com.pmttms.mapper.CompanyadminMapper;
import com.pmttms.service.CompanyadminService;
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
 * @since 2023-03-01
 */
@Service
public class CompanyadminServiceImpl extends ServiceImpl<CompanyadminMapper, Companyadmin> implements CompanyadminService {
    @Autowired
    private CompanyadminMapper companyAdminMapper;

    @Override
    public ResultVO saveAdmin(Companyadmin companyAdmin) {
        QueryWrapper<Companyadmin> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",companyAdmin.getUsername());
        Companyadmin companyAdminExist = this.companyAdminMapper.selectOne(queryWrapper);
        ResultVO resultVO=new ResultVO();
        if(companyAdminExist!=null){//账号存在，禁止注册
            resultVO.setCode(-1);
        }else{
            int insert = this.companyAdminMapper.insert(companyAdmin);
            if(insert == 1) {
                resultVO.setCode(0);
                resultVO.setData(companyAdmin);
            }else{
                resultVO.setCode(-2);
            }
        }
        return resultVO;
    }

    @Override
    public ResultVO login(RuleForm ruleForm) {
        //1、判断用户名是否存在
        QueryWrapper<Companyadmin> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",ruleForm.getUsername());
        Companyadmin companyAdmin = this.companyAdminMapper.selectOne(queryWrapper);
        ResultVO resultVO=new ResultVO();
        if(companyAdmin==null||companyAdmin.getState().equals("待审批")||companyAdmin.getState().equals("拒绝")){
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
        QueryWrapper<Companyadmin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", "待审批");
        Page<Companyadmin> companyAdminPage = new Page<>(page, size);
        Page<Companyadmin> resultPage = this.companyAdminMapper.selectPage(companyAdminPage, queryWrapper);
        List<Companyadmin> companyAdminList = resultPage.getRecords();
        PageVO pageVO = new PageVO();
        pageVO.setData(companyAdminList);
        pageVO.setTotal(resultPage.getTotal());
        return pageVO;
    }

    @Override
    public PageVO search(SearchForm searchForm) {
        QueryWrapper<Companyadmin> queryWrapperT = new QueryWrapper<>();
        queryWrapperT.eq("state", "待审批");
        Page<Companyadmin> companyAdminPage = new Page<>(searchForm.getPage(), searchForm.getSize());
        Page<Companyadmin> resultPage = null;
        if(searchForm.getValue().equals("")){
            resultPage = this.companyAdminMapper.selectPage(companyAdminPage, queryWrapperT);
        } else {
            QueryWrapper<Companyadmin> queryWrapper = new QueryWrapper<>();
            queryWrapper.like(searchForm.getKey(), searchForm.getValue());
            resultPage = this.companyAdminMapper.selectPage(companyAdminPage, queryWrapper);
        }
        List<Companyadmin> companyAdminList = resultPage.getRecords();
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

    @Override
    public PageVO listRecord(Integer page, Integer size) {
        QueryWrapper<Companyadmin> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("state", "同意","拒绝");
        Page<Companyadmin> companyAdminPage = new Page<>(page, size);
        Page<Companyadmin> resultPage = this.companyAdminMapper.selectPage(companyAdminPage, queryWrapper);
        List<Companyadmin> companyAdminList = resultPage.getRecords();
//        List<CompanyAdmin> tempList = new ArrayList<>();
//        for (CompanyAdmin companyAdmin : companyAdminList) {
//            if(companyAdmin.getState()==1) tempList.add(companyAdmin);
//        }
        PageVO pageVO = new PageVO();
        pageVO.setData(companyAdminList);
        pageVO.setTotal(resultPage.getTotal());
        return pageVO;
    }

    @Override
    public PageVO searchRecord(SearchForm searchForm) {
        QueryWrapper<Companyadmin> queryWrapperT = new QueryWrapper<>();
        queryWrapperT.in("state", "同意","拒绝");
        Page<Companyadmin> companyAdminPage = new Page<>(searchForm.getPage(), searchForm.getSize());
        Page<Companyadmin> resultPage = null;
        if(searchForm.getValue().equals("")){
            resultPage = this.companyAdminMapper.selectPage(companyAdminPage, queryWrapperT);
        } else {
            QueryWrapper<Companyadmin> queryWrapper = new QueryWrapper<>();
            queryWrapper.like(searchForm.getKey(), searchForm.getValue());
            resultPage = this.companyAdminMapper.selectPage(companyAdminPage, queryWrapper);
        }
        List<Companyadmin> companyAdminList = resultPage.getRecords();

        PageVO pageVO = new PageVO();
        pageVO.setData(companyAdminList);
        pageVO.setTotal(resultPage.getTotal());
        return pageVO;
    }

    @Override
    public PageVO listAll(Integer page, Integer size) {

        Page<Companyadmin> companyAdminPage = new Page<>(page, size);
        Page<Companyadmin> resultPage = this.companyAdminMapper.selectPage(companyAdminPage, null);
        List<Companyadmin> companyAdminList = resultPage.getRecords();
        PageVO pageVO = new PageVO();
        pageVO.setData(companyAdminList);
        pageVO.setTotal(resultPage.getTotal());
        return pageVO;
    }

    @Override
    public PageVO searchAll(SearchForm searchForm) {

        Page<Companyadmin> companyAdminPage = new Page<>(searchForm.getPage(), searchForm.getSize());
        Page<Companyadmin> resultPage = null;
        if(searchForm.getValue().equals("")){
            resultPage = this.companyAdminMapper.selectPage(companyAdminPage, null);
        } else {
            QueryWrapper<Companyadmin> queryWrapper = new QueryWrapper<>();
            queryWrapper.like(searchForm.getKey(), searchForm.getValue());
            resultPage = this.companyAdminMapper.selectPage(companyAdminPage, queryWrapper);
        }
        List<Companyadmin> companyAdminList = resultPage.getRecords();
        PageVO pageVO = new PageVO();
        pageVO.setData(companyAdminList);
        pageVO.setTotal(resultPage.getTotal());
        return pageVO;
    }
}
