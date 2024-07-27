package org.example.springmvc.coontroller;

import org.example.springmvc.model.MessageInfo;
import org.example.springmvc.service.MessageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/14 9:36
 */

@RequestMapping("/message")
@RestController
public class MessageController {
//    //存储留言信息
//    private List<MessageInfo> messageInfoList = new ArrayList<>();

    @Autowired
    private MessageInfoService messageInfoService;

    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public Boolean publish(@RequestBody MessageInfo messageInfo){
        System.out.println("发表留言");
        //添加到数据库中
//        messageInfoList.add(messageInfo);
        messageInfoService.insertMessage(messageInfo);
        return true;
    }

    @RequestMapping("/getList")
    public List<MessageInfo> getList(){
        //从数据库中查询
        return messageInfoService.queryMessage();
//        return messageInfoList;

    }
}
