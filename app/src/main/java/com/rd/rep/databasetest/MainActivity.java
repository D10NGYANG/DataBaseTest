package com.rd.rep.databasetest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rd.rep.databasetest.db.DBDao;
import com.rd.rep.databasetest.model.Person;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context mContext = this;
    private DBDao dbDao;

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbDao = new DBDao(mContext);
        dbDao.openDataBase();
        initView();
    }

    private void initView() {
        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);
        txt = (TextView) findViewById(R.id.txt_tips);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbDao.insertData(new Person("张三", System.currentTimeMillis(), "在吗？丽丝嫩红素"));//增加数据
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Person> lists = dbDao.queryDataList();//查询所有数据
                StringBuilder builder = new StringBuilder("数据如下：\n");
                for (int i = 0; i < lists.size(); i++) {
                    builder.append(lists.get(i).toString()).append("\n");
                }
                txt.setText(builder.toString());
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Person> lists = dbDao.queryDataList();//查询所有数据
                dbDao.deleteData(lists.get(0).id);
            }
        });
    }
}
