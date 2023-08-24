package com.bevan.servicedriveruser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bevan.internalcommon.model.DriverCarBindingRelations;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 司机与车辆绑定关系表 Mapper 接口
 * </p>
 *
 * @author bevan
 * @since 2023-08-22
 */
@Repository
public interface DriverCarBindingRelationsMapper extends BaseMapper<DriverCarBindingRelations> {

}
