package com.netease.product.vo;

/**
 * 功能说明
 *
 * @author wangliang01 on 2018/2/24
 */
public class AjaxResult {
    public int code;

    public String msg;

    public Object data;

    public AjaxResult(){

    }

    public AjaxResult(int code) {
        this.code = code;
    }

    public AjaxResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public AjaxResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static AjaxResult newSuccessResult(Object data){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setCode(200);
        ajaxResult.setData(data);
        return ajaxResult;
    }

    public static AjaxResult newSuccessResult(){
        return newSuccessResult(null);
    }

    public static AjaxResult newFailResult(String msg){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setCode(400);
        ajaxResult.setMsg(msg);
        return ajaxResult;
    }

    public static AjaxResult newFailResult(){
        return newFailResult(null);
    }
}
