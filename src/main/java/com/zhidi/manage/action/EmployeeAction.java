package com.zhidi.manage.action;

import com.zhidi.base.action.BaseAction;
import com.zhidi.manage.entity.Employee;
import com.zhidi.manage.vo.EmployeeVo;
import com.zhidi.util.Pager;
import com.zhidi.util.ResultData;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import java.io.IOException;


/**
 * Created by Administrator on 2017/7/26.
 */
@ParentPackage("struts-default")
@Namespace("/manage/employee")
public class EmployeeAction extends BaseAction {
    private String name;
    private String empids;
    private String empid;
    private Employee emp;


    public String getEmpids() {
        return empids;
    }

    public void setEmpids(String empids) {
        this.empids = empids;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    @Action(value = "list", results = {
            @Result(location = "list_employee.jsp")
    })
    public String list() {

        return SUCCESS;
    }

  /*  @Action(value = "findEmployeeByPage")
    public void findEmployeeByPage() throws IOException {

            Pager pager = employeeService.getEmployeeListByPage(page, rows, name);
            resultData = ResultData.buildSuccessResult("获取employee列表成功", pager);
            printJSONObject(resultData);
        }

    *//**
     * 删除
     * @throws IOException
     *//*
    @Action("EmployeeAction_remove")
    public void delete() throws IOException {
        String[] ids = null;
        if (empids != null){
            ids = empids.split(",");
        }
        employeeService.delete(ids);
        resultData = ResultData.buildSuccessResult("删除成功");
        printJSONObject(resultData);
    }

    *//**
     * 跳转到修改页面
     * @return
     * @throws IOException
     *//*
     @Action(value = "EmployeeAction_edit",results = {
     @Result(location = "edit_employee.jsp")
     })
     public String editEmployee() throws IOException {
         emp = employeeService.get(empid);
        return SUCCESS;
     }
    *//**
     * 修改更新员工
     * @return
     * @throws IOException
     *//*
    @Action("updateEmployee")
    public void updateEmployee() throws IOException {
        employeeService.update(emp);
        resultData = ResultData.buildSuccessResult("更新成功");
        printJSONObject(resultData);
    }

    *//**
     * 跳转到新增界面
     * @return
     *//*
    @Action(value = "EmployeeAction_add",results = {
            @Result(location = "add_employee.jsp")
    })
    public String addEmployee(){
        return SUCCESS;
    }
    *//**
     * 保存员工方法
     * @throws IOException
     *//*
    @Action("saveEmployee")
    public void saveEmployee() throws IOException {
        employeeService.save(emp);
        resultData = ResultData.buildSuccessResult("保存成功");
        printJSONObject(resultData);
    }*/

}
