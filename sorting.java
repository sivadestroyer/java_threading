import java.util.Arrays;
class bubblesort{
    int[] sortedarray;
    public void add(int[] array){
        for(int i=0; i<array.length-1;i++){
            for(int j=0; j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));;
        sortedarray=array;
    }
    int[] getarray(){
        return sortedarray;
    }
}
class access extends Thread{
    private bubblesort obj;
    int[] array;
    public access(bubblesort obj,int[] array){
        this.obj=obj;
        this.array=array;
    }
    public void run(){
        obj.add(array);

    }


}
public class sorting {
    public static void main(String[] args) throws Exception{
        int[] sortarray={1,2,11,12,3,4,9,5,6,7,8};
        int size = sortarray.length/2;
        int[] firsthalf = Arrays.copyOfRange(sortarray,0,size);
        int[] secondhalf = Arrays.copyOfRange(sortarray,size,sortarray.length);
        bubblesort obj1 = new bubblesort();
        bubblesort obj2 = new bubblesort();

        access t1 = new access(obj1, firsthalf);
        access t2 = new access(obj2, secondhalf);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        int[] mergedArray = mergeArrays(obj1.getarray(), obj2.getarray());

        access t3 = new access(obj1, mergedArray);
        t3.start();
        t3.join();

        int[] sortedArray = obj1.getarray();

        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
    }

    private static int[] mergeArrays(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, mergedArray, 0, array1.length);
        System.arraycopy(array2, 0, mergedArray, array1.length, array2.length);
        return mergedArray;
    }
}

