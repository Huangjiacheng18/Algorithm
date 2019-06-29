package net.lzzy.algorithm.algorlib;

public class ShellSort <T extends Comparable<? super T>>extends BaseSort<T> {
     ShellSort(T[] items) {
        super(items);
    }

    @Override
    void Sort() {
    int len=items.length;
    int g=len/2;
    while (g>0){
        for (int i=g;i<items.length-1;i+=g){
            int j=i-g;
            if (bigger(items[i],items[j])){
                continue;
            }
            T tmp=items[i];
            while (j>=0&&bigger(items[j],tmp)){
                items[j+g]=items[j];
                movestep++;
                j-=g;
            }
            items[j+g]=tmp;
        }
        g=g/2;
    }
    }
}
