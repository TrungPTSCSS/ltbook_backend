package io.data.ltbook.security;


import io.data.ltbook.filter.CustomAuthenticationFilter;
import io.data.ltbook.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/api/login");
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.csrf().disable();
        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues()).and()
        .authorizeRequests().antMatchers("/api/login/**","/api/token/refresh/**","/api/user/info",
                        "/api/blog/GetByQuery","/api/blog/GetById",
                        "/api/book/GetByQuery","/api/book/GetById","/api/book/GetByType",
                        "/api/productCart/GetByQuery","/api/productCart/GetByCodeCart",
                        "/api/bill/GetByQuery","/api/bill/GetByIdUser","api/users").permitAll()
                .antMatchers(POST,"/api/user/save/**"
                ,"/api/blog/Create","/api/book/Create",
                "/api/productCart/Create","/api/bill/Create")
                .hasAnyAuthority("ROLE_SUPER_ADMIN","ROLE_ADMIN")
                .antMatchers(POST,"/api/blog/Update","/api/book/Update","/api/productCart/Update","/api/bill/Update")
                .hasAnyAuthority("ROLE_SUPER_ADMIN","ROLE_ADMIN")
                .antMatchers(DELETE,"/api/blog/Delete","/api/book/Delete")
                .hasAnyAuthority("ROLE_SUPER_ADMIN","ROLE_ADMIN")
                .anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");
            }
        };
    }
}
