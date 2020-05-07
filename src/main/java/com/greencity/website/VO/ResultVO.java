package com.greencity.website.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: LiuZW
 * @CreateDate: 2020/1/3/003 16:48
 * @Version: 1.0
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 8848731630266574133L;

    private Integer code;

    private String msg;

    private T data;
}
