package com.jyu.apts.commons.dto;



import com.jyu.apts.commons.enums.ResponseStatusEnum;

import java.io.Serializable;

public class ResponseDTO implements Serializable{
    private Integer code;
    private String message;
    private Object data;

    public ResponseDTO(){

    }

    public ResponseDTO(ResponseStatusEnum ResponseStatusEnum){
        this.code = ResponseStatusEnum.getCode();
        this.message = ResponseStatusEnum.getMessage();
    }

    public ResponseDTO(ResponseStatusEnum ResponseStatusEnum, Object data){
        this.code = ResponseStatusEnum.getCode();
        this.message = ResponseStatusEnum.getMessage();
        this.data = data;
    }

    public ResponseDTO(Integer code, String message, Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResponseDTO success(){
        return new ResponseDTO(ResponseStatusEnum.SUCCESS);
    }

    public static ResponseDTO success(Object data){
        return new ResponseDTO(ResponseStatusEnum.SUCCESS, data);
    }

    public static ResponseDTO success(String message, Object data){
        return new ResponseDTO(ResponseStatusEnum.SUCCESS.getCode(), message, data);
    }

    public static ResponseDTO failture(){
        return new ResponseDTO(ResponseStatusEnum.FAILED);
    }

    public static ResponseDTO failture(ResponseStatusEnum responseStatusEnum){
        return new ResponseDTO(responseStatusEnum);
    }

    public static ResponseDTO failture(String message){
        return new ResponseDTO(ResponseStatusEnum.FAILED, message);
    }

    public static ResponseDTO failture(ResponseStatusEnum responseStatusEnum, String message){
        responseStatusEnum.setMessage(message);
        return new ResponseDTO(responseStatusEnum);
    }

    public static ResponseDTO failture(ResponseStatusEnum responseStatusEnum, Object data){
        return new ResponseDTO(responseStatusEnum, data);
    }

    public static ResponseDTO failture(String message, Object data){
        return new ResponseDTO(ResponseStatusEnum.FAILED.getCode(), message, data);
    }

    public static ResponseDTO result(ResponseStatusEnum ResponseStatusEnum){
        return new ResponseDTO(ResponseStatusEnum);
    }

    public static ResponseDTO result(ResponseStatusEnum ResponseStatusEnum, Object data){
        return new ResponseDTO(ResponseStatusEnum, data);
    }

    public Integer getCode(){
        return code;
    }

    public ResponseDTO setCode(Integer code){
        this.code = code;
        return this;
    }

    public String getMessage(){
        return message;
    }

    public ResponseDTO setMessage(String message){
        this.message = message;
        return this;
    }

    public Object getData(){
        return data;
    }

    public ResponseDTO setData(final Object data){
        this.data = data;
        return this;
    }
}
