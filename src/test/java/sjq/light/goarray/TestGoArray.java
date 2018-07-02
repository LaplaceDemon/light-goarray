package sjq.light.goarray;

public class TestGoArray {
    public static void main(String[] args) {
        {
            GoArray<Integer> goArray = new GoArray<>(10);
            goArray = GoArray.append(goArray, 1);
            System.out.println(goArray);
            
            goArray = GoArray.append(goArray, 2);
            goArray = GoArray.append(goArray, 3);
            goArray = GoArray.append(goArray, 4);
            goArray = GoArray.append(goArray, 5);
            System.out.println(goArray);
            
            Integer x = goArray.get(0);
            System.out.println(x);
        }
        
        {
            Integer[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
            GoArray<Integer> goArray0 = new GoArray<>(arr);
            GoArray<Integer> slice = goArray0.slice();
            System.out.println(slice);
        }
        
        {
            Integer[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
            GoArray<Integer> goArray0 = new GoArray<>(arr);
            GoArray<Integer> slice = goArray0.slice();
            System.out.println(slice);
        }
        
        {
            Integer[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
            GoArray<Integer> goArray0 = new GoArray<>(arr);
            GoArray<Integer> d = goArray0.slice(2,10);
            System.out.println(d);
        }
        
        {
            Integer[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
            GoArray<Integer> goArray0 = new GoArray<>(arr);
            GoArray<Integer> d = goArray0.slice(2,10);
            System.out.println(d.get(0));
            GoArray<Integer> s = d.slice(1,6);
            System.out.println(s);
            System.out.println(s.get(0));
            System.out.println(s.get(GoArray.len(s) - 1));
            try {
               System.out.println(s.get(GoArray.len(s)));
            } catch (RuntimeException ex) {
                if(!(ex instanceof ArrayIndexOutOfBoundsException)) {
                    throw ex;
                }
            }
        }
        
        {
            Integer[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
            GoArray<Integer> goArray = new GoArray<>(arr);
            goArray = GoArray.append(goArray, 16);
            System.out.println(goArray);
        }
        
        {
            System.out.println("-------------------");
            Integer[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
            GoArray<Integer> goArray0 = new GoArray<>(arr);
            System.out.println(goArray0);
            GoArray<Integer> goArray1 = goArray0.slice(12,14);
            System.out.println(goArray1);
            goArray1 = GoArray.append(goArray1, 16);
            System.out.println(goArray1);
        }
        
        {
            System.out.println("-------------------");
            Integer[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
            GoArray<Integer> goArray0 = new GoArray<>(arr);
            System.out.println(goArray0);
            GoArray<Integer> goArray1 = goArray0.slice(12,14);
            System.out.println(goArray1);
            goArray1 = GoArray.append(goArray1, 16);
            System.out.println(goArray1);  // [array=[13, 14, 16], len=3, cap=3]
            goArray1 = GoArray.append(goArray1, 17);
            System.out.println(goArray1);
            System.out.println(goArray0);
        }
        
        {
            System.out.println("-------------------");
            Integer[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
            GoArray<Integer> goArray0 = new GoArray<>(arr);
            System.out.println(goArray0);
            GoArray<Integer> goArray1 = goArray0.sliceWithStart(12);
            System.out.println(goArray1);
            
            GoArray<Integer> goArray2 = goArray0.sliceWithStart(0);
            System.out.println(goArray2);
        }
        
        {
            System.out.println("-------------------");
            Integer[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
            GoArray<Integer> goArray0 = new GoArray<>(arr);
            System.out.println(goArray0);
            GoArray<Integer> goArray1 = goArray0.sliceWithEnd(4);
            System.out.println(goArray1);
        }
        
        
        {
            System.out.println("------copy-------------");
            Integer[] arr0 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
            GoArray<Integer> goArray0 = new GoArray<>(arr0);
            
            Integer[] arr1 = {-1,-2,-3,-4,-5,-6,-7,-8,-9,-10,-11,-12,-13,-14,-15};
            GoArray<Integer> goArray1 = new GoArray<>(arr1);
            
            int copy = GoArray.copy(goArray0, goArray1);
            System.out.println(copy + "," + goArray0);
        }
        
        {
            System.out.println("------copy-------------");
            Integer[] arr0 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
            GoArray<Integer> goArray0 = new GoArray<>(arr0);
            
            Integer[] arr1 = {-1,-2,-3,-4};
            GoArray<Integer> goArray1 = new GoArray<>(arr1);
            
            int copy = GoArray.copy(goArray0, goArray1);
            System.out.println(copy + "," + goArray0);
        }
        
        {
            System.out.println("------copy-------------");
            Integer[] arr0 = {1,2,3,4};
            GoArray<Integer> goArray0 = new GoArray<>(arr0);
            
            Integer[] arr1 = {-1,-2,-3,-4,-5,-6,-7,-8,-9,-10,-11,-12,-13,-14,-15};
            GoArray<Integer> goArray1 = new GoArray<>(arr1);
            
            int copy = GoArray.copy(goArray0, goArray1);
            System.out.println(copy + "," + goArray0);
        }
        
        {
            System.out.println("------copy-------------");
            Integer[] arr0 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
            GoArray<Integer> goArray0 = new GoArray<>(arr0);
            GoArray<Integer> slice0 = goArray0.slice(1,3);
            
            Integer[] arr1 = {-1,-2,-3,-4,-5,-6,-7,-8,-9,-10,-11,-12,-13,-14,-15};
            GoArray<Integer> goArray1 = new GoArray<>(arr1);
            GoArray<Integer> slice1 = goArray1.slice(0,10);
            
            int copy = GoArray.copy(slice0, slice1);
            System.out.println(copy + "," + slice0);
        }
        
        {
            System.out.println("------make-------------");
            GoArray<Integer> goIntegerArray = GoArray.make(Integer[].class, 0, 10);
            System.out.println(goIntegerArray);
        }
        
        {
            System.out.println("------make-------------");
            GoArray<Integer> goIntegerArray = GoArray.make(Integer[].class, 10);
            System.out.println(goIntegerArray);
        }
    }
}
