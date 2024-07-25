package org.example.springmvc.coontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/12 11:35
 */
//@RestController
@RequestMapping("/response")
@Controller
public class ResponseController {
    @RequestMapping("/index")
    public String index() {
        return "/index.html";
    }

    @ResponseBody
    @RequestMapping(value = "/r1", produces = "application/json; charset=UTF-8")
    public String r1() {
        return "{\"status\":400}";
    }
}
