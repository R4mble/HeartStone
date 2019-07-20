package com.tiantianchat.config;

import com.tiantianchat.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

/**
 *
 */
@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    private final PlayerRepository playerRepository;

    private final JwtService jwtService;

    @Autowired
    public JwtTokenFilter(PlayerRepository playerRepository, JwtService jwtService) {
        this.playerRepository = playerRepository;
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        if ("OPTION".equals(request.getMethod())) {
            return;
        }

        String header = "Authorization";
        String token = request.getHeader(header);
        if (token != null){
            String id = jwtService.getSubFromToken(token);
            if (id != null) {
                if (SecurityContextHolder.getContext().getAuthentication() == null) {
                    playerRepository.findById(Long.valueOf(id)).ifPresent(user -> {
                        UsernamePasswordAuthenticationToken authenticationToken =
                                new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
                        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    });
                }
            }

        }

        filterChain.doFilter(request, response);
    }

    private Optional<String> getTokenString(String header) {
        return Optional.ofNullable(header);
    }
}
