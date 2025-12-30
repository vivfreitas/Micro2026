package org.com.programming.application.service.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET_KEY = "";

    public String extractUserName(String tokenUsuario){
        return extractInformationClaim(tokenUsuario, Claims::getSubject);
    }

    public<T> T extractInformationClaim(String token, Function<Claims, T> claimsTFunction){
        final Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }
    // Fazer a geração do token (gerarToken)
    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }
    public String generateToken(Map<String, Objects> extractClaim, UserDetails userDetails){
        return Jwts.builder()
                .setClaims(extractClaim)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date((System.currentTimeMillis() + 1000 * 60 * 24)))
                .signWith(sign(), SignatureAlgorithm.HS256)
                .compact();
    }
    // Fazer a verificação do token (seTokenEvalido - seTokenEvalido)
    public boolean ifTokenValid(String token, UserDetails userDetails){
        final String username = extractUserName(token);
        return (username.equals(userDetails.getUsername()) && !ifTokenExpiration(token));
    }
    public boolean ifTokenExpiration(String token){
        return extractExpiration(token).before(new Date());
    }
    // Verificar a expiraão do token (extrairExpiracao)
    public Date extractExpiration(String token){
        return extractInformationClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(sign())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key sign(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
