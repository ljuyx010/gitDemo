package net.dpwl.hellospringboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.dpwl.hellospringboot.entity.Article;
import net.dpwl.hellospringboot.mapper.ArticleMapper;
import net.dpwl.hellospringboot.service.ArticleService;
import org.springframework.stereotype.Service;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/2/12 15:28
 */
@Service
public class ArticleImpl extends ServiceImpl<ArticleMapper,Article> implements ArticleService {

}
