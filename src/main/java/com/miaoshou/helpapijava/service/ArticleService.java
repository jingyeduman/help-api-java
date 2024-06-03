package com.miaoshou.helpapijava.service;

import com.miaoshou.helpapijava.mapper.ArticleMapper;
import com.miaoshou.helpapijava.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    public List<Article> getAll() {
        List<Article> categories = articleMapper.selectAll();

        return categories;
    }

    public Article getOne() {
        return articleMapper.getOneArticle();
    }
}
