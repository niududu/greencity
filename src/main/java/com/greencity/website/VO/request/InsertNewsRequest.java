package com.greencity.website.VO.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description:
 * @Author: LiuZW
 * @CreateDate: 2020/4/25 23:40
 * @Version: 1.0
 */
@Data
@ApiModel
public class InsertNewsRequest {
    @ApiModelProperty(value = "新闻标题",required = true)
    private String title;
    @ApiModelProperty(value = "新闻简介",required = true)
    private String brief;
    @ApiModelProperty(value = "新闻内容",required = true)
    private String content;
    @ApiModelProperty(value = "作者",required = true)
    private String author;
    @ApiModelProperty(value = "新闻图片",required = true)
    private String url;

}
