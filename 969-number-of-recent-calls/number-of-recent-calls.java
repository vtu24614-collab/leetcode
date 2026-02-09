import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> requests;

    public RecentCounter() {
        // Initialize a queue to store the timestamps
        this.requests = new LinkedList<>();
    }
    
    public int ping(int t) {
        // 1. Add the new request time to the queue
        requests.add(t);
        
        // 2. Remove timestamps that are older than t - 3000
        // The queue head is always the oldest timestamp
        while (!requests.isEmpty() && requests.peek() < t - 3000) {
            requests.poll();
        }
        
        // 3. The remaining elements are within the [t - 3000, t] range
        return requests.size();
    }
}