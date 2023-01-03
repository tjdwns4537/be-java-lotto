package kr.codesquad.service;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.Person;

public class InputService {

    ScannerInput scannerInput = new ScannerInput();
    MakeLottoInterface makeLotto = new MakeLottoRobot();

    public void startInputRobot(Person person, Lotto lotto) {
        System.out.println("구입금액을 입력해 주세요.");
        buy(person);
        person = makeLotto.IssuedLotto(person);
        System.out.println(person.getHaveLotto() + "개를 구매했습니다.");
        person.LottoNumPrint();
        System.out.println("당첨 번호를 입력해 주세요.");
        for (int i = 0; i < 6; i++){
            inputCollectNum(lotto);
        }
    }

//    pㅡㅇ으

    public void buy(Person person){
        int haveMoney = scannerInput.inputNumber();
        person.setMoney(haveMoney);
        person.setHaveLotto(haveMoney / 1000);
    }

    public Lotto inputCollectNum(Lotto lotto) {
        int num = scannerInput.inputNumber();
        lotto.getWinNumber().add(num);
        return lotto;
    }
}
