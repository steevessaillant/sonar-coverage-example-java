package de.martinspielmann.wicket.pwnedpasswordsvalidator;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Represents the status of have i been pwned? API response.
 *
 * @author Martin Spielmann
 */
public enum Status implements Callable<Boolean> {

    UNKNOWN_API_ERROR(-1),
    PASSWORD_PWNED(200),
    PASSWORD_OK(404),
    TOO_MANY_REQUESTS(429);

    private final int code;
    private static final Map<Integer, Status> map = new HashMap<>();

    static {
        for (Status s : Status.values()){
            map.put(s.code, s);
        }
    }

    Status(int code){
        this.code = code;
    }

    public static Status of(int code){
        Status s = map.get(code);
        if(s == null){
            s = UNKNOWN_API_ERROR;
        }
        return s;
    }

    @Override
    public Boolean call() {
        return true;
    }
}