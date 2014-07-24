    public class TestFIle {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,6,6,6,7,8,9};
        System.out.println(isPattern(arr));
// This is my comment!
        int[] arr2 = {1,23,4,5,6,7,8,9,9,9,9,9,10};
        System.out.println(isPattern(arr2));

        int[] arr3 = {1,2,3,4,5,6,7};
        System.out.println(isPattern(arr3));
    }
    public static boolean isPattern(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count = 0;
            for (int j = i; j < arr.length; j++) { // !!!!!
                if (arr[i] == arr[j]) {
                    count ++;
                }
                else break;
            }
            System.out.println(count);
            if (count == 4)
                return true;
            if (count > 4) // !!!!!
                i += count - 1; // !!!!
        }
    return false;
    }
}
