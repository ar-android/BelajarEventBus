package com.ahmadrosid.belajareventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ahmadrosid.belajareventbus.model.User;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvName, tvAge;
    private Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = (TextView) findViewById(R.id.tvName);
        tvAge = (TextView) findViewById(R.id.tvAge);

        btnGo = (Button) findViewById(R.id.goNext);

        btnGo.setOnClickListener(this);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    public void onEvent(User user){
        if (user != null){
            tvName.setText("Username : " + user.getName());
            tvAge.setText("User Age : " + user.getAge());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.goNext:
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                break;
        }
    }
}
