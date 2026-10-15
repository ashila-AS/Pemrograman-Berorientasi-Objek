import java.util.Scanner;

public class WeeklySales {
   public static void main (String[] args) {
      Scanner scan = new Scanner(System.in);

      System.out.print ("\nHow many salespeople? ");
      int size = scan.nextInt();

      Salesperson[] salesStaff = new Salesperson[size];

      for (int i = 0; i < size; i++) {
         System.out.println ("\nSalesperson " + (i+1));

         System.out.print ("First name: ");
         String first = scan.next();

         System.out.print ("Last name: ");
         String last = scan.next();

         System.out.print ("Total sales: ");
         int sales = scan.nextInt();

         salesStaff[i] = new Salesperson (first, last, sales);
      }

      scan.close();

      Sorting.insertionSort(salesStaff);

      System.out.println ("\nRanking of Sales for the Week\n");

      for (Salesperson s : salesStaff)
         System.out.println (s);
   }
}