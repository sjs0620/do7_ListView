package com.sjs.disc.do7_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //데이터준비
        ArrayList<Weather> data = new ArrayList<>();
        data.add(new Weather("수원","25도","맑음"));
        data.add(new Weather("서울","26도","비"));
        data.add(new Weather("안양","24도","맑음"));
        data.add(new Weather("부산","29도","구름"));
        data.add(new Weather("인천","23도","구름"));
        data.add(new Weather("대구","28도","비"));
        data.add(new Weather("용인","25도","맑음"));
        data.add(new Weather("성남","24도","비"));
        data.add(new Weather("오산","22도","구름"));
        data.add(new Weather("평택","27도","맑음"));
        //어댑터
        MyFirstAdapter adapter = new MyFirstAdapter(data);

        //뷰
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        //클릭
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, position+" 번째 아이템 선택", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
