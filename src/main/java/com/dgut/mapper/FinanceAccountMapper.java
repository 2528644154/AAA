package com.dgut.mapper;

import com.dgut.model.FinanceAccount;

import java.math.BigDecimal;

public interface FinanceAccountMapper {


    /* 通过 uid 获取用户的账户信息*/
    FinanceAccount selectByUid(Integer uid);

    /*通过uid 检查用户资金 加了悲观锁*/
    FinanceAccount selectByUidForUpdate(Integer uid);

    /*根据  uid 扣除账户购买的资金*/
    int reduceAvailableMoney(Integer uid, BigDecimal bidMoney);

    /**
     * 退款  给钱包加钱 修改状态
     * @param uid
     * @param rechargeMoney
     * @return
     */
    int updateAvailableMoneyByRecharge(Integer uid, BigDecimal rechargeMoney);
}