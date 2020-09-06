package queue;

//SOURCE FROM
// = https://freestrokes.tistory.com/83


/*
* @ TITLE QUEUE ( 배열로 구현한 큐)
*/
interface Queue {
    boolean isEmpty();
    boolean isFull();
    void enqueue(char item);
    char dequeue();
    char peek();
    void clear();
}

public class freestrokesQueue implements Queue{
    
    private int front;
    private int rear;
    private int queueSize;
    private char queueArr[];

    // 큐를 생성하는 생성자
    public freestrokesQueue(int queueSize){
        front = -1; // from 포인터 초기화x`
        rear = -1; // rear 포인터 초기화
        this.queueSize = queueSize; // queue 사이즈 설정
        queueArr = new char[this.queueSize]; // 큐 배열 생성
    }

    // 큐가 비어있는 상태인지 확인
    public boolean isEmpty() {
        //fromt, rear 포인터가 같은 경우 데이터가 없는 상테이므로 모두 -1로 초기화
        if(front == rear){
            front = -1;
            rear = -1;
        }

        // front, rear 포인터가 같은 경우 데이터가 없는 상태이므로 true 아닌 경우 false return
        return (front == rear);
    }

    // 큐가 가득 찬 상태인지 확인
    public boolean isFull(){
        // rear 포인터가 큐의 마지막 인텍스와 동일한 경우 true 아닌 경우 false return
        return (rear == this.queueSize-1);
    }

    // 큐에 데이터 삽입
    public void enqueue(char item){
        if(isFull()){
            System.out.println("QUEUE US FULL!");
        }else{
            queueArr[++rear] = item; // 다음 rear 포인터가 가리키는 위치에 데이터 추가
            System.out.println("INSERTED ITEM : " + item);
        }
    }

    // 큐에서 데이터 추출 후 삭제
    public char dequeue() {
        if(isEmpty()){
            System.out.println("DELETING FAIL! QUEUE IS EMPTY!");
            return 0;
        }else {
            // 큐에서 삭제할 데이터 반환
            System.out.println("DELETED ITEM : " + queueArr[front+1]);
            front = (front + 1) % this.queueSize;
            return queueArr[front];
        }
    }

    // 큐의 첫번째 데이터 추출
    public char peek() {
        if(isEmpty()){
            System.out.println("PEEKING FAIL! QUEUE IS EMPTY!");
            return 0;
        }else {
            // front 포인터는 삭제한 위치에 있으므로 +1을 해줘서 첫번째 요소를 추출하도록 지정.
            System.out.println("PEEKED ITEM : " + queueArr[front+1]);
            return queueArr[front+1];
        }
    }

    // 큐 초기화
    public void clear(){
        if(isEmpty()){
            System.out.println("QUEUE IS ALREADY EMPTY!");
        }else {
            front = -1; // front 포인터 초기화
            rear = -1; // rear 포인터 초기화
            queueArr = new char[this.queueSize]; // 새로운 큐 배열 생성
            System.out.println("QUEUE IS CLEAR!");
        }
    }
    // 큐에 저장된 모든 데이터 출력
    public void printQueue(){
        if(isEmpty()){
            System.out.println("QUEUE IS EMPTY!");
        }else {
            System.out.println("QUEUE ELEMENTS : ");
            // front 포인터는 -1 또는 삭제된 요소의 위치에 있기 때문에,
            // +1 위치를 시작점으로 지정.
            for (int i = front+1; i<=rear; i++){
                System.out.println(queueArr[i] + " ");
            }
            System.out.println();
        }
    }
    
        public static void main(String args[]){
            int queueSize = 5;
            freestrokesQueue arrQueue = new freestrokesQueue(queueSize);

            arrQueue.enqueue('A');
            arrQueue.printQueue();

            arrQueue.enqueue('B');
            arrQueue.printQueue();

            arrQueue.enqueue('C');
            arrQueue.printQueue();

            arrQueue.enqueue('D');
            arrQueue.printQueue();

            arrQueue.enqueue('E');
            arrQueue.printQueue();

            arrQueue.enqueue('F');
            arrQueue.printQueue();

            arrQueue.dequeue();
            arrQueue.printQueue();

            arrQueue.peek();
            arrQueue.printQueue();

            System.out.println("arrQueue.front : " + arrQueue.front);
            System.out.println("arrQueue.rear : " + arrQueue.rear);




    }


}