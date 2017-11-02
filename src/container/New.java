/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package container;

/**
 *
 * @author Alex
 */
public class New extends Thread{
    public int r(int e){
      
        return e++;
        
    }
    public static void main(String[] args) {
        New f = new New();
        System.out.println(f.r(3));
        
    }
}
