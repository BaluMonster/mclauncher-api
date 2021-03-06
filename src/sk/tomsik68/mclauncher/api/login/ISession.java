package sk.tomsik68.mclauncher.api.login;

import java.util.List;

import sk.tomsik68.mclauncher.impl.login.yggdrasil.YDUserObject.Prop;
/**
 * Session is what is obtained in login process.
 * @author Tomsik68
 *
 */
public interface ISession {
    /**
     * 
     * @return Username of this session
     */
    public String getUsername();
    /**
     * 
     * @return ID of the session
     */
    public String getSessionID();
    /**
     * 
     * @return Player's UUID
     */
    public String getUUID();
    /**
     * 
     * @return Type of this session
     */
    public ESessionType getType();
    /**
     * 
     * @return User properties tied with this session
     */
    public List<Prop> getProperties();
}
