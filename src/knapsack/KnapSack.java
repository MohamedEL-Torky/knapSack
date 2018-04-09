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
        System.out.println("Please enter Sack size");
        int sackSize = input.nextInt();
        System.out.println("Please enter the number of elements");
        int eleNo = input.nextInt();
        Map<Float,Float> elements = new HashMap<Float,Float>();
        Map<Float,Float> elements2 = new HashMap<Float,Float>();
        float[] ratioKeys = new float[eleNo];
        System.out.println("Please enter weight and value");
        for(int x = 0; x < eleNo; x++){
            System.out.println("Element No."+(x+1));
            float w = input.nextInt(), v = input.nextInt();
            while(elements.containsKey(w) && elements.containsValue(v)){
                System.out.println("Please note that repetition of W and V is not"
                        + " allowed !");
                System.out.println("Please re-enter weight and value of element"
                        + " No."+ (x+1));
                w = input.nextInt();
                v = input.nextInt();
            }
            float ratio = v/w;
            ratioKeys[x] = ratio;
            elements2.put(v, w);
            if(elements.containsKey(ratio)){
                if(elements.get(ratio) > v){
                    ratio-=0.1;
                }
                else{
                    ratio+=0.1;
                }
            }
            elements.put(ratio, v);
        }
        System.out.println(elements.values());
        
        sort(ratioKeys,0,eleNo-1);
        int x = 0;
        int value = 0;
        while( sackSize > 0){
            if( (sackSize - elements2.get(elements.get(ratioKeys[x]))) > 0 ){
                value += elements.get(ratioKeys[x]);
                sackSize -= elements2.get(elements.get(ratioKeys[x]));
            }
            else{
                value += sackSize * ( elements.get(ratioKeys[x]) /
                        elements2.get(elements.get(ratioKeys[x])) );
                sackSize -= sackSize;

            }
            x++;
        }
        System.out.println("Total Value in the Sack is: "+value);
    }
    public static void printArray(float arr[]){
        for(int i = 0; i < arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
    }
    //Merge Sort
    public static void sort(float arr[], int L, int R){
        if(L < R){
            int M = (L+R)/2;
            sort(arr, L, M);
            sort(arr, M+1, R);
            merge(arr, L, M, R);
        }
    }
    public static void merge(float arr[], int L, int M, int R){
        int LSize = M - L + 1, RSize = R - M;
        float[] LTemp = new float[LSize];
        float[] RTemp = new float[RSize];
        for(int i = 0; i < LSize; i++){
            LTemp[i] = arr[L+i];
        }
        for(int j = 0; j < RSize; j++){
            RTemp[j] = arr[M+1+j];
        }
        int i = 0, j = 0;
        int k = L;
        while (i < LSize && j < RSize){
            if (LTemp[i] >= RTemp[j]){
                arr[k] = LTemp[i];
                i++;
            }
            else{
                arr[k] = RTemp[j];
                j++;
            }
            k++;
        }
        while (i < LSize || j < RSize){
            if(i < LSize){
                arr[k] = LTemp[i];
                i++;
            }
            if(j < RSize){
                arr[k] = RTemp[j];
                j++;
            }
            k++;
        }

    }
}
