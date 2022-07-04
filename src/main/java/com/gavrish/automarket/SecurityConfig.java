package com.gavrish.automarket;

import com.gavrish.automarket.model.entity.RoleType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http                 // ниже строчкой механизм от угрозы
               .csrf().disable()
               .authorizeRequests()   // к каким именно ресурсам человек имеет доступ
               .antMatchers("/").permitAll()  // кто имеет какую роль на паттерны доступ    permitAll()   -  имеют все
               .antMatchers(HttpMethod.GET, "/api/**").hasAnyRole(RoleType.SELLER.getValue(), RoleType.CUSTOMER.getValue(), RoleType.ADMIN.getValue())
               .antMatchers(HttpMethod.POST, "/api/**").hasAnyRole(RoleType.SELLER.getValue(), RoleType.ADMIN.getValue())
               .antMatchers(HttpMethod.DELETE, "/api/**").hasAnyRole(RoleType.SELLER.getValue(), RoleType.ADMIN.getValue())
               .antMatchers(HttpMethod.PATCH, "/api/**").hasAnyRole(RoleType.SELLER.getValue(), RoleType.ADMIN.getValue())
               .anyRequest()
               .authenticated()       // каждый запрос должен быть аутинтифицирован
               .and()
               .httpBasic();
         }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("seller")
                        .password(passwordEncoder().encode("seller"))
                        .roles(RoleType.SELLER.name())
                        .build(),
                User.builder()
                        .username("customer")
                        .password(passwordEncoder().encode("customer"))
                        .roles(RoleType.CUSTOMER.name())
                        .build(),
                User.builder()
                        .username("admin")
                        .password(passwordEncoder().encode("admin"))
                        .roles(RoleType.ADMIN.name())
                        .build()
        );
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
