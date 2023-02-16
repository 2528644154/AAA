package com.dgut.service.impl;

import com.dgut.mapper.BankCardMapper;
import com.dgut.mapper.FinanceAccountMapper;
import com.dgut.mapper.RechargeRecordMapper;
import com.dgut.model.FinanceAccount;
import com.dgut.model.RechargeRecord;
import com.dgut.service.BankCardService;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.util.Timer;

public class BankCardServiceImpl implements BankCardService {
    @Autowired
    private FinanceAccountMapper financeAccountMapper;
    @Autowired
    private BankCardMapper bankCardMapper;
    @Autowired
    private RechargeRecordMapper rechargeRecordMapper;

    /* 提现 */
    @Override
    public int addCash(Integer uid, BigDecimal money) {
        // 1 . 查询传参是否正确  有无此用户
        //2 .  查询用户钱包余额  ，是否大于参数money  ,若大于才可以提现
        FinanceAccount financeAccount =financeAccountMapper.selectByUidForUpdate(uid);
        int i = financeAccount.getAvailableMoney().compareTo(money);
        if (i >= 1) {
            //3.往银行卡存钱
            int k = bankCardMapper.updateAvailableMoneyByRecharge(uid,money);
            //生成记录表 记录明细
            Date timer = new Date();
            RechargeRecord rechargeRecord = new RechargeRecord(1,uid,"编号",1,money,timer); //记录表构造函数
            rechargeRecordMapper.insert(rechargeRecord);
            return k;
        }else {
            return 0;
        }


    }

    /*充值 ，充值原理与提现一致*/
    @Override
    public int addMoney(Integer uid, BigDecimal money) {
        return 0;
    }
}
