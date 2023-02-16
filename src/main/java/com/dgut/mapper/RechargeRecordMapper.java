package com.dgut.mapper;

import com.dgut.model.RechargeRecord;

public interface RechargeRecordMapper {


/*生成订单明细表  记录*/
    int insert(RechargeRecord record);
/*查看所有记录表*/
    RechargeRecord selectAll();
}
