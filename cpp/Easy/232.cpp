//
// Created by y6655 on 2022/8/1.
//
/**
 * 232.用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *
 * 说明：
 * 你只能使用标准的栈操作 —— 也就是只有push to top,peek/pop from top,size, 和is empty操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 */

#include <stack>
using namespace std;
class MyQueue {
public:
    stack<int> s;

    MyQueue() {

    }

    void push(int x) {
        s.push(x);
    }

    int pop() {
        int res = 0;
        stack<int> temp;
        while(!s.empty()){
            res = s.top();
            s.pop();
            temp.push(res);
        }

        temp.pop();
        int tempNum = 0;
        while(!temp.empty()){
            tempNum = temp.top();
            temp.pop();
            s.push(tempNum);
        }

        return res;
    }

    int peek() {
        int res = 0;
        stack<int> temp;
        while(!s.empty()){
            res = s.top();
            s.pop();
            temp.push(res);
        }

        int tempNum = 0;
        while(!temp.empty()){
            tempNum = temp.top();
            temp.pop();
            s.push(tempNum);
        }

        return res;
    }

    bool empty() {
        return s.empty();
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */