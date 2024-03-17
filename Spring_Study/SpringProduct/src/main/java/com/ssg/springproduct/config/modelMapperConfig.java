package com.ssg.springproduct.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration : 해당 클래스가 스프링 빈에 대한 설정(@Configuration) 클래스 명시
 *
 */
@Configuration
public class modelMapperConfig {

    /**
     * @Bean 해당 메소드의 실행 결과로 반환 된 객체를 스프링의 빈으로 등록시키는 역할
     *
     */
    @Bean
    public ModelMapper getMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

}
