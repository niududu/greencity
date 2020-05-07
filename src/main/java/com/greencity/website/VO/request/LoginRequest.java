package com.greencity.website.VO.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description:
 * @Author: LiuZW
 * @CreateDate: 2020/4/21 23:49
 * @Version: 1.0
 */
@Data
@ApiModel
public class LoginRequest {
    @ApiModelProperty(value = "账号",required = true)
    private String account;
    @ApiModelProperty(value = "密码",required = true)
    private String password;
}
