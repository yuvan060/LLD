package ATMMachine.Entity;

import java.time.LocalDateTime;

public abstract class Card {

    public final String card;
    private final Integer encryptedPin;
    private final Integer cvv;
    private final LocalDateTime expiryDate;
    private final String issuer;

    public Card(String card, Integer pin, Integer cvv, LocalDateTime expiryDate, String issuer) {
        this.card = card;
        this.encryptedPin = pin;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
        this.issuer = issuer;
    }

    public boolean validateCard(Integer pin) {
        //validate the expiry date
        // or else any otp level validation
        return encryptedPin.equals(pin);
    }
}
