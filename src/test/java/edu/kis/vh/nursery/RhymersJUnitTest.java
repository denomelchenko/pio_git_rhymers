package edu.kis.vh.nursery;

import org.junit.Assert;
import org.junit.Test;

public class RhymersJUnitTest {

    @Test
    public void testCountIn() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        int testValue = 4;
        rhymer.countIn(testValue);

        int result = rhymer.peek();
        Assert.assertEquals(testValue, result);
    }

    @Test
    public void testCallCheck() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        boolean result = rhymer.isEmpty();
        Assert.assertEquals(true, result);

        rhymer.countIn(888);

        result = rhymer.isEmpty();
        Assert.assertEquals(false, result);
    }

    @Test
    public void testIsFull() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int STACK_CAPACITY = 12;
        for (int i = 0; i < STACK_CAPACITY; i++) {
            boolean result = rhymer.isFull();
            Assert.assertEquals(false, result);
            rhymer.countIn(888);
        }

        boolean result = rhymer.isFull();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testPeekaboo() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int EMPTY_STACK_VALUE = -1;

        int result = rhymer.peek();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        int testValue = 4;
        rhymer.countIn(testValue);

        result = rhymer.peek();
        Assert.assertEquals(testValue, result);
        result = rhymer.peek();
        Assert.assertEquals(testValue, result);
    }

    @Test
    public void testCountOut() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int EMPTY_STACK_VALUE = -1;

        int result = rhymer.length();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        int testValue = 4;
        rhymer.countIn(testValue);

        result = rhymer.length();
        Assert.assertEquals(testValue, result);
        result = rhymer.length();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);
    }

    // ── FIFORhymer (section 16) ───────────────────────────────────────────────

    @Test
    public void testFifoOrder() {
        FIFORhymer fifo = new FIFORhymer();
        fifo.countIn(1);
        fifo.countIn(2);
        fifo.countIn(3);

        Assert.assertEquals(1, fifo.length());
        Assert.assertEquals(2, fifo.length());
        Assert.assertEquals(3, fifo.length());
    }

    @Test
    public void testFifoEmptyReturnsMinusOne() {
        FIFORhymer fifo = new FIFORhymer();
        Assert.assertEquals(-1, fifo.length());
    }

    @Test
    public void testFifoIsEmptyAfterDrain() {
        FIFORhymer fifo = new FIFORhymer();
        fifo.countIn(7);
        fifo.length();
        Assert.assertTrue(fifo.isEmpty());
    }

    // ── HanoiRhymer (section 16) ──────────────────────────────────────────────

    @Test
    public void testHanoiRejectsLargerNumbers() {
        HanoiRhymer hanoi = new HanoiRhymer();
        hanoi.countIn(5);
        hanoi.countIn(10); // 10 > 5 – should be rejected

        Assert.assertEquals(1, hanoi.reportRejected());
        Assert.assertEquals(5, hanoi.peek());
    }

    @Test
    public void testHanoiAcceptsSmallerOrEqualNumbers() {
        HanoiRhymer hanoi = new HanoiRhymer();
        hanoi.countIn(10);
        hanoi.countIn(5); // 5 <= 10 – should be accepted

        Assert.assertEquals(0, hanoi.reportRejected());
        Assert.assertEquals(5, hanoi.peek());
    }

    @Test
    public void testHanoiReportRejectedInitiallyZero() {
        HanoiRhymer hanoi = new HanoiRhymer();
        Assert.assertEquals(0, hanoi.reportRejected());
    }

    @Test
    public void testHanoiFirstElementAlwaysAccepted() {
        HanoiRhymer hanoi = new HanoiRhymer();
        hanoi.countIn(99);
        Assert.assertEquals(0, hanoi.reportRejected());
        Assert.assertFalse(hanoi.isEmpty());
    }

}