package com.pmttms.mapper;

import com.pmttms.entity.Employee;
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
public interface EmployeeMapper extends BaseMapper<Employee> {

}
