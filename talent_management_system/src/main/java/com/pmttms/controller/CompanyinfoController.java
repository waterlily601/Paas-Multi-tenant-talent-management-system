package com.pmttms.controller;


import com.pmttms.entity.Companyadmin;
import com.pmttms.entity.Companyinfo;
import com.pmttms.form.SearchForm;
import com.pmttms.service.CompanyadminService;
import com.pmttms.service.CompanyinfoService;
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
@RequestMapping("/companyinfo")
public class CompanyinfoController {
    @Autowired
    private CompanyinfoService companyInfoService;
    @Autowired
    private CompanyadminService companyAdminService;

    @PostMapping("/save")
    public ResultVO save(@RequestBody Companyinfo companyInfo){
        Boolean saveCompanyinfo = this.companyInfoService.saveInfo(companyInfo);
        if(!saveCompanyinfo) return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }

    @GetMapping("/list/{page}/{size}")
    public ResultVO list(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
        PageVO pageVO = this.companyInfoService.list(page, size);
        return ResultVOUtil.success(pageVO);
    }

    @GetMapping("/search")
    public ResultVO search(SearchForm searchForm){
        PageVO pageVO = this.companyInfoService.search(searchForm);
        return ResultVOUtil.success(pageVO);
    }

    @GetMapping("/findById/{id}")
    public ResultVO findById(@PathVariable("id") String id){
        Companyinfo companyinfo = this.companyInfoService.getById(id);
        return ResultVOUtil.success(companyinfo);
    }

    @PutMapping("/update")
    public ResultVO update(@RequestBody Companyinfo companyinfo){
        boolean update = this.companyInfoService.updateById(companyinfo);
        if(!update) return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResultVO deleteById(@PathVariable("id") String id){
        boolean remove = this.companyInfoService.removeById(id);
        boolean remove2 = this.companyAdminService.removeById(id);
        if((!remove)||(!remove2)) return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }
}

