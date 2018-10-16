package com.bjsxt.ego.rpc.service.impl;

import com.bjsxt.domain.EgoResult;
import com.bjsxt.ego.mapper.TbUserMapper;
import com.bjsxt.ego.pojo.TbUser;
import com.bjsxt.ego.pojo.TbUserExample;
import com.bjsxt.ego.pojo.TbUserExample.Criteria;
import com.bjsxt.ego.rpc.service.UserService;
import com.bjsxt.utils.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserMapper tbUserMapper;

    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public EgoResult loadUserInfoService(String param, Integer type) {

        TbUserExample example = new TbUserExample();

        Criteria c = example.createCriteria();
        EgoResult egoResult = new EgoResult();
        egoResult.setStatus(200);
        switch (type) {
            case 1:
                c.andUsernameEqualTo(param);
                break;
            case 2:
                c.andPhoneEqualTo(param);
                break;
            case 3:
                c.andEmailEqualTo(param);
                break;
            default:
                egoResult.setMsg("系统错误");
                egoResult.setData(false);
                return egoResult;
        }

        List<TbUser> list = tbUserMapper.selectByExample(example);

        if (list != null && list.size() > 0) {
            egoResult.setData(false);
            egoResult.setMsg("error");
        } else {
            egoResult.setData(true);
            egoResult.setMsg("ok");
        }

        return egoResult;
    }

    @Override
    public EgoResult saveUserRegister(TbUser tbUser) {
        EgoResult result = new EgoResult();
        try {
            tbUserMapper.insert(tbUser);
            result.setStatus(200);
            result.setMsg("ok");
        } catch(Exception ex) {
            ex.printStackTrace();
            result.setStatus(400);
            result.setMsg("注册失败,请校验数据后再次提交");
        }
        return result;
    }

    @Override
    public EgoResult selectUserService(TbUser tbUser) {

        TbUserExample example = new TbUserExample();

        Criteria c = example.createCriteria();

        String username=tbUser.getUsername();
        //StringUtils类是apache提供的工具组件
        if(!StringUtils.isBlank(username)){
            c.andUsernameEqualTo(username);
        }
        String phone=tbUser.getPhone();
        if(!StringUtils.isBlank(phone)){
            c.andPhoneEqualTo(phone);
        }
        String email=tbUser.getEmail();
        if(!StringUtils.isBlank(email)){
            c.andEmailEqualTo(email);
        }

        EgoResult result = new EgoResult();

        List<TbUser> users = tbUserMapper.selectByExample(example);

        if (users != null && users.size() == 1) {
            String password = tbUser.getPassword();
            password = DigestUtils.md5DigestAsHex(password.getBytes());

            TbUser user = users.get(0);
            if (password.equals(user.getPassword())) {
                String token = UUID.randomUUID().toString();

                redisTemplate.execute(new RedisCallback() {
                    @Override
                    public Object doInRedis(RedisConnection connection) throws DataAccessException {
                        byte[] key = ObjectUtils.objToByte(token);
                        byte[] value = ObjectUtils.objToByte(user);
                        connection.set(key, value);
                        Long seconds = 1800L;
                        connection.expire(key, seconds);
                        return null;
                    }
                });
                result.setStatus(200);
                result.setMsg("ok");
                result.setData(token);
                return result;
            }
        }
        result.setStatus(400);
        result.setMsg("用户名或密码错误");
        result.setData(null);
        return result;
    }

    @Override
    public EgoResult loadUserByToken(String token) {
        EgoResult egoResult = new EgoResult();
        redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {

                byte[] key = ObjectUtils.objToByte(token);

                byte[] bytes = redisConnection.get(key);
                if (bytes != null) {
                    TbUser user = ObjectUtils.byteToObj(bytes, TbUser.class);
                    Long seconds = 1800L;
                    redisConnection.expire(key, seconds);
                    egoResult.setStatus(200);
                    egoResult.setData(user);
                    egoResult.setMsg("ok");
                } else {
                    egoResult.setStatus(400);
                    egoResult.setData(null);
                    egoResult.setMsg("error");
                }

                return null;
            }
        });
        return egoResult;
    }

    @Override
    public EgoResult deleteUserState(String token) {
        EgoResult egoResult = new EgoResult();
        redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] key = ObjectUtils.objToByte(token);
                Long num = redisConnection.hDel(key);

                if (num > 0) {
                    egoResult.setStatus(200);
                    egoResult.setData("");
                    egoResult.setMsg("ok");
                } else {
                    egoResult.setStatus(400);
                    egoResult.setData("");
                    egoResult.setMsg("error");
                }
                return null;
            }
        });
        return egoResult;
    }
}
