package sjq.light.goarray;

public class TestNilGoArray {
    public static void main(String[] args) {
        GoArray<Integer> intArray = GoArray.make(Integer[].class, 0);
        
        GoArray<Integer> append = GoArray.append(intArray, 10);
        append = GoArray.append(append, 20);
        append = GoArray.append(append, 30);
        System.out.println(append);
    }
}
