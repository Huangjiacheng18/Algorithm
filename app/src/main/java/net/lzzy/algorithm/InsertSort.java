package net.lzzy.algorithm;

/**
 * Created by lzzy_gxy on 2019/6/15.
 * Description:
 */
public class InsertSort<T extends Comparable <? super T>>extends BaseSort {

    InsertSort(Integer[] items) {
        super(items);
    }


    public void sort() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < items.length - 1; i++) {
            int j = i - 1;
            if (bigger(items[i], items[j])) {
                continue;
            }
            T tmp = (T) items[i];
            while (j >= 0 && bigger(items[j], tmp)) {
                items[j + 1] = items[j];
                moveStep++;
                j--;
            }
            items[j - 1] = tmp;

        }
    }
}
