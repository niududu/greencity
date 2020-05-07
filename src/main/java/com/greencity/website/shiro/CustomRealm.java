package com.greencity.website.shiro;

/**
 * @Description:
 * @Author: LiuZW
 * @CreateDate: 2020/4/10 23:21
 * @Version: 1.0
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.greencity.website.entity.IfoUser;
import com.greencity.website.enums.ResultEnum;
import com.greencity.website.exception.AuthorizeException;
import com.greencity.website.mapper.IfoUserMapper;
import com.greencity.website.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @Description: 自定义Realm实现
 * @Author: LiuZW
 * @CreateDate: 2020/4/11 10:39
 * @Version: 1.0
 */
@Slf4j
public class CustomRealm extends AuthorizingRealm {

    @Resource
    private LoginService loginService;
    @Resource
    private IfoUserMapper ifoUserMapper;

    /**
     * @MethodName: doGetAuthorizationInfo
     * @Description: shiro权限配置方法
     * @Param: [principalCollection]
     * @Return: org.apache.shiro.authz.AuthorizationInfo
     * @Author: LiuZW
     * @Date: 2020/4/11 15:10
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //获取登录用户名
        /*String mobile = (String) principalCollection.getPrimaryPrincipal();
        //根据用户名去数据库查询用户信息
        UserAuthorizeVO userAuthorizeVO = loginService.getUserAuthorizeByMobile(mobile);
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        //添加角色
        simpleAuthorizationInfo.addRole(userAuthorizeVO.getRoleName());

        //添加权限
        Set<PermissionResourceVO> resourceVOSet = userAuthorizeVO.getResourceVOSet();
        for (PermissionResourceVO resourceVO : resourceVOSet) {
            simpleAuthorizationInfo.addStringPermission(resourceVO.getPermission());
        }
        return simpleAuthorizationInfo;*/
        return null;
    }

    /**
     * @MethodName: doGetAuthenticationInfo
     * @Description: 身份认证
     * @Param: [authenticationToken]
     * @Return: org.apache.shiro.authc.AuthenticationInfo
     * @Author: LiuZW
     * @Date: 2020/4/11 15:12
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
        String account = authenticationToken.getPrincipal().toString();
        QueryWrapper<IfoUser> queryWrapper = new QueryWrapper<>(new IfoUser());
        queryWrapper.getEntity().setAccount(account);
        IfoUser ifoUser = ifoUserMapper.selectOne(queryWrapper);
        if (ifoUser == null) {
            //这里返回后会报出对应异常
            log.error("shiro身份信息认证 ==》用户信息不存在");
            throw new AuthorizeException(ResultEnum.USER_NOT_EXIST);
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            // 获取盐值
            ByteSource salt = ByteSource.Util.bytes("");
            return new SimpleAuthenticationInfo(account, ifoUser.getPassword(),salt, getName());
        }
    }
}

