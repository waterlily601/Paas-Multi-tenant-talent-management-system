package com.pmttms.controller;


import com.pmttms.entity.CompanyAdmin;
import com.pmttms.form.RuleForm;
import com.pmttms.form.SearchForm;
import com.pmttms.service.CompanyAdminService;
import com.pmttms.service.SystemAdminService;
import com.pmttms.util.ResultVOUtil;
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
 * @since 2023-02-24
 */
@RestController
@RequestMapping("/companyAdmin")
public class CompanyAdminController {
    @Autowired
    private CompanyAdminService companyAdminService;

    @PostMapping("/save")
    public ResultVO save(@RequestBody CompanyAdmin companyAdmin){
        Boolean saveAnimal = this.companyAdminService.saveAnimal(companyAdmin);
        if(!saveAnimal) return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }

    @GetMapping("/login")
    public ResultVO login(RuleForm ruleForm){
        ResultVO resultVO = this.companyAdminService.login(ruleForm);
        return resultVO;
    }

    @GetMapping("/list/{page}/{size}")
    public ResultVO list(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        return ResultVOUtil.success(this.companyAdminService.list(page, size));
    }

    @GetMapping("/search")
    public ResultVO search(SearchForm searchForm){
        return ResultVOUtil.success(this.companyAdminService.search(searchForm));
    }

    @PutMapping("/agree/{id}")
    public ResultVO agree(@PathVariable("id") Integer id){
        Boolean agree = this.companyAdminService.agree(id);
        if(!agree) return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }

    @PutMapping("/refuse/{id}")
    public ResultVO refuse(@PathVariable("id") Integer id){
        Boolean agree = this.companyAdminService.refuse(id);
        if(!agree) return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }

}

