package com.pmttms.controller;


import com.pmttms.entity.DepartmentInformation;
import com.pmttms.form.RuleForm;
import com.pmttms.form.SearchForm;
import com.pmttms.service.DepartmentInformationService;
import com.pmttms.util.ResultVOUtil;
import com.pmttms.vo.PageVO;
import com.pmttms.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2023-02-28
 */
@RestController
@RequestMapping("/departmentInformation")
public class DepartmentInformationController {

    @Autowired
    private DepartmentInformationService departmentInformationService;

    @PostMapping("/save")
    public ResultVO save(@RequestBody DepartmentInformation departmentInformation){
        boolean save = this.departmentInformationService.save(departmentInformation);
        if(!save)return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }

    @GetMapping("/list/{page}/{size}")
    public ResultVO list(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageVO pageVO = this.departmentInformationService.list(page, size);
        return ResultVOUtil.success(pageVO);
    }

    @GetMapping("/search")
    public ResultVO search(SearchForm searchForm){
        System.out.println(searchForm.getValue());
        System.out.println(searchForm.getKey());
        PageVO pageVO = this.departmentInformationService.search(searchForm);
        return ResultVOUtil.success(pageVO);
    }

    @GetMapping("/findById/{id}")
    public ResultVO findById(@PathVariable("id") String id){
        DepartmentInformation departmentInformation = this.departmentInformationService.getById(id);
        return ResultVOUtil.success(departmentInformation);
    }

    @PostMapping("/update")
    public ResultVO update(@RequestBody DepartmentInformation departmentInformation){
        boolean update = this.departmentInformationService.updateById(departmentInformation);
        if(!update) return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResultVO deleteById(@PathVariable("id") String id){
        boolean remove = this.departmentInformationService.removeById(id);
        if(!remove) return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }
}

