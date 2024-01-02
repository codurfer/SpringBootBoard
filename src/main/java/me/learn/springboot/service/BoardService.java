package me.learn.springboot.service;

import lombok.RequiredArgsConstructor;
import me.learn.springboot.domain.Article;
import me.learn.springboot.dto.AddArticleRequest;
import me.learn.springboot.repository.BoardRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service // 빈으로 등록
public class BoardService {
    private final BoardRepository boardRepository;

    //블로그 글 추가 메서드
    public Article save(AddArticleRequest request) {
        return boardRepository.save(request.toEntity());
    }
}
