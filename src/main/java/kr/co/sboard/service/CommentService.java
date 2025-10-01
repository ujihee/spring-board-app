package kr.co.sboard.service;

import kr.co.sboard.dto.CommentDT0;
import kr.co.sboard.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentMapper commentMapper;

    public List<CommentDT0> getCommentAll(int ano) {
        return commentMapper.selectAll(ano);
    }
    public CommentDT0 getComment(int cno) {
        return commentMapper.select(cno);
    }
    public CommentDT0 save(CommentDT0 commentDTO){
        commentMapper.insert(commentDTO);
        return getComment(commentDTO.getCno());

    }
    public void update(CommentDT0 commentDTO) {
        commentMapper.update(commentDTO);
    }
    public void delete(int cno) {
        commentMapper.delete(cno);
    }
}
