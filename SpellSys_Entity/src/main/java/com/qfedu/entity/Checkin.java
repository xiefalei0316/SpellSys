package com.qfedu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 签到表
 * </p>
 *
 * @author rainbow
 * @since 2019-09-19
 */
public class Checkin extends Model<Checkin> {

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
     * 签到日期
     */
    private Date checkDate;

    /**
     * 基础金币
     */
    private Double baseGold;

    /**
     * 累计签到天数
     */
    private Integer countDay;

    /**
     * 奖励金币
     */
    private Double reward;

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
    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }
    public Double getBaseGold() {
        return baseGold;
    }

    public void setBaseGold(Double baseGold) {
        this.baseGold = baseGold;
    }
    public Integer getCountDay() {
        return countDay;
    }

    public void setCountDay(Integer countDay) {
        this.countDay = countDay;
    }
    public Double getReward() {
        return reward;
    }

    public void setReward(Double reward) {
        this.reward = reward;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Checkin{" +
        "id=" + id +
        ", uId=" + uId +
        ", checkDate=" + checkDate +
        ", baseGold=" + baseGold +
        ", countDay=" + countDay +
        ", reward=" + reward +
        "}";
    }
}
