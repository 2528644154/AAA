package com.dgut.service;

import com.dgut.model.User;

public interface UserService {
    /*
     注册   手机号码
     * */
    User userRegister(String phone, String password);

    /*
      登录    手机号码
     * */
    User userLogin(String phone, String loginPassword);

    /**
     * 通过 用户id  获取用户信息 名字
     * @param uid  用户id
     * @return
     */
    User findUserById(Integer uid);
}
