package net.lzzy.algorithm;

/**
 * Created by lzzy_gxy on 2019/6/13.
 * Description:
 */
public class DirectSort<T extends Comparable<T>>extends BaseSort<T>{
    DirectSort(T[] items) {
        super(items);
    }

    @Override
    void sort() {

    }


//    private Integer[] items;
//    private long dureation;
//    private int compareCount;
//    private int swapCount;
//    private int moveStep;
//
//
//    DirectSort(Integer[] items){
//        this.items=items;
//        compareCount=0;
//        swapCount=0;
//        moveStep=0;
//    }
//
//     public boolean bigger(Integer a,Integer b){
//        compareCount++;
//        return a.compareTo(b)>0;
//    }
//
//     public void swap(int i,int j){
//        int tmp = items[i];
//        items [i] = items[j];
//        items [j] = tmp;
//        swapCount++;
//    }
//
//    private String getResult() {
//        String display = "";
//        for (Integer i : items){
//            display = display.concat( i + "");
//        }
//        return  display.substring(0,display.length()-1);
//    }
//
//    public void sort() {
//        long start=System.currentTimeMillis();
//        for (int i = 0; i < items.length - 1; i++) {
//            int minPos = i;
//            for (int j = i; j < items.length; j++) {
//                if (items[minPos].compareTo(items[j]) > 0) {
//                    minPos = j;
//                }
//            }
//            swap(minPos, i);
//        }
//        dureation=System.currentTimeMillis()-start;
//    }
//
//    public long getDureation(){
//        return dureation;
//    }
//
//    public int getCompareCount(){
//        return compareCount;
//    }
//
//    public int getSwapCount() {
//        return swapCount;
//    }
//
//    public int getMoveStep() {
//        return moveStep;
//    }
}
