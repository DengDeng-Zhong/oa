package cn.targetpath.auth;

import cn.targetpath.auth.service.SysRoleService;
import cn.targetpath.auth.model.system.SysRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 测试service
 *
 * @author Zhong-Dengbo
 * @version V1.0
 * @ClassName: test02
 * @date 2023/3/21 15:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class test02 {
    @Autowired
    private SysRoleService sysRoleService;

    @Test
    public void testSelectList(){
        List<SysRole> list = sysRoleService.list();
        list.forEach(System.out::println);
    }
}
