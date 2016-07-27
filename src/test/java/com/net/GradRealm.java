package com.net;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha1Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class GradRealm extends AuthorizingRealm {
	private SecurityApplication securityApplication = new SecurityApplicationImpl();
	 
    public GradRealm() {
         super();
         //设置认证token的实现类
         setAuthenticationTokenClass(UsernamePasswordToken.class);
         //设置加密算法
         setCredentialsMatcher(new HashedCredentialsMatcher(Sha1Hash.ALGORITHM_NAME));
         
    }
    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
         String loginName = (String) principalCollection.fromRealm(getName()).iterator().next();
         User user = securityApplication.findby(loginName);
         if (null == user) {
              return null;
         } else {
              SimpleAuthorizationInfo result = new SimpleAuthorizationInfo();
              
              result.addRoles(UserRoles.findRoleNamesOf(user));
              for (Role role : UserRoles.findRolesOf(user)) {
                   result.addStringPermissions(role.getPermissions());
              }
              
              return result;

         }
    }

    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
         UsernamePasswordToken upToken = (UsernamePasswordToken) token;
         User user = securityApplication.findby(upToken.getUsername());
         if (user != null) {
              return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
         }
         return null;
    }
}
