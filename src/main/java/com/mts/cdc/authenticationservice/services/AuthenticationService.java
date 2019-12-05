package com.mts.cdc.authenticationservice.services;

import com.mts.cdc.authenticationservice.entity.User;
import com.mts.cdc.authenticationservice.payload.AuthenticationPayload;
import com.mts.cdc.authenticationservice.payload.LoginResponse;
import com.mts.cdc.authenticationservice.payload.TokenPayload;
import com.mts.cdc.authenticationservice.repository.UserRepository;
import com.mts.cdc.authenticationservice.security.jwt.JwtTokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import java.util.List;


@Service
@Slf4j
public class AuthenticationService {


    private UserRepository userRepository;
    private AuthenticationProvider authenticationProvider;
    private JwtTokenProvider jwtTokenProvider;

    public AuthenticationService(UserRepository userRepository, AuthenticationProvider authenticationProvider, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.authenticationProvider = authenticationProvider;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public LoginResponse login(@Nonnull AuthenticationPayload user){

        @CheckForNull
        String username = user.getUsername();
        @CheckForNull
        String password = user.getPassword();
        String token;

        @CheckForNull
        User userLogin = userRepository.findByUsername(username);

        try {
            authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (DisabledException e) {
            throw new DisabledException("Account is disabled");
        }catch (BadCredentialsException e) {
            throw new BadCredentialsException("Bad Credentials");
        }catch(InternalAuthenticationServiceException e) {
            throw new InternalAuthenticationServiceException("Internal Authentication Service Exception");
        }
        catch (UsernameNotFoundException e){
            throw new UsernameNotFoundException("Username not found");
        }
        catch(HttpServerErrorException e) {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @CheckForNull
        List<String> roles = userLogin.getRoles();
        for(String role : roles){
            log.info("role--:"+ role);
        }

        token = jwtTokenProvider.createToken(username, roles);
        log.info("TOKEN:", token);

        return new LoginResponse(true, "You have login successfully", new TokenPayload(username, token));
    }
}
