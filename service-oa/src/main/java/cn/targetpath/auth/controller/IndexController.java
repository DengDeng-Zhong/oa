package cn.targetpath.auth.controller;

import cn.targetpath.common.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 后端默认访问
 *
 * @author Zhong-Dengbo
 * @version V1.0
 * @ClassName: IndexController
 * @date 2023/3/22 14:58
 */
@RestController
public class IndexController {

    @RequestMapping("/")
    public Result index(){
        return Result.ok("欢迎使用本服务，请通过前端地址访问。");
    }
}
