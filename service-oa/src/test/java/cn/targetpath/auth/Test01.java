package cn.targetpath.auth;

/**
 * @author Zhong-Dengbo
 * @version V1.0
 * @ClassName: Test01
 * @date 2023/3/21 15:09
 */

import cn.targetpath.auth.mapper.SysRoleMapper;
import cn.targetpath.auth.model.system.SysRole;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test01 {
    @Autowired
    SysRoleMapper sysRoleMapper;


    @Test
    @Ignore
    public void testSelect02(){
        LambdaQueryWrapper<SysRole> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysRole::getRoleCode,"COMMON");
        List<SysRole> sysRoles = sysRoleMapper.selectList(lambdaQueryWrapper);
        sysRoles.forEach(System.out::println);
    }

    @Test
    @Ignore
    public void testSelect01(){
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_name","组长");
        List<SysRole> sysRoles = sysRoleMapper.selectList(queryWrapper);
        sysRoles.forEach(System.out::println);
    }

    @Test
    @Ignore
    public void testDeleteBatchIds(){
        int res = sysRoleMapper.deleteBatchIds(Arrays.asList(1, 1));
        System.out.println("res = " + res);
    }


    @Test
    @Ignore
    public void testDeleteRoleById(){
        int res = sysRoleMapper.deleteById(9L);
        System.out.println("res = " + res);
    }


    @Test
    @Ignore
    public void testUpdateRoleById(){
        SysRole role = new SysRole();
        role.setId(9L);
        role.setRoleName("组长");
        int res = sysRoleMapper.updateById(role);
        System.out.println("res = " + res);
    }

    @Test
    @Ignore
    public void testInsertRole(){
        SysRole role = new SysRole();
        role.setRoleName("TL");
        role.setDescription("班长");
        role.setRoleCode("TL");
        int res = sysRoleMapper.insert(role);
        System.out.println("res = " + res);
        System.out.println(role);
    }


    @Test
    @Ignore
    public void testSelectLists(){
        List<SysRole> sysRoles = sysRoleMapper.selectList(null);
        sysRoles.forEach(System.out::println);
        //System.out.println(sysRoles);
    }

}
