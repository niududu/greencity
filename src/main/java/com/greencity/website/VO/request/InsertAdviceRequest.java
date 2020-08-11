package com.greencity.website.VO.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description:
 * @Author: LiuZW
 * @CreateDate: 2020/5/8 14:25
 * @Version: 1.0
 */
@Data
@ApiModel
public class InsertAdviceRequest {
    @ApiModelProperty(value = "姓名",required = true)
    private String name;
    @ApiModelProperty(value = "电话",required = true)
    private String mobile;
    @ApiModelProperty(value = "邮箱",required = true)
    private String email;
    @ApiModelProperty(value = "反馈详情",required = true)
    private String detail;

}
