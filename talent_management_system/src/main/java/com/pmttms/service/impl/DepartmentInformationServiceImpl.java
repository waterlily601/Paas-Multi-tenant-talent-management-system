package com.pmttms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmttms.entity.DepartmentInformation;
import com.pmttms.form.SearchForm;
import com.pmttms.mapper.DepartmentInformationMapper;
import com.pmttms.service.DepartmentInformationService;
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
 * @since 2023-02-28
 */
@Service
public class DepartmentInformationServiceImpl extends ServiceImpl<DepartmentInformationMapper, DepartmentInformation> implements DepartmentInformationService {

    @Autowired
    private DepartmentInformationMapper departmentInformationMapper;

    @Override
    public PageVO list(Integer page, Integer size) {
        Page<DepartmentInformation> departmentInformationPage = new Page<>(page, size);
        Page<DepartmentInformation> resultPage = this.departmentInformationMapper.selectPage(departmentInformationPage, null);
        PageVO pageVO = new PageVO();
        pageVO.setTotal(resultPage.getTotal());
        pageVO.setData(resultPage.getRecords());
        return pageVO;
    }

    @Override
    public PageVO search(SearchForm searchForm) {
        //模糊查询+分页
        Page<DepartmentInformation> departmentInformationPage = new Page<>(searchForm.getPage(),searchForm.getSize());
        Page<DepartmentInformation> resultPage = null;
        if(searchForm.getValue().equals("")){
            resultPage = this.departmentInformationMapper.selectPage(departmentInformationPage, null);
        } else {
            QueryWrapper<DepartmentInformation> queryWrapper = new QueryWrapper<>();
            queryWrapper.like(searchForm.getKey(), searchForm.getValue());
            resultPage = this.departmentInformationMapper.selectPage(departmentInformationPage,queryWrapper);
        }
        PageVO pageVO = new PageVO();
        pageVO.setTotal(resultPage.getTotal());
        pageVO.setData(resultPage.getRecords());
        return pageVO;
    }
}
