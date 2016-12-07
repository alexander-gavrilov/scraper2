package scraper;

/**
 * Created by gavrilov_a on 06.12.2016.
 */
public class Zone {
    private String name;
    private  String code;

    public Zone(String name,String code){
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
