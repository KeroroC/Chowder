package xyz.keroro.arknights.dao.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author wangpeng
 * @since 2023年12月28日 14:58
 */
@TableName("T_ARK_ACCOUNT")
public class ArkAccount {

    @TableId(value = "ID_ACCOUNT", type = IdType.ASSIGN_ID)
    private String idAccount;

    @TableField("ARK_ACCOUNT")
    private String arkAccount;

    @TableField("ARK_PWD")
    private String arkPwd;

    public ArkAccount(String arkAccount, String arkPwd) {
        this.arkAccount = arkAccount;
        this.arkPwd = arkPwd;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public String getArkAccount() {
        return arkAccount;
    }

    public void setArkAccount(String arkAccount) {
        this.arkAccount = arkAccount;
    }

    public String getArkPwd() {
        return arkPwd;
    }

    public void setArkPwd(String arkPwd) {
        this.arkPwd = arkPwd;
    }
}
