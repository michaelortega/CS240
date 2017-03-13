package Final;


import java.util.Arrays;

/**
 * Created by Michael on 3/11/2017.
 */
public class TestDictionary {
    public static void main(String[] args) {
        MyDictionary<Integer,String> d = new MyDictionary<>();
        d.add(1,"michael");
        d.add(1,"sam");
        d.add(1,"fuck");
        d.add(2,"fuck");
        d.add(2,"fuck1");
        d.add(2,"fuck2");

        //d.testVI(1);



        Object[] names = d.getValue(1);
        System.out.println("Printing for ID: 1");
        for (Object val: names){
            System.out.println(val + " ");
        }

        Object[] names2 = d.getValue(2);
        System.out.println("Printing for ID: 2");
        for (Object val: names2){
            System.out.println(val + " ");
        }

    }



}
