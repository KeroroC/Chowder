package com.keroro.chowder;

import lombok.Data;

/**
 * @author wangpeng
 * @since 2023年12月18日 17:06
 */
@Data
public class PersonTest {

    private String name;

    PersonTest() {
        this.name = "name";
    }
}
