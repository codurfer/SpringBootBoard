package me.learn.springboot.controller;

import lombok.RequiredArgsConstructor;
import me.learn.springboot.domain.Article;
import me.learn.springboot.dto.ArticleResponse;
import me.learn.springboot.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardViewController {
    private final BoardService boardService;

    @GetMapping("/show/board")
    public String getArticles(Model model) {
        List<ArticleResponse> articles = boardService.findAll().stream()
                .map(ArticleResponse::new)
                .toList();
        model.addAttribute("articles", articles); // 게시판 글 리스트 저장

        return "board"; // boards.html 읽기
    }

    @GetMapping("/show/board/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
        Article article = boardService.findById(id);
        model.addAttribute("article", new ArticleResponse(article));

        return "boardInfo";
    }
}
