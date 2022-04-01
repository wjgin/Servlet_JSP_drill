package hello.servlet.web.frontController.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontController.ModelView;
import hello.servlet.web.frontController.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    private MemberRepository store = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        List<Member> members = store.findAll();
        ModelView mv = new ModelView("members");    // 전체 멤버 조회 논리 이름
        mv.getModel().put("members", members);  // 전송할 모델이 list 넣어주기

        return mv;
    }
}
