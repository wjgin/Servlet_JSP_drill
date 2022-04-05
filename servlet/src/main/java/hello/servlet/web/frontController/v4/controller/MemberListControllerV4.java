package hello.servlet.web.frontController.v4.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontController.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {

    private MemberRepository store = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paraMap, Map<String, Object> model) {
        List<Member> members = store.findAll();

        model.put("members", members);
        return "members";
    }
}
