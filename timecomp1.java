import java.util.Scanner;

public class timeComp1 {
    static Scanner s = new Scanner(System.in);
    static int n;
    static int[] a;
    static int key, i, flag, pos;

    static int search(int key, int pos) {
        if (pos >= n) {
            System.out.println("Key not found!!!");
            return -1;
        }
        if (a[pos] == key) {
            System.out.println("Found key " + key + " at position " + pos);
            return pos;
        }
        return search(key, pos + 1);
    }

    static void visit(int i) {
        if (i >= n) {
            return;
        }
        System.out.println("\n...Visit() Menu...\n");
        System.out.println("a. Go to print before VISIT().\n");
        System.out.println("b. Go to print After VISIT().\n");
        System.out.println("c. Go to print between VISIT().");

        System.out.println("\nEnter the choice for visit(): ");
        String ch = s.nextLine();
        switch (ch) {
            case "a":
                System.out.println("i = " + i + " a[i] = " + a[i]);
                visit(2 * i + 1);
                visit(2 * i + 2);
                break;
            
            case "b":
                visit(2 * i + 1);
                System.out.println("i = " + i + " a[i] = " + a[i]);
                visit(2 * i + 2);
                break;

            case "c":
                visit(2 * i + 1);
                visit(2 * i + 2);
                System.out.println("i = " + i + " a[i] = " + a[i]);
                break;

            default:
                System.out.println("\nInvalid Choice entered !!!");
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the size of array:");
        n = s.nextInt();
        a = new int[n];  
        int opt;
        do { 
            System.out.println("...Menu...\n");
            System.out.println("1. Enter the Array.\n");
            System.out.println("2. VISIT() Function.\n");
            System.out.println("3. Search the element in array.");
            //System.out.println("4.Display Array.");

            System.out.println("\nEnter the option you want to perform: ");
            opt = s.nextInt();
            s.nextLine();  

            switch (opt) {
                case 1:
                    System.out.println("\nEnter the Array elements: ");
                    for (int j = 0; j < n; j++) {
                        a[j] = s.nextInt();
                    }
                    
                    System.out.println("\nDisplay Array:");
                    for (int j = 0; j < n; j++) {
                        System.out.println(a[j]);
                    }
                    break;

                case 2:
                    visit(0);
                    break;

                case 3:
                    System.out.println("\nEnter the number to search: ");
                    key = s.nextInt();
                    pos = search(key, 0);
                    if (pos != -1) {
                        System.out.println("Found key " + key + " at position " + pos);
                    }
                    break;

                default:
                    System.out.println("\nInvalid Option entered !!!");
            }
        } while (opt != 3);  
        s.close();
    }
}
