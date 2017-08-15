package com.zhidi.manage.vo;

import com.zhidi.manage.entity.Business;
import com.zhidi.manage.entity.Contract;
import com.zhidi.util.DateUtil;

import java.util.Set;

/**
 * Created by Administrator on 2017/7/26.
 */
public class BusinessVO {

    private String updateById;              //通过userByUpdateby获
    private String updateByName;//修改者 通过userByUpdateby获
    private String createById;
    private String createByName;

    private String customerId;
    private String customerName;

    private String businessId;
    private String businessName;
    private String businessOrgnin;

    private String nextsteptime;
    private String nextstep;

    private String createtimeBusiness;
    private String updatetimeBusiness;

    private String salesprice;
    private String contractaddress;
    private String type;

    private String gainrate;
    private String estimateprice;

    private String description;

    private String businessStatusId;
    private String businessStatusName;

    private String contactsId;
    private String contactsName;

    private String totalamount;
    private String subtotalval;
    private String discountprice;
    private String duedate;
    private String totalprice;
    private String isdeleted;
    private String deletetime;








    public String getUpdateById() {
        return updateById;
    }

    public void setUpdateById(String updateById) {
        this.updateById = updateById;
    }

    public String getUpdateByName() {
        return updateByName;
    }

    public void setUpdateByName(String updateByName) {
        this.updateByName = updateByName;
    }

    public String getCreateById() {
        return createById;
    }

    public void setCreateById(String createById) {
        this.createById = createById;
    }

    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessOrgnin() {
        return businessOrgnin;
    }

    public void setBusinessOrgnin(String businessOrgnin) {
        this.businessOrgnin = businessOrgnin;
    }

    public String getNextsteptime() {
        return nextsteptime;
    }

    public void setNextsteptime(String nextsteptime) {
        this.nextsteptime = nextsteptime;
    }

    public String getNextstep() {
        return nextstep;
    }

    public void setNextstep(String nextstep) {
        this.nextstep = nextstep;
    }




    public String getCreatetimeBusiness() {
        return createtimeBusiness;
    }

    public void setCreatetimeBusiness(String createtimeBusiness) {
        this.createtimeBusiness = createtimeBusiness;
    }

    public String getUpdatetimeBusiness() {
        return updatetimeBusiness;
    }

    public void setUpdatetimeBusiness(String updatetimeBusiness) {
        this.updatetimeBusiness = updatetimeBusiness;
    }

    public String getSalesprice() {
        return salesprice;
    }

    public void setSalesprice(String salesprice) {
        this.salesprice = salesprice;
    }

    public String getContractaddress() {
        return contractaddress;
    }

    public void setContractaddress(String contractaddress) {
        this.contractaddress = contractaddress;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public String getGainrate() {
        return gainrate;
    }

    public void setGainrate(String gainrate) {
        this.gainrate = gainrate;
    }

    public String getEstimateprice() {
        return estimateprice;
    }

    public void setEstimateprice(String estimateprice) {
        this.estimateprice = estimateprice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBusinessStatusName() {
        return businessStatusName;
    }

    public void setBusinessStatusName(String businessStatusName) {
        this.businessStatusName = businessStatusName;
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    public String getBusinessStatusId() {
        return businessStatusId;
    }

    public void setBusinessStatusId(String businessStatusId) {
        this.businessStatusId = businessStatusId;
    }

    public String getContactsId() {
        return contactsId;
    }

    public void setContactsId(String contactsId) {
        this.contactsId = contactsId;
    }


    public String getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(String totalamount) {
        this.totalamount = totalamount;
    }

    public String getSubtotalval() {
        return subtotalval;
    }

    public void setSubtotalval(String subtotalval) {
        this.subtotalval = subtotalval;
    }

    public String getDiscountprice() {
        return discountprice;
    }

    public void setDiscountprice(String discountprice) {
        this.discountprice = discountprice;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public String getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(String isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getDeletetime() {
        return deletetime;
    }

    public void setDeletetime(String deletetime) {
        this.deletetime = deletetime;
    }

    /**
     * 将business对象封装到vo中
     * @return
     */
    public static BusinessVO fromBusiness(Business business) {
        if(business != null) {
            BusinessVO businessVO = new BusinessVO();
            businessVO.setBusinessId(business.getBusinessid());
            businessVO.setBusinessName(business.getName());
            businessVO.setBusinessOrgnin(business.getOrigin());
            if(business.getBusinessContacts() != null) {
                businessVO.setContactsId(business.getBusinessContacts().getContactsid());
                businessVO.setContactsName(business.getBusinessContacts().getName());
            }

            if(business.getSalesprice() != null) {
                businessVO.setSalesprice(business.getSalesprice().toString());
            }
            businessVO.setContractaddress(business.getContractaddress());
            businessVO.setType(business.getType());
            if(business.getGainrate() != null) {
                businessVO.setGainrate(business.getGainrate().toString());
            }
            if(business.getEstimateprice() != null) {
                businessVO.setEstimateprice(business.getEstimateprice().toString());
            }
            if(business.getNextsteptime() != null) {
                businessVO.setNextsteptime(DateUtil.formatDate(business.getNextsteptime(), "yyyy-MM-dd HH:mm:ss"));
            }
            businessVO.setNextstep(business.getNextstep());
            if(business.getCreatetime() != null) {
                businessVO.setCreatetimeBusiness(DateUtil.formatDate(business.getCreatetime(), "yyyy-MM-dd HH:mm:ss"));
            }
            if(business.getUpdatetime() != null) {
                businessVO.setUpdatetimeBusiness(DateUtil.formatDate(business.getUpdatetime(), "yyyy-MM-dd HH:mm:ss"));
            }
            businessVO.setDescription(business.getDescription());
            if(business.getBusinessStatus() != null) {
                businessVO.setBusinessStatusName(business.getBusinessStatus().getName());
                businessVO.setBusinessStatusId(business.getBusinessStatus().getStatusid());
            }

            if(business.getCustomer() != null) {
                businessVO.setCustomerId(business.getCustomer().getCustomerid());
                businessVO.setCustomerName(business.getCustomer().getName());
            }
            if(business.getUserByUpdateuserid() != null) {
                businessVO.setUpdateById(business.getUserByUpdateuserid().getId());
                businessVO.setUpdateByName(business.getUserByUpdateuserid().getUsername());
            }
            if(business.getUserByCreatoruserid() != null) {
                businessVO.setCreateById(business.getUserByCreatoruserid().getId());
                businessVO.setCreateByName(business.getUserByCreatoruserid().getUsername());
            }
            return businessVO;

        }


        return null;
    }

}
