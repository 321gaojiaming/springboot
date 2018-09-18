package com.ming.demo.controller;

import com.ming.demo.dao.UserMapper;
import com.ming.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserMapper userMapper;


    @RequestMapping(value = "/login")
    public  String login(String username, String password, HttpSession session, Model model)
    {
        System.out.println(username+"密码"+password);
        User user=userMapper.selectUserByUserNameAndPassword(username,password);
        if (user!=null)
        {
            session.setAttribute("user",user);
            model.addAttribute("user",user);
            return "user/index";
        }
        return "login";
    }


    @RequestMapping(value = "/test")
    public User test(){
        //User user=userMapper.selectUserByUserName("admin");
        User user=userMapper.selectUserByUserNameAndPassword("admin","admin");
        return  user;
    }
    @RequestMapping(value = {"/login.html"},method = RequestMethod.GET)
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @RequestMapping(value = {"/index"},method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

}
