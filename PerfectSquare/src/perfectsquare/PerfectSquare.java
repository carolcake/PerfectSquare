/*
Caroline Hsu - 9/4/2021
This program prompts the user to enter a number, then the program will
find all of the factors of the number. It will then see what numbers appear
an odd amount of times, and therefore, will multiply those numbers with 
the user number and will equal a perfect square. It will print out the output
for the user. 

main method 
declare variables and arraylist & scanner

ask user for number and save it
send the number to the factor method
find n
multiply m * n
print m, n, perfect square for the user

preconditions for the factor method
  the method needs to receive the user input
postconditions for the factor method
  the method needs to return an array list with the factors of the user input
  factor method returns factor array list and will receive user input
  declare array list
  for loop starting at 2 (to account for dividing by 1, 1 won't count)
  must be less than userInput and i++ to increment
    if statement for modulus is 0 from dividing by factor
      add i to the factors
      new user input to redo the program
      subtract 1 for repeating numbers (to redo the for loop again)
  add the remainder to the end of the arraylist
  return the arraylist to the main method

preconditions for the product method
  product method needs to receive factors 
postconditions for the product method
  the method needs to return an integer of the odd products (n)
  declare product
  for loop for if the index = 0, i < size of array list - 1, i++
    (the -1 is like the selection sort method)
    another for loop for if the k index is index +1; k < size of array list, k++
      if statement for if the factors at index = index at k
        set factor at i to 1
        set factor at k to 1
  for loop to multiply all the array values
    (for loop works bc if similar values are set to 1, only one of the odd number
    repeated values will be there)
  return product
 */
// package perfectsquare;

// import scanner from API and arraylist method
import java.util.ArrayList;
import java.util.Scanner;

public class PerfectSquare
{

  public static void main(String[] args)
  {
    // declare scanner for input, also variables for user input and array list
    Scanner input = new Scanner(System.in);
    int userInput;
    int n;
    int perfectSquare;
    ArrayList<Integer> factor = new ArrayList<Integer>();

    // ask the user for a number and save it
    System.out.println("Please enter an integer number: ");
    userInput = input.nextInt();

    // push to the methods and calculate the perfect square (m*n value)
    factor = factor(userInput);
    n = nProduct(factor);
    perfectSquare = userInput * n;

    // print out everything to your user 
    System.out.println("The answer of your user input, m = " + userInput
        + ", and the product of the factors, n = " + n + " that appear"
        + " oddly in the program is: " + perfectSquare);
    System.out.println("Therefore, the m * n of your number is: "
        + perfectSquare);
  }

  // factor method returns factor array list, receives user input
  public static ArrayList factor(int userInput)
  {
    // declare array list to return to the main method
    ArrayList<Integer> factors = new ArrayList<Integer>();
    // for loop for starting at 2 (if you start at 1, it doesn't count)
    for (int i = 2; i < userInput; i++)
    {
      // if statement for if the user input modulus index i == 0
      if (userInput % i == 0)
      {
        // add the i to the factors
        factors.add(i);
        // new user input number to redo the program
        userInput = userInput / i;
        // minus 1 to repeat to account for repeating numbers (aka 2 two's)
        i--;
      }
    }
    // add the remainder to the end of arraylist
    factors.add(userInput);
    // return the arraylist to the main method
    return factors;
  }

  // method to get product, return product and receives arraylist
  public static int nProduct(ArrayList<Integer> factors)
  {
    // preset product to 1
    int product = 1;

    // for loop for i at 0; i is less than factors size - 1; i++
    // this method is similar to selection sort and bubble sort combined = 
    // you look at the numbers like king and queen and compare numbers side 
    // by side
    for (int i = 0; i < factors.size() - 1; i++)
    {
      // for loop for starting at one more than i; k is less than factors size; k++
      for (int k = i + 1; k < factors.size(); k++)
      {
        // if statement for if the factor at i is the factor at k
        if (factors.get(i) == factors.get(k))
        {
          // set both values to 1 so that you do not repeat multiply if they
          // appear more than 1 odd number of times
          factors.set(i, 1);
          factors.set(k, 1);
        }
      }
    }

    // for loop to multiply all of the factors that appear an odd number of times
    for (int i = 0; i < factors.size(); i++)
    {
      product = product * factors.get(i);
    }
    // finally, return the product to the main method
    return product;
  }

}
