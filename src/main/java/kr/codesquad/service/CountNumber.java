package kr.codesquad.service;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.Person;

import java.util.List;

public class CountNumber {

    public Integer checkNumber(List<Integer> inputLotto, List<Integer> compLotto) { //로또 맞는 개수 구하기
        int cnt = 0;
        for (int i = 0; i < compLotto.size(); i++) {
            cnt = checkNumberCount(inputLotto, compLotto.get(i),cnt);
        }
        return cnt;
    }

    public int checkNumberCount(List<Integer> inputLotto, int b,int cnt) {
        if (inputLotto.contains(b)) {
            cnt++;
        }
        return cnt;
    }

    public Person collectNumberCount(Person person, Lotto lotto) { // 로또 일치 개수 구하기
        for (int i = 0; i < person.getSize(); i++) {
            collectNumberCountIndex(person,lotto,i);
        }
        return person;
    }

    public void collectNumberCountIndex(Person person, Lotto lotto, int i) {
        int cnt = checkNumber(person.getLotto(i), lotto.getWinNumber());
        if(cnt == 3) person.setWinNumber(0, person.getWinNumber(0)+1);
        if(cnt == 4) person.setWinNumber(1, person.getWinNumber(1)+1);
        if(cnt == 5) checkBonus(person.getLotto(i),lotto.getBonus(),person);
        if(cnt == 6) person.setWinNumber(4, person.getWinNumber(4)+1);
    }

    public void checkBonus(List<Integer> list, int bonus, Person person) {
        if(!list.contains(bonus)) person.setWinNumber(2, person.getWinNumber(2)+1);
        if(list.contains(bonus)) person.setWinNumber(3, person.getWinNumber(3)+1);
    }
}
