package org.example.book.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/26 16:39
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageResult<T> {
    private List<T> items;
    private int count;
    private RequestPage requestPage;

}
