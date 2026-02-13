package locations;

import java.util.ArrayList;
import java.util.List;

public class Location {

    private String name;
    private String description;
    private String west;
    private String east;
    private String north;
    private String south;
    private List<String> items = new ArrayList<>();
    private int visitCount;
    private boolean canUseItem;
    private boolean canSpeakWithNpc;

    public Location() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWest() {
        return west;
    }

    public void setWest(String west) {
        this.west = west;
    }

    public String getEast() {
        return east;
    }

    public void setEast(String east) {
        this.east = east;
    }

    public String getNorth() {
        return north;
    }

    public void setNorth(String north) {
        this.north = north;
    }

    public String getSouth() {
        return south;
    }

    public void setSouth(String south) {
        this.south = south;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public boolean isCanUseItem() {
        return canUseItem;
    }

    public void setCanUseItem(boolean canUseItem) {
        this.canUseItem = canUseItem;
    }

    public boolean isCanSpeakWithNpc() {
        return canSpeakWithNpc;
    }

    public void setCanSpeakWithNpc(boolean canSpeakWithNpc) {
        this.canSpeakWithNpc = canSpeakWithNpc;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", west='" + west + '\'' +
                ", east='" + east + '\'' +
                ", north='" + north + '\'' +
                ", south='" + south + '\'' +
                ", items=" + items +
                ", visitCount=" + visitCount +
                ", canUseItem=" + canUseItem +
                ", canSpeakWithNpc=" + canSpeakWithNpc +
                '}';
    }
}
