package com.pmttms.controller;


import com.pmttms.entity.Performance;
import com.pmttms.form.CompanySearchForm;
import com.pmttms.form.SearchForm;
import com.pmttms.service.PerformanceService;
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
@RequestMapping("/performance")
public class PerformanceController {
    @Autowired
    private PerformanceService performanceService;

    @PostMapping("/save")
    public ResultVO save(@RequestBody Performance performance){
        boolean save = this.performanceService.save(performance);
        if(!save)
            return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }

    @GetMapping("/list/{page}/{size}/{id}")
    public ResultVO list(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @PathVariable("id") Integer id){
        PageVO pageVO = this.performanceService.list(page, size, id);
        return ResultVOUtil.success(pageVO);
    }

    @GetMapping("/search")
    public ResultVO search(CompanySearchForm companySearchForm){
        PageVO pageVO = this.performanceService.search(companySearchForm);
        return ResultVOUtil.success(pageVO);
    }

    @GetMapping("/findById/{id}")
    public ResultVO findById(@PathVariable("id") Integer id){
        Performance performance = this.performanceService.getById(id);
        return ResultVOUtil.success(performance);
    }

    @PutMapping("/update")
    public ResultVO update(@RequestBody Performance performance){
        boolean update = this.performanceService.updateById(performance);
        if(!update)
            return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }
}
