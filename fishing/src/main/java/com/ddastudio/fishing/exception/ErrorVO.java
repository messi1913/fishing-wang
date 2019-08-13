package com.ddastudio.fishing.exception;

import lombok.*;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019-08-06
 */

@Builder
@AllArgsConstructor @NoArgsConstructor
@Data
public class ErrorVO {

    private int code;
    private String message;
}
