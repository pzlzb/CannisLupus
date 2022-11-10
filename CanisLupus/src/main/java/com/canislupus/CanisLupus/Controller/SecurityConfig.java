package com.canislupus.CanisLupus.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration//archivo de configuracion
@EnableWebSecurity
public class SecurityConfig {//WebSecurityConfigurerAdapter

    @Autowired
    private UserDetailsService userDetailsService;    

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
         return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder build) throws Exception{
        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
            .csrf().disable()
            .authorizeRequests().anyRequest().authenticated()
            .and()
            .httpBasic();
        return http.build();
    }

/* 
    //AUTORIZACION
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                                
                                .antMatchers("/cl/tutor/**").hasRole("TUTOR")
                                .antMatchers("/cl/student/**").hasRole("TUTORADO")
                                .antMatchers("/cl/admin/**").hasRole("ADMINISTRATOR")
                                .antMatchers("/cl/").hasAnyRole("TUTORADO", "ADMINISTRATOR", "TUTOR")
                                
                                .and()
                                .formLogin()
                                .loginPage("/login")
                                .and().exceptionHandling().accessDeniedPage("/errores/403");
    }
*/
    //AUTENTICACION 2
    //agregar usuarios y configurar usuarios
    //Modificacion de modo de acceso y permisos.
    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        final AdministratorService adminService;
        final TutorService tutorService;
        final StudentService pupilService;
        final CarrerService carrerService;
        
        auth.inMemoryAuthentication()
            .withUser("admin")//nombre del usuario
            .password("{noop}123")//noop es para que no se encripte la contraseña
            .roles("ADMIN", "USER")
                .and()
            .withUser("tutor1")
            .password("{noop}123")
            .roles("TUTOR")
                .and()
            .withUser("tutor2")
            .password("{noop}123")
            .roles("TUTOR")  
                .and()
            .withUser("user")
            .password("{noop}123")
            .roles("USER")
        ;
    }*/

}