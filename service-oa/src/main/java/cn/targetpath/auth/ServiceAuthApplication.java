package cn.targetpath.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 *
 * @author Zhong-Dengbo
 * @version V1.0
 * @ClassName: ServiceAuthApplication
 * @date 2023/3/21 15:04
 */
@SpringBootApplication
@ComponentScan("cn.targetpath")
@MapperScan("cn.targetpath.*.mapper")
public class ServiceAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAuthApplication.class, args);
    }
}
