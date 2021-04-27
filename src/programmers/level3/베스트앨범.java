package programmers.level3;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class 베스트앨범 {
  public int[] solution(String[] genres, int[] plays) {
    Map<String, Genre> genreMap = new HashMap<>();
    for (int i = 0; i < genres.length; i++) {
      String genreString = genres[i];
      Genre genre = genreMap.get(genreString);
      if (genre == null) {
        genre = new Genre();
        genreMap.put(genreString, genre);
      }
      genre.set.add(new Song(plays[i], i));
      genre.total += plays[i];
    }
    int[] answer = genreMap.values().stream().sorted().flatMapToInt(s -> {
      if (s.set.size() >= 2) {
        return IntStream.of(s.set.pollLast().idx, s.set.pollLast().idx);
      } else {
        return IntStream.of(s.set.pollLast().idx);
      }
    }).toArray();

    return answer;
  }
}



class Song implements Comparable<Song> {
  int play;
  int idx;

  public Song(int play, int idx) {
    this.play = play;
    this.idx = idx;
  }

  @Override
  public int compareTo(Song s2) {
    int retVal = Integer.compare(this.play, s2.play);
    if (retVal == 0)
      return Integer.compare(s2.idx, this.idx);
    else
      return retVal;


  }
}


class Genre implements Comparable<Genre> {
  int total;
  TreeSet<Song> set;

  public Genre() {
    this.total = 0;
    this.set = new TreeSet<>();
  }

  @Override
  public int compareTo(Genre g2) {
    return Integer.compare(g2.total, this.total);
  }
}
