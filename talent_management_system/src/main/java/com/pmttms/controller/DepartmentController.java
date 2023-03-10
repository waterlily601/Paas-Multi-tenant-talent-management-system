package com.pmttms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pmttms.entity.Department;
import com.pmttms.form.CompanySearchForm;
import com.pmttms.service.DepartmentService;
import com.pmttms.util.ResultVOUtil;
import com.pmttms.vo.PageVO;
import com.pmttms.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/save")
    public ResultVO save(@RequestBody Department departmentInformation){
        boolean save = this.departmentService.save(departmentInformation);
        if(!save)return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }

    @GetMapping("/list/{page}/{size}/{id}")
    public ResultVO list(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @PathVariable("id") Integer id){
        PageVO pageVO = this.departmentService.list(page, size,id);
        return ResultVOUtil.success(pageVO);
    }

    @GetMapping("/search")
    public ResultVO search(CompanySearchForm companySearchForm){
        System.out.println(companySearchForm.getValue());
        System.out.println(companySearchForm.getKey());
        PageVO pageVO = this.departmentService.search(companySearchForm);
        return ResultVOUtil.success(pageVO);
    }

    @GetMapping("/findById/{id}")
    public ResultVO findById(@PathVariable("id") String id){
        Department departmentInformation = this.departmentService.getById(id);
        return ResultVOUtil.success(departmentInformation);
    }

    @PostMapping("/update")
    public ResultVO update(@RequestBody Department departmentInformation){
        boolean update = this.departmentService.updateById(departmentInformation);
        if(!update) return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResultVO deleteById(@PathVariable("id") String id){
        boolean remove = this.departmentService.removeById(id);
        if(!remove) return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }

    @GetMapping("/departmentlist/{id}")
    public ResultVO departmentlist(@PathVariable("id") Integer id){
        QueryWrapper<Department> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("departmentname");
        queryWrapper.in("companyID", id);
        List<Department> departmentlist = this.departmentService.list(queryWrapper);

        return ResultVOUtil.success(departmentlist);
    }
}

