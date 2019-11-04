package com.bravo.ocp.filosophers;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class RoundDinningTable {


    private List<DinningSeat> seats = new LinkedList<>();


    public RoundDinningTable(int seatsQuantity) {

        initializeSeats(seatsQuantity);
    }

    private void initializeSeats(final int seatsQuantity) {
        IntStream.iterate(0, operand -> operand + 1)
                .limit(seatsQuantity)
                .forEach(index ->
                        addSeat(seatsQuantity, index)
                );
    }

    private void addSeat(final int seatsQuantity, int seatIndex) {
        if (isFirstSeatToAdd()) {
            seats.add(new DinningSeat(new Stick(seatIndex), new Stick(++seatIndex)));
        } else if (isLastSeatToAdd(seatsQuantity)) {
            seats.add(new DinningSeat(new Stick(++seatIndex), seats.get(0).getLeftStick()));
        } else {
            seats.add(new DinningSeat(seats.get(seatIndex - 1).getRightStick(), new Stick(++seatIndex)));
        }
    }

    private boolean isLastSeatToAdd(int seatsQuantity) {
        return seats.size() == seatsQuantity - 1;
    }

    private boolean isFirstSeatToAdd() {
        return seats.isEmpty();
    }


    @Override
    public String toString() {
        return "RoundDinningTable{" +
                "seats=" + seats +
                '}';
    }
}
