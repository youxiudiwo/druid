package com.zuoshao.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zuoshao.gmall.bean.UserInfo;
import com.zuoshao.gmall.service.UserService;
import org.apache.http.HttpResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zuoshao
 * @date 2019/5/11 - 15:35
 */
@Controller
public class UserController {
    //远程调用
    @Reference
    UserService userservice;

    @RequestMapping("/userlist")
    public ResponseEntity<List<UserInfo>> listuser(){
        List<UserInfo> list=userservice.userInfoList();
        return ResponseEntity.ok(list);
    }

    @RequestMapping("/login")
    public String longin(){
        return "succse";
    }

    @RequestMapping("/logins")
    @ResponseBody
    public UserInfo logins(@Param("username") String username, @Param("password") String password, HttpSession session){

        System.out.println(username+password);
        if (password!=null){
            session.setAttribute("ags","验证完成");
            UserInfo user=new UserInfo();
            user.setUserName(username);
            user.setUserPassword(password);
            UserInfo user2=userservice.userone(user);
            System.out.println(user2);
            return user2;
        }
        UserInfo user3=new UserInfo();
        return user3;
    }
}
