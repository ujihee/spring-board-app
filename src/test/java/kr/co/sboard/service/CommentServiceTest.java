package kr.co.sboard.service;

import kr.co.sboard.dto.CommentDT0;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceTest {

    @Autowired
    CommentService commentService;

    @Test
    void getCommentAll() {
        List<CommentDT0> dtoList = commentService.getCommentAll(6);
        System.out.println(dtoList);
    }

    @Test
    void getComment() {
    }

    @Test
    void save() {

        CommentDT0 commentDTO = CommentDT0.builder()
                .ano(11)
                .content("11번 댓글")
                .writer("tmfflavndn")
                .reg_ip("127.0.0.1")
                .build();

        CommentDT0 savedCommentDTO = commentService.save(commentDTO);
        System.out.println(savedCommentDTO);

    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}