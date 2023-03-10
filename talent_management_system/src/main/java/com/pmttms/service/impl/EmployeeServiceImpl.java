package com.pmttms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmttms.entity.Employee;
import com.pmttms.form.CompanySearchForm;
import com.pmttms.mapper.EmployeeMapper;
import com.pmttms.service.EmployeeService;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public PageVO list(Integer page, Integer size, Integer id){
        QueryWrapper<Employee> idQueryWrapper = new QueryWrapper<>();
        idQueryWrapper.eq("companyID", id);
        Page<Employee> checkformPage = new Page<>(page, size);
        Page<Employee> resultPage = this.employeeMapper.selectPage(checkformPage, idQueryWrapper);
        PageVO pageVO = new PageVO();
        pageVO.setTotal(resultPage.getTotal());
        pageVO.setData(resultPage.getRecords());
        return pageVO;
    }

    @Override
    public PageVO search(CompanySearchForm companySearchForm){
        QueryWrapper<Employee> idQueryWrapper = new QueryWrapper<>();
        idQueryWrapper.eq("companyID", companySearchForm.getId());
        //模糊查询+分页
        Page<Employee> checkformPage = new Page<>(companySearchForm.getPage(),companySearchForm.getSize());
        Page<Employee> resultPage = null;
        if(companySearchForm.getValue().equals("")){
            resultPage = this.employeeMapper.selectPage(checkformPage, idQueryWrapper);
        } else {
            QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
            queryWrapper.like(companySearchForm.getKey(), companySearchForm.getValue());
            queryWrapper.eq("companyID", companySearchForm.getId());
            resultPage = this.employeeMapper.selectPage(checkformPage,queryWrapper);
        }
        PageVO pageVO = new PageVO();
        pageVO.setTotal(resultPage.getTotal());
        pageVO.setData(resultPage.getRecords());
        return pageVO;
    }
}
