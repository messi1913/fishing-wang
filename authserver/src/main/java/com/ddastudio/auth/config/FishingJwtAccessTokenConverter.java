package com.ddastudio.auth.config;//package com.ddastudio.auth.config;
//
//import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
//import org.springframework.security.oauth2.common.OAuth2AccessToken;
//import org.springframework.security.oauth2.provider.OAuth2Authentication;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.HashMap;
//import java.util.Map;
//
//public class FishingJwtAccessTokenConverter extends JwtAccessTokenConverter {
//
//    @Override
//    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
//        Map<String, Object> addInfo = new HashMap<>();
//        String currentTime = LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE);
//        addInfo.put("expired_time", currentTime);
//
//        // Write it to the token
//        ((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(addInfo);
//        // Encode Token to JWT
//        String encoded = super.encode(accessToken, authentication);
//
//        // Set JWT as value of the token
//        ((DefaultOAuth2AccessToken) accessToken).setValue(encoded);
//
////        return accessToken;
//        return super.enhance(accessToken, authentication);
//    }
//}
