package com.pmttms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmttms.entity.Checkonwork;
import com.pmttms.entity.Department;
import com.pmttms.form.CompanySearchForm;
import com.pmttms.form.SearchForm;
import com.pmttms.mapper.CheckonworkMapper;
import com.pmttms.service.CheckonworkService;
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
public class CheckonworkServiceImpl extends ServiceImpl<CheckonworkMapper, Checkonwork> implements CheckonworkService {
    @Autowired
    private CheckonworkMapper checkonworkMapper;

    @Override
    public PageVO list(Integer page, Integer size, Integer id){
        QueryWrapper<Checkonwork> idQueryWrapper = new QueryWrapper<>();
        idQueryWrapper.eq("companyID", id);
        Page<Checkonwork> checkformPage = new Page<>(page, size);
        Page<Checkonwork> resultPage = this.checkonworkMapper.selectPage(checkformPage, idQueryWrapper);
        PageVO pageVO = new PageVO();
        pageVO.setTotal(resultPage.getTotal());
        pageVO.setData(resultPage.getRecords());
        return pageVO;
    }

    @Override
    public PageVO search(CompanySearchForm companySearchForm){
        QueryWrapper<Checkonwork> idQueryWrapper = new QueryWrapper<>();
        idQueryWrapper.eq("companyID", companySearchForm.getId());
        //模糊查询+分页
        Page<Checkonwork> checkformPage = new Page<>(companySearchForm.getPage(),companySearchForm.getSize());
        Page<Checkonwork> resultPage = null;
        if(companySearchForm.getValue().equals("")){
            resultPage = this.checkonworkMapper.selectPage(checkformPage, idQueryWrapper);
        } else {
            QueryWrapper<Checkonwork> queryWrapper = new QueryWrapper<>();
            queryWrapper.like(companySearchForm.getKey(), companySearchForm.getValue());
            queryWrapper.eq("companyID", companySearchForm.getId());
            resultPage = this.checkonworkMapper.selectPage(checkformPage,queryWrapper);
        }
        PageVO pageVO = new PageVO();
        pageVO.setTotal(resultPage.getTotal());
        pageVO.setData(resultPage.getRecords());
        return pageVO;
    }
}
