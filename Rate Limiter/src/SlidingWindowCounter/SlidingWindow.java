package SlidingWindowCounter;

import java.util.ArrayDeque;
import java.util.Deque;

//Here you will not see that the theory of Sliding window Counter and this code will not match because divides the timeline into fixed size time equal to window size then we will take window of fixed size and we will be moving this window on that timeline and when new request comes in then we start counting the request in previous time equal to window size but this code is totally different working.

//By looking the code the implementation may be different from theory but the result which we are achieving is same because here we are using data structure so we don't need to divide timeframe and all  but still managing to achieve functionality of sliding window

public class SlidingWindow {
    private final int windowSize; // Size of the time window in milliseconds
    private final int maxRequests; // Maximum number of requests allowed in the window
    private final Deque<Long> requestQueue; // Queue to hold request timestamps

    public SlidingWindow(int windowSize, int maxRequests) {
        this.windowSize = windowSize;
        this.maxRequests = maxRequests;
        this.requestQueue = new ArrayDeque<>(maxRequests);
    }

    public synchronized boolean allowRequest() {
        long currentTime = System.currentTimeMillis();
        
        // Remove expired timestamps from the queue
        while (!requestQueue.isEmpty() && currentTime - requestQueue.peek() > windowSize) {
            requestQueue.poll();
        }
        
        // If the queue size exceeds the maximum requests, reject the request
        if (requestQueue.size() >= maxRequests) {
            return false;
        }
        
        // Add the current timestamp to the queue
        requestQueue.offer(currentTime);
        return true;
    }
}
