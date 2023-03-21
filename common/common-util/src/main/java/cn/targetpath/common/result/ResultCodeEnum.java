package cn.targetpath.common.result;

import lombok.Getter;

/**
 * @Description  统一返回结果状态信息类
 *
 * @author Zhong-Dengbo
 * @version V1.0
 * @ClassName: ResultCodeEnum
 * @date 2023/3/21 16:34
 */
@Getter
public enum  ResultCodeEnum {
    SUCCESS(200,"成功"),
    FAIL(201, "失败"),
    SERVICE_ERROR(2012, "服务异常"),
    DATA_ERROR(204, "数据异常"),

    LOGIN_AUTH(208, "未登陆"),
    PERMISSION(209, "没有权限")
    ;

    private Integer code;

    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
