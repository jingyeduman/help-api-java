package com.miaoshou.helpapijava.controller;

import com.miaoshou.helpapijava.pojo.Article;
import com.miaoshou.helpapijava.pojo.ArticleGroup;
import com.miaoshou.helpapijava.service.ArticleGroupService;
import com.miaoshou.helpapijava.service.ArticleService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleGroupService articleGroupService;

    @RequestMapping("/get_all")
    public List<Article> getAll() {
        return articleService.getAll();
    }

    @RequestMapping("/get_one")
    public Article getOne(HttpServletRequest request) {
        Article article = articleService.getOne();
        System.out.println("article" + article);

        System.out.println(request.getSession(true).getAttribute("test"));

        request.getSession(true).setAttribute("test", "555");

        Enumeration<String> attributeNames = request.getSession().getAttributeNames();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return article;
    }

    @RequestMapping("/test_group")
    public List<ArticleGroup> testGroup() {
        return articleGroupService.test();
    }

    @RequestMapping("/selectOneByExample")
    public ArticleGroup selectOneByExample() {
        return articleGroupService.selectOneByExample();
    }

}
