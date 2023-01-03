package kr.codesquad.service.Input;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.Person;
import kr.codesquad.service.Inteface.MakeLottoInterface;
import kr.codesquad.service.MakeLottoRobot;

public class InputService {

    ScannerInput scannerInput = new ScannerInput();
    MakeLottoInterface makeLotto = new MakeLottoRobot();

    public void startPersonInput(Person person) {
        System.out.println("구입금액을 입력해 주세요.");
        buy(person);
        makeLotto.IssuedLotto(person);
        System.out.println(person.getHaveLotto() + "개를 구매했습니다.");
        person.LottoNumPrint();
    }

    public void startLottoInput(Lotto lotto) {
        System.out.println("당첨 번호를 입력해 주세요.");
        for (int i = 0; i < 6; i++){
            inputCollectNum(lotto);
        }
        System.out.println("보너스 볼을 입력해주세요.");
        lotto.setBonus(scannerInput.inputNumber());
    }

    public void buy(Person person){
        int haveMoney = scannerInput.inputNumber();
        person.setMoney(haveMoney);
        person.setHaveLotto(haveMoney / 1000);
    }

    public void inputCollectNum(Lotto lotto) {
        int num = scannerInput.inputNumber();
        lotto.getWinNumber().add(num);
    }
}
