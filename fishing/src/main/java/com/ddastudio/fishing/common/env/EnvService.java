package com.ddastudio.fishing.common.env;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019-08-13
 */
@Service
@RequiredArgsConstructor
public class EnvService {

    private final EnvDAO envDAO;

    public String getProperty(String key) {
        return this.getProperty(key, "");
    }

    public String getProperty(String key, String defaultValue ) {
        return envDAO.getProperty(key).orElse(defaultValue);
    }
}
