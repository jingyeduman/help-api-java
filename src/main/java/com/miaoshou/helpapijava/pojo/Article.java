package com.miaoshou.helpapijava.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;


@Data
@Table(schema = "article")
public class Article {

    private Integer articleId;

    private Integer websiteId;

}
