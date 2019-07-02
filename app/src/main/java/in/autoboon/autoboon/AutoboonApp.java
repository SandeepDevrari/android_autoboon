package in.autoboon.autoboon;

import android.app.Application;

public class AutoboonApp extends Application {
    private AppComponentDagger appComponentDagger;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponentDagger=DaggerAppComponentDagger.builder().appModuleDagger(new AppModuleDagger(this)).build();
        appComponentDagger.inject(this);
    }

    public AppComponentDagger getAppComponentDagger() {
        return appComponentDagger;
    }
}
