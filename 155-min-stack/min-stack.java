class MinStack {
    Stack<Long> st = new Stack<>();
    long min;

    public MinStack() {
    }

    public void push(int val) {
        if(st.isEmpty()) {
            st.push((long)val);
            min = val;
        } else if(val >= min) {
            st.push((long)val);
        } else {
            st.push(2L * val - min);
            min = val;
        }
    }

    public void pop() {
        if(st.isEmpty()) return;

        long top = st.peek();

        if(top >= min) {
            st.pop();
        } else {
            min = 2 * min - top;
            st.pop();
        }
    }

    public int top() {
        if(st.isEmpty()) return -1;

        long top = st.peek();

        if(top >= min) {
            return (int)top;
        } else {
            return (int)min;
        }
    }

    public int getMin() {
        if(st.isEmpty()) return -1;
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */