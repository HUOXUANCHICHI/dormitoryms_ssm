package com.ablaze.service.impl;

import com.ablaze.dto.AccountDto;
import com.ablaze.entity.DormitoryAdmin;
import com.ablaze.entity.SystemAdmin;
import com.ablaze.form.AccountForm;
import com.ablaze.mapper.DormitoryAdminMapper;
import com.ablaze.mapper.SystemAdminMapper;
import com.ablaze.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: ablaze
 * @Date: 2022/09/08/12:57
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private SystemAdminMapper systemAdminMapper;

    @Autowired
    private DormitoryAdminMapper dormitoryAdminMapper;

    @Override
    public AccountDto login(AccountForm accountForm) {
        AccountDto dto = new AccountDto<>();
        //判断用户类型
        switch (accountForm.getType()) {
            case "systemAdmin":
                SystemAdmin systemAdmin = systemAdminMapper.findByUsername(accountForm.getUsername());
                //判断用户名是否正确
                if (systemAdmin == null) {
                    dto.setCode(-1);
                } else {
                    //判断密码是否正确
                    if(!systemAdmin.getPassword().equals(accountForm.getPassword())){
                        dto.setCode(-2);
                    }else {
                        dto.setCode(0);
                        dto.setAdmin(systemAdmin);
                    }
                }
                break;
            case "dormitoryAdmin":
                DormitoryAdmin dormitoryAdmin = dormitoryAdminMapper.findByUserName(accountForm.getUsername());
                if (dormitoryAdmin == null) {
                    dto.setCode(-1);
                } else {
                    if (!dormitoryAdmin.getPassword().equals(accountForm.getPassword())) {
                        dto.setCode(-2);
                    } else {
                        dto.setCode(0);
                        dto.setAdmin(dormitoryAdmin);
                    }
                }
                break;
            default:
        }
        return dto;
    }
}
