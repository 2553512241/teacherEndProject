package com.zhidi.manage.vo;

import com.zhidi.manage.entity.Customer;

import java.util.Date;

/**
 * Created by 段俊 on 2017/7/31.
 */
public class CustomerVO {

    private String customerid;                     //客户编号
    private String name;                           //客户名称
    private String industry;                       //客户所属行业
    private String rating;                         //评分
    private String address;                        //客户联系地址
    private String owner;                          //负责人
    private String createUser;                     //创建人
    private String createTime;                     //创建时间
    private String updateTime;                     //更新时间
    private Integer days;                          //距离到期天数

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public static CustomerVO fromCustomer(Customer customer) {
        if (customer != null) {
            CustomerVO customerVO = new CustomerVO();
            customerVO.setCustomerid(customer.getCustomerid());
            customerVO.setName(customer.getName());
            customerVO.setIndustry(customer.getIndustry());
            customerVO.setRating(customer.getRating());
            customerVO.setAddress(customer.getAddress());
            if (customer.getUserByOwneruserid() != null) {
                customerVO.setOwner(customer.getUserByOwneruserid().getUsername());
            }
            if (customer.getUserByCreatoruserid() != null) {
                customerVO.setCreateUser(customer.getUserByCreatoruserid().getUsername());
            }
            if (customer.getCreatetime() != null) {
                customerVO.setCreateTime(customer.getCreatetime().toString());
            }else {
                customerVO.setCreateTime(null);
            }
            if (customer.getUpdatetime() != null) {
                customerVO.setUpdateTime(customer.getUpdatetime().toString());
            }else {
                customerVO.setUpdateTime(null);
            }
            return  customerVO;
        }
       return null;
    }

}
