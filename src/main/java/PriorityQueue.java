
public class PriorityQueue {
    private Job[] arr;
    private int current = -1;
    
    PriorityQueue() { arr = new Job[10]; }
    
    public int capacity() { return arr.length; }
    public int size() { return current + 1; }
    public boolean isEmpty() { return size() == 0; }
     
    public void insert(Job job) {
        if(size() == capacity()) {
            Job[] newArr = new Job[capacity() * 2];
            for(int i = 0; i < size(); i++)
                newArr[i] = arr[i];
            arr = newArr;
        }
        arr[++current] = job;
    }
    
    public Job extractMax() {
        Job max = getMax();
        removeAt(getIndex(max));
        return max;
    }
    
    public Job getMax() {
        if(isEmpty())
            throw new RuntimeException("Error: <priority queue empty>");
        Job max = arr[0];
        for(int i = 1; i < size(); i++) {
            if(arr[i].priority > max.priority)
                max = arr[i];
        }
        return max;
    }
    
    public Job getMin() {
        if(isEmpty())
            throw new RuntimeException("Error: <priority queue empty>");
        Job min = arr[0];
        for(int i = 1; i < size(); i++) {
            if(arr[i].priority < min.priority)
                min = arr[i];
        }
        return min;
    }
    
    public Job extractMin() {
        Job min = getMin();
        removeAt(getIndex(min));
        return min;
    }
    
    private int getIndex(Job job) {
        if(!contains(job))
            throw new RuntimeException("Error: <" + job.processID + " no such data in priority queue>");
        for(int i = 0; i < size(); i++)
            if(arr[i] == job) return i;
        return -1;
    }

    public boolean contains(Job job) {
        if(isEmpty())
            throw new RuntimeException("Error: <empty priority queue>");
        for(Job j : arr)
            if(j == job) return true;
        return false;
    }

    public void removeAt(int index) {
        if(isEmpty())
            throw new RuntimeException("Error: <empty priority queue>");
        for(int i = index; i < size(); i++) {
            if(i != size() - 1) 
                arr[i] = arr[i+1];
        }
        --current;
    }

    public int getPriority(int index) {
        if(index >= size() || index < 0)
            throw new RuntimeException("Error: <invalid index>");
        return arr[index].priority;
    }
}
