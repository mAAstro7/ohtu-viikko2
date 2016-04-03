
import java.util.ArrayList;
import java.util.List;
import ohtuesimerkki.Player;
import ohtuesimerkki.Reader;
import ohtuesimerkki.Statistics;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {

    Statistics stats;
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void getYzerman() {
        Player player = stats.search("Yzerman");
        assertEquals("Yzerman", player.getName());
    }

    @Test
    public void getYzermanGoals() {
        Player player = stats.search("Yzerman");
        assertEquals(42, player.getGoals());
    }
    
        @Test
    public void getSemenkoPass() {
        Player player = stats.search("Semenko");
        assertEquals(12, player.getAssists());
    }

    @Test
    public void findNull() {
        Player none = stats.search("Iiiiiljaaaaaaa");
        assertNull(none);
    }

    @Test
    public void getTeam() {
        List<Player> players = stats.team("PIT");
        assertEquals(1, players.size());
    }

    @Test
    public void getTop() {
        List<Player> players = stats.topScorers(1);
        assertEquals(2, players.size());
    }

}
