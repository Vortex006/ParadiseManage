package com.vortex.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.vortex.Controller")
@EnableWebMvc
public class SpringMvcConfig {

}
