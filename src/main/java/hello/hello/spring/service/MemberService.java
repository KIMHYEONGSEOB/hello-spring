package hello.hello.spring.service;

import hello.hello.spring.domain.Member;
import hello.hello.spring.repository.MemberRepository;
import hello.hello.spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


public class MemberService {

    private  final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /****** 회원 가입******/
    public Long join(Member member){
        //같은 이름이 있는 중복 회원은 x
        memberRepository.findByName(member.getName())
            .ifPresent(m-> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });

        memberRepository.save(member);
        return  member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName());

    }
    /*전체 회원 조회*/
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(long memberId){
        return memberRepository.findById(memberId);
    }
}
