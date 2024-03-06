package hello.hellospirng.repository;

import hello.hellospirng.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    // TODO::concurrent hashmap 이란? 동시성 문제
    // TODO::AtomicLong? 도 동시성 문제

    private static long sequence = 0L;
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    /**
     * null 로 넘어 올 수 있기 때문에 Optional 로 감사줍니다.
     * @param id
     * @return
     */
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    /**
     * 실무에서는 loop 돌리기가 편해서 list 를 더 많이 쓰기 때문에 list 로 변환
     * @return
     */
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
