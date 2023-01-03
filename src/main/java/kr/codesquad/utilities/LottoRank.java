package kr.codesquad.utilities;

public enum LottoRank {
    FIRST("2000000000",1), SECOND("30000000",2), THIRD("1500000",3), FOURTH("50000",4), FIVE("5000",5);

    private final String rank;
    private final Integer value;

    LottoRank(String rank, Integer value){
        this.rank = rank;
        this.value = value;
    }

    public String getRank() {
        return this.rank;
    }

    public Integer getValue() {
        return this.value;
    }
}
