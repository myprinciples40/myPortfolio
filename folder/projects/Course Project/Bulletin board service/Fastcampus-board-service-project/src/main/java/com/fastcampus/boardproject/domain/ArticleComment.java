package com.fastcampus.boardproject.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy"),
})

@Entity
public class ArticleComment extends AuditingFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(optional = false)
    private Article article; //Post (ID)

    @Setter
    @ManyToOne(optional = false)
    private UserAccount userAccount;

    @Setter @Column(nullable = false, length = 500) private String content; //Body

    protected ArticleComment() {
    }

    private ArticleComment(Article article, UserAccount userAccount, String content) {
        this.article = article;
        this.userAccount = userAccount;
        this.content = content;
    }

    public static ArticleComment of(Article article, UserAccount userAccount, String content) {
        return new ArticleComment(article, userAccount, content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
//        if (!(o instanceof ArticleComment that)) return false;
        if (!(o instanceof ArticleComment articleComment)) return false;
        return this.getId() != null && this.getId().equals(articleComment.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}
