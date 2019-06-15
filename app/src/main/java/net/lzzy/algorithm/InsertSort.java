package net.lzzy.algorithm;

/**
 * Created by lzzy_gxy on 2019/6/15.
 * Description:
 */
public class InsertSort extends BaseSort {

    InsertSort(Integer[] items) {
        super(items);
    }
    
    
    public void sort() {
        long start=System.currentTimeMillis();
        for (int i = 0; i < items.length - 1; i++) {
            int minPos = i;
            for (int j = i; j < items.length; j++) {
                if (items[minPos].compareTo(items[j]) > 0) {
                    continue;
                }
                Integer tmp=items[i];
                while (j>=0&&bigger(items[j],tmp)){
                    items[j+1]=items[j];
                    moveStep++;
                    i--;
                }
                items[j+1]=tmp;
            }
            duration=System.currentTimeMillis()-start;
        }
        long dureation = System.currentTimeMillis() - start;
    }
}
