import java.util.Scanner;

public class ArrayTest {
    public static void main(String[] args) {
//        new Scanner(System.in).nextLine();
        MyTools myTools1 = new MyTools();
        MyTools myTools = new MyTools();
        int[] a = {10,5,30,20,70,1,0,-3};
        myTools.bubbleSort(a);
        System.out.println("====排序后的数组====");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
class MyTools{
    String name;
    int age;

    public MyTools(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public MyTools() {
//        sout模板快捷键
        System.out.println();
//        fori模板快捷键
        for (int i = 0; i < 5; i++) {

        }
    }

    //    排序方法
    public void bubbleSort(int[] arr){
        int temp;
        for(int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
