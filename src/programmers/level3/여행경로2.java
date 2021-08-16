package programmers.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 여행경로2 {

  public static HashMap<String, Airport> map = new HashMap<>();

  public String[] solution(String[][] tickets) {


    for (int i = 0; i < tickets.length; i++) {

      Airport go = null;
      if (map.containsKey(tickets[i][0])) {
        go = map.get(tickets[i][0]);
      } else {
        go = new Airport(tickets[i][0]);
        map.put(tickets[i][0], go);
      }

      Airport come = null;
      if (map.containsKey(tickets[i][1])) {
        come = map.get(tickets[i][1]);
      } else {
        come = new Airport(tickets[i][1]);
        map.put(tickets[i][1], come);
      }
      go.add(new Ticket(go, come));

    }
    //           for(Airport a : map.values()){
    //               System.out.print(a.name +" "+ a.tickets.size());
    //               for(Ticket t : a.tickets){
    //                   System.out.print(t.come.name +" ");    
    //               }
    //               System.out.println();


    //           }
    List<String> retVal = new ArrayList<>();
    retVal.add("ICN");
    dfs(map.get("ICN"), tickets.length, retVal);



    return retVal.toArray(new String[retVal.size()]);
  }

  public boolean dfs(Airport a, int target, List<String> arrval) {

    if (arrval.size() > target) {

      boolean chk = true;
      for (String airportName : arrval) {
        if (!map.containsKey(airportName)) {
          chk = false;
          break;
        }
      }
      return chk;
    }

    Collections.sort(a.tickets);
    for (Ticket ticket : a.tickets) {
      if (!ticket.used) {
        arrval.add(ticket.come.name);
        ticket.used = true;
        if (dfs(ticket.come, target, arrval)) {
          return true;
        } else {
          if (arrval.size() > 0)
            arrval.remove(arrval.size() - 1);
        }
        ticket.used = false;
      }
    }
    return false;
  }

  static class Ticket implements Comparable<Ticket> {
    public Airport go;
    public Airport come;
    public boolean used;

    public Ticket(Airport go, Airport come) {
      this.go = go;
      this.come = come;
    }

    @Override
    public int compareTo(Ticket a) {
      return this.come.name.compareTo(a.come.name);
    }
  }

  static class Airport {

    public List<Ticket> tickets;
    public String name;

    Airport(String name) {
      this.name = name;
      this.tickets = new ArrayList<>();
    }


    //a 는 도착지
    public void add(Ticket a) {
      this.tickets.add(a);
    }

  }


}
