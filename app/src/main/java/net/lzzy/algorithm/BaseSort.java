package net.lzzy.algorithm;

import android.widget.TextView;

import java.util.List;

/**
 * Created by lzzy_gxy on 2019/6/15.
 * Description:
 */
public abstract class BaseSort<T extends Comparable<T>> {

//     Integer[] items;
    T[] items;
     long duration;
    private int compareCount;
    private int swapCount;
     int moveStep;

    BaseSort(T[] items){
        this.items=items;
        compareCount=0;
        swapCount=0;
        moveStep=0;
    }

    boolean bigger(T a,T b){
        compareCount++;
        return a.compareTo(b)>0;
    }

     void swap(int i,int j){
        T tmp=items[i];
        items[i]=items[j];
        items[j]=tmp;
        swapCount++;
    }

    private String getResult() {
        String display = "";
        for (T i : items) {
            display = display.concat(i + ",");
        }
        return display.substring(0,display.length());
    }

    public void sortWithTime(){
        long start=System.currentTimeMillis();
        sortWithTime();
        duration = System.currentTimeMillis()-start;
    }

    abstract void sort();

    public long getDuration(){return duration;}

    public int getCompareCount(){return compareCount;}

    public int getSwapCount(){return swapCount;}

    public int getMoveStep(){return moveStep;}
    //0.0.0.0.0
}
