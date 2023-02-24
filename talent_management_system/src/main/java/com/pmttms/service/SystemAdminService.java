package com.pmttms.service;

import com.pmttms.entity.SystemAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pmttms.form.RuleForm;
import com.pmttms.vo.ResultVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2023-02-24
 */
public interface SystemAdminService extends IService<SystemAdmin> {
    public ResultVO login(RuleForm ruleForm);
}
