package com.aaa.shiro;

import com.aaa.entity.User;
import com.aaa.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import javax.security.sasl.AuthorizeCallback;

public class UserRealm extends AuthorizingRealm {


    /**
     * 执行授权逻辑
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行授权逻辑");
        return null;
    }

    /***
     * 执行认证逻辑
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Resource
    UserMapper userMapper;



    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        
        //编写shiro判断逻辑，判断用户名和密码
        //1.判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken)arg0;
        System.out.println(token.getUsername()+"-------------");

        User user = userMapper.findByName(token.getUsername());
        System.out.println(user);
        if(user==null){
            //用户名不存在
            return null;//shiro底层会抛出UnKnowAccountException
        }

        //2.判断密码
        return new SimpleAuthenticationInfo("",user.getPassword(),"");
    }



}
