package com.zhidi.manage.action;

import com.zhidi.base.action.BaseAction;
import com.zhidi.manage.entity.Business;
import com.zhidi.manage.entity.Contract;
import com.zhidi.manage.vo.ContractVO;
import com.zhidi.system.entity.User;
import com.zhidi.util.Pager;
import com.zhidi.util.ResultData;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.w3c.dom.stylesheets.LinkStyle;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
@ParentPackage("struts-default")
@Namespace("/manage/contract")
public class ContractAction extends BaseAction {

    private String number;

    private String contractid;

    private ContractVO contractVO;

    private Integer contractOne;

    private Integer contractTwo;

    private String contractThree;

    private List<Business> businesses;



    /**
     * 去list页面
     * @return
     */
    @Action(value = "list", results = {
            @Result(location = "list_contract.jsp")
    })
    public String list() {
        return SUCCESS;
    }


    /**
     * 分页查询
     * @throws IOException
     */
    @Action(value = "findByPage")
    public void findByPage() throws IOException {
        Pager pager = contractService.getBusinessListByPage(page, rows, contractOne, contractTwo, contractThree);
        resultData = ResultData.buildSuccessResult("发送成功", pager);
        printJSONObject(resultData);
    }


    /**
     * 去修改的页面
     * @return
     */
    @Action(value = "edit", results = {
            @Result(location = "edit_contract.jsp")
    })
    public String edit() {
        businesses = businessService.getAll();
        contractVO = contractService.get(contractid);
        return SUCCESS;
    }

    /**
     * 修改的操作
     * @return
     */
    @Action(value = "update")
    public void update() throws IOException, ParseException {
        Contract contract = Contract.fromContract(contractVO);
        contractService.update(contract);
        resultData = ResultData.buildSuccessResult("修改成功");
        printJSONObject(resultData);
    }


    /**
     * 去添加的页面
     * @return
     */
    @Action(value = "add", results = {
            @Result(location = "add_contract.jsp")
    })
    public String add() {
        businesses = businessService.getAll();
        return SUCCESS;
    }


    /**
     * 添加的操作
     * @throws ParseException
     */
    @Action(value = "save")
    public void save() throws ParseException, IOException {
        Contract contract = Contract.fromContract(contractVO);
        contractService.save(contract);
        resultData = ResultData.buildSuccessResult("添加成功");
        printJSONObject(resultData);
    }

    /**
     * 删除的操作
     * @throws IOException
     */
    @Action(value = "delete")
    public void delete() throws IOException {
        contractService.delete(contractid);
        resultData = ResultData.buildSuccessResult("删除成功");
        printJSONObject(resultData);
    }



    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getContractid() {
        return contractid;
    }

    public void setContractid(String contractid) {
        this.contractid = contractid;
    }

    public ContractVO getContractVO() {
        return contractVO;
    }

    public void setContractVO(ContractVO contractVO) {
        this.contractVO = contractVO;
    }

    public Integer getContractOne() {
        return contractOne;
    }

    public void setContractOne(Integer contractOne) {
        this.contractOne = contractOne;
    }

    public Integer getContractTwo() {
        return contractTwo;
    }

    public void setContractTwo(Integer contractTwo) {
        this.contractTwo = contractTwo;
    }

    public String getContractThree() {
        return contractThree;
    }

    public void setContractThree(String contractThree) {
        this.contractThree = contractThree;
    }

    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }
}
