package com.dgut.mapper;

import com.dgut.model.BankCard;
import com.dgut.model.FinanceAccount;

import java.math.BigDecimal;

public interface BankCardMapper {

    /* 通过 uid 获取用户的银行卡信息*/
    BankCard selectByUid(Integer uid);

    /*通过uid 检查银行资金 加了悲观锁*/
    BankCard selectByUidForUpdate(Integer uid);

    /*充值  根据uid 扣除银行卡的资金*/
    int reduceAvailableMoney(Integer uid, BigDecimal bidMoney);

    /**
     * 提现   用户钱包金钱提现到银行卡
     * @param uid
     * @param rechargeMoney
     * @return
     */
    int updateAvailableMoneyByRecharge(Integer uid, BigDecimal rechargeMoney);
}
