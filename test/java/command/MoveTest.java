package command;
import main.java.command.*;
import main.java.Default.*;
import locations.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;


public class MoveTest {

    private Move moveCommand;

    @BeforeEach
    void setUp() {
        LocationManager lm = LocationManager.loadLocations("resources/map.json");
        GameInfo.setAllLocations(lm.getLocations());
        

        Location startLoc = GameInfo.getAllLocations().stream()
                .filter(l -> l.getName().equalsIgnoreCase("OldVillagersHouse"))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("OldVillagersHouse not found"));
        GameInfo.setCurrentLocation(startLoc);

        command.Inventory.getInventory().clear();
        command.Inventory.getInventory().add("lantern");

        moveCommand = new Move();
    }

    @Test
    void testMoveWestSuccess() {
        String input = "west";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = moveCommand.execute();

        assertEquals("Obchodnikuvdomecek", GameInfo.getCurrentLocation().getName());
        assertTrue(result.contains("You just moved to"));
    }

    @Test
    void testMoveEastSuccess() {
        String input = "east";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = moveCommand.execute();

        assertEquals("Forest", GameInfo.getCurrentLocation().getName());
        assertTrue(result.contains("You just moved to"));
    }

    @Test
    void testCannotMoveWithoutLantern() {
        command.Inventory.getInventory().clear();

        String input = "west";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = moveCommand.execute();

        assertEquals("You don’t have a lantern, so you can’t move.", result);
    }

    @Test
    void testInvalidMove() {
        Location castle = GameInfo.getAllLocations().get(0);
        GameInfo.setCurrentLocation(castle);

        String input = "backward";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = moveCommand.execute();

        assertEquals("Castle", GameInfo.getCurrentLocation().getName());
        assertEquals("You cannot move there.", result);
    }
    @Test
    void testVisitCountIncrementsOnMove() {
        Location forest = GameInfo.getAllLocations().get(1);
        int initialVisitCount = forest.getVisitCount();

        String input = "east";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        moveCommand.execute();

        assertEquals(initialVisitCount + 1, forest.getVisitCount(), "Visit count should increment after moving to a location.");
    }

    @Test
    void testMoveUsingBackCommand() {

        String input = "back";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = moveCommand.execute();

        assertEquals("Forest", GameInfo.getCurrentLocation().getName());
        assertTrue(result.contains("You just moved to"));
    }

    @Test
    void execute() {
    }
}
