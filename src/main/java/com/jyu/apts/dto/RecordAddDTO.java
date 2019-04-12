package com.jyu.apts.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RecordAddDTO {

    @NotBlank(message = "溯源编码不能为空")
    private String code;

    @NotBlank(message = "溯源信息不能为空")
    private String data;
}
