package org.example.book.Model;

import lombok.Data;

import java.util.List;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/26 16:39
 */
@Data
public class PageResult<T> {
    private List<T> bookInfos;
    private int count;
}
