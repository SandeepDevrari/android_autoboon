package in.autoboon.autoboon;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModuleDagger {
    private AutoboonApp autoboonApp;

    public AppModuleDagger(AutoboonApp autoboonApp) {
        this.autoboonApp = autoboonApp;
    }

    @Provides
    @Singleton
    public AutoboonApp provideAutoboonApp(){
        return autoboonApp;
    }
}
