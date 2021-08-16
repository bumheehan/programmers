package datastructure;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {

  public static int prime(int n) {
    if (n == 1 && n == 0) {
      return 0;
    }
    if (n == 2) {
      return 1;
    }
    List<Integer> primeNumbers = new ArrayList<>();
    primeNumbers.add(2);
    for (int i = 3; i <= n; i += 2) {
      int limit = (int) Math.sqrt(i);
      boolean isPrime = true;
      for (int prime : primeNumbers) {
        if ((prime > limit) || (i % prime == 0)) {
          isPrime = false;
          break;
        }
      }
      if (isPrime) {
        primeNumbers.add(i);
      }
    }
    return primeNumbers.size();
  }

  public static void main(String[] args) {

  }
}
