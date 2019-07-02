package in.autoboon.autoboon;

import javax.inject.Singleton;

import dagger.Component;
import in.autoboon.autoboon.fragments.Home;
import in.autoboon.autoboon.fragments.UserProfile;

@Singleton
@Component(modules = {AppModuleDagger.class})
public interface AppComponentDagger {
    void inject(AutoboonApp autoboonApp);
    void inject(Splash splash);
    void inject(MainActivity mainActivity);
    void inject(Home home);
    void inject(UserProfile profile);
    void inject(LoginActivity loginActivity);
    void inject(SignUpActivity signUpActivity);
}
