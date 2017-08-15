package com.zhidi.manage.action;


import com.zhidi.base.action.BaseAction;

import com.zhidi.manage.entity.Business;
import com.zhidi.manage.entity.BusinessStatus;
import com.zhidi.manage.entity.Contacts;
import com.zhidi.manage.entity.Customer;
import com.zhidi.manage.vo.BusinessVO;
import com.zhidi.system.entity.Role;
import com.zhidi.system.entity.User;
import com.zhidi.system.vo.UserVO;
import com.zhidi.util.Pager;

import com.zhidi.util.ResultData;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;


/**
 * BusinessAction_index
 */
@ParentPackage("struts-default")
@Namespace("/manage/business")
public class BusinessAction extends BaseAction {

    private BusinessVO businessVO;

    private List<Business> list;

    private Business business;

    private List<UserVO> userVOs;

    private List<Customer> customers;

    private List<BusinessStatus> businessStatuses;

    private List<Contacts> contactss;

    private Integer searchBy;
    private String searchText;



    public BusinessVO getBusinessVO() {
        return businessVO;
    }

    public void setBusinessVO(BusinessVO businessVO) {
        this.businessVO = businessVO;
    }

    public List<Business> getList() {
        return list;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public void setList(List<Business> list) {
        this.list = list;
    }

    public List<UserVO> getUserVOs() {
        return userVOs;
    }

    public void setUserVOs(List<UserVO> userVOs) {
        this.userVOs = userVOs;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<BusinessStatus> getBusinessStatuses() {
        return businessStatuses;
    }

    public void setBusinessStatuses(List<BusinessStatus> businessStatuses) {
        this.businessStatuses = businessStatuses;
    }

    public List<Contacts> getContactss() {
        return contactss;
    }

    public void setContactss(List<Contacts> contactss) {
        this.contactss = contactss;
    }

    public Integer getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(Integer searchBy) {
        this.searchBy = searchBy;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    /**
     * 进入list页面
     *
     * @return
     */
    @Action(value = "list", results = {
            @Result(location = "list_business.jsp")
    })
    public String list() {
        return SUCCESS;
    }


    /**
     * 分页查询
     *
     * @throws IOException
     */
    @Action(value = "BusinessAction_findByPage")
    public void findBusinessByPager() throws IOException {
        Pager pager = businessService.getBusinessListByPage(page, rows, searchBy, searchText);
        resultData = ResultData.buildSuccessResult("获取列表成功", pager);
        printJSONObject(resultData);
    }

    /**
     * 去查看的页面
     *
     * @return
     */
    @Action(value = "seeBusiness", results = {
            @Result(location = "see_business.jsp")
    })
    public String seeToPage() throws IOException {
        businessVO = businessService.get(businessId);
        return SUCCESS;
    }

    /**
     * 去修改的页面
     *
     * @return
     */
    @Action(value = "editBusiness", results = {
            @Result(location = "edit_business.jsp")
    })
    public String editBusiness() {
        contactss = contactsService.getAll();
        businessStatuses = businessStatusService.getAll();
        customers = customerService.getAll();
        userVOs = userSerivce.getAll();
        list = businessService.getAll();
        businessVO = businessService.get(businessId);
        return SUCCESS;
    }

    /**
     * 更新
     *
     * @return
     * @throws IOException
     */
    @Action(value = "update")
    public void update() throws IOException, ParseException {
        User curreUser = (User) getSession().getAttribute("user");
        business = Business.fromBusiness(businessVO);
        business.setUpdatetime(new Date());
        business.setUserByUpdateuserid(curreUser);
        businessService.update(business);
        resultData = ResultData.buildSuccessResult("modify success");
        printJSONObject(resultData);
    }


    /**
     * 去添加的页面
     *
     * @return
     */
    @Action(value = "addBusiness", results = {
            @Result(location = "add_business.jsp")
    })
    public String add() {
        contactss = contactsService.getAll();
        businessStatuses = businessStatusService.getAll();
        customers = customerService.getAll();
        userVOs = userSerivce.getAll();
        list = businessService.getAll();
        return SUCCESS;
    }

    /**
     * 添加的操作
     *
     * @return
     */
    @Action(value = "save")
    public void save() throws ParseException, IOException {
        User curreUser = (User) getSession().getAttribute("user");
        business = Business.fromBusiness(businessVO);
        business.setBusinessid(null);
        business.setCreatetime(new Date());
        business.setUserByCreatoruserid(curreUser);
        businessService.save(business);
        resultData = ResultData.buildSuccessResult("修改成功");
        printJSONObject(resultData);
    }

    /**
     * 删除
     *
     * @return
     * @throws IOException
     */
    @Action(value = "delBusiness")
    public void delBusiness() throws IOException {
        businessService.delete(businessId);
        resultData = ResultData.buildSuccessResult("删除成功");
        printJSONObject(resultData);
    }

}
