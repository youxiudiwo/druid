package com.zuoshao.gmall.service;

import com.zuoshao.gmall.bean.UserInfo;

import java.util.List;

/**
 * @author zuoshao
 * @date 2019/5/11 - 16:34
 */
public interface UserService {
    public List<UserInfo> userInfoList();
    public UserInfo userone(UserInfo userInfo);
}
