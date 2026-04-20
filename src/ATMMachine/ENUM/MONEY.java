package ATMMachine.ENUM;

public enum MONEY {
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    HUNDRED(100),
    TWO_HUNDRED(200),
    FIVE_HUNDRED(500),
    THOUSAND(1000);

    private final int value;

    MONEY(int value) {
        this.value = value;
    }

    public int getValue() {
        return  value;
    }
}
