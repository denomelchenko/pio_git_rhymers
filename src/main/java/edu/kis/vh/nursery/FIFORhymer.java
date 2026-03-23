package edu.kis.vh.nursery;

public class FIFORhymer extends DefaultCountingOutRhymer {

    final public DefaultCountingOutRhymer temp = new DefaultCountingOutRhymer();

    @Override
    public int length() {
        while (!isEmpty())
            temp.countIn(super.length());

        int length = temp.length();

        while (!temp.isEmpty())
            countIn(temp.length());

        return length;
    }
}
