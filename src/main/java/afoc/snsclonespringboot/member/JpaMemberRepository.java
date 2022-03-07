package afoc.snsclonespringboot.member;

import afoc.snsclonespringboot.board.Board;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaMemberRepository implements MemberRepository{

    @PersistenceContext
    private EntityManager em;

    public JpaMemberRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public Member save(Member member) {

        em.persist(member);

        return member;
    }

    // TODO - 변경
    // member의 boardList에 인수로 받은 board 객체 추가
    // 인수로 받은 board 객체에도 board가 어떤 member 객체의 board인지 세팅
    public void setBoardItem(Member member, Board board){

//        List<Board> boardList = member.getBoardList();
//
//        boardList.add(board);
//
//        board.setMember(member);
    }

    // memberId를 이용해 member 서칭
    @Override
    public Optional<Member> findMemberByMemberId(Long MemberId) {

        Member findMember = em.find(Member.class, MemberId);

        return Optional.of(findMember);
    }

    //
    @Override
    public Optional<Member> findMemberByMemberEmail(String email){

        Member findMember = em.find(Member.class, email);

        return Optional.of(findMember);
    }

//    @Override
//    public List<Board> findBoardListByMemberId(Long memberId){
//
//        Member findMember = findMemberByMemberId(memberId).get();
//
//        return findMember.getBoardList();
//    }

    // TODO
    @Override
    public Boolean updateMember(Member member) {

//        Member findMember = findMemberByMemberId(memberId).get();
//
//        // update
//
//        return Optional.of(findMember);
        return false;
    }

    // TODO
    @Override
    public Boolean deleteMemberByMemberId(Long memberId) {

//        if(findMemberByMemberId(memberId).get() != null){
//            em.remove(em.find(Member.class, memberId));
//            return true;
//        }
        return false;
    }

    // TODO
    @Override
    public void clear(){
    }
}
