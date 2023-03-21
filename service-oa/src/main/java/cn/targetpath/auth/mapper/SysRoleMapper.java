package cn.targetpath.auth.mapper;

import cn.targetpath.auth.model.system.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色
 *
 * @author Zhong-Dengbo
 * @version V1.0
 * @ClassName: SysRoleMapper
 * @date 2023/3/21 15:08
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
}
