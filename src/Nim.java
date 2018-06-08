import java.util.Scanner;


public class Nim {
    static int remove, i;
    static int A = 3;
    static int B = 4;
    static int C = 5;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String name1, name2, name, pile;


        System.out.print("Player 1, please enter your name: ");
        name1 = input.next();
        System.out.print("Player 2, please enter your name: ");
        name2 = input.next();

        System.out.println("");
        i = 0;
        if(A>i)
            i=A;
        if(B>i)
            i=B;
        if(C>i)
            i=C;
        graphic();

        name = name2;
        while((A>0 || B>0 || C> 0) && (A+B+C > 1)) {
            if(name.equals(name1)) {
                name = name2;
            } else name = name1;
            System.out.print("\n\n" + name + ", choose a pile: ");
            pile = input.next().toUpperCase();

            while((pile.equals("A") && A<=0) || (pile.equals("B") && B<=0) || (pile.equals("C") && C<=0)) {
                System.out.print("That pile is empty. Please choose again: ");
                pile = input.next().toUpperCase();
            }

            System.out.print("How many you want to remove from pile "+pile+": ");
            remove = input.nextInt();

            while(remove <= 0 || remove >= 4) {
                if(remove <=0) {
                    System.out.print("\nYou must remove at least 1. Please try again: ");
                    remove = input.nextInt();
                }else if(remove >= 4){
                    System.out.print("\n The maximum you can remove is 3. Please try again: ");
                    remove = input.nextInt();
                }
            }

            while((pile.equals("A") && remove>A) || (pile.equals("B") && remove>B) || (pile.equals("C") && remove>C)){
                System.out.print("Pile "+pile+" doesn't have that many. Please try again: ");
                remove = input.nextInt();
            }

            if(pile.equals("A")){
                A -= remove;
            } else if(pile.equals("B")){
                B -= remove;
            } else if(pile.equals("C")){
                C -= remove;
            }

            System.out.println("");
            i = 0;
            if(A > i)
                i = A;
            if(B > i)
                i = B;
            if(C > i)
                i = C;
            graphic();
        }

        if((A+B+C == 1) && name.equals(name1)){
            System.out.println(name2+", you have to take the last remaining number, you lose. "+name1+" is the winner.");
        } else if((A+B+C == 1) && name.equals(name2)) {
            System.out.println(name1 + ", you have to take the last remaining number, you lose. " + name2 + " is the winner.");
        } else if(name.equals(name1)){
            System.out.println(name2+ " there are no numbers left, you win.");
        } else if(name.equals(name2)){
            System.out.println(name1+" there are no numbers left, you win.");
        }
    }
    static void graphic(){

        while(i > 0){
            System.out.print("\t");
            if( i <= A)
                System.out.print("* ");
            else System.out.print("  ");
            if( i <= B)
                System.out.print("* ");
            else System.out.print("  ");
            if( i <= C)
                System.out.print("* ");
            else System.out.print("  ");
            System.out.println("");
            i -= 1;
        }
        System.out.println("\tA B C");
    }
}
