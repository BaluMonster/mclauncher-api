package sk.tomsik68.mclauncher.impl.login.legacy;

import java.net.URLEncoder;

import sk.tomsik68.mclauncher.api.login.ILoginService;
import sk.tomsik68.mclauncher.api.login.IProfile;
import sk.tomsik68.mclauncher.api.login.ISession;
import sk.tomsik68.mclauncher.api.login.ISessionFactory;
import sk.tomsik68.mclauncher.api.net.HttpUtils;

public class LegacyLoginService implements ILoginService {
    private final ISessionFactory factory;
    private final String LEGACY_LOGIN_URL = "https://login.minecraft.net/";
    public LegacyLoginService() {
        factory = new LegacySessionFactory();
    }

    @Override
    public ISession login(IProfile profile) throws Exception {
        // create connection and retrieve the array which represents a session
        String[] result = HttpUtils.securePost(LEGACY_LOGIN_URL, LegacyLoginService.class.getResourceAsStream("minecraft.key"), "user="+URLEncoder.encode(profile.getName(), "UTF-8")+"&password="+URLEncoder.encode(profile.getPassword(), "UTF-8")+"&version=13").split(":");
        // create session from the array or throw an exception(use factory)
        return factory.createSession(result);
    }

    @Override
    public String getBranding() {
        return "minecraft.net";
    }

}