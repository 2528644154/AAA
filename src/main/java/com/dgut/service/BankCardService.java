package com.dgut.service;

import java.math.BigDecimal;

public interface BankCardService {


    /**
     *  钱包提现到银行卡的接口    如果成功  给用户的钱包余额减钱，同时记录消费信息到RechargeRecord中,银行卡余额增加
     * @param uid  用户
     * @param money 提现金钱
     * @return
     */
    int addCash(Integer uid, BigDecimal money);

    /**
     * 银行卡向钱包充值金钱  如果成功  给用户的钱包余额加钱，同时记录退款信息到RechargeRecord中，银行卡余额减少
     * @param uid  用户
     * @param money
     * @return
     */
    int addMoney(Integer uid, BigDecimal money);
}
