package com.dgut.service;

import com.dgut.model.RechargeRecord;

import java.math.BigDecimal;




public interface RechargeRecordService {


    /**
     * 用户消费100元的接口    如果成功  给用户的钱包余额减钱，同时记录消费信息到RechargeRecord中
     * @param uid  用户
     * @param money = 100消费金额
     * @return
     */
    int addConsumption(Integer uid, BigDecimal money);

    /**
     * 用户退款20元接口    如果成功  给用户的钱包余额加钱，同时记录退款信息到RechargeRecord中
     * @param uid  用户
     * @param money = 20退款金额
     * @return
     */
    int addRefund(Integer uid, BigDecimal money);


    /**
     *  查询用户钱包金额变动明细的接口
   RechargeRecord详细信息
     */
    RechargeRecord showRechargeRecord();
}
