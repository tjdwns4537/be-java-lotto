package kr.codesquad.service.Inteface;

import kr.codesquad.domain.Person;

import java.util.List;

public interface MakeLottoInterface {
    void IssuedLotto(Person person);

    List<Integer> make();
}
