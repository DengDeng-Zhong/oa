package cn.targetpath.auth.service.impl;

import cn.targetpath.auth.mapper.SysRoleMapper;
import cn.targetpath.auth.service.SysRoleService;
import cn.targetpath.auth.model.system.SysRole;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Zhong-Dengbo
 * @version V1.0
 * @ClassName: SysRoleServiceImpl
 * @date 2023/3/21 15:42
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
}
