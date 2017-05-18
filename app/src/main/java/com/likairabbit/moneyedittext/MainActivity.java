package com.likairabbit.moneyedittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MoneyEditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = (MoneyEditText)findViewById(R.id.edit);
        edit.setChange(200);
        Button bt = (Button)findViewById(R.id.bt);

    }


    public void onClick(View view) {
        Toast.makeText(MainActivity.this,"您输入的金额去除小数点后为:"+edit.getValue(),Toast.LENGTH_LONG).show();
    }
}
