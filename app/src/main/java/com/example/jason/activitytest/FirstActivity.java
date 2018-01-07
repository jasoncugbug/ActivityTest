package com.example.jason.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"You click ADD",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You click REMOVE",Toast.LENGTH_SHORT ).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1=findViewById(R.id.button_1);
        Button button5=findViewById(R.id.button_5);

       //下一页
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //悬浮窗口提示
                //Toast.makeText(FirstActivity.this,"You click the button",Toast.LENGTH_SHORT).show();
               //back键
                // finish();
                //Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                String data="Welcome_SecondActivity_FromFirstButton";
                Intent intent=new Intent("com.example.activitytest.ACTION_START");
                intent.addCategory("com.example.activitytest.MY_CATEGORY");
                intent.putExtra("extra_data",data);
                startActivity(intent);
            }
        });

        //下一页并传值
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data="Hello_SecondActivity_FromSecondButton";
                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("extra_data",data);
                startActivity(intent);
            }
        });
    }
    /*public void clickHandler(View source){
        Toast.makeText(FirstActivity.this,"You click the button",Toast.LENGTH_SHORT).show();
    }*/
}
