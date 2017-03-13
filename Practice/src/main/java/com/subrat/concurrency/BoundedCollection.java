/**
 * 
 */
package com.subrat.concurrency;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class BoundedCollection<T> {
    private final Set hashSet;
    private final Semaphore semaphore;

    public BoundedCollection(int nosOfPermit) {
        this.hashSet = Collections.synchronizedSet(new HashSet());
        semaphore = new Semaphore(nosOfPermit);
    }

    public boolean add(T o) throws InterruptedException {
        semaphore.acquire();
        boolean isSomethingAdded = false;
        try {
            isSomethingAdded = hashSet.add(o);
            return isSomethingAdded;
        } finally {
            if (!isSomethingAdded)
                semaphore.release();
        }
    }

    public boolean remove(Object o) {
        boolean isSomethingRemoved = hashSet.remove(o);
        if (isSomethingRemoved)
            semaphore.release();
        return isSomethingRemoved;
    }
}