package test.projet.security;


import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }
     
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/").hasAnyAuthority("DEV")
            .antMatchers("/listeCl").hasAnyAuthority("CLIENT")
            .antMatchers("/add").hasAnyAuthority("CLIENT")
            .antMatchers("/redirection").hasAnyAuthority("ADMIN")
            .antMatchers("/select").hasAnyAuthority("ADMIN")
            .antMatchers("/listeAdmin").hasAnyAuthority("ADMIN")
            .antMatchers("/aff").hasAnyAuthority("ADMIN")
            .antMatchers("/add").hasAnyAuthority("DEV")
            .antMatchers("/edit/**").hasAnyAuthority("CLIENT")
            .antMatchers("/editt/**").hasAnyAuthority("DEV")
            .antMatchers("/delete/**").hasAnyAuthority("CLIENT")
            .anyRequest().authenticated()
            .and()
            .formLogin().defaultSuccessUrl("/success", true)
            .and()
            .logout().permitAll()
            .and()
            .exceptionHandling().accessDeniedPage("/403")
            ;
    }
}
