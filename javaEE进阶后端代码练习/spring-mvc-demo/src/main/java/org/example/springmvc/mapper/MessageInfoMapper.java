package org.example.springmvc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.springmvc.model.MessageInfo;

import java.util.List;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/27 15:58
 */
@Mapper
public interface MessageInfoMapper {
    /**
     * @description 添加留言
     * spring-mvc-demo       
     * @date 2024/7/27 15:59:09
     */
    @Insert("insert into message_info (`from`, `to`, `message`) values " +
            "(#{from}, #{to}, #{message})")
    Integer insertMessage(MessageInfo messageInfo);
    
    /**
     * @description 查询留言列表
     * spring-mvc-demo       
     * @date 2024/7/27 16:00:01
     */
    @Select("select * from message_info where delete_flag = 0")
    List<MessageInfo> queryMessage();
}
