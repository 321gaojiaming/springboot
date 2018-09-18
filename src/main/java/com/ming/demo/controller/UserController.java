package com.ming.demo.controller;

import com.ming.demo.dao.UserMapper;
import com.ming.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserMapper userMapper;


   /* @RequestMapping(value = "/login")
    public  ModelAndView login(String username, String password, HttpSession session, Model model)
    {
        System.out.println(username+"密码"+password);
        ModelAndView mv;
        User user=userMapper.selectUserByUserNameAndPassword(username,password);
        if (user!=null)
        {
            session.setAttribute("user",user);
            model.addAttribute("user",user);
            mv = new ModelAndView("user/index");
        }
        else {
            mv = new ModelAndView("login");
        }
        return mv;
    }*/
   @RequestMapping(value = "/login")
    public List<User> login(String username, String password)
    {
        System.out.println(username+"密码"+password);
        List<User> user=userMapper.selectUserByUserNameAndPassword(username,password);
        return user;
    }

    @RequestMapping(value = {"/login.html"},method = RequestMethod.GET)
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @RequestMapping(value = {"/index"},method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("user/index");
        return mv;
    }

}
