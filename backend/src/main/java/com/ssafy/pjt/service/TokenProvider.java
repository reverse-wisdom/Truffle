package com.ssafy.pjt.service;

import java.util.Calendar;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class TokenProvider {

	private SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // 토큰 암호화키
	private int tokenExpirationMsec = 1800000 * 2; // 만료시간 60분

	public String createToken() {

		// setExpiration 매개변수가 Date로 되어있어 LocalDateTime를 사용하지 못함
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MILLISECOND, tokenExpirationMsec);
		Date expiryDate = calendar.getTime();

		return Jwts.builder().setSubject("Truffle").setIssuedAt(now).setExpiration(expiryDate)
				.signWith(key, SignatureAlgorithm.HS256).compact();
	}

	public boolean validateToken(String authToken) throws JwtException {

		try {
			Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(authToken);
			return true;
		} catch (JwtException e) {
			e.printStackTrace();
		}
		return false;
	}
}