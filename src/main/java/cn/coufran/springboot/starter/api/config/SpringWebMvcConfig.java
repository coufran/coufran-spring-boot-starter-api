package cn.coufran.springboot.starter.api.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Spring Web MVC配置
 * @author liuhuiming
 * @since 1.0.0
 * @version 1.0.0
 */
@Configuration
public class SpringWebMvcConfig implements WebMvcConfigurer {

    /**
     * POM文件中移除了默认的jackson依赖，手动配置fastjson converter。
     */
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));

        converters.add(converter);
    }
}
