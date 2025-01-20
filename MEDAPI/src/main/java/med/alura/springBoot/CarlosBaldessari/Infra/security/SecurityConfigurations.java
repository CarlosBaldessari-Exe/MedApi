package med.alura.springBoot.CarlosBaldessari.Infra.security;

import med.alura.springBoot.CarlosBaldessari.security.SecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
//public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
//
//    return HttpSecurity.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//        .and().build();

    //ESTE CODIGO QUE NO ESTA COMENTADO ES LA VERSION DESPUES DE LA
    // VERSION 3.1

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return
        http.csrf(csrf -> csrf.disable())
        .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(req -> {
            req.requestMatchers("/login").permitAll();
            req.anyRequest().authenticated();
        })
    .build();
}
      // BEAN SIRVE PARA EXPORTAR UNA CLSE PARA SPRING
            //HACIENDO QUE EL CONSIGA CARGARLO Y REALICE LA INJECCION DE DEPENDENCIAS
            //EN OTRAS CLASES
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

