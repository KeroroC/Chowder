package xyz.keroro.chowder.domain.entity.vo;

/**
 * 用户实体类
 * @author wangpeng
 * @since 2023年04月27日 11:29
 */
public class UserVO {

    private String id;

    private String name;

    private String sex;

    private String gender;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
