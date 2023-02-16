package com.dgut.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class RechargeRecord implements Serializable {
    private Integer id;

    private Integer uid;

    private String rechargeNo;

    private Integer rechargeStatus;

    private BigDecimal rechargeMoney;

    private Date rechargeTime;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getRechargeNo() {
        return rechargeNo;
    }

    public void setRechargeNo(String rechargeNo) {
        this.rechargeNo = rechargeNo;
    }

    public Integer getRechargeStatus() {
        return rechargeStatus;
    }

    public void setRechargeStatus(Integer rechargeStatus) {
        this.rechargeStatus = rechargeStatus;
    }

    public BigDecimal getRechargeMoney() {
        return rechargeMoney;
    }

    public void setRechargeMoney(BigDecimal rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }

    public Date getRechargeTime() {
        return rechargeTime;
    }

    public void setRechargeTime(Date rechargeTime) {
        this.rechargeTime = rechargeTime;
    }

    public RechargeRecord(Integer id, Integer uid, String rechargeNo, Integer rechargeStatus, BigDecimal rechargeMoney, Date rechargeTime) {
        this.id = id;
        this.uid = uid;
        this.rechargeNo = rechargeNo;
        this.rechargeStatus = rechargeStatus;
        this.rechargeMoney = rechargeMoney;
        this.rechargeTime = rechargeTime;
    }
}