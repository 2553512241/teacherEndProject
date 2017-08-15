package com.zhidi.manage.vo;

import com.zhidi.manage.entity.Contract;
import com.zhidi.util.DateUtil;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/1.
 */
public class ContractVO {

    private String contractid;

    private String businessCustomerId;
    private String businessCustomerName;

    private String contractnumber;

    private String price;
    private String duetime;

    private String ownerUserId;
    private String ownerUserName;

    private String createUserId;
    private String createUserName;


    private String contractcontent;
    private String description;
    private String createtime;
    private String updatetime;
    private String startdate;
    private String enddate;
    private String status;
    private String isdeleted;
    private String deletetime;

    private String businessIds;
    private String businessNames;

    private String businessConnectionId;
    private String businessConnectionName;


    public String getContractid() {
        return contractid;
    }

    public void setContractid(String contractid) {
        this.contractid = contractid;
    }

    public String getBusinessCustomerId() {
        return businessCustomerId;
    }

    public void setBusinessCustomerId(String businessCustomerId) {
        this.businessCustomerId = businessCustomerId;
    }

    public String getBusinessCustomerName() {
        return businessCustomerName;
    }

    public void setBusinessCustomerName(String businessCustomerName) {
        this.businessCustomerName = businessCustomerName;
    }

    public String getContractnumber() {
        return contractnumber;
    }

    public void setContractnumber(String contractnumber) {
        this.contractnumber = contractnumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDuetime() {
        return duetime;
    }

    public void setDuetime(String duetime) {
        this.duetime = duetime;
    }

    public String getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(String ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public String getOwnerUserName() {
        return ownerUserName;
    }

    public void setOwnerUserName(String ownerUserName) {
        this.ownerUserName = ownerUserName;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getContractcontent() {
        return contractcontent;
    }

    public void setContractcontent(String contractcontent) {
        this.contractcontent = contractcontent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getBusinessIds() {
        return businessIds;
    }

    public void setBusinessIds(String businessIds) {
        this.businessIds = businessIds;
    }

    public String getBusinessNames() {
        return businessNames;
    }

    public void setBusinessNames(String businessNames) {
        this.businessNames = businessNames;
    }

    public String getBusinessConnectionId() {
        return businessConnectionId;
    }

    public void setBusinessConnectionId(String businessConnectionId) {
        this.businessConnectionId = businessConnectionId;
    }

    public String getBusinessConnectionName() {
        return businessConnectionName;
    }

    public void setBusinessConnectionName(String businessConnectionName) {
        this.businessConnectionName = businessConnectionName;
    }

    public static ContractVO formContract(Contract contract) {
        if (contract != null) {
            ContractVO contractVO = new ContractVO();
            contractVO.setContractid(contract.getContractid());
            contractVO.setContractnumber(contract.getContractnumber());
            contractVO.setDuetime(DateUtil.formatDate(contract.getDuetime(), "yyyy-MM-dd HH:mm:ss"));
            contractVO.setPrice(contract.getPrice().toString());
            contractVO.setDuetime(DateUtil.formatDate(contract.getDuetime(),"yyyy-MM-dd HH:mm:ss" ));
            if(contract.getContractcontent() != null) {
                contractVO.setContractcontent(contract.getContractcontent().toString());
            }
            contractVO.setDescription(contract.getDescription());
            contractVO.setUpdatetime(DateUtil.formatDate(contract.getUpdatetime(), "yyyy-MM-dd HH:mm:ss"));
            contractVO.setCreatetime(DateUtil.formatDate(contract.getCreatetime(), "yyyy-MM-dd HH:mm:ss"));
            contractVO.setStartdate(DateUtil.formatDate(contract.getStartdate(),"yyyy-MM-dd HH:mm:ss"));
            contractVO.setEnddate(DateUtil.formatDate(contract.getEnddate(), "yyyy-MM-dd HH:mm:ss"));
            contractVO.setStatus(contract.getStatus());
            contractVO.setIsdeleted(contract.getIsdeleted().toString());
            contractVO.setDeletetime(DateUtil.formatDate(contract.getDeletetime(), "yyyy-MM-dd HH:mm:ss"));

            if(contract.getBusiness() != null && contract.getBusiness().getContracts() !=null) {
                contractVO.setBusinessConnectionId(contract.getBusiness().getBusinessContacts().getContactsid());
                contractVO.setBusinessConnectionName(contract.getBusiness().getBusinessContacts().getName());
            }
            if (contract.getBusiness() != null && contract.getBusiness().getCustomer() != null) {
                contractVO.setBusinessCustomerId(contract.getBusiness().getBusinessid());
                contractVO.setBusinessCustomerName(contract.getBusiness().getCustomer().getName());
            }

            if (contract.getOwnerUser() != null && contract.getOwnerUser().getId() != null) {
                contractVO.setOwnerUserId(contract.getOwnerUser().getId());
                contractVO.setOwnerUserName(contract.getOwnerUser().getUsername());
            }
            if (contract.getCreateUser() != null && contract.getCreateUser().getId() != null) {
               contractVO.setCreateUserId(contract.getCreateUser().getId());
               contractVO.setCreateUserId(contract.getCreateUser().getUsername());
            }
            return contractVO;
        }
        return null;
    }

}
