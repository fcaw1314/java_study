package org.example.book.Model;

import lombok.Data;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/26 16:42
 */
@Data
public class RequestPage {
    private Integer currentPage = 1;
    private Integer pageSize = 10;
}
