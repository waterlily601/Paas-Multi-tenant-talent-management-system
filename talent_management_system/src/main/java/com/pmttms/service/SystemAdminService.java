package com.pmttms.service;

import com.pmttms.entity.Systemadmin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pmttms.form.RuleForm;
import com.pmttms.vo.ResultVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2023-03-01
 */
public interface SystemadminService extends IService<Systemadmin> {
    public ResultVO login(RuleForm ruleForm);
}
