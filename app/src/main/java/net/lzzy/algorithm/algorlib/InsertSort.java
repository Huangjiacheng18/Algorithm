package net.lzzy.algorithm.algorlib;


class insertSort  <T extends Comparable<? super T>>extends BaseSort<T> {

    public insertSort(T[] items) {
        super(items);
    }

    //--
    @Override
    public void Sort() {

        for (int i=1;i<items.length;i++){
            int j=i-1;
            if (bigger(items[i],items[j])){
                continue;
            }
            T tmp=items[i];
            while (j>=0&&bigger(items[j],tmp)){
                items[j+1]=items[j];
                movestep++;
                j--;
            }
            items[j+1]=tmp;
        }

    }
}