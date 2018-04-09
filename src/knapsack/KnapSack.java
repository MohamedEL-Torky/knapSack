/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Mohamed ELTorky
 */
public class KnapSack {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter Stack size");
        int sackSize = input.nextInt();
        System.out.println("Please enter the number of elements");
        int eleNo = input.nextInt();
        Map elements = new HashMap();
        System.out.println("Please enter value and weight");
        for(int x = 0; x < eleNo; x++){
            System.out.println("Element No."+(x+1));
            float w = input.nextInt(), v = input.nextInt();
            while(elements.containsKey(w) || elements.containsValue(v)){
                System.out.println("Please note that repetition of W or V is not"
                        + " allowed !");
                System.out.println("Please re-enter value and weight of element"
                        + " No."+ (x+1));
                w = input.nextInt();
                v = input.nextInt();
            }
            elements.put(w, v);
        }
        
    }
    
}
