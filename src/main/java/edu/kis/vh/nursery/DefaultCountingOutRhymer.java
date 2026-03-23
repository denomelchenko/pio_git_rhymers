package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    public static final int EMPTY = -1;
    public static final int ERROR = -1;
    public static final int CAPACITY = 12;
    final private int[] NUMBERS = new int[CAPACITY];

    public int total = EMPTY;

    public void countIn(int in) {
        if (!isFull())
            NUMBERS[++total] = in;
    }

    public boolean isEmpty() {
        return total == EMPTY;
    }

    public boolean isFull() {
        return total == 11;
    }

    protected int peek() {
        if (isEmpty())
            return ERROR;
        return NUMBERS[total];
    }

    public int length() {
        if (isEmpty())
            return ERROR;
        return NUMBERS[total--];
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
