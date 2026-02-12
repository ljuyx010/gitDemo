package net.dpwl.hellospringboot.controller;

import net.dpwl.hellospringboot.entity.Article;
import net.dpwl.hellospringboot.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/2/12 15:29
 */
//@RestController
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleServer;
    public ArticleController(ArticleService articleServer) {
        this.articleServer = articleServer;
    }

    @GetMapping("/{id}")
    public Article getArticle(@PathVariable Integer id) {
        return articleServer.getById(id);
    }
}
