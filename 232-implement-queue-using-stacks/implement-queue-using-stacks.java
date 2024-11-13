/*
push : push to stack1
pop : pop from stack1 and push to stack2 until stack1's empty and pop stack2
peek : pop from stack1 and push to stack2 until stack1's empty and peek stack2
empty : if two staks are both empty
*/


class MyQueue {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MyQueue() {
    }
    
    public void push(int x) {
        Stack<Integer> emptyStack = getEmptyStack();
        if(emptyStack == s1) {
            s2.push(x);
        } else {
            s1.push(x);
        }
    }
    
    public int pop() {
        Stack<Integer> emptyStack = getEmptyStack();
        if(emptyStack == s1) {
            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            int result = s1.pop();
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return result;
        } else if (emptyStack == s2) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            int result =  s2.pop();
            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return result;
        } else {
            throw new RuntimeException("queue is empty, can't pop");
        }
    }
    
    public int peek() {
        Stack<Integer> emptyStack = getEmptyStack();
        if(emptyStack == s1) {
            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            int result = s1.peek();
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return result;
        } else if (emptyStack == s2) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            int result = s2.peek();
            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return result;
        } else {
            throw new RuntimeException("queue is empty, can't peek");
        }
    }
    
    public boolean empty() {
        if(getEmptyStack() == null) {
            return true;
        }
        return false;
    }

    private Stack<Integer> getEmptyStack() {
        if(s1.isEmpty() && !s2.isEmpty()) {
            return s1;
        } else if (s2.isEmpty() && !s1.isEmpty()) {
            return s2;
        } else {
            return null;
        }
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