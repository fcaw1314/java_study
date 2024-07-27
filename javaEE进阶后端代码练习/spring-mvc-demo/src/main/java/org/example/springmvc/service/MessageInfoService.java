package org.example.springmvc.service;

import org.example.springmvc.mapper.MessageInfoMapper;
import org.example.springmvc.model.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/27 16:16
 */
@Service
public class MessageInfoService {

    @Autowired
    private MessageInfoMapper messageInfoMapper;

    public Integer insertMessage(MessageInfo messageInfo) {
        return messageInfoMapper.insertMessage(messageInfo);
    }

    public List<MessageInfo> queryMessage() {
        return messageInfoMapper.queryMessage();
    }
}
