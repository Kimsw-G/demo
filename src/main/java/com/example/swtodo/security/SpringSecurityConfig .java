package com.example.swtodo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig{

    private static final String[] AUTH_WHITELIST = {
        "/", "/user/**"
    };

    @Bean
    protected void configure(HttpSecurity http) throws Exception{
        // return http.authorizeHttpRequests(authorize -> authorize
        //     .shouldFilterAllDispatcherTypes(false)
        //     .requestMatchers(AUTH_WHITELIST)
        //     .permitAll()
        //     .anyRequest()
        //     .authenticated())
        // .build();
        http.httpBasic()
        .and()
            .authorizeRequests()
            .antMatchers("/users/{userId}")
            .access("@authenticationCheckHandler.checkUserId(authentication,#userId)")
            .antMatchers("/register/**")
            .hasRole("ANONYMOUS")
        .and()
            .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                // .successHandler(successHandler())
                // .failureHandler(failureHandler())
                .permitAll();
            
    }

    
}
