package com.zhidi.manage.action;

import com.zhidi.base.action.BaseAction;
import com.zhidi.util.Pager;
import com.zhidi.util.ResultData;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import java.io.IOException;

/**
 * Created by Administrator on 2017/7/31.
 */
@ParentPackage("struts-default")
@Namespace("/manage/position")
public class PositionAction extends BaseAction {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Action(value = "list", results = {

            @Result(location = "list_position.jsp")
    })
    public String list() {

        return SUCCESS;
    }

 /*   @Action(value = "PositionAction_findByCondition")
    public void findEmployeeByPage() throws IOException {

        Pager pager  = positionService.getPositionListByPage(page,rows,name);
        resultData = ResultData.buildSuccessResult("获取position列表成功", pager);
        printJSONObject(resultData);
    }*/


}
