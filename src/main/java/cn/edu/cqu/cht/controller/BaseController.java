package cn.edu.cqu.cht.controller;

import cn.edu.cqu.cht.model.Kotlin;
import cn.edu.cqu.cht.model.Orderlist;
import cn.edu.cqu.cht.service.KotlinService;
import cn.edu.cqu.cht.service.OrderlistService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author WJL
 * @version 1.0
 * @date 创建时间：2022年5月31日 下午19:01
 */
@Controller
@RequestMapping("/base")
public class BaseController {

    @Autowired
    private OrderlistService orderService;
    @Autowired
    private KotlinService kotlinService;

//    @RequestMapping("/title")
//    public String title() {
//        return "base/title";
//    }

    @RequestMapping("/welcome")
    public String toWelcome() {
        return "base/welcome";
    }

    @RequestMapping("/index")
    public String index() {
        return "base/base";
    }

    @RequestMapping("/register")
    public String toRegister() {
        return "base/register";
    }

    @RequestMapping("/login")
    public String toLogin() {
        return "base/login";
    }


    @RequestMapping(value = "/searchOrder", method = RequestMethod.GET)
    public String searchOrder(HttpServletRequest request, Model model, @RequestParam(required = true, defaultValue = "1") Integer page, @RequestParam(required = true, defaultValue = "6") Integer limit) {
        String phoneOrOrderId = request.getParameter("phoneOrOrderId");
        if (phoneOrOrderId == null) {
            phoneOrOrderId = (String) request.getSession().getAttribute("phoneOrOrderId");
        }
        if (phoneOrOrderId.length() == 11) {
            List<Orderlist> orderlists = orderService.findByRecipientPhone(phoneOrOrderId, page, limit);
            PageInfo<Orderlist> p = new PageInfo<Orderlist>(orderlists);
            model.addAttribute("page", p);
            model.addAttribute("userlist", orderlists);
            model.addAttribute("limit", limit);
            request.getSession().setAttribute("phoneOrOrderId", phoneOrOrderId);
            return "base/success";
        } else {
            List<Orderlist> orderlists = new ArrayList<Orderlist>();
            orderlists.add(orderService.findByOrderId(phoneOrOrderId));
            PageInfo<Orderlist> p = new PageInfo<>(orderlists);
            model.addAttribute("page", p);
            model.addAttribute("userlist", orderlists);
            model.addAttribute("limit", limit);
            request.getSession().setAttribute("phoneOrOrderId", phoneOrOrderId);
            return "base/success";
        }
    }

    @RequestMapping(value = "/aboutUs")
    public ModelAndView aboutUs(HttpServletRequest request) {
        Kotlin kotlin = kotlinService.findById(1L);
        request.getSession().setAttribute("kotlin", kotlin);
        //		return "base/aboutUs";
        return new ModelAndView("base/aboutUs");
    }
}
