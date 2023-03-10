package com.pmttms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmttms.entity.Department;
import com.pmttms.form.CompanySearchForm;
import com.pmttms.form.SearchForm;
import com.pmttms.mapper.DepartmentMapper;
import com.pmttms.service.DepartmentService;
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
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentInformationMapper;

    @Override
    public PageVO list(Integer page, Integer size, Integer id) {
        QueryWrapper<Department> idQueryWrapper = new QueryWrapper<>();
        idQueryWrapper.eq("companyID", id);
        Page<Department> departmentInformationPage = new Page<>(page, size);
        Page<Department> resultPage = this.departmentInformationMapper.selectPage(departmentInformationPage, idQueryWrapper);
        PageVO pageVO = new PageVO();
        pageVO.setTotal(resultPage.getTotal());
        pageVO.setData(resultPage.getRecords());
        return pageVO;
    }

    @Override
    public PageVO search(CompanySearchForm companySearchForm) {
        QueryWrapper<Department> idQueryWrapper = new QueryWrapper<>();
        idQueryWrapper.eq("companyID", companySearchForm.getId());
        //模糊查询+分页
        Page<Department> departmentInformationPage = new Page<>(companySearchForm.getPage(),companySearchForm.getSize());
        Page<Department> resultPage = null;
        if(companySearchForm.getValue().equals("")){
            resultPage = this.departmentInformationMapper.selectPage(departmentInformationPage, idQueryWrapper);
        } else {
            QueryWrapper<Department> queryWrapper = new QueryWrapper<>();
            queryWrapper.like(companySearchForm.getKey(), companySearchForm.getValue());
            queryWrapper.eq("companyID", companySearchForm.getId());
            resultPage = this.departmentInformationMapper.selectPage(departmentInformationPage,queryWrapper);
        }
        PageVO pageVO = new PageVO();
        pageVO.setTotal(resultPage.getTotal());
        pageVO.setData(resultPage.getRecords());
        return pageVO;
    }
}
