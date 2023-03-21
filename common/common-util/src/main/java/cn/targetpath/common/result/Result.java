package cn.targetpath.common.result;

import lombok.Data;

/**
 * 全局统一返回结果类
 *
 * @author Zhong-Dengbo
 * @version V1.0
 * @ClassName: Result
 * @date 2023/3/21 16:30
 */
@Data
public class Result<T> {
    /**返回码*/
    private Integer code;
    /**返回信息*/
    private String message;
    /**返回数据*/
    private T data;
    public Result(){}
    
    /** 
     * @Description  返回数据
            
     * @Author Zhong-Dengbo
     * @Date 16:33 2023/3/21
     * @Param [data]
     * @return cn.targetpath.common.result.Result<T>
     **/
    protected  static <T> Result<T> build(T data){
        Result<T> result = new Result<>();
        if (data!= null){
            result.setData(data);
        }
        return result;
    }
    public static <T> Result<T> build(T body, Integer code, String message) {
        Result<T> result = build(body);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> build(T body, ResultCodeEnum resultCodeEnum) {
        Result<T> result = build(body);
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }

    public static<T> Result<T> ok(){
        return Result.ok(null);
    }

    /**
     * 操作成功
     * @param data  baseCategory1List
     * @param <T>
     * @return
     */
    public static<T> Result<T> ok(T data){
        Result<T> result = build(data);
        return build(data, ResultCodeEnum.SUCCESS);
    }

    public static<T> Result<T> fail(){
        return Result.fail(null);
    }

    /**
     * 操作失败
     * @param data
     * @param <T>
     * @return
     */
    public static<T> Result<T> fail(T data){
        Result<T> result = build(data);
        return build(data, ResultCodeEnum.FAIL);
    }

    public Result<T> message(String msg){
        this.setMessage(msg);
        return this;
    }

    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }
}
