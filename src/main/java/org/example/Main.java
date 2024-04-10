package org.example;

public class Main {

    // Check is a number is prime
    public static boolean PrimeNum(int num){

        if (num < 2) return false;
        for(int i = 2; i < num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    // Check if a number contains a 3 in it
    public static boolean hasAThree(int num){
        while(num > 0) {
            if(num % 10 == 3)
                return true;
            num=num/10;
        }
        return false;
    }

    // Populate linked list with prime numbers
    public static void makeList(LinkedList listOfPrimes, int n){
        Node nodeA;
        for (int i = 1; i <= n; i++) {
            if (PrimeNum(i)) {
                nodeA = new Node(i);
                listOfPrimes.append(nodeA);
            }
        }
    }

    // Populate list with numbers that contain 3 from listOfPrimes
    public static void listOf3(LinkedList primes,LinkedList primesWithThree){
        Node current = primes.head;

        // Iterate through listOfPrimes
        while (current != null) {
            if(hasAThree(current.data)) {
                primesWithThree.append(current);
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList listOfPrimes = new LinkedList();
        LinkedList primesWithThree = new LinkedList();
        int n = 100000;

        makeList(listOfPrimes,n);
        listOfPrimes.print();

        listOf3(listOfPrimes,primesWithThree);
        primesWithThree.print();

        System.out.println("Sum of all prime numbers with a three: " + primesWithThree.sum());

    }
}