/**
 * ClassName:RedissonConfig
 * Author:机械革命
 * Date:2019/9/2316:08
 * Description:TODO
 */
package com.example.demo.redissonConfig;

/**
 * @Author: yuliang
 * @Date: 2019/9/23 16:08
 */

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * redisson 配置类
 * Created on 2018/6/19
 */
@Configuration
@EnableCaching
public class RedissonConfig {

	@Value("${spring.redis.host}")
	private String host;

	@Value("${spring.redis.port}")
	private int port;

//	@Value("${spring.redis.password}")
//	private String password;

	@Bean
	public RedissonClient getRedisson(){

		Config config = new Config();
//		config.useSingleServer().setAddress("redis://" + host + ":" + port).setPassword(password);
		config.useSingleServer().setAddress("redis://" + host + ":" + port);
		//添加主从配置
//        config.useMasterSlaveServers().setMasterAddress("").setPassword("").addSlaveAddress(new String[]{"",""});

		return Redisson.create(config);
	}

}