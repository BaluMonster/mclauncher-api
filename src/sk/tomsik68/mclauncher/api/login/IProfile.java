package sk.tomsik68.mclauncher.api.login;

public interface IProfile {
    public String getName();

    public String getPassword();

    public String getToken();

    public boolean isRemember();
}