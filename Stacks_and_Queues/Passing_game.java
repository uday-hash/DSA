/*
 * Problem Description
There is a football event going on in your city. In this event, you are given A passes and players having ids between 1 and 106.

Initially, some player with a given id had the ball in his possession. You have to make a program to display the id of the player who possessed the ball after exactly A passes.

There are two kinds of passes:

1) ID

2) 0

For the first kind of pass, the player in possession of the ball passes the ball "forward" to the player with id = ID.

For the second kind of pass, the player in possession of the ball passes the ball back to the player who had forwarded the ball to him.

In the second kind of pass "0" just means Back Pass.

Return the ID of the player who currently possesses the ball.



Problem Constraints
1 <= A <= 100000

1 <= B <= 100000

|C| = A


 */
package Stacks_and_Queues;

import java.util.*;

public class Passing_game {
    public int solve(int A, int B, ArrayList<Integer> C) {
        Stack<Integer> stack = new Stack<>();
        stack.push(B);
        for (int i = 0; i < A; i++) {
            if (C.get(i) == 0) {
                stack.pop();
            } else {
                stack.push(C.get(i));
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        Passing_game p = new Passing_game();
        int A = 5;
        int B = 5;
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(5, 0, 0, 0, 0));
        System.out.println(p.solve(A, B, C));
    }
    
}
