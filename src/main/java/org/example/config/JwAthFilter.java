package org.example.config;

import lombok.RequiredArgsConstructor;
import org.example.DAO.UserDao;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
@RequiredArgsConstructor
public class JwAthFilter extends OncePerRequestFilter {

    private final UserDao userDao;
    private final JwUtils jwUtils;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        final String authHeader = request.getHeader(AUTHORIZATION);
        final String userName;
        final String jwtToken;

        if (authHeader == null || !authHeader.startsWith("Bearer")) { //dont have a bearer token
            filterChain.doFilter(request, response);
            return;
        }
        jwtToken = authHeader.substring(7);
        //userEmail = "something"; // TODO to be implemented
        userName = jwUtils.extractUsername(jwtToken);
        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null ) { //check if the user has authenticated or not
            UserDetails userDetails = userDao.findUser(userName);
            //final boolean isTokenValid; // TODO

            if(jwUtils.validateToken(jwtToken, userDetails)) {
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        System.out.println("token exist.");
        filterChain.doFilter(request, response);
    }
}
