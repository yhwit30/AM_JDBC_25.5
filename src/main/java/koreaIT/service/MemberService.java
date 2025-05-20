package koreaIT.service;

import koreaIT.Member;
import koreaIT.container.Container;
import koreaIT.dao.MemberDao;

import java.util.Map;

public class MemberService {

    private MemberDao memberDao = null;

    public MemberService() {
        this.memberDao = Container.memberDao;
    }

    public boolean isLoginJoinable(String loginId) {
        return memberDao.isLoginJoinable(loginId);
    }

    public int doJoin(String loginId, String loginPw, String name) {
        return memberDao.doJoin(loginId, loginPw, name);
    }

    public Member getMemberByLoginId(String loginId) {
        Map<String, Object> memberMap = memberDao.getMemberByLoginId(loginId);

        Member member = new Member(memberMap);

        return member;
    }
}
