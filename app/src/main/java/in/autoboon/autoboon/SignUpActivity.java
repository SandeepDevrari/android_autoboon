package in.autoboon.autoboon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import javax.inject.Inject;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    @Inject
    AutoboonApp autoboonApp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ((AutoboonApp)getApplication()).getAppComponentDagger().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setUpUI();
    }

    private void setUpUI() {
        findViewById(R.id.tv_login_text_2_register).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_login_text_2_register:{
                startActivity(new Intent(autoboonApp,LoginActivity.class));
                break;
            }
        }
    }
}
