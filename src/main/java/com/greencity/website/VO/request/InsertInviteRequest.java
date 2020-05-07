package com.greencity.website.VO.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Description:
 * @Author: LiuZW
 * @CreateDate: 2020/4/25 23:02
 * @Version: 1.0
 */
@Data
public class InsertInviteRequest {
    @ApiModelProperty(value = "岗位名称",name = "name",required = true)
    private String jobName;
    @ApiModelProperty(value = "岗位数量",name = "number",required = true)
    private Integer jobNumber;
    @ApiModelProperty(value = "岗位要求",name = "requirement",required = true)
    private String inviteDetail;
    @ApiModelProperty(value = "发布日期",name = "time",required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;


}
