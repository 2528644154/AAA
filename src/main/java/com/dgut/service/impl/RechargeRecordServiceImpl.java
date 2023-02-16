package com.dgut.service.impl;

import com.dgut.mapper.BankCardMapper;
import com.dgut.mapper.FinanceAccountMapper;
import com.dgut.mapper.RechargeRecordMapper;
import com.dgut.model.FinanceAccount;
import com.dgut.model.RechargeRecord;
import com.dgut.service.RechargeRecordService;

import java.math.BigDecimal;
import java.util.Date;

public class RechargeRecordServiceImpl implements RechargeRecordService {


    @Autowired
    private FinanceAccountMapper financeAccountMapper;
    @Autowired
    private BankCardMapper bankCardMapper;
    @Autowired
    private RechargeRecordMapper rechargeRecordMapper;
    /**
     * 用户消费100元的接口    如果成功  给用户的钱包余额减钱，同时记录消费信息到RechargeRecord中
     * @param uid  用户
     * @param money = 100消费金额
     * @return
     */
    @Override
    public int addConsumption(Integer uid, BigDecimal money) {

        //1.查看用户余额
        FinanceAccount financeAccount = financeAccountMapper.selectByUidForUpdate(uid);
        //2.判断余额大于消费金额
        int i = financeAccount.getAvailableMoney().compareTo(money);
        if(i>=1){
            System.out.println("消费成功");
            //减少钱包金钱
            int i1 = financeAccountMapper.reduceAvailableMoney(uid, money);
            //生成记录表 记录明细
            Date timer = new Date();
            RechargeRecord rechargeRecord = new RechargeRecord(1,uid,"编号",1,money,timer); //记录表构造函数
            int insert = rechargeRecordMapper.insert(rechargeRecord);
            return insert;
        }else{
            System.out.println("余额不足");
        }

        return 0;
    }
    /**
     * 用户退款20元接口    如果成功  给用户的钱包余额加钱，同时记录退款信息到RechargeRecord中
     * @param uid  用户
     * @param money = 20退款金额
     * @return
     */
    @Override
    public int addRefund(Integer uid, BigDecimal money) {
        int i = financeAccountMapper.updateAvailableMoneyByRecharge(uid, money);
        //生成记录表 记录明细
        Date timer = new Date();
        //记录表状态为 3 退款
        RechargeRecord rechargeRecord = new RechargeRecord(1,uid,"编号",3,money,timer); //记录表构造函数
        int insert = rechargeRecordMapper.insert(rechargeRecord);
        return insert;
    }

    @Override
    public RechargeRecord showRechargeRecord() {
        RechargeRecord rechargeRecord = rechargeRecordMapper.selectAll();
        return rechargeRecord;
    }
}
