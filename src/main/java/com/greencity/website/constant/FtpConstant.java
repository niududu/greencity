package com.greencity.website.constant;

import lombok.Data;

/**
 * @Description:
 * @Author: LiuZW
 * @CreateDate: 2020/4/27 23:52
 * @Version: 1.0
 */
@Data
public class FtpConstant {
    //ip地址
    private String ipAddr = "120.25.120.159";
    //端口号
    private Integer port = 22;
    //用户名
    private String userName ="root";
    //密码
    private String pwd ="DJS@2019tts";
    //aaa路径
    private String path ="/redsun/website/html";

    public static String baseUrl = "http://120.25.120.159/html/";


}
