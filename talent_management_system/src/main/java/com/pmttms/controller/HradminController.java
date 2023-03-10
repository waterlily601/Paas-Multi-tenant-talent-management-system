package com.pmttms.controller;


import com.pmttms.entity.Hradmin;
import com.pmttms.form.CompanySearchForm;
import com.pmttms.form.RuleForm;
import com.pmttms.form.SearchForm;
import com.pmttms.service.HradminService;
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
 * @since 2023-03-01
 */
@RestController
@RequestMapping("/hradmin")
public class HradminController {

    @Autowired
    private HradminService hradminService;

    @GetMapping("/login")
    public ResultVO login(RuleForm ruleForm){
        ResultVO resultVO = this.hradminService.login(ruleForm);
        return resultVO;
    }

    @PostMapping("/save")
    public ResultVO save(@RequestBody Hradmin hradmin){
        Boolean saveHr = this.hradminService.saveHr(hradmin);
        if(!saveHr) return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }

    @GetMapping("/list/{page}/{size}/{id}")
    public ResultVO list(@PathVariable("page") Integer page,@PathVariable("size") Integer size,@PathVariable("id") Integer id){
        PageVO pageVO = this.hradminService.list(page, size, id);
        return ResultVOUtil.success(pageVO);
    }

    @GetMapping("/search")
    public ResultVO search(CompanySearchForm companySearchForm){
        PageVO pageVO = this.hradminService.search(companySearchForm);
        return ResultVOUtil.success(pageVO);
    }

    @GetMapping("/findById/{id}")
    public ResultVO findById(@PathVariable("id") Integer id){
        Hradmin hradmin = this.hradminService.getById(id);
        return ResultVOUtil.success(hradmin);
    }

    @PutMapping("/update")
    public ResultVO update(@RequestBody Hradmin hradmin){
        Boolean update = this.hradminService.update(hradmin);
        return ResultVOUtil.success(null);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResultVO deleteById(@PathVariable("id") Integer id){
        boolean remove = this.hradminService.removeById(id);
        if(!remove) return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }
}
