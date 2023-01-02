package kr.codesquad;

import kr.codesquad.domain.Lotto;
import kr.codesquad.service.CountNumber;
import kr.codesquad.service.MakeLotto;
import kr.codesquad.service.ScannerInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Lotto lotto = new Lotto();
    static MakeLotto makeLotto = new MakeLotto();
    static List<Integer> winNumber = new ArrayList<>();
    static CountNumber countNumber = new CountNumber();
    static ScannerInput scannerInput = new ScannerInput();

    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int haveMoney = scannerInput.moneyInput();
        int buyCount = makeLotto.buy(haveMoney);
        for (int i = 0; i < buyCount; i++) lotto.addLotto(makeLotto.make()); // 사용자 로또 생성
        System.out.println(buyCount + "개를 구매했습니다.");
        lotto.LottoNumPrint();
        System.out.println("당첨 번호를 입력해 주세요.");
        for (int i = 0; i < 6; i++) inputCollectNum(scannerInput.winNumberInput());
        lotto = countNumber.collectNumberCount(lotto, winNumber);
        lotto.print(haveMoney);
    }

    public static void inputCollectNum(int num) {
        winNumber.add(num);
    }
}