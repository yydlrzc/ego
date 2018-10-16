package com.bjsxt.ego.sso.service.impl;

import com.bjsxt.domain.EgoResult;
import com.bjsxt.ego.pojo.TbUser;
import com.bjsxt.ego.rpc.service.UserService;
import com.bjsxt.ego.sso.service.SsoUserService;
import com.bjsxt.utils.CookieUtils;
import com.bjsxt.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Service
public class SsoUserServiceImpl implements SsoUserService {

    @Autowired
    private UserService userServiceProxy;
    @Override
    public EgoResult loadUserExist(String param, Integer type) {
        return userServiceProxy.loadUserInfoService(param,type);
    }

    @Override
    public EgoResult saveUserRegisterService(TbUser tbUser) {
        Date date = new Date();
        tbUser.setCreated(date);
        tbUser.setUpdated(date);

        Long id = IDUtils.genItemId();
        tbUser.setId(id);

        String password = tbUser.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        tbUser.setPassword(password);
        return userServiceProxy.saveUserRegister(tbUser);
    }

    @Override
    public EgoResult loadUserLoginService(TbUser tbUser, HttpServletRequest request, HttpServletResponse response) {
        EgoResult egoResult = userServiceProxy.selectUserService(tbUser);
        CookieUtils.setCookie(request, response, "sso_token", egoResult.getData().toString());
        return egoResult;
    }

    @Override
    public EgoResult loadUserLoginStateService(String token) {
        return userServiceProxy.loadUserByToken(token);
    }

    @Override
    public EgoResult deleteUserStateService(String token) {
        return userServiceProxy.deleteUserState(token);
    }
}
