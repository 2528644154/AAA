CREATE TABLE `u_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID，主键',
  `phone` varchar(11) NOT NULL COMMENT '注册手机号码',
  `login_password` varchar(32) NOT NULL COMMENT '登录密码，密码长度最大16位',
  `name` varchar(16) DEFAULT NULL COMMENT '用户姓名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='用户表';

CREATE TABLE `u_finance_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL COMMENT '用户ID',
  `available_money` decimal(11,2) NOT NULL DEFAULT '0.00' COMMENT '用户可用资金',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用户钱包';


CREATE TABLE `u_Bank_card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL COMMENT '用户ID',
   `password` varchar(12) NOT NULL COMMENT '银行卡密码，密码长度最大6位',
  `account_balance` decimal(11,2) NOT NULL DEFAULT '0.00' COMMENT '账户余额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用户银行卡';

CREATE TABLE `b_recharge_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL COMMENT '用户id',
  `recharge_no` varchar(50) NOT NULL COMMENT '消费订单号',
  `recharge_status` int(1) NOT NULL COMMENT '订单状态（0充值中，1充值成功，2充值失败，3申请退款）',
  `recharge_money` decimal(11,2) NOT NULL DEFAULT '0.00' COMMENT '消费金额',
  `recharge_time` datetime NOT NULL COMMENT '消费时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8 COMMENT='消费记录表';