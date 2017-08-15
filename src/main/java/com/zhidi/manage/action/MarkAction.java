package com.zhidi.manage.action;

import com.zhidi.base.action.BaseAction;
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
@Namespace("/manage/marketing")
public class MarkAction extends BaseAction {

    /**
     * 进入email页面
     *
     * @return
     */
    @Action(value = "email", results = {
            @Result(location = "email_marketing.jsp")
    })
    public String email() {
        return SUCCESS;
    }


    /**
     * 去发送邮件页面
     * @return
     * @throws IOException
     */
    @Action(value = "sendemail", results = {
            @Result(location = "sendemail_marketing.jsp")
    })
    public String sendemail() throws IOException {
        return SUCCESS;
    }

}