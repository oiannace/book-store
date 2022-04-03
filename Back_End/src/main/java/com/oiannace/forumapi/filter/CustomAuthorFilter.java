package com.oiannace.forumapi.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
public class CustomAuthorFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getServletPath().equals("/login")){
            filterChain.doFilter(request,response);
        }
        else{
            String authorizationHeader = request.getHeader(AUTHORIZATION);
            if((authorizationHeader != null) && (authorizationHeader.startsWith("Bearer "))){
               try{
                   String token = authorizationHeader.substring("Bearer ".length());
                   Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                   //refactor algorithm into a utility class to make it less redundant

                   //Below decodes the token given in the request header and obtains the username from the decoded token
                   JWTVerifier verifier = JWT.require(algorithm).build();
                   DecodedJWT decodedJWT = verifier.verify(token);
                   String username = decodedJWT.getSubject();

                   //Below gets the roles from the decoded token and add the roles to a collection as type SimpleGrantedAuthority
                   String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
                   Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                   stream(roles).forEach(role -> {
                       authorities.add(new SimpleGrantedAuthority(role));
                   });


                   UsernamePasswordAuthenticationToken authenToken = new UsernamePasswordAuthenticationToken(username, null, authorities);
                   SecurityContextHolder.getContext().setAuthentication(authenToken);
                   filterChain.doFilter(request, response);

               }catch (Exception exception){
                    log.error("Error loggin in: {}", exception.getMessage());
                    response.setHeader("error", exception.getMessage());
                    response.setStatus(FORBIDDEN.value());
                    //response.sendError(FORBIDDEN.value());

                   //Below send error as JSON object in the response body
                    Map<String, String> error = new HashMap<>();
                    error.put("error_message", exception.getMessage());
                    response.setContentType(APPLICATION_JSON_VALUE);
                    new ObjectMapper().writeValue(response.getOutputStream(), error);
               }
            }
            else{
                filterChain.doFilter(request, response);
            }
        }
    }
}
