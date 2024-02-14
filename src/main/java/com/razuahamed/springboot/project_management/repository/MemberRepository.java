package com.razuahamed.springboot.project_management.repository;
import com.razuahamed.springboot.project_management.model.Member;
import com.razuahamed.springboot.project_management.model.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemberRepository {
    private List<Member> memberList;

    public MemberRepository() {
        memberList = new ArrayList<>();
        Member akash = new Member("Akash Rahman", 20, "akash@dsinnovators.com", 10);
        Member nakib = new Member("Nakibur Rahman", 25, "nakib@dsinnovators.com", 20);
        Member reyad = new Member("Reyad Ahamed", 30, "reyad@dsinnovators.com", 30);
        Member foez = new Member("Foez Ahamed", 40, "foez@dsinnovators.com", 40);
        Member safi = new Member("Ataus Safi", 50, "safi@dsinnovators.com", 50);
        Member rafi = new Member("Rubait Rafi", 25, "rafi@dsinnovators.com", 60);
        Member rifa = new Member("Rifa Mist", 24, "rifa@dsinnovators.com", 90);
        Member tulon = new Member("Tulon khan", 25, "tulon@dsinnovators.com", 100);
        Member fardin = new Member("Fardin Mia", 26, "fardin@dsinnovators.com", 110);

        memberList.add(akash);
        memberList.add(nakib);
        memberList.add(reyad);
        memberList.add(foez);
        memberList.add(safi);
        memberList.add(rafi);
        memberList.add(rifa);
        memberList.add(tulon);
        memberList.add(fardin);
    }

    public void addMember(Member member) {
        member.setId(memberList.get(memberList.size()-1).getId()+10);
        memberList.add(member);
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    public Member getMemberByName(String name) {
        for(Member member : memberList) {
            if(member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "MemberRepository{" +
                "memberList=" + memberList +
                '}';
    }
}
