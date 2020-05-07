package com.greencity.website.VO.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description:
 * @Author: LiuZW
 * @CreateDate: 2020/4/25 21:39
 * @Version: 1.0
 */
@ApiModel
@Data
public class InsertCaseRequest {
    @ApiModelProperty(value = "案例类型【市政、公园、学校、绿化、保洁、其它】",required = true)
    private Integer type;
    @ApiModelProperty(value = "案例标题",required = true)
    private String title;
    @ApiModelProperty(value = "案例简介",required = true)
    private String brief;
    @ApiModelProperty(value = "案例内容",required = true)
    private String content;
    @ApiModelProperty(value = "案例图片地址",required = true)
    private String url;

}
