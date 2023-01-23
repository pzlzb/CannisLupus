package com.canislupus.CanisLupus.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//https://stackoverflow.com/questions/41480102/how-spring-security-filter-chain-works
@Configuration
@EnableWebSecurity
public class SecurityConfig  {//WebSecurityConfigurerAdapter

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
    //https://stackoverflow.com/questions/65296773/thymeleaf-extras-security-doesnt-work-with-spring-security
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                .csrf().disable()
                .authorizeHttpRequests()
                 .requestMatchers("/**").permitAll()
                // .requestMatchers("/login").permitAll()
                // .requestMatchers("/registry").permitAll()
                .requestMatchers("/").hasAnyRole("ADMINISTRATOR","TUTOR","STUDENT")
                // .and()
				// .formLogin().loginPage("/login").permitAll()
                // .and()
                // .logout() .invalidateHttpSession(true) 
                // .clearAuthentication(true) .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/errores/403")
                .and().build();
		        //@formatter:on

        // return http.csrf().disable().authorizeHttpRequests()
        //         .requestMatchers("/").permitAll()
        //         .requestMatchers("/").hasAnyRole("ADMINISTRATOR","TUTOR","STUDENT")
        //         //.requestantMatchers("/cl/admin/**").hasRole("ADMINISTRATOR")
        //         //.requestantMatchers("/cl/student/**").hasRole("STUDENT")
        //         //.requestantMatchers("/cl/tutor/**").hasRole("TUTOR")
        //         .and()
        //         .formLogin()
        //         .loginPage("/login")
        //         .and()
        //         .exceptionHandling().accessDeniedPage("/errores/403")
        //         .and().build();
    }

    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //     http.authorizeRequests().antMatchers("/resources/**", "/static/**", "/public/**").permitAll()
    //             .antMatchers("/", "/signin/", "/signup","/**").permitAll()
    //             .antMatchers("/admin/**").hasRole("ADMIN")
    //             .antMatchers("/user/**")
    //             .hasAnyRole("USER", "ADMIN")
    //             .anyRequest().authenticated().and().sessionManagement()
    //             .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    //                 .and().formLogin().loginPage("/signin").defaultSuccessUrl("/")
    //                 .usernameParameter("email").passwordParameter("password")
    //                 .permitAll()
    //                 .defaultSuccessUrl("/",true)
    //             .and().logout().logoutSuccessUrl("/")
    //             .logoutRequestMatcher(new AntPathRequestMatcher("/home/logout"));
    //     http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    // }

   /*@Bean
    //@Order(1)
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
            //.csrf().disable()
            .authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
            .and().logout().permitAll()
            //.authorizeRequests().antMatchers("/cl/admin").hasRole("ADMIN")            
            .and().httpBasic();
        return http.build();
    } */ 
    // @Bean                                                            
	// public SecurityFilterChain formLoginFilterChain(HttpSecurity http) throws Exception {
	// 	http.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated()).formLogin();
	// 	return http.build();
	// }

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