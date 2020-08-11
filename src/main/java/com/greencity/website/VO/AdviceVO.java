package com.greencity.website.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @Description:
 * @Author: LiuZW
 * @CreateDate: 2020/5/8 14:20
 * @Version: 1.0
 */
@Data
public class AdviceVO {

    private Integer id;
    /**
     * 客户名称
     */
    private String name;
    /**
     * 客户手机
     */
    private String mobile;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 反馈意见
     */
    private String detail;
    /**
     * 反馈时间
     */
    private String date;

}
