package kr.codesquad.service;

import kr.codesquad.domain.Person;

import java.util.List;

public class CountNumber {

    public Integer checkNumber(List<Integer> inputLotto, List<Integer> compLotto) { //로또 맞는 개수 구하기
        int cnt = 0;
        for (int i = 0; i < compLotto.size(); i++) {
            cnt = checkNumber(inputLotto, compLotto.get(i),cnt);
        }
        return cnt;
    }

    public int checkNumber(List<Integer> inputLotto, int b,int cnt) {
        if (inputLotto.contains(b)) {
            cnt++;
        }
        return cnt;
    }

    public Person collectNumberCount(Person person, List<Integer> collectNumber) { // 로또 일치 개수 구하기
        for (int i = 0; i < person.getSize(); i++) {
            collectNumberCountIndex(person,collectNumber,i);
        }
        return person;
    }

    public void collectNumberCountIndex(Person person, List<Integer> collectNumber, int i) {
        int cnt = checkNumber(person.getLotto(i), collectNumber);
        if(cnt == 3) person.setCollectNum(0, person.getCollectNum(0)+1);
        if(cnt == 4) person.setCollectNum(1, person.getCollectNum(1)+1);
        if(cnt == 5) person.setCollectNum(2, person.getCollectNum(2)+1);
        if(cnt == 6) person.setCollectNum(3, person.getCollectNum(3)+1);
    }
}
