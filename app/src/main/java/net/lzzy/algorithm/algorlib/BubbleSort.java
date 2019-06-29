package net.lzzy.algorithm.algorlib;


public class BubbleSort  <T extends Comparable<? super T>>extends BaseSort<T> {
    public BubbleSort(T[] items) {
        super(items);
    }

    @Override
    void Sort() {
        for (int i=0;i<items.length-1;i++){
            for (int j=0;j<items.length-1-i;){
                if (bigger(items[j],items[j+1])){
                    T temp=items[j];
                    items[j]=items[j+1];
                    items[j+1]=temp;
                }
            }

        }

    }


}
