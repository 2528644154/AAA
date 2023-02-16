package com.dgut.service.impl;

import com.dgut.mapper.FinanceAccountMapper;
import com.dgut.model.FinanceAccount;
import com.dgut.service.FinanceAccountService;

public class FinanceAccountServiceimpl implements FinanceAccountService {

    @Autowired
    private FinanceAccountMapper financeAccountMapper;
    @Override
    public FinanceAccount queryByUid(Integer uid) {
        /*通过用户id   查询用户钱包余额*/
        return financeAccountMapper.selectByUid(uid);
    }
}
