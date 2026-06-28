import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayInsertion {
    private static List<Integer> num= Arrays.asList(12,33,2,9,90,10,77);

    public static void arrayInsertion() {

        int index=7;
        int value=30;
        List<Integer>a=new ArrayList<>();
        for(int i=0;i<num.size();i++){
            if(index==i){
                a.add(value);
            }
            a.add(num.get(i));
        }
        if(num.size()==index){
            a.add(value);
        }
        System.out.println(a+" value");
    }

    public static void copyElementBeforeIndex(){
            int [] copyarr =convertListtoArray(num);
            int [] newArray= new int[num.size()+1];
            int index=4;
            int value=99;
            for(int i=0;i<newArray.length;i++){
                if(i>index){
                    newArray[i]=copyarr[i-1];
                }
                else if(i==index){
                    newArray[i]=value;
                }
                else{
                    newArray[i]=copyarr[i];
                }
            }
            Arrays.stream(newArray).forEach(System.out::println);
    }
    private static int[] convertListtoArray(List<Integer> num){
        int []arr= new int[num.size()];
        for(int i=0;i<num.size();i++){
            arr[i]=num.get(i);
        }
        return arr;
    }
}
