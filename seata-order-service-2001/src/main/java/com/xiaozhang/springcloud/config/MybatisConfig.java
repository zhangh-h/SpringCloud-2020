package com.xiaozhang.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: MybatisConfig <br/>
 *
 * @author xiao张<br />
 * @date: 2021/3/26 10:49
 * @version: 1.0
 * <p>
 * Description: <br/>
 */
@Configuration
@MapperScan({"com.xiaozhang.springcloud.dao"})
public class MybatisConfig {
}
