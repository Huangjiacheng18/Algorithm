package net.lzzy.algorithm;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.lzzy.algorithm.algorlib.BaseSearch;
import net.lzzy.algorithm.algorlib.BaseSort;
import net.lzzy.algorithm.algorlib.DirectSort;
import net.lzzy.algorithm.algorlib.SortFactory;
import net.lzzy.algorithm.algorlib.SortFactory2;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

import javax.crypto.SecretKeyFactory;

public class MainActivity <T extends Comparable <? super T>> extends AppCompatActivity implements View.OnClickListener {
    private Integer[] items;
    private EditText edtItems;
    private TextView tvResult;
    private Spinner spSearch;
  private   Spinner spinner;
  private LinearLayout container;
  private Button btnSort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtItems = findViewById(R.id.activity_main_edt_items);
        findViewById(R.id.activity_main_btn_generate).setOnClickListener(this);
        findViewById(R.id.activity_main_btn_sort).setOnClickListener(this);
        tvResult = findViewById(R.id.activity_main_tv_result);
        initSpinner();
        initSearch();
    }


private  void  initSearch(){
        spSearch=findViewById(R.id.sp2);
        spSearch.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, SortFactory2.getSearchNames()));
       container=findViewById(R.id.ll);
       findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               resetSearch();
           }
       });
   resetSearch();

    }
    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            BaseSearch<Integer>search= SortFactory2.getInstance(spSearch.getSelectedItemPosition(),items);
            if (search!=null){
                int pos=search.search(v.getId());
                tvResult.setText("该元素位于数组的第".concat((pos+1)+"位"));
            }
        }
    };

private  void resetSearch(){
    container.removeAllViews();
    generateItems();
   if (spSearch.getSelectedItemPosition()==1){
       btnSort.callOnClick();
   }

    for (Integer i:items){
        Button btn=new Button(this);
        btn.setText(String.format(i.toString(), Locale.CHINA));
        btn.setId(i);
        btn.setLayoutParams(new LinearLayout.LayoutParams(0,
                ViewGroup.LayoutParams.WRAP_CONTENT,1));
        btn.setOnClickListener(listener);
        container.addView(btn);

    }

}



    private void initSpinner() {
        spinner=findViewById(R.id.sp);
//        String[] names={"选择排序","直接插入排序","希尔排序"};
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, SortFactory.getSortNames()));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_btn_generate:
                generateItems();
                displayItems(edtItems);
                break;
            case R.id.activity_main_btn_sort:
//                insertSort<Integer> sort=new insertSort<>(items);
//                sort.sortwithtime();
                BaseSort<Integer>sort=SortFactory.getInstance(spinner.getSelectedItemPosition(),items);
              BaseSort<Integer>sortNotNull= Objects.requireNonNull(sort);
              sortNotNull.sortwithtime();
               String result=sortNotNull.getconut();
               tvResult.setText(result);
                Toast.makeText(this, "总时长"+sort.getDuration(), Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    private void displayItems(TextView tv) {
        String display = "";
        for (Integer i : items) {
            display = display.concat(i + ",");
        }
        display = display.substring(0, display.length() - 1);
        tv.setText(display);
    }

    private void directSort() {
        //todo:直接选择排序的具体实现

        for (int i=0;i<items.length-1;i++){
            int min=i;
            for (int j=i+1;j<items.length;j++){
                if (items[min].compareTo(items[j])>0){
                    min=items[j];

                }
                swap(min,i);
            }


        }
    }
    private void insertSort(){
        //todo:直接插入排序的具体实现
        for (int i=1;i<items.length;i++) {
            int j=i-1;
            if (items[j].compareTo(items[i])<0){
                continue;
            }
            Integer tmp=items[i];
            while (j>0&&items[j].compareTo(tmp)>0){
                items[j+1]=items[j];
                j--;
            }
            items[j+1]=tmp;
        }
    }

    private void swap(int m, int n) {
        int tmp=items[m];
        items[m]=items[n];
        items[n]=tmp;
    }


    private void generateItems() {
        items = new Integer[10];
        Random generator = new Random();
        for (int i = 0; i < items.length; i++) {
            items[i] = generator.nextInt(99);
        }
    }
}
