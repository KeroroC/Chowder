package com.keroro.chowder.domain.entity.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Description: 用户实体类
 * @author: wangpeng
 * @date: 2023年04月27日 11:29
 */
@Data
@Schema(name = "UserVO", description = "用户实体类")
public class UserVO {

    private String id;

    private String name;

    private String sex;

    private String gender;
}
