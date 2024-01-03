package me.learn.springboot.service;

import lombok.RequiredArgsConstructor;
import me.learn.springboot.domain.Article;
import me.learn.springboot.dto.AddArticleRequest;
import me.learn.springboot.dto.UpdateArticleRequest;
import me.learn.springboot.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service // 빈으로 등록
public class BoardService {
    private final BoardRepository boardRepository;

    // 게시판 글 추가 메서드
    public Article save(AddArticleRequest request) {
        return boardRepository.save(request.toEntity());
    }

    // 게시판 글 모두 조회
    public List<Article> findAll() {
        return boardRepository.findAll();
    }

    // 게시판 글 한개 조회
    public Article findById(long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id "+id + "을 찾을 수 없습니다."));
    }

    // 게시판 글 수정
    @Transactional // 트랜잭션 역활
    public Article update(long id, UpdateArticleRequest request) {
        Article article = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id " + id + "를 못 찾습니다."));

        article.update(request.getTitle(), request.getContent());

        return article;
    }

    // 게시판 글 삭제
    public void delete(long id) {
        boardRepository.deleteById(id);
    }
}
