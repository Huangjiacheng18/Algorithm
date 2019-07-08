package net.lzzy.algorithm.algorlib;


public abstract class BaseSearch <T extends Comparable<? super T>> {
    T[] items;
   long duration;
    private   int compareCount;
    private   int swapCount;
    boolean equal(T a, T b){
        compareCount++;
        return a.compareTo(b)==0;
        //比较
    }
    int compare(T a,T b){
        compareCount++;
        return a.compareTo(b);
    }

    BaseSearch(){}

   public abstract int search(T key);
    public void setDuration(long duration){
        this.duration=duration;
    }
    public void setCompareCount(long duration){
        this.compareCount=compareCount;
    }

    public BaseSearch(T[] items){
        this. items=  items;
        duration=0;
        compareCount=0;
        swapCount=0;

    }
    public int getSwapCount() {
        return swapCount;

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

