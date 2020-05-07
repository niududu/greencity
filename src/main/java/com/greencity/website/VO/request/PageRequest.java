package com.greencity.website.VO.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description:
 * @Author: LiuZW
 * @CreateDate: 2020/4/25 21:01
 * @Version: 1.0
 */
@ApiModel
@Data
public class PageRequest {
    @ApiModelProperty(value = "当前页",required = true,example = "1")
    private Integer currentPage;
    @ApiModelProperty(value = "页容量",required = true,example = "10")
    private Integer pageSize;
}
