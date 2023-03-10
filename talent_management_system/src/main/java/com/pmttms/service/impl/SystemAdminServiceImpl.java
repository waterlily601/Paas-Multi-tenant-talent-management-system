package com.pmttms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pmttms.entity.Systemadmin;
import com.pmttms.form.RuleForm;
import com.pmttms.mapper.SystemadminMapper;
import com.pmttms.service.SystemadminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class SystemadminServiceImpl extends ServiceImpl<SystemadminMapper, Systemadmin> implements SystemadminService {
    @Autowired
    private SystemadminMapper systemAdminMapper;

    @Override
    public ResultVO login(RuleForm ruleForm) {
        //1、判断用户名是否存在
        QueryWrapper<Systemadmin> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",ruleForm.getUsername());
        Systemadmin systemAdmin = this.systemAdminMapper.selectOne(queryWrapper);
        ResultVO resultVO=new ResultVO();
        if(systemAdmin==null){
            resultVO.setCode(-1);
        }else{
            //2、判断密码是否正确
            if(!systemAdmin.getPassword().equals(ruleForm.getPassword())){
                resultVO.setCode(-2);
            }else{
                resultVO.setCode(0);
                resultVO.setData(systemAdmin);
            }
        }
        return resultVO;
    }
}
