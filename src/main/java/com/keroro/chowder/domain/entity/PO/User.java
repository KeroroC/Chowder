package com.keroro.chowder.domain.entity.PO;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Description: 用户实体类
 * @author: wangpeng
 * @date: 2023年04月27日 11:29
 */
@Data
@ApiModel(value = "用户", description = "用户实体类")
public class User {

    private String id;

    private String name;

    private String sex;

    private String gender;
}
