package help;

import java.util.TimeZone;

public class Main {

    public void init(){
        // Setting Spring Boot SetTimeZone
        TimeZone.setDefault(TimeZone.getTimeZone("CST"));
    }
}
