
public class LLTest {
    private static ListInterface<Integer> list1 = new LinkedBasedList<>();

    public static void main(String[] args) {
        list1.addToEnd(1);
        list1.addToEnd(2);
        list1.addToEnd(3);
        list1.addToEnd(4);
        list1.addToEnd(5);
        list1.addToEnd(6);
        list1.display();
        list1.replace(2,99999);
        list1.replace(5,99999);
        list1.display();
        System.out.println(list1.contains(99999));
        System.out.println(list1.contains(9009));
        System.out.println(list1.getCount());
    }
}
