package com.yxb.blog.utils;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {

    @Test
    void format() {
        System.out.println(DateUtils.format(new Date()));
    }
}