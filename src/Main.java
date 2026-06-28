import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer>num= Arrays.asList(12,33,2,9,90,10,77);
//        Print all elements
        for(int i=0;i<num.size();i++){
//            System.out.println(num.get(i));
        }

//        Find the sum of all elements.
        int sum=0;
        for(int i=0;i<num.size();i++){
            sum+=num.get(i);
        }

//       Find the maximum element.
        int max=Integer.MIN_VALUE;
        for(int i=0;i<num.size();i++){
            if(max<num.get(i)){
                max=num.get(i);
            }
        }

//        Find the minimum element.
        int min =Integer.MAX_VALUE;
        for(int i=0;i<num.size();i++){
            if(min>num.get(i)){
                min=num.get(i);
            }
        }

//        Count even numbers.
        int evenCount=0;
        for(int i=0;i<num.size();i++){
            if(num.get(i)%2==0){
                evenCount++;
            }
        }


//        Count odd numbers.
        int OddCount=0;
        for(int i=0;i<num.size();i++){
            if(num.get(i)%2!=0){
                OddCount++;
            }
        }

//        Check if a number exists in the array.
        Scanner sc = new Scanner(System.in);
        int input=12;
        boolean exist=false;
        int index=-1;
        for(int i=0;i<num.size();i++){
            if(num.get(i).equals(input)){
                exist=true;
                index=i;
                break;
            }
        }

//        Reverse-print the array (don't actually reverse it, just print from end to start).
        for(int j=num.size()-1;j>=0;j--){
            System.out.println(num.get(j));
        }

        //Sort
        int [] copyarr =new int []{12,33,2,9,90,10,77,0};
        for(int i=0;i<copyarr.length;i++){
                for(int j=i+1;j<copyarr.length;j++){
                    if(copyarr[i]>copyarr[j]) {
                        int temp = copyarr[i];
                        copyarr[i] = copyarr[j];
                        copyarr[j] = temp;
                    }
                }
        }


    }
}