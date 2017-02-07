/**
 * Created by Michael on 2/6/2017.
 */
public class StackTest {
    private static FixedArrayStack<Integer> intStack1 = new FixedArrayStack<>();


    public static void main(String[] args) {
        intStack1.isEmpty();
        intStack1.push(5);
        intStack1.push(52);
        intStack1.push(53);
        intStack1.push(25);
        intStack1.push(151);
        intStack1.push(0);
        intStack1.pop();
        intStack1.pop();
        intStack1.pop();
        intStack1.peek();
        intStack1.clear();

    }


}
