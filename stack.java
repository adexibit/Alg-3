import com.sun.corba.se.spi.orbutil.fsm.Input;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Stack {
    int maxSize;
    char [] stack;
    int top;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.top=-1;
        this.stack= new char[maxSize];
    }
    public void push(char i){
        this.stack[++this.top] = i;
    }
    public boolean isEmpty(){
        return (this.top == -1);
    }

    public boolean isFull(){
        return (this.top == this.maxSize-1);
    }

    public char pop(){
        return this.stack[this.top--];
    }

    public int peek() {
        return this.stack[this.top];
    }

}
class Queue{
    private int maxSize;
    private int[] queue;
    private int front;
    private int rear;
    private int items;

    public Queue(int maxSize){
        this.maxSize = maxSize;
        this.queue = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.items = 0;
    }


    public boolean isEmpty(){
        return (items==0);
    }

    public boolean isFull(){
        return (items==maxSize);
    }

    public int size(){
        return items;
    }

    public void insert(int i){
        if (items<maxSize) {
            if (rear == maxSize - 1)
                rear = -1;
            queue[++rear] = i;
            items++;
        }
        else System.out.println("Очередь заполнена");
    }


    public long remove(){
        int temp = queue[front++];
        if(front == maxSize)
        front = 0;
        items--;
        return temp;
    }


    public int peek(){
        return queue[front];
    }


}
class NotUsualRevers {
    private static String getSTR() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();

    }

private static StringBuilder reverse (String t ){
        Stack st = new Stack(t.length());
    for (int i = 0; i <t.length() ; i++) {
        st.push(t.charAt(i));
    }
        StringBuilder sb = new StringBuilder();
    for (int j = 0; j <st.maxSize ; j++) {
        sb.insert(j,st.pop());
    }
    return sb;
}


    public static void main(String[] args)throws IOException {
        System.out.println(reverse(getSTR()));

    }
}