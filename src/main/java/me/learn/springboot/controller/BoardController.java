package me.learn.springboot.controller;

import lombok.RequiredArgsConstructor;
import me.learn.springboot.domain.Article;
import me.learn.springboot.dto.AddArticleRequest;
import me.learn.springboot.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController //HTTP Response Body에 객체 JSON 형식으로 반환하는 컨트롤러
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/test/data")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = boardService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }
}
