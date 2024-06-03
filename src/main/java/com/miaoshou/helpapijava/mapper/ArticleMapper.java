package com.miaoshou.helpapijava.mapper;


import com.miaoshou.helpapijava.pojo.Article;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;


public interface ArticleMapper extends Mapper<Article> {
    @Select("select * from article where article_id = 2")
    public Article getOneArticle();
}
