package edu.core.java.races.additional;

/**
 * Created by Ubeto on 21.05.17.
 */
public class IncrementId {
    public Long value;

    public IncrementId() {
        this(0L);
    }

    public IncrementId(Long value) { this.value = value; }

    public void increment() { increment(1);}

    public void increment(long toAdd) { value += toAdd; }

}
