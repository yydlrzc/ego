package com.bjsxt.ego.sso.service;

import com.bjsxt.domain.EgoResult;
import com.bjsxt.ego.pojo.TbUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SsoUserService {

    public EgoResult loadUserExist(String param, Integer type);

    /**
     * 完成用户注册
     * @param tbUser
     * @return
     */
    public EgoResult saveUserRegisterService(TbUser tbUser);

    /**
     * 完成用户信息验证
     * @param tbUser
     * @return
     */
    public EgoResult loadUserLoginService(TbUser tbUser, HttpServletRequest request, HttpServletResponse response);

    /**
     * 获得用户登录状态
     * @param token
     * @return
     */
    public EgoResult loadUserLoginStateService(String token);

    /**
     * 删除用户登录状态
     * @param token
     * @return
     */
    public EgoResult deleteUserStateService(String token);
}
