package com.ahmadrosid.belajareventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ahmadrosid.belajareventbus.model.User;

import de.greenrobot.event.EventBus;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private Button save;
    private EditText name, age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        EventBus.getDefault().register(this);

        name = (EditText) findViewById(R.id.inputName);
        age = (EditText) findViewById(R.id.inputAge);

        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.save:
                User user = new User();
                user.setName(name.getText().toString());
                user.setAge(Integer.parseInt(age.getText().toString()));
                EventBus.getDefault().post(user);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }


    public void onEvent(User user){

    }

}
