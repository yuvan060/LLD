package MovieTicketBookingSystem;

import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

public class BookingSystem {
    /*
    In an ideal movie ticket booking system application,
    A theater has multiple screens,  Each screen have different seat capacities & screen size,
    each screen have different slots, each slot or show has limited number of seats
    the seats can be locked for certain period of time and after successful locking of the seat the user can book that seat
    once seat is locked by some user, other users cannot book the seat until it lock is released.


    Entity :-

    Seat - abstract class: seatNo, basePrice; calculatePrice()
    different types of seats can extend the seat and implement the seat by cost multiplier.
    Screen - Map<seatNo, Seat>, screenSize;
    Movie - metaData
    ShowSeat - seat, seatStatus, reentrantLock, lockedTime, userId; lockSeat(), bookSeat(), cancelSeat()
    Show - int screenId, Map<seatNo, ShowSeat>, Movie, metaData; getAvailableSeats(), getSeats()
    Theater - Map<Screen>, Map<showId, Show>;

    Abstract Factory for show creation.
    Strategy design pattern for payment methods ...
     */
}

abstract class Seat {
    //seat class
}

enum SeatStatus {
    EMPTY,
    LOCKED,
    BOOKED
}

class ShowSeat {
    private Seat seat;
    private SeatStatus seatStatus;
    private final ReentrantLock lock;
    private long lockedUntil;
    private UUID userId;

    public ShowSeat(Seat seat) {
        this.seat = seat;
        this.seatStatus = SeatStatus.EMPTY;
        this.lock = new ReentrantLock();
    }

    public boolean lockSeat(UUID requestUserId) {
        if (lock.tryLock()) {
            try {
                if (seatStatus == SeatStatus.BOOKED) {
                    return false;
                }

                if (seatStatus == SeatStatus.LOCKED) {
                    boolean isLockExpired = lockedUntil > System.currentTimeMillis();

                    if (!isLockExpired && !this.userId.equals(requestUserId)) {
                        return false; // actively locked by someone else
                    }

                    if (!isLockExpired && this.userId.equals(requestUserId)) {
                        return false; // already locked by you, don't renew silently
                    }
                }

                this.userId = requestUserId;
                this.seatStatus = SeatStatus.LOCKED;
                this.lockedUntil = System.currentTimeMillis() + (3 * 60 * 1000);

                return true;

            } finally {
                lock.unlock();
            }
        }
        return false;
    }

    public boolean bookSeat(UUID requestUserId) {
        // TODO
        return false;
    }
}

