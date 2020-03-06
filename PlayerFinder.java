package eg.edu.alexu.csd.datastructure.iceHockey.cs77;

import java.awt.Point;
import java.util.Arrays; 

public class PlayerFinder implements IPlayersFinder {
  static int xmin = 100;
  static int ymin = 100;
  static int xmax = 0;
  static int ymax = 0;
  public static int coun;


  public int points(char[][] photo, char t, int x, int y) { 
    int counter = 0;
    if ((photo[x][y] != t)) {
      return 0; 
    }
    else if (photo[x][y] == t) {
      counter++;
      photo[x][y] = 'a';
      if (x >= ymax) {
        ymax = x;
      }
      if (x <= ymin) {
        ymin = x; 
      }
      if (y <= xmin) {
        xmin = y;
      }
      if (y >= xmax) {
        xmax = y;
      }

      if ((x == 0) && (y == 0)) {
        counter += points(photo,t,x + 1,y);
        counter += points(photo,t,x,y + 1);
      }
      if ((x == 0) && (y != 0) && (y != photo[0].length - 1)) {
        counter += points(photo,t,x + 1,y);
        counter += points(photo,t,x,y + 1);
      }
      if ((x != 0) && (y == 0) && (x != photo.length - 1)) {
        counter += points(photo,t,x + 1,y);
        counter += points(photo,t,x,y + 1);
        counter += points(photo,t,x - 1,y);
      }
      if ((x == photo.length - 1) && (y == photo[0].length - 1)) {
        counter += points(photo,t,x - 1,y);
        counter += points(photo,t,x,y - 1);
      }
      if ((x == photo.length - 1) && (y != photo[0].length - 1) && (y != 0)) {
        counter += points(photo,t,x - 1,y);
        counter += points(photo,t,x,y - 1);
        counter += points(photo,t,x,y + 1);
      }
      if ((x != photo.length - 1) && (y == photo[0].length - 1) && (x != 0)) {
        counter += points(photo,t,x - 1,y);
        counter += points(photo,t,x,y - 1);
        counter += points(photo,t,x + 1,y);
      }
      if ((x == 0) && (y == photo[0].length - 1)) {
        counter += points(photo,t,x,y - 1);
        counter += points(photo,t,x + 1,y);
      }
      if ((x == photo.length - 1) && (y == 0)) {
        counter += points(photo,t,x - 1,y);
        counter += points(photo,t,x,y + 1);
      }
      if ((x != photo.length - 1) && (y != photo[0].length - 1) && (x != 0) && (y != 0)) {
        counter += points(photo,t,x - 1,y);
        counter += points(photo,t,x,y - 1);
        counter += points(photo,t,x + 1,y);
        counter += points(photo,t,x,y + 1);
      }
    }

    return counter;
  }
  
  public Point center() {
    int centery;
    int centerx;
    centery = ymin + ymax + 1;
    centerx = xmin + xmax + 1;
    xmin = 100;
    ymin = 100;
    xmax = 0;
    ymax = 0;
    return new Point(centerx,centery);
  }
  
  public void sortplayers(Point[] players) {
    for (int i = 0; i < players.length; i++) {
      for (int j = 0; j < players.length; j++) {
        if (players[i].x < players[j].x) {
          Point temp = players[i];
          players[i] = players[j];
          players[j] = temp;
        }
        if (players[i].x == players[j].x) {
          if (players[i].y < players[j].y) {
            Point temp = players[i];
            players[i] = players[j];
            players[j] = temp;
          }
        }
      }
    }
  }

  @Override
    public Point[] findPlayers(String[] photo, int team, int threshold) {
    if (photo == null) {
      return null;
    }
    char t = Character.forDigit(team, 10);
    char[][] characters = new char[photo.length][photo[0].length()];
    Point[] playerstemp = new Point[1000];
    int coun = 0;
    for (int i = 0; i < photo.length; i++) {
      characters[i] = photo[i].toCharArray();
    }

    for (int i = 0; i < characters.length; i++) {
      for (int j = 0; j < characters[0].length; j++) {
        if (characters[i][j] == t) {
          int area = points(characters,t,i,j) * 4;
          if (area >= threshold) {
            playerstemp[coun] = center();
            coun++;
          }
          else {
            Point notplayer = center();
          }
        }
      }
    }
    if (coun == 0) {
      System.out.println("Empty photo no players detected");
      return null;
    }
    Point[] players = new Point[coun];
    for (int i = 0; i < coun; i++) {
      players[i] = playerstemp[i];
    }
    sortplayers(players);
    return players;
  }

}