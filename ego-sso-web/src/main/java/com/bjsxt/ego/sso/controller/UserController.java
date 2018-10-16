package com.bjsxt.ego.sso.controller;

import com.bjsxt.domain.EgoResult;
import com.bjsxt.ego.pojo.TbUser;
import com.bjsxt.ego.sso.service.SsoUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    private SsoUserService ssoUserService;

    @RequestMapping(value = "/user/check/{param}/{type}",method = RequestMethod.GET)
    @ResponseBody
    public EgoResult userCheck(@PathVariable String param, @PathVariable Integer type, @RequestParam(required = false) String callback) {
        return ssoUserService.loadUserExist(param, type);
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    @ResponseBody
    public EgoResult userRegister(TbUser tbUser) {
        return ssoUserService.saveUserRegisterService(tbUser);
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @ResponseBody
    public EgoResult userLogin(TbUser tbUser, HttpServletRequest request, HttpServletResponse response) {
        return ssoUserService.loadUserLoginService(tbUser,request,response);
    }

    @RequestMapping(value = "/user/token/{token}", method = RequestMethod.GET)
    @ResponseBody
    public EgoResult userLogin(@PathVariable String token, @RequestParam(required = false) String callback) {
        return ssoUserService.loadUserLoginStateService(token);
    }

    @RequestMapping(value = "/user/logout/{token}", method = RequestMethod.GET)
    @ResponseBody
    public MappingJacksonValue userLogout(@PathVariable String token, @RequestParam(required = false) String callback) {
        EgoResult egoResult = ssoUserService.deleteUserStateService(token);
        MappingJacksonValue val = new MappingJacksonValue(egoResult);
        if (!StringUtils.isBlank(callback)) {
            val.setJsonpFunction(callback);
        }
        return val;
    }
}
