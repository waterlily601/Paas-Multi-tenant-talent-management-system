package com.pmttms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmttms.entity.Hradmin;
import com.pmttms.form.CompanySearchForm;
import com.pmttms.form.RuleForm;
import com.pmttms.mapper.HradminMapper;
import com.pmttms.service.HradminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pmttms.vo.PageVO;
import com.pmttms.vo.ResultVO;
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
public class HradminServiceImpl extends ServiceImpl<HradminMapper, Hradmin> implements HradminService {
    @Autowired
    private HradminMapper hradminMapper;

    @Override
    public ResultVO login(RuleForm ruleForm) {
        //1、判断用户名是否存在
        QueryWrapper<Hradmin> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",ruleForm.getUsername());
        Hradmin hradmin = this.hradminMapper.selectOne(queryWrapper);
        ResultVO resultVO=new ResultVO();
        if(hradmin==null){
            resultVO.setCode(-1);
        }else{
            //2、判断密码是否正确
            if(!hradmin.getPassword().equals(ruleForm.getPassword())){
                resultVO.setCode(-2);
            }else{
                resultVO.setCode(0);
                resultVO.setData(hradmin);
            }
        }
        return resultVO;
    }

    @Override
    public Boolean saveHr(Hradmin hradmin) {
        //添加记录数据
        int insert = this.hradminMapper.insert(hradmin);
        if (insert != 1) return false;
        return true;
    }

    @Override
    public PageVO list(Integer page, Integer size, Integer id) {
        QueryWrapper<Hradmin> idQueryWrapper = new QueryWrapper<>();
        idQueryWrapper.eq("companyID", id);
        Page<Hradmin> hradminPage = new Page<>(page, size);
        Page<Hradmin> resultPage = this.hradminMapper.selectPage(hradminPage, idQueryWrapper);
        PageVO pageVO = new PageVO();
        pageVO.setTotal(resultPage.getTotal());
        pageVO.setData(resultPage.getRecords());
        return pageVO;
    }

    @Override
    public PageVO search(CompanySearchForm companySearchForm) {
        QueryWrapper<Hradmin> idQueryWrapper = new QueryWrapper<>();
        idQueryWrapper.eq("companyID", companySearchForm.getId());
        //模糊查询+分页
        Page<Hradmin> hradminPage = new Page<>(companySearchForm.getPage(),companySearchForm.getSize());
        Page<Hradmin> resultPage = null;
        if(companySearchForm.getValue().equals("")){
            resultPage = this.hradminMapper.selectPage(hradminPage, idQueryWrapper);
        } else {
            QueryWrapper<Hradmin> queryWrapper = new QueryWrapper<>();
            queryWrapper.like(companySearchForm.getKey(), companySearchForm.getValue());
            queryWrapper.eq("companyID", companySearchForm.getId());
            resultPage = this.hradminMapper.selectPage(hradminPage,queryWrapper);
        }
        PageVO pageVO = new PageVO();
        pageVO.setTotal(resultPage.getTotal());
        pageVO.setData(resultPage.getRecords());
        return pageVO;
    }

    @Override
    public Boolean update(Hradmin alarmrecord){
        int update = this.hradminMapper.updateById(alarmrecord);
        return null;
    }
}