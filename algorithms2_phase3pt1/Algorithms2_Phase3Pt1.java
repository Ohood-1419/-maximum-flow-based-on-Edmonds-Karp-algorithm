/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms2_phase3pt1;

/**
 *
 * @author luluahmaldakhil
 */
public class Algorithms2_Phase3Pt1 {

    //testing out functions with given data set
    public static void main(String[] args) {
         int graph[][] = new int[][] {
          //  1  2  3  4  5  6
            { 0, 2, 7, 0, 0, 0 }, //1 
            { 0, 0, 0, 3, 4, 0},  //2
            { 0, 0, 0, 4, 2, 0 }, //3  
            { 0, 0, 0, 0, 0, 1 }, //4
            { 0, 0, 0, 7, 0, 5 }, //5
            { 0, 0, 0, 0, 0, 0 }  //6
        };
        MaxFlow m = new MaxFlow();
 
        System.out.println("The maximum flow (Ford Fulkerson): "
                           + m.fordFulkerson(graph, 0, 5));
    }
    }
    

