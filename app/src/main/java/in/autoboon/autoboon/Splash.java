package in.autoboon.autoboon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import javax.inject.Inject;

public class Splash extends AppCompatActivity {

    @Inject
    public AutoboonApp autoboonApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((AutoboonApp)getApplication()).getAppComponentDagger().inject(this);
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        Thread thread=new Thread(){
            @Override
            public void run() {
                try{
                    sleep(1500);
                }catch (InterruptedException i){
                    //log
                }finally {
                    Intent intent=new Intent(autoboonApp,MainActivity.class);
//                    if(sharedPreferences.getBoolean(getResources().getString(R.string.preference_key_first_time),false)) {
//                        if(!sharedPreferences.getBoolean(sBase.IS_REACHED_TOHOME,false)) {
//                            intent = new Intent(health, LoginSignupActivity.class);
//                        }else{
//                            intent = new Intent(health, MainActivity.class);//home
//                        }
//                    }else{
//                        intent=new Intent(health, Start.class);
//                    }
                    startActivity(intent);
                }
            }
        };
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
