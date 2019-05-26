package com.zuoshao.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zuoshao.gmall.bean.UserInfo;
import com.zuoshao.gmall.user.mapper.UserInfoMapper;
import com.zuoshao.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author zuoshao
 * @date 2019/5/11 - 15:37
 */
@Service
public class UserServiceimpl implements UserService {
    @Autowired
    UserInfoMapper usermapper;


    @Override
    public List<UserInfo> userInfoList() {
            List<UserInfo> userInfos= usermapper.selectAll();
            return userInfos;
    }

    @Override
    public UserInfo userone(UserInfo userInfo) {
        UserInfo userInfo1=usermapper.selectOne(userInfo);
        return userInfo1;
    }


}
