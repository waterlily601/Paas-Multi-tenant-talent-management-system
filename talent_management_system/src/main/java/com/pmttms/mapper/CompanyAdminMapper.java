package com.pmttms.mapper;

import com.pmttms.entity.Companyadmin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2023-03-01
 */
@Mapper
public interface CompanyadminMapper extends BaseMapper<Companyadmin> {
    public void agree(Integer id);
    public void refuse(Integer id);
}
