package com.aitangbao.sso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.wlgzs.website.dao")
public class OrgApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrgApplication.class, args);
	}

}
