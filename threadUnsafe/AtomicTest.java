package threadUnsafe;

public class AtomicTest{
    private int a = 0;
    public int incrementAndGet(){
        return a ++;
    }
public static void main(String[] args){
    final AtomicTest test = new AtomicTest();
    for (int i=-0; i<100;i++){
        new Thread(){
            public void run(){
                System.out.println(test.incrementAndGet());
            }
        }.start();
    }
}
}