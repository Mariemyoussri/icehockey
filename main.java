package eg.edu.alexu.csd.datastructure.iceHockey.cs77;

import java.awt.Point;
import java.lang.String;

public class main {
  public static void main(String[] args) {
    PlayerFinder player = new PlayerFinder();	
    String[] x = {"33JUBU33", "3U3O4433", "O33P44NB", "PO3NSDP3", "VNDSD333", "OINFD33X" };
    Point[] po = player.findPlayers(x, 3, 16);
    for (int j = 0; j < po.length; j++) {
      System.out.println("(" + (int)po[j].x + "," + (int)po[j].y + ")");
    }
  }
}
