package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    List<Integer> winNumber = new ArrayList<>();

    public void setWinNumber(List<Integer> winNumber) {
        this.winNumber = winNumber;
    }

    public List<Integer> getWinNumber() {
        return this.winNumber;
    }
}
