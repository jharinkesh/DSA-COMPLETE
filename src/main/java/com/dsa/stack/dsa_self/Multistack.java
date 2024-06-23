public class Multistack {

    int cap;
    int  top1 = -1, top2;
    int[] data;

    Multistack(int cap){
        this.cap = cap;
        data = new int[cap];
        top2 = cap;
    }

    void push1(int x){
        if(top1<(top2-1)){
            top1++;
            data[top1] = x;
        }
    }

    void push2(int x){
        if(top2>(top1+1)){
            top2--;
            data[top2] = x;
        }
    }

    void pop1(){
        if(top1>=0)
            top1--;
    }

    void pop2(){
        if(top2<cap)
            top2++;
    }

    void disp(){
        System.out.println("elements are \n");
        for(int i=0;i<=top1;i++)
            System.out.print(data[i]+" ");
        System.out.print(" ## ");
        for(int i= top2;i<this.cap;i++)
            System.out.print(data[i]+" ");
    }


    public static void main(String[] args) {
        Multistack ms = new Multistack(8);
        ms.push1(10);
        ms.push1(20);
        ms.push1(30);

        ms.push2(11);
        ms.push2(22);
        ms.push2(33);
        ms.push2(44);
        ms.push2(55);
        ms.push2(66);

        ms.disp();

        ms.pop1();
        ms.pop2();
        ms.disp();
    }
}
