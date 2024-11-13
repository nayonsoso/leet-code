/*
push : push to stack1
pop : pop from stack1 and push to stack2 until stack1's empty and pop stack2
peek : pop from stack1 and push to stack2 until stack1's empty and peek stack2
empty : if two staks are both empty
*/


class MyQueue {

    Stack<Integer> queue = new Stack<>();
    Stack<Integer> tmp = new Stack<>();

    public MyQueue() {
    }
    
    public void push(int x) {
        while(!queue.isEmpty()) {
            tmp.push(queue.pop());
        }
        queue.push(x);
        while(!tmp.isEmpty()) {
            queue.push(tmp.pop());
        }
    }
    
    public int pop() {
        return queue.pop();
    }
    
    public int peek() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */