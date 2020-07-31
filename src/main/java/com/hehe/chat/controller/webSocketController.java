package com.hehe.chat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class webSocketController {


    /**
     * 登陆界面
     */
    @GetMapping("/")
    public ModelAndView login() {
        return new ModelAndView("/login");
    }

    /**
     * 聊天界面
     */
    @GetMapping("/index")
    public ModelAndView index(String username, String password, HttpServletRequest request) throws UnknownHostException {
        if (StringUtils.isEmpty(username)) {
            username = "匿名用户";
        }
/*        if (webSocketChatServer.getUser(username)) {
            throw new DefinitionException(400,"用户名已存在");
        }*/
        ModelAndView mav = new ModelAndView("/chat");
        mav.addObject("username", username);
        mav.addObject("webSocketUrl", "ws://" + InetAddress.getLocalHost().getHostAddress() + ":" + request.getServerPort() + request.getContextPath() + "/chat" + "/" + username);
        return mav;
    }

}
