package edu.kis.vh.nursery;

/**
 * Default implementation of the counting-out rhymer.
 * Operates as a stack (LIFO – Last In First Out).
 * Stores integers and allows them to be added and retrieved in reverse order.
 *
 * <p>Example usage:
 * <pre>
 *     DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
 *     rhymer.countIn(5);
 *     int value = rhymer.length(); // returns 5
 * </pre>
 */
public class DefaultCountingOutRhymer {

    // TODO: consider renaming length() to pop() or countOut() for clarity
    // – the current name is misleading (it removes and returns an element)

    /** Maximum number of elements the rhymer can hold. */
    private static final int STACK_CAPACITY = 12;

    /** Value returned when the rhymer is empty. */
    private static final int RETURNED_ON_EMPTY = -1;

    private final int[] numbers = new int[STACK_CAPACITY];

    private int total = RETURNED_ON_EMPTY;

    /**
     * Adds the given number to the rhymer.
     * The number is ignored if the rhymer is already full.
     *
     * @param in the number to add
     */
    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    /**
     * Checks whether the rhymer contains no elements.
     *
     * @return {@code true} if the rhymer is empty, {@code false} otherwise
     */
    public boolean isEmpty() {
        return total == RETURNED_ON_EMPTY;
    }

    /**
     * Checks whether the rhymer has reached its maximum capacity.
     *
     * @return {@code true} if the rhymer is full, {@code false} otherwise
     */
    public boolean isFull() {
        return total == STACK_CAPACITY - 1;
    }

    /**
     * Returns the top element without removing it.
     *
     * @return the top element, or {@value #RETURNED_ON_EMPTY} if the rhymer is empty
     */
    protected int peek() {
        // TODO: consider making peek() public for a consistent API
        if (isEmpty())
            return RETURNED_ON_EMPTY;
        return numbers[total];
    }

    /**
     * Removes and returns the top element (pop operation).
     *
     * @return the removed element, or {@value #RETURNED_ON_EMPTY} if the rhymer is empty
     */
    public int length() {
        if (isEmpty())
            return RETURNED_ON_EMPTY;
        return numbers[total--];
    }

    /**
     * Returns the index of the current top element.
     *
     * @return the current top index, or {@value #RETURNED_ON_EMPTY} if empty
     */
    public int getTotal() {
        return total;
    }

}