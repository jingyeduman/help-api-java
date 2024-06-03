package com.miaoshou.helpapijava.service;

import com.miaoshou.helpapijava.mapper.ArticleGroupMapper;
import com.miaoshou.helpapijava.mapper.ArticleMapper;
import com.miaoshou.helpapijava.pojo.Article;
import com.miaoshou.helpapijava.pojo.ArticleGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ArticleGroupService {
    @Autowired
    private ArticleGroupMapper articleGroupMapper;

    public List<ArticleGroup> test() {
        return articleGroupMapper.test();
    }

    public ArticleGroup selectOneByExample() {
        Example example = new Example(ArticleGroup.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("articleGroupId", 1);

        return articleGroupMapper.selectOneByExample(example);

    }
}
