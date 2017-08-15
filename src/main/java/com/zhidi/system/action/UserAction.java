package com.zhidi.system.action;

import com.zhidi.base.action.BaseAction;
import com.zhidi.system.entity.User;
import com.zhidi.system.service.UserSerivce;
import com.zhidi.system.vo.UserVO;
import com.zhidi.util.Pager;
import com.zhidi.util.ResultData;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by  on 2017/7/24.
 */
@ParentPackage("struts-default")
@Namespace("/system/user")
public class UserAction extends BaseAction {

    private User user;
    private List<UserVO> userVOList;

    private List<UserVO> list;

    /**
     * 跳转到用户列表页
     * @return
     */
    @Action(value = "list", results = {
            @Result(location = "list.jsp")
    })
    public String list() {
        return SUCCESS;
    }

    /**
     * 分页查询的ajax请求
     */
    @Action(value = "findUserByPager")
    public void findUserByPager() throws IOException {
        Pager pager = userSerivce.getUserListByPage(page, rows);
        resultData = ResultData.buildSuccessResult("获取列表成功", pager);
        printJSONObject(resultData);
    }

    @Action(value = "login")
    public void login() throws IOException {
        //如果user对象为空
        if (user == null) {
            resultData = ResultData.buildFailureResult("用户名或密码为空！");
            printJSONObject(resultData);
            return;
        }
        if (StringUtils.isEmpty(user.getUsername())) {
            resultData = ResultData.buildFailureResult("用户名为空!");
            printJSONObject(resultData);
            return;
        }
        if (StringUtils.isEmpty(user.getPassword())) {
            resultData = ResultData.buildFailureResult("密码为空！");
            printJSONObject(resultData);
            return;
        }
        //如果用户名密码都填写了，就根据用户名查询用户信息
        User user2 = userSerivce.getUserByName(user.getUsername());
        if (user2 == null) {
            resultData = ResultData.buildFailureResult("用户不存在！");
            printJSONObject(resultData);
            return;
        }
        //如果用户存在就比较密码
        if (!user2.getPassword().equals(user.getPassword())) {
            resultData = ResultData.buildFailureResult("密码错误！");
            printJSONObject(resultData);
            return;
        }

        //将用户信息写入session
        getSession().setAttribute("user", user2);

        //留着待续


        //否则返回登录成功信息
        resultData = ResultData.buildSuccessResult("登录成功！");
        printJSONObject(resultData);
    }

    @Action(value = "logout", results = {
            @Result(type = "redirect", location = "/login.jsp")
    })
    public String logout() {
        //清除用户信息
        //getSession().invalidate();
        getSession().setAttribute("user", null);
        return SUCCESS;
    }

    @Action(value = "edit", results = {
            @Result(location = "edit.jsp")
    })
    public String add() {
        return SUCCESS;
    }


    @Action(value = "findAllUpdateName")
    public String findAllUpdateName() throws IOException {
        userVOList = userSerivce.getAll();
        resultData = ResultData.buildSuccessResult("获取成功", userVOList);
        printJSONObject(resultData);
        return SUCCESS;
    }


   /* *//**
     * 获取所有的user
     * @return
     *//*
    @Action(value = "UserAction_findAll")
    protected String findAll() {
        list = userSerivce.getAll();
        return SUCCESS;
    }

*/


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<UserVO> getUserVOList() {
        return userVOList;
    }

    public void setUserVOList(List<UserVO> userVOList) {
        this.userVOList = userVOList;
    }

    public List<UserVO> getList() {
        return list;
    }

    public void setList(List<UserVO> list) {
        this.list = list;
    }
}
