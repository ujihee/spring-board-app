package kr.co.sboard.repository;

import com.querydsl.core.Tuple;
import kr.co.sboard.dto.PageRequestDTO;
import kr.co.sboard.dto.PageResponseDTO;
import kr.co.sboard.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleRepositoryTest {

    @Autowired
    ArticleRepository articleRepository;

    @Test
    @Transactional
    void test1(){

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();

        Pageable pageable = pageRequestDTO.getPageable("ano");

        Page<Tuple> pageTuple = articleRepository.selectArticleAllForList(pageRequestDTO, pageable);

        List<Tuple> tupleList = pageTuple.getContent();

        System.out.println(tupleList);
    }

    @Test
    @Transactional //no session에러시: select이 article, file 두번 들어감 -> 한번에
    void test2(){

        Optional<Article> optArticle = articleRepository.findById(10);

        if(optArticle.isPresent()){

            Article article = optArticle.get();
            System.out.println(article);
        }
    }

}