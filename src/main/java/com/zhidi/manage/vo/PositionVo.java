package com.zhidi.manage.vo;

import com.zhidi.manage.entity.Department;
import com.zhidi.manage.entity.Position;

/**
 * Created by Administrator on 2017/7/31.
 */
public class PositionVo {
    //岗位管理上级
    private Department department;
    //岗位
    private Position position;
    //岗位名称
    private String name;
    private String description;


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static PositionVo fromPosition(Position position){
        if(position !=null){
           PositionVo positionVo = new PositionVo();
           positionVo.setName(position.getName());
           positionVo.setDepartment(position.getDepartment());
           positionVo.setPosition(position.getPosition());
           positionVo.setDescription(position.getDescription());
           return  positionVo;
        }

        return  null;
    }


}
