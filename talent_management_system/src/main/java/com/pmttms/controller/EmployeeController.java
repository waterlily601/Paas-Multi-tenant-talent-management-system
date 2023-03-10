package com.pmttms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pmttms.entity.Employee;
import com.pmttms.form.CompanySearchForm;
import com.pmttms.form.SearchForm;
import com.pmttms.service.EmployeeService;
import com.pmttms.util.ResultVOUtil;
import com.pmttms.vo.PageVO;
import com.pmttms.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2023-03-01
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public ResultVO save(@RequestBody Employee employee){
        boolean save = this.employeeService.save(employee);
        if(!save)
            return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }

    @GetMapping("/list/{page}/{size}/{id}")
    public ResultVO list(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @PathVariable("id") Integer id){
        PageVO pageVO = this.employeeService.list(page, size, id);
        return ResultVOUtil.success(pageVO);
    }

    @GetMapping("/search")
    public ResultVO search(CompanySearchForm companySearchForm){
        PageVO pageVO = this.employeeService.search(companySearchForm);
        return ResultVOUtil.success(pageVO);
    }

    @GetMapping("/findById/{id}")
    public ResultVO findById(@PathVariable("id") Integer id){
        Employee employee = this.employeeService.getById(id);
        return ResultVOUtil.success(employee);
    }

    @PutMapping("/update")
    public ResultVO update(@RequestBody Employee employee){
        boolean update = this.employeeService.updateById(employee);
        if(!update)
            return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResultVO deleteById(@PathVariable("id") Integer id){
        boolean remove = this.employeeService.removeById(id);
        if(!remove) return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }

    @GetMapping("/employeelist/{id}")
    public ResultVO employeelist(@PathVariable("id") Integer id){
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("employeeID");
        queryWrapper.in("companyID", id);
        List<Employee> employeelist = this.employeeService.list(queryWrapper);
        return ResultVOUtil.success(employeelist);
    }
}
