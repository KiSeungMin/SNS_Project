package afoc.snsclonespringboot.config;

import afoc.snsclonespringboot.board.*;
import afoc.snsclonespringboot.member.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Persistent;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class AppConfig {
    @PersistenceContext
    private EntityManager em;

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JpaMemberRepository(em);
    }

    @Bean
    public BoardService boardService() {
        return new BoardServiceImpl(boardRepository());
    }

    @Bean
    public BoardRepository boardRepository() {
//        return new MemoryBoardRepository();
        return new JpaBoardRepository(em);
    }
}
