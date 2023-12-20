package kopo.poly.repository.entity;


import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name = "NOTICE")
@Builder
@Entity
public class NoticeEntity {

    @Id  // PK 컬럼에 적용
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrement와 같은 효과. 자동 증가. 항상 @Id와 같이 사용
    @Column(name = "notice_seq")
    private Long noticeSeq;

    @NonNull // NotNull
    @Column(name = "title", length = 500, nullable = false)
    private String title;

    @NonNull
    @Column(name = "notice_yn", length = 1, nullable = false)
    private String noticeYn;

    @NonNull
    @Column(name = "contents", nullable = false)
    private String contents;

    @NonNull
    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "read_cnt", nullable = false)
    private Long readCnt;

    @Column(name = "reg_id", updatable = false)
    private String regId;

    @Column(name = "reg_dt", updatable = false)
    private String regDt;

    @Column(name = "chg_id")
    private String chgId;

    @Column(name = "chg_dt")
    private String chgDt;
}
