package com.bjsxt.ego.rpc.service;

import com.bjsxt.domain.EgoResult;
import com.bjsxt.ego.pojo.TbUser;

public interface UserService {

    public EgoResult loadUserInfoService(String param, Integer type);

    /**
     * 完成用户注册
     * @param tbUser
     * @return
     */
    public EgoResult saveUserRegister(TbUser tbUser);

    /**
     * 验证用户身份
     * @param tbUser
     * @return
     */
    public EgoResult selectUserService(TbUser tbUser);

    /**
     * 验证用户登录状态
     * @param token
     * @return
     */
    public EgoResult loadUserByToken(String token);

    /**
     * 删除用户登录状态
     * @param token
     * @return
     */
    public EgoResult deleteUserState(String token);
}
