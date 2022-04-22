package pl.edu.pw.fizyka.java.lab7.mojeprogramy.Zadanie1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JSlider1Runnable extends JSlider implements Runnable {

	int pauza = 1000;
	boolean czynny = true;
	int[] wartosci = new int[100];
		  
	
		  
		  
	public JSlider1Runnable() {
		  setMaximum(100);
		  setMinimum(0);
		  setValue(50);
		  setMajorTickSpacing(10);
		  setMinorTickSpacing(5);
		  setPaintTicks(true);
		  setPaintLabels(true);
		  
		  Timer timer;
		  ActionListener listener;
		  listener = new ActionListener() {
		      int counter = 0;

		      public void actionPerformed(ActionEvent ae) {
		          counter++;
		          setValue(counter);
		          
		      }
		  };
		  timer = new Timer(50, listener);
		  timer.start();
	}	  
	

/*	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/

	public int getRandomInt(int min, int max) {
	    min = (int) Math.ceil(min);
	    max = (int) Math.floor(max);
	    return (int) (Math.floor(Math.random() * (max - min + 1)) + min);
	}
	
	@Override
	public void run() {

		while(czynny) {
			
			
			
			
			  
			 try {
				Thread.sleep(pauza);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
