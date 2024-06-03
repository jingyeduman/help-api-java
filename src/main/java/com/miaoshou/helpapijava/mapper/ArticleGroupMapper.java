package com.miaoshou.helpapijava.mapper;


import com.miaoshou.helpapijava.pojo.ArticleGroup;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ArticleGroupMapper extends Mapper<ArticleGroup> {

    public List<ArticleGroup> test();
}
