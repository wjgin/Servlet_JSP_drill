package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringmvcMemberControllerV3 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    // Sptring annotation 사용으로 return을 String으로 반환하면 view 파싱
    // method 인자롤 주어서 해당하는 요청 method에만 실행되게 설정 가능
    // @RequestMapping(value = "/new-form", method = RequestMethod.GET)
    @GetMapping("/new-form")    // @RequestMapping(method = ...)의 발전 단계
    public String  newForm(){
        return "new-form";
    }

    // 인자로 파라미터를 직접 받을 수 있음, 자동 형변환 제공
    // Model 객체를 사용 가능
    @PostMapping("/save")
    public String save(
            @RequestParam("username")String username,
            @RequestParam("age")int age,
            Model model
    ){
        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }


    // 인자로 model 만 사용도 가능 (유연함)
    @GetMapping
    public String members(Model model){
        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);
        return "members";
    }
}
