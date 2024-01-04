package oop.collection.list.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetMain {
    public static void main(String[] args) {
        Set<Member> memberSet = new HashSet<>();

        memberSet.add(new Member("TJ", 30));
        memberSet.add(new Member("David", 29));
        memberSet.add(new Member("David", 29));

        System.out.println(memberSet.size()); // 2 because duplicates are not allowed in set

        // 객체를 하나씩 가져와서 처리
        Iterator<Member> itMember = memberSet.iterator();
        // Option 1 : 도는 와중에 어떠한 처리를 해주고 싶을 떄
        while (itMember.hasNext()) {
            Member member = itMember.next();
            System.out.println("이름: " + member.name + " 나이 : " + member.age);

            // 어떠한 처리 (삭제)
            if (member.name.equals("David")) {
                itMember.remove();
            }
        }
        System.out.println("=====================================================");
        // Option 2 : 그냥 프린트만
        for (Member member: memberSet) {
            System.out.println("이름: " + member.name + " 나이 : " + member.age);
        }


        /**
         * OUTPUT:
         * 이름: TJ 나이 : 30
         * 이름: David 나이 : 29
         * 이름: David 나이 : 29
         * 이름: TJ 나이 : 30
         */

    }// main
}// class
