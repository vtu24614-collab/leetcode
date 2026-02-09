class MyCircularQueue {
    private int[] queue;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.capacity = k;
        this.head = 0;
        this.tail = -1; // Start at -1 so the first enQueue moves it to 0
        this.size = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        
        // Circularly increment tail: (tail + 1) % capacity
        tail = (tail + 1) % capacity;
        queue[tail] = value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        
        // Circularly increment head: (head + 1) % capacity
        head = (head + 1) % capacity;
        size--;
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : queue[head];
    }
    
    public int Rear() {
        return isEmpty() ? -1 : queue[tail];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}    