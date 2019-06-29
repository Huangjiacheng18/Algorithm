package net.lzzy.algorithm.algorlib;


public class SortFactory {
    public static <T extends Comparable<? super T>> BaseSort<T> getInstance(int key,T[] items){
        BaseSort<T> sort;
        switch (key){
            case 0:

                sort=new DirectSort<>(items);
                break;
            case 1:
                sort=new insertSort<>(items);
                break;
            case 2:
                sort=new ShellSort<>(items);
                break;
            case 3:
                sort=new BubbleSort<>(items);
                break;

                default:
                    return null;


        }
        return sort;
    }

public static String[]getSortNames(){
        return new String[]{"选择排序","直接插入排序","希尔排序","冒泡排序"};
}
}
