/*
UIL 2017
State - Dai
*/
import java.io.*;
import java.util.*;


class Dai {
  public static void main(String [] args) throws FileNotFoundException {
    Scanner f = new Scanner(new File("dai.dat"));
    int N = f.nextInt();f.nextLine();
    while(N-- > 0) {
      ArrayList<Pair> list = new ArrayList<>();
      String chop = f.nextLine();
      Scanner c = new Scanner(chop);
      while(c.hasNextInt()) {
        Pair p = new Pair(c.nextInt(), c.nextInt());
        list.add(p);
      }

//      System.out.println(list);

      ArrayList<Line> lines = new ArrayList<>();
      for(int x = 0; x < list.size(); x+=2) {
        Pair s = list.get(x);
        Pair e = list.get(x+1);

        double m = (e.y-s.y)/(e.x-s.x);
        double b = e.y - m * e.x;
        Line l = new Line();
        l.m = m;
        l.b = b;
        l.e = e;
        l.s = s;
        lines.add(l);
      }

  //    System.out.println(lines);

      ArrayList<Intersection> intersections = new ArrayList<>();
      for(int i = 0; i < lines.size(); i++) {
        for (int j = i; j < lines.size(); j++) {
          if(i == j) {
            continue;
          }

          Line a = lines.get(i);
          Line b = lines.get(j);
          double x = (b.b - a.b)/(a.m - b.m);
          Pair intersection = new Pair(x, a.m * x + a.b);
    //      System.out.println(intersection);

          if(isBetween(intersection, a.s, a.e) && isBetween(intersection, b.s, b.e)) {
              intersections.add(new Intersection(intersection, a, b));

          }
        }
      }

//      System.out.println(intersections);

      if(intersections.size() == 0 ){
        System.out.println(0);
        continue;
      }
      Line close = intersections.get(0).b;
      Line cur = intersections.get(0).b;
      ArrayList<Line> polygon = new ArrayList<>();
      for(int i = 0; i < intersections.size(); i ++) {
        for(int j = 0; j < intersections.size(); j ++) {
          if(cur == intersections.get(j).a && !polygon.contains(cur)) {
            polygon.add(cur);
            cur = intersections.get(j).b;
            continue;
          }


          if(cur == intersections.get(j).b && !polygon.contains(cur)) {
            polygon.add(cur);
            cur = intersections.get(j).a;
          }
        }
      }
      if (cur == close && polygon.size() > 2) {
          System.out.println(polygon.size());
      } else {
        System.out.println(0);
      }


    }
  }

  public static boolean isBetween(Pair q, Pair a, Pair b) {
    if(Math.abs(q.x - a.x) < 0.001 && Math.abs(q.y - a.y) < 0.001) {
      return true;
    }

    if(Math.abs(q.x - b.x) < 0.001 && Math.abs(q.y - b.y) < 0.001) {
      return true;
    }
    double d = Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
    double d1 = Math.sqrt(Math.pow(q.x - a.x, 2) + Math.pow(q.y - a.y, 2));
    double d2 = Math.sqrt(Math.pow(b.x - q.x, 2) + Math.pow(b.y - q.y, 2));
    return !(d1 > d || d2 > d);
  }
}

class Pair {
  double x;
  double y;
  public Pair(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public String toString() {
    return String.format("(%5.2f, %5.2f)", x, y);
  }
}

class Line {
  double m;
  double b;
  Pair s;
  Pair e;

  public String toString() {
    return String.format("y=%.2fx+%.2f", m, b);
  }
}

class Intersection {
  Line a;
  Line b;
  Pair i;

  public Intersection(Pair i, Line a, Line b) {
    this.a = a;
    this.b = b;
    this.i = i;
  }

  public String toString() {
    return i.toString() + ": " + a.toString() + " " + b.toString();
  }
}
