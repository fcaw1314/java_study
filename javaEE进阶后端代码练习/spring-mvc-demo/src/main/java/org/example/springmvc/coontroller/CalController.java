package org.example.springmvc.coontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/13 9:59
 */

@RestController
@RequestMapping("/calc")
public class CalController {
    @RequestMapping("/sum")
    public String sum(Integer num1, Integer num2) {
        //参数校验省略
        Integer sum = num1 + num2;
        return "计算结果: " + sum;
    }
}
