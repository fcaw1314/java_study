package org.example.springmvc.mapper;

import org.example.springmvc.model.MessageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class MessageInfoMapperTest {

    @Autowired
    private MessageInfoMapper messageInfoMapper;

    @Test
    void insertMessage() {
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setFrom("你");
        messageInfo.setTo("我");
        messageInfo.setMessage("一定找到高薪工作");
        messageInfoMapper.insertMessage(messageInfo);
    }

    @Test
    void queryMessage() {
        messageInfoMapper.queryMessage().forEach(System.out::println);
    }
}