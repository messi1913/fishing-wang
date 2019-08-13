package com.ddastudio.fishing.bank;

        import com.ddastudio.fishing.common.AppProperties;
        import com.ddastudio.fishing.common.BaseControllerTest;
        import com.ddastudio.fishing.common.util.BeanUtil;
        import com.ddastudio.fishing.common.util.CommonUtil;
        import org.junit.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpEntity;
        import org.springframework.http.HttpMethod;
        import org.springframework.http.ResponseEntity;
        import org.springframework.security.jwt.Jwt;
        import org.springframework.security.jwt.JwtHelper;
        import org.springframework.web.client.RestTemplate;

        import java.time.LocalDateTime;
        import java.util.HashMap;
        import java.util.Map;

public class BankRestAPITest extends BaseControllerTest {

    @Autowired
    AppProperties properties;

    @Test
    public void getAuth() {

        LocalDateTime from = LocalDateTime.of(2019, 8, 6, 21, 49, 9);
        LocalDateTime to = LocalDateTime.of(2019, 8, 6, 21, 52, 9);

        System.out.println(from.plusMinutes(3).isBefore(to));

    }
}
