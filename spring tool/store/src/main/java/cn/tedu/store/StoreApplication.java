package cn.tedu.store;

import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

@SpringBootApplication
@MapperScan("cn.tedu.store.mapper")
@Configuration
public class StoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}
	
	@Bean
	public MultipartConfigElement getMultipartConfigElement() {
		
		
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//上传单个文件大小
		factory.setMaxFileSize(DataSize.ofMegabytes(50));
		/* 整个请求的大小 */
		factory.setMaxRequestSize(DataSize.ofMegabytes(50));
		return factory.createMultipartConfig();
	}

}
