package com.greencity.website.enums;

import lombok.Getter;

/**
 * @Description:
 * @Author: LiuZW
 * @CreateDate: 2020/1/3/003 16:48
 * @Version: 1.0
 */
@Getter
public enum ResultEnum {

    SUCCESS(200, "成功"),

    PARAM_ERROR(201, "参数不正确"),

    CASE_NOT_EXIST(10, "案例信息不存在"),

    CASE_DELETE_ERROR(11, "案例状态错误,无法删除"),

    INVITE_NOT_EXIST(20, "招聘信息不存在"),

    INVITE_DELETE_ERROR(21, "招聘状态错误,无法删除"),

    NEWS_NOT_EXIST(30,"新闻信息不存在"),

    NEWS_DELETE_ERROR(31,"新闻状态错误,无法删除"),

    USER_NOT_EXIST(40, "用户不存在"),

    NO_LOGIN(300, "用户未登录"),

    LOGIN_FAIL(301, "登录失败, 登录信息不正确"),

    LOGOUT_SUCCESS(302, "登出成功"),

    NO_PERMISSION(403, "暂无权限访问"),

    PASSWORD_ERROR(306, "密码错误"),

    ERROR(500, "异常"),
    ;


    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
