package com.zhidi.base.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zhidi.manage.entity.Business;
import com.zhidi.manage.entity.Contract;
import com.zhidi.manage.service.*;
import com.zhidi.system.entity.User;
import com.zhidi.system.service.*;
import com.zhidi.util.Pager;
import com.zhidi.util.ResultData;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by lx on 2017/7/24.
 */
public class BaseAction extends ActionSupport {

    @Autowired
    protected UserSerivce userSerivce;
    @Autowired
    protected RoleService roleService;
    @Autowired
    protected FunctionService functionService;
    @Autowired
    protected MenuService menuService;
    @Autowired
    protected BusinessService businessService;
    @Autowired
    protected ContractService contractService;
    @Resource
    protected CustomerService customerService;
    @Autowired
    protected BusinessStatusService businessStatusService;
    @Autowired
    protected ContactsService contactsService;


    protected String businessId;

    protected Integer page;
    protected Integer rows;

    protected ResultData resultData;

    public ResultData getResultData() {
        return resultData;
    }

    public void setResultData(ResultData resultData) {
        this.resultData = resultData;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    /**
     * 获取HttpSession
     * @return
     */
    protected HttpSession getSession() {
        return ServletActionContext.getRequest().getSession();
    }

    /**
     * 把对象转换为json格式并且输出至客户端
     * @param obj
     * @throws IOException
     */
    protected void printJSONObject(Object obj) throws IOException{
        printJSONObject(obj, new String[]{});
    }

    /**
     * 将对象转换为json格式并且输出至客户端
     * @param obj
     * @param excludeProperties -将会被配置属性
     * @throws IOException
     */
    protected void printJSONObject(Object obj, String... excludeProperties) throws IOException{
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");

        PrintWriter out = response.getWriter();

        JsonConfig config = new JsonConfig();
        config.setExcludes(excludeProperties);

        JSONObject json = JSONObject.fromObject(obj, config);

        out.print(json.toString());
        out.flush();
    }
}
