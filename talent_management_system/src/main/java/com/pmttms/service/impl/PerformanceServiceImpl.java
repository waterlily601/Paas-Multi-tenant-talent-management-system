package com.pmttms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmttms.entity.Department;
import com.pmttms.entity.Performance;
import com.pmttms.form.CompanySearchForm;
import com.pmttms.form.SearchForm;
import com.pmttms.mapper.PerformanceMapper;
import com.pmttms.service.PerformanceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pmttms.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2023-03-01
 */
@Service
public class PerformanceServiceImpl extends ServiceImpl<PerformanceMapper, Performance> implements PerformanceService {
    @Autowired
    private PerformanceMapper performanceMapper;

    @Override
    public PageVO list(Integer page, Integer size, Integer id){
        QueryWrapper<Performance> idQueryWrapper = new QueryWrapper<>();
        idQueryWrapper.eq("companyID", id);
        Page<Performance> checkformPage = new Page<>(page, size);
        Page<Performance> resultPage = this.performanceMapper.selectPage(checkformPage, idQueryWrapper);
        PageVO pageVO = new PageVO();
        pageVO.setTotal(resultPage.getTotal());
        pageVO.setData(resultPage.getRecords());
        return pageVO;
    }

    @Override
    public PageVO search(CompanySearchForm companySearchForm){
        QueryWrapper<Performance> idQueryWrapper = new QueryWrapper<>();
        idQueryWrapper.eq("companyID", companySearchForm.getId());
        //模糊查询+分页
        Page<Performance> checkformPage = new Page<>(companySearchForm.getPage(),companySearchForm.getSize());
        Page<Performance> resultPage = null;
        if(companySearchForm.getValue().equals("")){
            resultPage = this.performanceMapper.selectPage(checkformPage, idQueryWrapper);
        } else {
            QueryWrapper<Performance> queryWrapper = new QueryWrapper<>();
            queryWrapper.like(companySearchForm.getKey(), companySearchForm.getValue());
            queryWrapper.eq("companyID", companySearchForm.getId());
            resultPage = this.performanceMapper.selectPage(checkformPage,queryWrapper);
        }
        PageVO pageVO = new PageVO();
        pageVO.setTotal(resultPage.getTotal());
        pageVO.setData(resultPage.getRecords());
        return pageVO;
    }
}
