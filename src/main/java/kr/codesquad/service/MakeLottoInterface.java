package kr.codesquad.service;

import kr.codesquad.domain.Person;

import java.util.List;

public interface MakeLottoInterface {

    Person IssuedLotto(Person person);

    List<Integer> make();
}
