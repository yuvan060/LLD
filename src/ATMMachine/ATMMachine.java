package ATMMachine;

public class ATMMachine {
    /*
    We need to design an ATM,

    The ATM should hold different denominations of Money and machine has to handle different type of transactions
    The user should insert the card, then the card should be validated, then handle intended transaction.


    ENUM :
        MONEY - HUNDRED(value), TWO_HUNDRED(value), FIVE_HUNDRED(value)
        TransactionStatus - IN_PROGRESS, SUCCESS, FAILED
    Entity :
        ATMInventory - singleton class : Map<MONEY, count>; fillInventory(), dispenseCashFromOInventory()
        ATMState : interface, insertCard(), validateCard(), selectTransaction(), processTransaction(), ejectCard(), nextState()
        implemented by IDLEState, ValidateCard, SelectTransaction, ProcessTransaction, EjectCard
        Transaction - abstract class : transactionId, transactionStatus; execute(ATMContext)
        extended by WithDrawCash - amountToWithdraw, CheckBalance, GeneratePin
        Card - abstract class: cardNo, Pin, cvv, ...metaData; validateCard()
        Extended by DebitCard - dailySpentLimit, currentSpent
                    CreditCard - monthlyLimit, currentSpent
        ATMContext : ATMState, card, transaction,
        ATMMachine - Singleton class : ATMContext, ATMInventory, BankService, List<Observers>
        Observer - Interface : notify(card)
        implemented by SMSNotifier....

     */
}
