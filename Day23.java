// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 23 : Challenge XI - Your 'Mini Store'.
// Day 23 | IG : https://www.instagram.com/benjivrik/
// ----------------------------------------------------
// what would be the output of this program ?
/**
 * Create your Store
 * 
 * Create three employees and set the isWorking to True for two of them.
 *
 * Assign these employees to the store
 * 
 * Get the list of employees from the store and print them on your terminal (showing which employee is working and not working)
 * 
 * Create four Items with the following prices 200,1200,15 and 12.75
 * 
 * Create two customers with the following budget 1500 and 45
 * 
 * The first customer ( budget 1500 CAD ) should be able to buy 3 of the items without any problem
 * 
 * The second customer ( budget 45 CAD ) should try to buy the item at 1200 CAD and the one at 12.75 CAD
 * 
 * You should expect him to be denied to buy the items based on the function buy() implemented in the Customer class
 * 
 * Now, remove  the item at 1200 CAD
 * 
 * Let the second customer buys the items
 * 
 * Display the store information
 * 
 */
public class Day23
{
    public static void main(String[] args)
    {
        Store store =  new Store("Stunt-Business");

        // initialize three employees and add them to the store
        // Two of them should have their status changed to 'working' when you assign them to the store
        // first employee
        Employee employee = new Employee("Jivrik", 15);
        employee.status(); // isWorking to True
        store.addEmployee(employee);

        // second employee
        employee = new Employee("Kavrik", 18.7);
        employee.status(); // isWorking to True
        store.addEmployee(employee);

        //third employee
        employee = new Employee("bevrik", 75);
        store.addEmployee(employee);

        // get the list of employees and display them to your terminal showing their status
        System.out.println("\nWhich employee is currently working? (True for 'working' | False for 'not working')");

        for(Employee emp : store.getEmployees())
        {
            System.out.printf("\n> %s : %s\n", emp.getName(), emp.getWorkStatus());
        }

        // add items in your store
        Item computer = new Item("laptop", "computer", 200);
        Item tv =  new Item("TV", "computer", 1200);
        Item orange = new Item("orange", "fruit", 15);
        Item banana  =  new Item("banana", "fruit", 12.75);

        // adding five laptops to the store
        store.addItem(computer, 5);

        // add ten Tvs in the store
        store.addItem(tv,10);

        // adding ten oranges to the store
        store.addItem(orange, 10);

        // add twenty bananas in the store
        store.addItem(banana,20);

        //display details about the store
        System.out.println(store);


        // Create two customers
        Customer customerOne = new Customer("Tim", 1500);
        Customer customerTwo = new Customer("Tristan", 45);

        // set store
        customerOne.setStore(store);
        customerTwo.setStore(store);

        System.out.println("\n>>>> Adding items in the chart of the first customer <<<<\n");

        // add item to the cart of the first customer
        customerOne.addToCart("laptop");
        customerOne.addToCart("orange");
        customerOne.addToCart("TV");

        // display info about the customer
        System.out.println(customerOne);

        System.out.println("\n>>>> First customer buying items. <<<<\n");

        // buy items for your first customer
        customerOne.buy();
        

        System.out.println("\n>>>> Adding items in the chart of the second customer <<<<\n");

        // add item to the cart of the second customer
        customerTwo.addToCart("banana");
        customerTwo.addToCart("TV");

        // display info about the customer
        System.out.println(customerTwo);

        System.out.println("\n>>>> Second customer buying items. <<<<\n");

        // buy items for your second customer
        customerTwo.buy();

        System.out.println("\n>>>> Second customer removing items. <<<<\n");
        customerTwo.removeFromCart("TV");

        // display info about the customer
        System.out.println(customerTwo);

        System.out.println("\n>>>> Second customer buying items. <<<<\n");
        customerTwo.buy();


        //display details about the store
        System.out.println(store);


    }
}