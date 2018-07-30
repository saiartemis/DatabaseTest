package com.example.zhangxian.databasetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.zhangxian.databasetestBase.DatabaseConnect;
import com.example.zhangxian.databasetestDao.PersionDao;
import com.example.zhangxian.databasetestEntity.Persion;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button add_button;
    private Button del_button;
    private Button modify_button;
    private Button query_button;
    private PersionDao persionDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseConnect dc = new DatabaseConnect(this);
        dc.getWritableDatabase();
        persionDao = new PersionDao(dc);
        initButton();
    }

    private void initButton() {
        add_button = findViewById(R.id.add_button);
        del_button = findViewById(R.id.del_button);
        modify_button = findViewById(R.id.modify_button);
        query_button = findViewById(R.id.query_button);
        add_button.setOnClickListener(this);
        del_button.setOnClickListener(this);
        modify_button.setOnClickListener(this);
        query_button.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        EditText editTextId = null;
        EditText editTextName = null;
        String idText = null;
        String nameText = null;
        switch (view.getId()) {
            case R.id.add_button:
                editTextId = findViewById(R.id.editText_id);
                editTextName = findViewById(R.id.editText_name);
                idText = editTextId.getText().toString().trim();
                nameText = editTextName.getText().toString();
                persionDao.add(new Persion(idText, nameText));
                System.out.println("插入成功");
                break;
            case R.id.del_button:
                editTextId = findViewById(R.id.editText_id);
                idText = editTextId.getText().toString().trim();
                persionDao.del(new Persion(idText, null));
                System.out.println("删除成功");
                break;
            case R.id.query_button:
                editTextId = findViewById(R.id.editText_id);
                idText = editTextId.getText().toString().trim();
                persionDao.query(new Persion(idText,""));
                System.out.println("查询成功");
                break;
            case R.id.modify_button:
                editTextId = findViewById(R.id.editText_id);
                editTextName = findViewById(R.id.editText_name);
                idText = editTextId.getText().toString().trim();
                nameText = editTextName.getText().toString();
                persionDao.modify(new Persion(idText, nameText));
                System.out.println("修改成功");
                break;

        }
    }
}


