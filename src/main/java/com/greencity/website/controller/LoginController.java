package com.greencity.website.controller;

import com.alibaba.fastjson.JSONObject;
import com.greencity.website.VO.request.LoginRequest;
import com.greencity.website.VO.ResultVO;
import com.greencity.website.enums.ResultEnum;
import com.greencity.website.service.LoginService;
import com.greencity.website.util.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.Serializable;

/**
 * @Description:
 * @Author: LiuZW
 * @CreateDate: 2020/4/10 23:25
 * @Version: 1.0
 */
@Api(tags = "登录模块API")
@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    /**
     * @MethodName: login
     * @Description: 用户登录
     * @Param: [request]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/22 0:29
     **/
    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public ResultVO login(LoginRequest request) {

        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken =
                new UsernamePasswordToken(request.getAccount(), request.getPassword());
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
            Serializable id = subject.getSession().getId();
            JSONObject jsonResult = new JSONObject();
            jsonResult.put("JSESSIONID",id);
            return ResultVOUtil.success(jsonResult);
        } catch (IncorrectCredentialsException e) {
            return ResultVOUtil.error(ResultEnum.PASSWORD_ERROR);
        } catch (AuthenticationException e) {
            return ResultVOUtil.error(ResultEnum.USER_NOT_EXIST);
        } catch (AuthorizationException e) {
            return ResultVOUtil.error(ResultEnum.NO_PERMISSION);
        }
    }

    /**
     * @MethodName: logout
     * @Description: 登出操作
     * @Param: []
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/22 22:42
     **/
    @GetMapping("/logout")
    @ApiOperation(value = "用户登出")
    public ResultVO logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResultVOUtil.success();
    }

    @GetMapping("/check")
    @ApiOperation(value = "用户校验")
    public ResultVO checkLogin() {
        Subject subject = SecurityUtils.getSubject();
        boolean authenticated = subject.isAuthenticated();
        return ResultVOUtil.success(authenticated);
    }

    /**
     * @MethodName: index
     * @Description: 测试
     * @Param: []
     * @Return: java.lang.String
     * @Author: LiuZW
     * @Date: 2020/4/11 16:27
     **/
    //@RequiresRoles("admin")
    @GetMapping("/index")
    public String index() {

        return "index!";
    }

    /**
     * @MethodName: changePassword
     * @Description: 修改密码
     * @Param: [oldPassword, newPassword]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/4/29 23:39
     **/
    @PostMapping("/changePassword")
    @ApiOperation(value = "修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "oldPassword", value = "旧密码", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "newPassword", value = "新密码", required = true, paramType = "query", dataType = "String"),
    })
    public ResultVO changePassword(String oldPassword,String newPassword) {

        return loginService.changePassword(oldPassword,newPassword);
    }

    /**
     * @MethodName: upload
     * @Description: 上传接口
     * @Param: [file]
     * @Return: com.greencity.website.VO.ResultVO
     * @Author: LiuZW
     * @Date: 2020/5/1 16:44
     **/
    @PostMapping(value = "/upload", headers = "content-type=multipart/form-data")
    @ApiOperation(value = "图片上传返回URL", notes = "图片上传返回URL")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", required = true, value = "图片信息", dataType = "file", paramType = "form"),
    })
    public ResultVO upload(@RequestParam(value = "file") MultipartFile file) throws Exception {

        return loginService.upload(file);
    }


}
