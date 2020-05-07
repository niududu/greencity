package com.greencity.website.exception;

import com.greencity.website.enums.ResultEnum;
import lombok.Getter;

/**
 * @Description:
 * @Author: LiuZW
 * @CreateDate: 2020/4/10 16:46
 * @Version: 1.0
 */
@Getter
public class AuthorizeException extends RuntimeException {
    private Integer code;

    public AuthorizeException() {

    }
    public AuthorizeException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public AuthorizeException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
