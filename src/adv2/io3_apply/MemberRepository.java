package adv2.io3_apply;

import java.util.List;

public interface MemberRepository {
    void add(Member member);
    List<Member> findAll();
}
