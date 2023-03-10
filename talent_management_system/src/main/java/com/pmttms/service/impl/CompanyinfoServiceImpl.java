package com.pmttms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmttms.entity.Companyadmin;
import com.pmttms.entity.Companyinfo;
import com.pmttms.form.SearchForm;
import com.pmttms.mapper.CompanyadminMapper;
import com.pmttms.mapper.CompanyinfoMapper;
import com.pmttms.service.CompanyinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pmttms.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class CompanyinfoServiceImpl extends ServiceImpl<CompanyinfoMapper, Companyinfo> implements CompanyinfoService {
    @Autowired
    private CompanyinfoMapper companyInfoMapper;
    @Autowired
    private CompanyadminMapper companyAdminMapper;

    @Override
    public Boolean saveInfo(Companyinfo companyInfo) {
        int insert = this.companyInfoMapper.insert(companyInfo);
        if(insert != 1) return false;
        return true;
    }

    @Override
    public PageVO list(Integer page, Integer size) {
        QueryWrapper<Companyadmin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", "同意");
        Page<Companyadmin> companyAdminPage = new Page<>(page, size);
        Page<Companyadmin> resultPage = this.companyAdminMapper.selectPage(companyAdminPage, queryWrapper);
        List<Companyadmin> companyAdminList = resultPage.getRecords();
        Page<Companyinfo> companyInfoPage = new Page<>(page, size);
        Page<Companyinfo> resultInfoPage = this.companyInfoMapper.selectPage(companyInfoPage, null);
        List<Companyinfo> companyInfoList = resultInfoPage.getRecords();
        List<Companyinfo> tempList = new ArrayList<>();
        for (Companyadmin companyadmin : companyAdminList) {
            for (Companyinfo companyinfo : companyInfoList) {
                if(companyinfo.getCompanyID()==companyadmin.getCompanyID()){
                    tempList.add(companyinfo);
                }
            }
        }
        PageVO pageVO = new PageVO();
        pageVO.setTotal(resultPage.getTotal());
        pageVO.setData(tempList);
        return pageVO;
    }

    @Override
    public PageVO search(SearchForm searchForm) {
        QueryWrapper<Companyadmin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", "同意");
        Page<Companyadmin> companyAdminPage = new Page<>(searchForm.getPage(),searchForm.getSize());
        Page<Companyadmin> resultAdminPage = this.companyAdminMapper.selectPage(companyAdminPage, queryWrapper);
        List<Companyadmin> companyAdminList = resultAdminPage.getRecords();
        Page<Companyinfo> companyInfoPage = new Page<>(searchForm.getPage(),searchForm.getSize());
        Page<Companyinfo> resultInfoPage = this.companyInfoMapper.selectPage(companyInfoPage, null);
        List<Companyinfo> companyInfoList = resultInfoPage.getRecords();
        List<Companyinfo> tempList = new ArrayList<>();
        for (Companyadmin companyadmin : companyAdminList) {
            for (Companyinfo companyinfo : companyInfoList) {
                if(companyinfo.getCompanyID()==companyadmin.getCompanyID()){
                    tempList.add(companyinfo);
                }
            }
        }
        //模糊查询+分页
        //Page<Companyinfo> companyInformationPage = new Page<>(searchForm.getPage(),searchForm.getSize());
        Page<Companyinfo> resultPage = new Page<>(searchForm.getPage(),searchForm.getSize());
        if(searchForm.getValue().equals("")){
            resultPage.setRecords(tempList);
        } else {
            resultPage.setRecords(tempList);
            QueryWrapper<Companyinfo> queryWrapperSearch = new QueryWrapper<>();
            queryWrapperSearch.like(searchForm.getKey(), searchForm.getValue());
            resultPage = this.companyInfoMapper.selectPage(resultPage,queryWrapperSearch);
        }
        PageVO pageVO = new PageVO();
        pageVO.setTotal(resultPage.getTotal());
        pageVO.setData(resultPage.getRecords());
        return pageVO;
    }
}
