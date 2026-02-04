package Items;

import java.io.IOException;
import java.io.InputStream;

public class MapOfTheForest {
 private static String mapMT = "[ CASTLE ]──[ FOREST ]──[ VILLAGER ]──[ MERCHANT ]";
 public static String getMapMT(){
     return mapMT;
 }
 private String id = "mapoftheforest";

    public void setMapMT(String mapMT) {
        this.mapMT = mapMT;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
