package com.pmttms.controller;


import com.pmttms.entity.Checkonwork;
import com.pmttms.form.CompanySearchForm;
import com.pmttms.form.SearchForm;
import com.pmttms.service.CheckonworkService;
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
@RequestMapping("/checkonwork")
public class CheckonworkController {
    @Autowired
    private CheckonworkService checkonworkService;

    @PostMapping("/save")
    public ResultVO save(@RequestBody Checkonwork checkonwork){
        boolean save = this.checkonworkService.save(checkonwork);
        if(!save)
            return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }

    @GetMapping("/list/{page}/{size}/{id}")
    public ResultVO list(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @PathVariable("id") Integer id){
        PageVO pageVO = this.checkonworkService.list(page, size, id);
        return ResultVOUtil.success(pageVO);
    }

    @GetMapping("/search")
    public ResultVO search(CompanySearchForm companySearchForm){
        PageVO pageVO = this.checkonworkService.search(companySearchForm);
        return ResultVOUtil.success(pageVO);
    }

    @GetMapping("/findById/{id}")
    public ResultVO findById(@PathVariable("id") Integer id){
        Checkonwork checkonwork = this.checkonworkService.getById(id);
        return ResultVOUtil.success(checkonwork);
    }

    @PutMapping("/update")
    public ResultVO update(@RequestBody Checkonwork checkonwork){
        boolean update = this.checkonworkService.updateById(checkonwork);
        if(!update)
            return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }
}
