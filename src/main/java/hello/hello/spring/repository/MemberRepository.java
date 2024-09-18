package hello.hello.spring.repository;
/*회원 객체를 저장하는 저장소*/
import hello.hello.spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);//회원을 저장하면 저장한 회원이 반환됨
    Optional<Member> findById(long id);//ID로 회원을 찾음
    Optional<Member> findByName(String name);//이름으로 회원을 찾음
    List<Member> findAll();// 지금까지 저장된 모든회원리스트를 반환함

}
