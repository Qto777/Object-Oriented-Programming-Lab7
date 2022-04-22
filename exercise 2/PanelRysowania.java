package pl.edu.pw.fizyka.java.lab7.zadanie2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

class PanelRysowania extends JPanel {

	private static final long serialVersionUID = 1L;
	List<Prostokat> prostakaty = new ArrayList<Prostokat>();


	public PanelRysowania() {
       // domyslny konstruktor
	}
	
	public void dodajLosowyProstokat(){
		Random r = new Random();
		
		Prostokat p = new Prostokat();
		p.setX(r.nextInt(550));
		p.setY(r.nextInt(550));
		p.setWidth(r.nextInt(80));
		p.setHeight(r.nextInt(80));
		p.setColor(new Color(r.nextInt(255), r.nextInt(255),
				r.nextInt(255), r.nextInt(255)));

		prostakaty.add(p);	
		
	}
	
	public int getRandomInt(int min, int max) {
	    min = (int) Math.ceil(min);
	    max = (int) Math.floor(max);
	    return (int) (Math.floor(Math.random() * (max - min + 1)) + min);
	}
	
	public void dodajProstokat(int x, int y, int width, int height, Color c){
		Prostokat p = new Prostokat();
		p.setX(x);
		p.setY(y);
		p.setWidth(width);
		p.setHeight(height);
		p.setColor(c);
		
		prostakaty.add(p);			
		
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (Prostokat pr : prostakaty) {
			pr.paint(g);
			int r = getRandomInt(0,10);
		
			pr.setvX(r);
			pr.setvY(r);
			
			int x = pr.getX();
			int y = pr.getvY();
		
			x = x + pr.getvX();
			y = y + pr.getvY();
			
		}
		
		 try
	      {
	        Thread.sleep(100);
	      }catch(Exception e)
	      {
	    	  
	      }
	      

	}
	
	public Dimension getPreferredSize() {
		return new Dimension(600, 600);
	}
}
