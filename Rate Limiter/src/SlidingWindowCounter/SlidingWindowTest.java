package SlidingWindowCounter;

import java.time.Instant;

public class SlidingWindowTest {
    public static void main(String[] args) {
    	
    	Instant instant = Instant.now();
    	SlidingWindow rateLimiter = new SlidingWindow(1000, 10); // 10 requests per second
        
        // Simulate making requests
        for (int i = 0; i < 50; i++) {
            boolean allowed = rateLimiter.allowRequest();
            System.out.println("Request " + (i + 1) + ": " + (allowed ? "Allowed" : "Rejected")+" at " + instant);
            
            try {
                Thread.sleep(50); // Sleep for 100 milliseconds between requests
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

