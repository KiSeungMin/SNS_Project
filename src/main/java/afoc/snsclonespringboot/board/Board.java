package afoc.snsclonespringboot.board;

import afoc.snsclonespringboot.board.like.Like;
import afoc.snsclonespringboot.member.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter @Getter
@ToString
@Table(name = "BOARD")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "BOARD_ID")
    private Long boardId;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Long memberId;

    private String dataPath;

    //@OneToMbany(mappedBy = "board")
    //private List<Like> likeList = new ArrayList<>();
}
