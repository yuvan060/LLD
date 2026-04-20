package ATMMachine.Entity;

import ATMMachine.BankService;

public class ATM {

    public final BankService bankService;
    public final ATMInventory atmInventory;
    public final ATMContext atmContext;

    public ATM(BankService bankService, ATMInventory atmInventory, ATMContext atmContext) {
        this.bankService = bankService;
        this.atmInventory = atmInventory;
        this.atmContext = atmContext;
    }

    public boolean insertCard(Card card) {
        return atmContext.atmState.insertCard(atmContext, card);
    }

    public boolean enterPin(int pin) {
        return atmContext.atmState.validateCard(atmContext, pin);
    }

    public Transaction selectTransaction() {
        return atmContext.atmState.selectTransaction(atmContext);
    }

    public boolean processTransaction() {
        return atmContext.atmState.processTransaction(atmContext);
    }

    public boolean ejectCard() {
        return atmContext.atmState.ejectCard(atmContext);
    }

}
