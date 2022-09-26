package com.ablaze.dto;

import lombok.Data;

/**
 * @Author: ablaze
 * @Date: 2022/09/08/12:55
 */
@Data
public class AccountDto<T> {
    /**
     * -1 用户名错误
     * -2 密码错误
     *  0 登陆成功
     */
    private Integer code;
    private T admin;
}
