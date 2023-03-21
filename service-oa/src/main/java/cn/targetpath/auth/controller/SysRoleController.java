package cn.targetpath.auth.controller;

import cn.targetpath.auth.model.system.SysRole;
import cn.targetpath.auth.service.SysRoleService;
import cn.targetpath.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Zhong-Dengbo
 * @version V1.0
 * @ClassName: SysRoleController
 * @date 2023/3/21 16:15
 */
@Api(tags = "角色管理")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @ApiOperation(value = "获取全部角色列表")
    @GetMapping("findAll")
    public Result<List<SysRole>> findAll(){
        List<SysRole> roleList = sysRoleService.list();
        return Result.ok(roleList);
    }
}
