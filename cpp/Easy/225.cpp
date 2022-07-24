//
// Created by y6655 on 2022/7/24.
//
/**
 * 225.用队列实现栈
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * 实现 MyStack 类：
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * 注意：
 * 你只能使用队列的基本操作 —— 也就是push to back、peek/pop from front、size 和is empty这些操作。
 * 你所使用的语言也许不支持队列。你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。
 *
 */

#include <queue>
#include <iostream>
using namespace std;
class MyStack {
public:
    queue<int> q;
    MyStack() {

    }

    void push(int x) {
        q.push(x);
    }

    int pop() {
        if(empty())
            return 0;
        int length = q.size();
        for(int i = 0; i < length - 1; ++i){
            int first = q.front();
            q.pop();
            q.push(first);
        }
        int res = q.front();
        q.pop();
        return res;
    }

    int top() {
        if(empty())
            return 0;
        int length = q.size();
        int first = 0;
        for(int i = 0; i < length; ++i){
            first = q.front();
            q.pop();
            q.push(first);
        }
        return first;
    }

    bool empty() {
        return q.empty();
    }
};

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */

int main(){
    MyStack stack;
    stack.push(1);
    stack.push(2);
    cout << stack.top() << endl;
    cout << stack.empty() << endl;
    stack.pop();
    cout << stack.top() << endl;
    cout << stack.empty() << endl;
}