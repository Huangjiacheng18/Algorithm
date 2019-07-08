package net.lzzy.algorithm.algorlib;


public class SortFactory2 {
    public static <T extends Comparable<? super T>> BaseSearch<T> getInstance(int key, T[] items){
        BaseSearch<T> search = null;
        switch (key){
            case 0:

                search=new DrirectSearch<>(items);
                break;
            case 1:
              search= new BinarySearch<>(items);
                break;
                
            default:
                return null;


        }
        return search;
    }

    public static String[]getSearchNames(){
        return new String[]{"顺序查找","二分查找","二叉树查找"};
    }
}

