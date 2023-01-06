package kr.codesquad.service.Inteface;

import kr.codesquad.domain.Person;

import java.util.List;

public interface MakeLottoInterface {
    void IssuedLotto(Person person) throws Exception;

    List<Integer> make() throws Exception;
}
