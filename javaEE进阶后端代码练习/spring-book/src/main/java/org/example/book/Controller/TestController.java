package org.example.book.Controller;

import org.example.book.Model.BookInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/30 11:29
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/t1")
    public String t1(){
        return "t1";
    }

    @RequestMapping("/t2")
    public Integer t2(){
        int a = 10/0;
        return 10;
    }

    @RequestMapping("/t3")
    public Boolean t3(){
        return true;
    }

    @RequestMapping("/t4")
    public BookInfo t4(){
        return new BookInfo();
    }

}
