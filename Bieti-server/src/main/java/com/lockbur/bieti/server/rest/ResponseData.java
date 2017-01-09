package com.lockbur.bieti.server.rest;


import com.lockbur.bieti.server.enums.ResponseStatus;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 用户ajax提交之后的相应结果
 *
 * @author wangkun23
 */
public class ResponseData implements Serializable {

    /**
     * 响应状态
     */
    private ResponseStatus status;

    /**
     * 消息code
     */
    private String code;

    /**
     * 错误提示
     */
    private String error;

    /**
     * 结果数据
     * 如果返回对象或数组直接用setData
     * 如果返回简单的键值对用addData
     */
    private Object data;
    private Map<String, Object> dataShadow;

    public ResponseData() {

    }

    public ResponseData(ResponseStatus status, String code) {
        this.status = status;
        this.code = code;
    }

    public ResponseData(ResponseStatus status, String code, String error) {
        this.status = status;
        this.code = code;
        this.error = error;
    }

    /**
     * 返回成功
     *
     * @return
     */
    public static ResponseData success() {
        return new ResponseData(ResponseStatus.SUCCESS, "0");
    }

    /**
     * 返回成功消息
     *
     * @param code 消息code
     * @return 成功消息
     */
    public static ResponseData success(String code) {
        return new ResponseData(ResponseStatus.SUCCESS, code);
    }

    /**
     * 返回警告消息
     *
     * @param code 消息code
     * @return 警告消息
     */
    public static ResponseData warn(String code) {
        return new ResponseData(ResponseStatus.WARN, code);
    }

    /**
     * 返回错误
     *
     * @return
     */
    public static ResponseData error() {
        return new ResponseData(ResponseStatus.ERROR, "1");
    }

    /**
     * 返回错误消息
     *
     * @param code 消息code
     * @return 错误消息
     */
    public static ResponseData error(String code) {
        return new ResponseData(ResponseStatus.ERROR, code);
    }

    /**
     * 返回错误消息
     *
     * @param code 消息code
     * @return 错误消息
     */
    public static ResponseData error(String code, String error) {
        return new ResponseData(ResponseStatus.ERROR, code, error);
    }


    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public void addData(String key, Object value) {
        if(this.dataShadow == null){
            this.dataShadow = new LinkedHashMap<String, Object>();

            this.data = this.dataShadow;
        }
        this.dataShadow.put(key, value);
    }


    public Object removeData(String key) {
        return this.dataShadow != null ? this.dataShadow.remove(key) : null;
    }
}
