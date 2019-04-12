package com.jyu.apts.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RecordQueryDTO {

    @NotBlank(message = "溯源编码不能为空")
    private String code;
}
