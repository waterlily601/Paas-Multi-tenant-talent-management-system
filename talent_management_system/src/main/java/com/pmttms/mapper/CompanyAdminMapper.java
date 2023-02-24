package com.pmttms.mapper;

import com.pmttms.entity.CompanyAdmin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2023-02-24
 */
@Mapper
public interface CompanyAdminMapper extends BaseMapper<CompanyAdmin> {
    public void agree(Integer id);
    public void refuse(Integer id);
}
