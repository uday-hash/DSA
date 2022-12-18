/*
 * Given a string A representing an absolute path for a file (Unix-style).

Return the string A after simplifying the absolute path.

Note:

In Unix-style file system:

A period '.' refers to the current directory.
A double period '..' refers to the directory up a level.
Any multiple consecutive slashes '//' are treated as a single slash '/'.
In Simplified Absolute path:

The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path doesn't end with trailing slashes '/'.
The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
Path will not have whitespace characters.

 */
package Stacks_and_Queues;

import java.util.*;

public class Simplify_directory_path {
    public String simplifyPath(String A) {
        Stack<String> stack = new Stack<>();
        String[] arr = A.split("/");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!arr[i].equals(".") && !arr[i].equals("")) {
                stack.push(arr[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        if (sb.length() == 0) {
            sb.append("/");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Simplify_directory_path s = new Simplify_directory_path();
        String A = "/home/";
        System.out.println(s.simplifyPath(A));
    }

}
