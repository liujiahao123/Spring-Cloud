package com.hoyan.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by 20160709 on 2018/11/23.
 */
public class ResultVo {
    //定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();
    //响应业务状态
    private Integer status;
    //相应消息
    private String msg;
    //相应中的数据
    private Object data;
    public static ResultVo error(){
        ResultVo resultVo =new ResultVo();
        resultVo.setMsg("操作失败");
        resultVo.setStatus(201);
        return resultVo;
    }

    public static ResultVo error(String mes){
        ResultVo resultVo =new ResultVo();
        resultVo.setMsg(mes);
        resultVo.setStatus(201);
        return resultVo;
    }

    public static ResultVo success(){
        ResultVo resultVo =new ResultVo();
        resultVo.setMsg("操作成功");
        resultVo.setStatus(200);
        return resultVo;
    }

    public static ResultVo success(Object data){
        ResultVo resultVo =new ResultVo();
        resultVo.setMsg("操作成功");
        resultVo.setStatus(200);
        resultVo.setData(data);
        return resultVo;
    }

    public static ObjectMapper getMAPPER() {
        return MAPPER;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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


}
