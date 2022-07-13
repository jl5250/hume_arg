package cn.edu.cqu.cht.controller;

import cn.edu.cqu.cht.service.BaseService;
import cn.edu.cqu.cht.service.CourierService;
import cn.edu.cqu.cht.service.StationService;
import cn.edu.cqu.cht.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author WJL
 * @version 1.0
 * @date 创建时间：2022年5月31日 19:03
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private BaseService baseService;
    @Autowired
    private UserService userService;
    @Autowired
    private CourierService courierService;
    @Autowired
    private StationService stationService;

    //登录验证
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String check(HttpServletRequest request) {
        if (baseService.checkLogin(request.getParameter("account"), request.getParameter("password"), request.getParameter("type"))) {
            if (request.getParameter("account").equals("root")) {
                //return "base/base";
                return "root/root";
            } else if (request.getParameter("type").equals("u")) {
                String account = "u" + request.getParameter("account");
                request.getSession().setAttribute("loginuser", userService.findUserByUserId(baseService.findByAccount(account).getId()));
                return "user/user";
            } else if (request.getParameter("type").equals("s")) {
                String account = "s" + request.getParameter("account");
                if (stationService.findByStationId(baseService.findByAccount(account).getId()).getStationState() == 1) {
                    request.getSession().setAttribute("loginstation", stationService.findByStationId(baseService.findByAccount(account).getId()));
                    return "station/station";
                } else {
                    return "station/stationerror";
                }

            } else {
                String account = "c" + request.getParameter("account");
                request.getSession().setAttribute("logincourier", courierService.findByCourierId(baseService.findByAccount(account).getId()));
                return "courier/courier";
            }
        } else {
            return "base/nologin";
        }
    }

    //返回找回密码
    @RequestMapping(value = "findPassword")
    public String findPassword() {
        return "base/findPassword";
    }

    //返回注册页面
    @RequestMapping("/register")
    public String register() {
        return "base/register";
    }
}
