package hello.servlet.domain.member;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 작은 프로젝트이기에 repository 하나의 패키지에 생성
 * -> 프로젝트가 크면 나눠주는게 좋은
 * 동시성 문제로 HashMap을 사용하지 않고 실무에선 ConcurrentHashMap, AtomicLong 고려
 */
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    // singleton 생성
    private static final MemberRepository instance = new MemberRepository();

    // 생성자를 private으로 만들어서 싱글톤이 깨지지 않게 외부 생성을 막음
    private MemberRepository() {
    }
    // 외부에서 싱글톤으로 생성된 instance를 사용할 수 있게 메서드 생성
    public static MemberRepository getInstance(){
        return instance;
    }

    // repository에 member 저장
    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    // id로 member 조회
    public Member findById(Long id){
        return store.get(id);
    }

    // 모든 member 조회
    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    // store 모두 삭제
    public void clearStore(){
        store.clear();
    }


}
