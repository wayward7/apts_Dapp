package com.jyu.apts.commons.enums;

import java.io.Serializable;

public enum ResponseStatusEnum implements Serializable{

    SUCCESS(1, "成功", "操作成功"),
    FAILED(-1, "失败", "操作失败");

    private static final String OPERATION_FAIL = "操作失败";


    Integer code;
    String message;
    String details;

    ResponseStatusEnum(final Integer code, final String message, final String details){
        this.code = code;
        this.message = message;
        this.details = details;
    }

    ResponseStatusEnum(final Integer code, final String message){
        this.code = code;
        this.message = message;
        this.details = OPERATION_FAIL;
    }


    public Integer getCode(){
        return code;
    }

    public void setCode(final Integer code){
        this.code = code;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(final String message){
        this.message = message;
    }

    public String getDetails(){
        return details;
    }

    public void setDetails(final String details){
        this.details = details;
    }
}
