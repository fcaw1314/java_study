package org.bite.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.bite.mybatis.model.ArticleInfo;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/25 16:25
 */

@Mapper
public interface ArticleInfoMapper {

    @Select("select ta.*, tb.username, tb.age from articleinfo ta " +
            "left join userinfo tb on ta.uid = tb.id " +
            "where ta.id = #{id}")
    ArticleInfo queryArticleInfo(Integer id);

}
