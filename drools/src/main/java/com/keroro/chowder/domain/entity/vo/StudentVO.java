package com.keroro.chowder.domain.entity.vo;

/**
 * @author wangpeng
 * @since 2023年09月12日 14:36
 */
public class StudentVO {

    private String name;

    private Integer age;

    private Integer weight;

    private Float score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}
