package kr.codesquad.service;

import kr.codesquad.domain.Lotto;

import java.util.List;

public class CountNumber {

    MakeLotto makeLotto = new MakeLotto();

    public Lotto collectNumberCount(Lotto lotto, List<Integer> collectNumber) { // 로또 일치 개수 구하기
        for (int i = 0; i < lotto.getSize(); i++) {
            collectNumberCountIndex(lotto,collectNumber,i);
        }
        return lotto;
    }

    public void collectNumberCountIndex(Lotto lotto,List<Integer> collectNumber, int i) {
        int cnt = makeLotto.checkNumber(lotto.getLotto(i), collectNumber);
        if(cnt == 3) lotto.setCollectNum(0,lotto.getCollectNum(0)+1);
        if(cnt == 4) lotto.setCollectNum(1,lotto.getCollectNum(1)+1);
        if(cnt == 5) lotto.setCollectNum(2,lotto.getCollectNum(2)+1);
        if(cnt == 6) lotto.setCollectNum(3,lotto.getCollectNum(3)+1);
    }
}
