package com.ablaze.service;

import com.ablaze.dto.AccountDto;
import com.ablaze.form.AccountForm;

/**
 * @Author: ablaze
 * @Date: 2022/09/08/12:54
 */
public interface AccountService {

    /**
     * 系统管理员登录
     * @param accountForm
     * @return
     */
    AccountDto login(AccountForm accountForm);
}
