package com.keroro.chowder.dao.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * @Description: 抽卡记录表
 * @author: wangpeng
 * @date: 2022年07月05日 22:14
 */
@TableName("GACHA_RECORD")
public class GachaRecordPO {

    /**
     * 抽卡记录表主键
     */
    @TableId(value = "ID_GACHA_RECORD", type = IdType.ASSIGN_ID)
    private String idGachaRecord;

    /**
     * 抽卡时间-时间戳
     */
    @TableField("TIMESTAMP")
    private String timestamp;

    /**
     * 抽卡时间
     */
    @TableField("TIME")
    private Date time;

    /**
     * 卡池名
     */
    @TableField("POOL")
    private String pool;

    /**
     * 干员名
     */
    @TableField("NAME")
    private String name;

    /**
     * 稀有度
     */
    @TableField("RARITY")
    private String rarity;

    /**
     * 是否为新获得
     */
    @TableField("IS_NEW")
    private boolean isNew;

    /**
     * 插入时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 昵称
     */
    @TableField("UID")
    private String playerUID;

    public String getIdGachaRecord() {
        return idGachaRecord;
    }

    public void setIdGachaRecord(String idGachaRecord) {
        this.idGachaRecord = idGachaRecord;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPlayerUID() {
        return playerUID;
    }

    public void setPlayerUID(String playerUID) {
        this.playerUID = playerUID;
    }
}
