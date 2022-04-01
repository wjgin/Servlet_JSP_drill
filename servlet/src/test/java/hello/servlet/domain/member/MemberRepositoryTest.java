package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach  // 모든 테스트 후에 실행
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        // given
        Member member = new Member("hello", 20);
        // when
        Member savedMember = memberRepository.save(member);
        // then
        Member foundMember = memberRepository.findById(member.getId());
        assertThat(savedMember).isEqualTo(foundMember);
    }

    @Test
    void findAllMembers(){
        // given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        // when
        List<Member> allMembers = memberRepository.findAll();

        // then
        assertThat(allMembers.size()).isEqualTo(2); // 저장된 member가 2명이 맞는지 확인
        assertThat(allMembers).contains(member1, member2);  // member1, member2가 제대로 저장이 되었는지 확인
    }


}