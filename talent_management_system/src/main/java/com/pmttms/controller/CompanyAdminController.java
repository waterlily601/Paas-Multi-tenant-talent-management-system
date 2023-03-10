package com.pmttms.controller;


import com.pmttms.entity.Companyadmin;
import com.pmttms.form.RuleForm;
import com.pmttms.form.SearchForm;
import com.pmttms.service.CompanyadminService;
import com.pmttms.util.ResultVOUtil;
import com.pmttms.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2023-03-01
 */
@RestController
@RequestMapping("/companyadmin")
public class CompanyadminController {
    @Autowired
    private CompanyadminService companyAdminService;

    @PostMapping("/save")
    public ResultVO save(@RequestBody Companyadmin companyAdmin){
        ResultVO saveCompanyadmin = this.companyAdminService.saveAdmin(companyAdmin);
        return saveCompanyadmin;
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

    @GetMapping("/listRecord/{page}/{size}")
    public ResultVO listRecord(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
        return ResultVOUtil.success(this.companyAdminService.listRecord(page, size));
    }

    @GetMapping("/searchRecord")
    public ResultVO searchRecord(SearchForm searchForm){
        return ResultVOUtil.success(this.companyAdminService.searchRecord(searchForm));
    }

    @GetMapping("/findById/{id}")
    public ResultVO findById(@PathVariable("id") String id){
        Companyadmin companyAdmin = this.companyAdminService.getById(id);
        return ResultVOUtil.success(companyAdmin);
    }

    @GetMapping("/listAll/{page}/{size}")
    public ResultVO listAll(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
        return ResultVOUtil.success(this.companyAdminService.listAll(page, size));
    }

    @GetMapping("/searchAll")
    public ResultVO searchAll(SearchForm searchForm){
        return ResultVOUtil.success(this.companyAdminService.searchAll(searchForm));
    }

    @PostMapping("/updatepassword")
    public ResultVO update(@RequestBody Companyadmin companyadmin){
        boolean update = this.companyAdminService.updateById(companyadmin);
        if(!update) return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }

}

