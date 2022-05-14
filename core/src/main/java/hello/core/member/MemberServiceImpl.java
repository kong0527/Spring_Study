package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // ctrl shift enter 하면 ;까지 자동으로 쳐짐
    // DIP 위반
    // private final MemberRepository memberRepository = new MemoryMemberRepository()

    // 수정
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        // 다형성에 의해 override한 save가 호출됨
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
