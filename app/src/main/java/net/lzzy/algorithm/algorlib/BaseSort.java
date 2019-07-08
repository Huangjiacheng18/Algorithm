package net.lzzy.algorithm.algorlib;


public abstract class BaseSort <T extends Comparable<? super T>>{
    T[] items;
    private long duration;
    private   int compareCount;
    private   int swapCount;
    int movestep;
    boolean bigger(T a, T b){
        compareCount++;
        return a.compareTo(b)>0;
        //比较
    }
    void swap(int i, int j) {
        T num= (T) items[i];
        items[i]=items[j];
        items[j]=  num;
        swapCount++;
    }


    abstract void Sort();
    public void sortwithtime(){
//        long start=System.currentTimeMillis();
       Sort();
//        duration=System.currentTimeMillis()-start;
    }

    public BaseSort(T[] items){
        this. items=  items;
        duration=0;
        compareCount=0;
        swapCount=0;
        movestep=0;
    }
    public int getSwapCount() {
        return swapCount;

    }


    public int getMovestep() {
        return movestep;
    }


    public long getDuration(){
        return duration;
    }


    public long getcompareCount(){
        return compareCount;
    }



    public String getconut(){
        String display = "";
        for (T i : items) {
            display = display.concat(i + ",");
        }
        display = display.substring(0, display.length() - 1);

        return display;
    }
}
