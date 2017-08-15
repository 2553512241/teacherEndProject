package com.zhidi.manage.vo;

import com.zhidi.manage.entity.Employee;

/**
 * Created by Administrator on 2017/7/26.
 */
public class EmployeeVo {
    private  String  empid;
    private  String name;
    private  String telephone;
    private  String  email;
    private  String  address;


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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public static EmployeeVo  fromEmployee(Employee employee){
        if(employee!=null){
            EmployeeVo employeeVo = new EmployeeVo();
            employeeVo.setEmpid(employee.getEmpid());
            employeeVo.setName(employee.getName());
            employeeVo.setTelephone(employee.getTelephone());
            employeeVo.setAddress(employee.getAddress());
            employeeVo.setEmail(employee.getEmail());

            return employeeVo;
        }
           return  null;
    }






}
