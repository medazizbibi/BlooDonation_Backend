package insat.bibiboussaid.bloodonation.Security;

import com.sun.org.apache.bcel.internal.generic.GETFIELD;
import insat.bibiboussaid.bloodonation.Domain.JwtAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

    public JwtAuthenticationTokenFilter() {
        super("/Donors/**");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {

        String header = httpServletRequest.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            throw new RuntimeException("JWT token is missing");
        }
        String authenticationToken = header.substring(7);
        JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);

        return getAuthenticationManager().authenticate(token);
    }

    /*public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    public void setAuthenticationSuccessHandler(JwtSuccessHandel authenticationSuccessHandler) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }*/

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }
}