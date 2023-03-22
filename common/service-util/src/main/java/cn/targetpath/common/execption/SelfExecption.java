package cn.targetpath.common.execption;

import cn.targetpath.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * 自定义全局异常类
 *
 * @author Zhong-Dengbo
 * @version V1.0
 * @ClassName: SelfExecption
 * @date 2023/3/22 9:20
 */
@Data
public class SelfExecption extends RuntimeException{
    private Integer code;
    private String msg;

    /** 
     * @Description  通过状态码和错误消息创建异常对象
            
     * @Author Zhong-Dengbo
     * @Date 9:38 2023/3/22
     * @Param [code, msg]
     * @return 
     **/
    public SelfExecption(Integer code,String msg){
        super(msg);
        this.code = code;
        this.msg=msg;
    }
    
    /** 
     * @Description  接收枚举类型对象
            
     * @Author Zhong-Dengbo
     * @Date 9:40 2023/3/22
     * @Param [resultCodeEnum]
     * @return 
     **/
    public SelfExecption(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMessage();
    }
}
