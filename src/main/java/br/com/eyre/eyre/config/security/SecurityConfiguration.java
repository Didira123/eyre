package br.com.eyre.eyre.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.eyre.eyre.repository.UsuarioRepository;
import br.com.eyre.eyre.service.UsuarioService;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private TokenService tokenService;
//	@Autowired
//	private AuthenticationProvider authenticationProvider;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

//	@Bean
//	protected AuthenticationManager authentication(AuthenticationManagerBuilder auth) throws Exception {
//		return auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder()).and().build();
//	}

	// Sobreescrita do DaoAuthenticationProvider Padrão do Spring (o código
	// comentado acima fazia a alteração do existente, o que causava o erro de
	// "OBJECT ALREADY BUILT")
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider dap = new DaoAuthenticationProvider();
		dap.setUserDetailsService(usuarioService);
		dap.setPasswordEncoder(passwordEncoder());
		return dap;
	}

	// A Aplicação não faz a injeção desta dependência de forma automática, sendo
	// necessário adquirí-la assim
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				(authz) -> authz.requestMatchers("/auth/", "/actuator/**").permitAll().anyRequest().authenticated())
				.csrf(csrf -> csrf.disable())
				.sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, usuarioRepository),
						UsernamePasswordAuthenticationFilter.class);
//            .httpBasic(withDefaults());
		return http.build();
	}

	// Terá aparentemente o mesmo efeito de fazer "requestMatchers(...).permitAll()"
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**"); //"/swagger-ui.html" é uma URL que faz parte de "/**.html"
    }

	// LDAP AUTHENTICATION
//    @Bean
//    public EmbeddedLdapServerContextSourceFactoryBean contextSourceFactoryBean() {
//        EmbeddedLdapServerContextSourceFactoryBean contextSourceFactoryBean =
//            EmbeddedLdapServerContextSourceFactoryBean.fromEmbeddedLdapServer();
//        contextSourceFactoryBean.setPort(0);
//        return contextSourceFactoryBean;
//    }
//
//    @Bean
//    public AuthenticationManager ldapAuthenticationManager(
//            BaseLdapPathContextSource contextSource) {
//        LdapBindAuthenticationManagerFactory factory = 
//            new LdapBindAuthenticationManagerFactory(contextSource);
//        factory.setUserDnPatterns("uid={0},ou=people");
//        factory.setUserDetailsContextMapper(new PersonContextMapper());
//        return factory.createAuthenticationManager();
//    }

	// JDBC Authentication com SINGLE USER
//    @Bean
//    public DataSource dataSource() {
//        return new EmbeddedDatabaseBuilder()
//            .setType(EmbeddedDatabaseType.H2)
//            .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
//            .build();
//    }
//
//    @Bean
//    public UserDetailsManager users(DataSource dataSource) {
//    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
//        UserDetails user = User.withDefaultPasswordEncoder()
//            .username("user")
//            .password(encoder.encode("myPassword"))
//            .roles("USER")
//            .build();
//        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//        users.createUser(user);
//        return users;
//    }

	// In-Memory Authentication
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
//        UserDetails user = User.withDefaultPasswordEncoder()
//            .username("user")
//            .password(encoder.encode("myPassword"))
//            .roles("USER")
//            .build();
//        return new InMemoryUserDetailsManager(user);
//    }

}
