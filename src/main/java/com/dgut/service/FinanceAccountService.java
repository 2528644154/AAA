package com.dgut.service;

import com.dgut.model.FinanceAccount;




public interface FinanceAccountService {


    /*通过用户id   查询用户钱包余额*/
    FinanceAccount queryByUid(Integer uid);
}
