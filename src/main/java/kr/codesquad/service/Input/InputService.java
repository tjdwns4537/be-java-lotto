package kr.codesquad.service.Input;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.Person;
import kr.codesquad.service.Inteface.MakeLottoInterface;
import kr.codesquad.service.MakeLottoPerson;
import kr.codesquad.service.MakeLottoRobot;

public class InputService {

    ScannerInput scannerInput = new ScannerInput();
    MakeLottoInterface makeLottoRobot = new MakeLottoRobot();
    MakeLottoInterface makeLottoPerson = new MakeLottoPerson();

    public void startPersonInput(Person person) {
        // 구입 금액를 1000원 단위로 설정 필요
        System.out.println("구입금액을 입력해 주세요.");
        buy(person);
//        makeLotto.IssuedLotto(person);
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
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        person.setHaveHandLotto(scannerInput.inputNumber());
        person.setHaveRobotLotto(haveMoney/1000 - person.getHaveHandLotto()); // 14개면 14개에 대한 범위에 대한 예외 필요
        System.out.println("수동으로"+ person.getHaveHandLotto() + "장," + "자동으로" + person.getHaveRobotLotto() + "개를 구매했습니다.");
    }

    public void inputCollectNum(Lotto lotto) {
        int num = scannerInput.inputNumber();
        lotto.getWinNumber().add(num);
    }
}
