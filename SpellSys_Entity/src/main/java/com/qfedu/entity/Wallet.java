package com.qfedu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 用户钱包表
 * </p>
 *
 * @author rainbow
 * @since 2019-09-19
 */
public class Wallet extends Model<Wallet> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer uId;

    /**
     * 金币
     */
    private Double gold;

    /**
     * 积分
     */
    private Double integal;

    /**
     * 余额
     */
    private Double balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }
    public Double getGold() {
        return gold;
    }

    public void setGold(Double gold) {
        this.gold = gold;
    }
    public Double getIntegal() {
        return integal;
    }

    public void setIntegal(Double integal) {
        this.integal = integal;
    }
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Wallet{" +
        "id=" + id +
        ", uId=" + uId +
        ", gold=" + gold +
        ", integal=" + integal +
        ", balance=" + balance +
        "}";
    }
}
