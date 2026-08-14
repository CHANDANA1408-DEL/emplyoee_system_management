package com.example.emplyoee_system_management.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	//securityFilterChain is an interface its act like chain of security like accesing github account need to put password has  well has otp that we get in email hhtp securiy is also interfce
@Bean
	 SecurityFilterChain securityfilterChain(HttpSecurity http) { 
		 http.csrf(csrf->csrf.disable()).
		 authorizeHttpRequests(auth->auth.
		 requestMatchers(HttpMethod.POST,"/users/register","/users/verify-otp").permitAll().
		 requestMatchers(HttpMethod.GET,"/employees/**").hasAnyRole("ADMIN","USER").
		 requestMatchers(HttpMethod.POST,"/employees/**").hasRole("ADMIN").
		 requestMatchers(HttpMethod.PUT,"/employees/**").hasRole("ADMIN").
		  requestMatchers(HttpMethod.DELETE,"/employees/**").hasRole("ADMIN").
		requestMatchers("/employees/**").authenticated().
		anyRequest().authenticated()).
		 httpBasic(org.springframework.security.config.Customizer.withDefaults());
		 return http.build();
	 }

@Bean 
UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
	UserDetails admin=User.withUsername("admin").password(passwordEncoder.encode("admin@123")).roles("ADMIN").build();
	UserDetails user=User.withUsername("user").password(passwordEncoder.encode("user@123")).roles("USER").build();
			
	return new InMemoryUserDetailsManager(admin,user);
	
				 		
		 
		

	}

}
