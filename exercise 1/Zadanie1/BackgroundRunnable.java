package pl.edu.pw.fizyka.java.lab7.mojeprogramy.Zadanie1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.GridLayout;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class BackgroundRunnable extends JPanel implements Runnable {

	int pauza = 1000;
	boolean czynny = true;
	
	public BackgroundRunnable() {
		super();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame f = new JFrame();
				f.setLayout(new GridLayout(1,1));
				f.setSize(600, 400);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				BackgroundRunnable b1 = new BackgroundRunnable();
				f.add(b1);

				ExecutorService exec = Executors.newFixedThreadPool(2);
				//Executors.newSingleThreadExecutor();

				exec.execute(b1);
				exec.shutdown();

				f.setVisible(true);
			}
		});
	}

	@Override
	public void run() {
		while (czynny) {
			
			
			//GradientPaint gp = new GradientPaint(0, 0, new Color((int)Math.random()), 0, 400, new Color((int)Math.random()));
			setBackground(new Color((float)Math.random(),(float)Math.random(),(float)Math.random()));
			//setBackground(gp);
			
			try {
				Thread.sleep(pauza);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
