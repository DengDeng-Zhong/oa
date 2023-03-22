package cn.targetpath.auth.controller;

import cn.targetpath.auth.model.system.SysRole;
import cn.targetpath.auth.service.SysRoleService;
import cn.targetpath.auth.vo.system.SysRoleQueryVo;
import cn.targetpath.common.execption.SelfExecption;
import cn.targetpath.common.result.Result;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public Result<List<SysRole>> findAll() {
        List<SysRole> roleList = sysRoleService.list();
//        try {
//            int a= 10/0;
//        }catch (Exception e){
//            throw new SelfExecption(2001,"controller自定义异常");
//        }
        return Result.ok(roleList);
    }

    /**
     * 条件分页查询
     *
     * @param page      当前页
     * @param limit     每页显示记录数
     * @param sysRoleVo 条件对象
     * @return
     */
    @ApiOperation(value = "条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result pageQueryRole(@PathVariable Long page,
                                @PathVariable Long limit,
                                SysRoleQueryVo sysRoleVo) {
        //调用service的方法实现
        //1 创建Page对象，传递分页相关参数
        //page 当前页  limit 每页显示记录数
        Page<SysRole> pageParam = new Page<>(page, limit);

        //2 封装条件，判断条件是否为空，不为空进行封装
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        String roleName = sysRoleVo.getRoleName();
        if (!StringUtils.isEmpty(roleName)) {
            //封装 like模糊查询
            wrapper.like(SysRole::getRoleName, roleName);
        }

        //3 调用方法实现
        IPage<SysRole> pageModel = sysRoleService.page(pageParam, wrapper);

        return Result.ok(pageModel);
    }

    @ApiOperation(value = "通过Id查询角色")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        SysRole role = sysRoleService.getById(id);
        return Result.ok(role);
    }

    @ApiOperation(value = "新增角色")
    @PostMapping("save")
    public Result save(@RequestBody SysRole role) {
        boolean is_success = sysRoleService.save(role);
        if (is_success) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @ApiOperation(value = "修改角色")
    @PutMapping("update")
    public Result update(@RequestBody SysRole role) {
        boolean is_success = sysRoleService.updateById(role);
        if (is_success) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @ApiOperation(value = "根据id删除")
    @DeleteMapping("reomve/{id}")
    public Result remove(@PathVariable
                                 Long id) {
        boolean is_success = sysRoleService.removeById(id);
        if (is_success) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody
                                      List<Long> ids) {
        boolean is_success = sysRoleService.removeByIds(ids);
        if (is_success) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

}
