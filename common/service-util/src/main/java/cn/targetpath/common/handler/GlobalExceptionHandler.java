package cn.targetpath.common.handler;

import cn.targetpath.common.execption.SelfExecption;
import cn.targetpath.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常类
 *
 * @author Zhong-Dengbo
 * @version V1.0
 * @ClassName: GlobalExceptionHandler
 * @date 2023/3/22 9:01
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @Description  全局异常

     * @Author Zhong-Dengbo
     * @Date 9:43 2023/3/22
     * @Param [e]
     * @return cn.targetpath.common.result.Result
     **/
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        return Result.fail().message("执行全局异常:"+e.getMessage());
    }

    /**
     * @Description  特定异常

     * @Author Zhong-Dengbo
     * @Date 9:44 2023/3/22
     * @Param [e]
     * @return cn.targetpath.common.result.Result
     **/
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e){
        return Result.fail().message("执行特定异常:"+e.getMessage());
    }

    /**
     * @Description  执行自定义异常

     * @Author Zhong-Dengbo
     * @Date 9:46 2023/3/22
     * @Param [e]
     * @return cn.targetpath.common.result.Result
     **/
    @ExceptionHandler(SelfExecption.class)
    @ResponseBody
    public Result error(SelfExecption e){
        return Result.fail().code(e.getCode()).message(e.getMessage());
    }

}
