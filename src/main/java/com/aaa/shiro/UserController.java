package com.aaa.shiro;

import com.aaa.entity.Xiaoliang;
import com.aaa.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        System.out.println("UserController.hello()");
        return "ok";
    }


        @RequestMapping("/testThymeleaf")
    public String testThymeleaf(Model model){
        model.addAttribute("name", "黑马程序员");
        return "test";
    }

    @RequestMapping("/add")
    public String add(){
        return "add.html";
    }

    @RequestMapping("/update")
    public String update(){
        return "update.html";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login.html";
    }


    @RequestMapping("/test")
    public String highcharts(){
        return "demo2.html";
    }


    @Resource
    UserMapper userMapper;

    @RequestMapping("/test2")
    @ResponseBody
    public Map<String,Object> getXiaoliangList() {
            List<Xiaoliang> xlist = new ArrayList<Xiaoliang>();
            Map<String,Object> xmap=new HashMap<String,Object>();
            xlist=userMapper.findxl();
            /*创建装载月销量数组*/
            int[] xxdata=new int[xlist.size()];
            /*创建装载月份数组*/
            String[] xdata=new String[xlist.size()];
            /*定义数组下标*/
            int i=0;
            /*遍历数据库数据*/
            for (Xiaoliang xiaoliang : xlist) {
            /*将销量放入数组*/
            xxdata[i]=xiaoliang.getXcount();
            /*将月份放入数组*/
            xdata[i]=xiaoliang.getXname();
            i++;
}
/*将两个数组存入集合中*/
xmap.put("xname", xdata);
xmap.put("xcount", xxdata);
return xmap;
}

    /**
     * 登录逻辑处理
     */
    @RequestMapping("/login")
    public String login(String name,String password,Model model){
        System.out.println("进入登录方法");

        /**
         * 使用Shiro编写认证操作
         */
        //1.获取Subject

        Subject subject = SecurityUtils.getSubject();

        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);



        //3.执行登录方法
        try {
            subject.login(token);

            //登录成功
            //跳转到test.html
            return "redirect:/testThymeleaf";
            } catch (UnknownAccountException e) {
            //e.printStackTrace();
            //登录失败:用户名不存在
            model.addAttribute("msg", "用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e) {
            //e.printStackTrace();
            //登录失败:密码错误
            model.addAttribute("msg", "密码错误");
            return "login";
        }
    }

}
