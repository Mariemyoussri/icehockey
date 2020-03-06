package eg.edu.alexu.csd.datastructure.iceHockey.cs77;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class test {
  @Test
  void test0() {
    PlayerFinder test = new PlayerFinder();
    String[] photo = {"33JUBU33", "3U3O4433", "O33P44NB", "PO3NSDP3", "VNDSD333", "OINFD33X" };
    Point[] points = {
      new Point(4, 5),
      new Point(13, 9),
      new Point(14,2)
    };
    Assert.assertArrayEquals(points, test.findPlayers(photo, 3, 16));
  }

  @Test
  void test1() {
    PlayerFinder test1 = new PlayerFinder();
    String[] photo1 = {"44444H44S4", "K444K4L444", "4LJ44T44XH", "444O4VIF44", "44C4D4U444", "4V4Y4KB4M4", "G4W4HP4O4W", "4444ZDQ4S4", "4BR4Y4A444", "4G4V4T4444"  };
    Point[] points1 =
    {
      new Point(3, 8),
      new Point(4, 16),
      new Point(5, 4),
      new Point(16, 3),
      new Point(16, 17),
      new Point(17, 9)
    };
    Assert.assertArrayEquals(points1, test1.findPlayers(photo1, 4, 16));
  }
  
  @Test
  void test2() {
    PlayerFinder test2 = new PlayerFinder();
    String[] photo2 = null;
    assertNull(test2.findPlayers(photo2, 3, 16));
  }
  
  @Test
  void test3() {
    PlayerFinder test3 = new PlayerFinder();
    String[] photo3 = {"0abg0", "5sfsg", "O33po", "PO391", "VNDSD", "OINFD" };
    assertNull(test3.findPlayers(photo3, 8, 16));
  }
  
  @Test
  void test4() {
    PlayerFinder test4 = new PlayerFinder();
    String[] photo4 = {"11111", "1AAA1", "1A1A1", "1AAA1", "11111"  };
    Point[] points4 = {
      new Point(5, 5),
      new Point(5, 5)
    };
    Assert.assertArrayEquals(points4, test4.findPlayers(photo4, 1, 3));
  }
  

}
