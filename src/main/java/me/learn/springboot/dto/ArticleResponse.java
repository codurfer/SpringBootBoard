package me.learn.springboot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.learn.springboot.domain.Article;

@NoArgsConstructor
@Getter
public class ArticleResponse {
    private Long id;
    private String title;
    private String content;

    public ArticleResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
