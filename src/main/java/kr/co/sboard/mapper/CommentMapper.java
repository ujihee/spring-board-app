package kr.co.sboard.mapper;

import kr.co.sboard.dto.CommentDT0;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    public CommentDT0 select(int cno);
    public List<CommentDT0> selectAll(int ano);
    public void insert(CommentDT0 commentDTO);
    public void update(CommentDT0 commentDTO);
    public void delete(int cno);

}
