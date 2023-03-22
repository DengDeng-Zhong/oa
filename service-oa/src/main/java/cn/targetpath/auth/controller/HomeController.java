package cn.targetpath.auth.controller;

import cn.targetpath.common.result.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author Zhong-Dengbo
 * @version V1.0
 * @ClassName: HomeController
 * @date 2023/3/22 15:03
 */
@Api(tags = "后台登录管理")
@RestController
@RequestMapping("/admin/system/index")
public class HomeController {

    /**
     * @Description  登录

     * @Author Zhong-Dengbo
     * @Date 15:11 2023/3/22
     * @Param []
     * @return cn.targetpath.common.result.Result
     **/
    @PostMapping("login")
    public Result login(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("token","admin-token");
        return Result.ok(map);
    }

    /** 
     * @Description  获取用户信息
            
     * @Author Zhong-Dengbo
     * @Date 15:17 2023/3/22
     * @Param []
     * @return cn.targetpath.common.result.Result
     **/
    @GetMapping("info")
    public Result info(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("roles","[admin]");
        map.put("name","admin");
        map.put("avatar","https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg");
        return Result.ok(map);
    }
    
    /** 
     * @Description  退出
            
     * @Author Zhong-Dengbo
     * @Date 15:18 2023/3/22
     * @Param []
     * @return cn.targetpath.common.result.Result
     **/
    @PostMapping("logout")
    public Result logout(){
        return Result.ok();
    }
}
