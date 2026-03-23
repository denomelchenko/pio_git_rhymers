package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    private int[] NUMBERS = new int[12];

    private int total = -1;

    public void countIn(int in) {
        if (!isFull())
            NUMBERS[++total] = in;
    }

    public boolean isEmpty() {
        return total == -1;
    }

    public boolean isFull() {
        return total == 11;
    }

    protected int peek() {
        if (isEmpty())
            return -1;
        return NUMBERS[total];
    }

    public int length() {
        if (isEmpty())
            return -1;
        return NUMBERS[total--];
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
