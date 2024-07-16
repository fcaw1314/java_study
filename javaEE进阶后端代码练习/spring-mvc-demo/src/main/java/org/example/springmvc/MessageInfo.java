package org.example.springmvc;

import lombok.Data;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/14 9:33
 */

@Data
public class MessageInfo {
    private String from;
    private String to;
    private String msg;
}
