package configuration.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfiguration {

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationProvider authenticationProvider;



    @Autowired
    @Qualifier("customAuthenticationEntryPoint")
    AuthenticationEntryPoint authEntryPoint;
    private final String path = "/api/v1/auth";
    private final String[] AUTH_WHITELIST = {
            path +"/signin/**", path + "/forgot-password", path + "/reset-password",
            path + "/register", path + "/verify-code", path + "/references",
           "/v3/api-docs/**",  "/configuration/**",   "/swagger*/**", "/api/v1/wallet/transaction-webhook",
            "/swagger-ui/**",  "/webjars/**", "/api/v1/bills/verify-account",

            path + "/register", path + "/verify-code", path + "/references",
            path + "/forgot-password/**",
            path + "/reset-password/**",
            path + "/verify-token/**",
            path + "/sign-up",
            "/api/v1/transfers/bank/response",
            path + "/verify-link"
    };

    private final JwtAuthFilter jwtAuthFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .cors().and()
                .csrf().disable()
                .authorizeRequests()
                .requestMatchers(AUTH_WHITELIST).permitAll()
                .anyRequest()
                .authenticated()
                .and().exceptionHandling().authenticationEntryPoint(authEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration
    ) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
