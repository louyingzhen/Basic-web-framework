package org.smart4j.framework.plugin;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.smart4j.framework.util.CodecUtil;

public class Md5CredentialsMatcher implements CredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        //获取从表单提交过来的密码、明文，尚未通过MD5加密
        String submitted = String.valueOf(((UsernamePasswordToken) token).getPassword());
        //获取数据库中存储的密码，已通过MD5加密
        String encrypted = String.valueOf(info.getCredentials());
        return CodecUtil.md5(submitted).equals(encrypted);
    }
}
