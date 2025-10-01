package kr.co.sboard.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
//@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_ARTICLE")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ano;

    private String cate;
    private String title;
    private String content;
    private int comment_cnt;
    private int file_cnt;
    private int hit_cnt;

    private String writer;
    private String reg_ip;

    @CreationTimestamp
    private LocalDateTime wdate;

    //관계설정 안하면 join 해야햄
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ano")
    private List<File> fileList;

    // 추가 필드
    @Transient
    private String nick;

    public void setNick(String nick) {
        this.nick = nick;
    }
}
