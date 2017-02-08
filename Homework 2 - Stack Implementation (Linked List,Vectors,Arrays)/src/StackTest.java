/**
 * Created by Michael on 2/6/2017.
 */
public class StackTest {
    private static FixedArrayStack<Integer> intStack1 = new FixedArrayStack<>();
    private static VectorStack<Integer> intVectorStack1 = new VectorStack<>();
    private static LinkedListStack<Integer> integerLinkedListStack =  new LinkedListStack<>();
    private static FixedArrayQueue<Integer> fixedArrayQueue = new FixedArrayQueue<>();


    public static void main(String[] args) {
//        intStack1.isEmpty();
//        intStack1.push(5);
//        intStack1.push(52);
//        intStack1.push(53);
//        intStack1.push(25);
//        intStack1.push(151);
//        intStack1.push(0);
//        intStack1.pop();
//        intStack1.pop();
//        intStack1.pop();
//        intStack1.peek();
//        intStack1.clear();
//
//        intVectorStack1.push(15);
//        intVectorStack1.push(135);
//        intVectorStack1.push(145);
//        intVectorStack1.push(175);
//        System.out.println(intVectorStack1.pop());
//        intVectorStack1.clear();
//        //intVectorStack1.pop();
//
//
//        integerLinkedListStack.push(15);
//        integerLinkedListStack.push(135);
//        System.out.println(integerLinkedListStack.peek());
//        System.out.println(integerLinkedListStack.isEmpty());
//        System.out.println(integerLinkedListStack.pop());
//        System.out.println(integerLinkedListStack.isEmpty());

        fixedArrayQueue.enqueue(14);
        System.out.println(fixedArrayQueue.isEmpty());
        System.out.println(fixedArrayQueue.dequeue());
        fixedArrayQueue.enqueue(144);
        fixedArrayQueue.enqueue(1554);
        fixedArrayQueue.enqueue(555514);
        fixedArrayQueue.clear();





    }


}
