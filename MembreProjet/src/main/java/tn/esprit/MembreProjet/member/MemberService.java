package tn.esprit.MembreProjet.member;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public List<Member> retrieveAllMembers() {
        return memberRepository.findAll();
    }

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public void deleteMember(Integer id) {
        memberRepository.deleteById(id);
    }

    public Member updateMember(Member member) {
        return memberRepository.save(member);
    }

    public Member retrieveMember(Integer id) {
        return memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id:" + id));
    }


}
