package com.greencity.website.exception;

import com.greencity.website.enums.ResultEnum;
import lombok.Getter;

/**
 * @Description:
 * @Author: LiuZW
 * @CreateDate: 2020/1/8/008 17:27
 * @Version: 1.0
 */
@Getter
public class WebSiteException extends RuntimeException {

    private Integer code;

    public WebSiteException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public WebSiteException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
