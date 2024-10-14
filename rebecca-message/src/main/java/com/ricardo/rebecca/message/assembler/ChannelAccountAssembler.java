package com.ricardo.rebecca.message.assembler;

import com.ricardo.rebecca.api.dto.SaveAccountDTO;
import com.ricardo.rebecca.api.entity.ChannelAccount;
import com.ricardo.rebecca.common.constant.RebeccaConstant;
import com.ricardo.rebecca.common.enums.ValidEnum;

import java.util.Date;

/**
 * @Class ChannelAccountAssembler
 * @Description TODO
 * @Author Cypress
 * @Date 2024/10/14 20:50
 */
public class ChannelAccountAssembler {

    public static ChannelAccount convertToEntity(ChannelAccount account, SaveAccountDTO dto, boolean isNewAccount) {
        Date nowTime = new Date();

        account.setAccountConfig(dto.getAccountConfig());
        account.setName(dto.getName());
        account.setSendChannel(dto.getSendChannel());
        account.setUpdated(nowTime);

        if (isNewAccount){
            account.setCreated(nowTime);
            account.setUserId(RebeccaConstant.DEFAULT_USER_ID);
            account.setIsValid(ValidEnum.VALID.getCode());
        }
        return account;
    }

}
