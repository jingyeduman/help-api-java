package com.miaoshou.helpapijava.pojo;

import lombok.Data;

import javax.persistence.Table;


@Data
@Table(schema = "article_group")

public class ArticleGroup {

    private Integer articleGroupId;

    private Integer websiteId;

}
