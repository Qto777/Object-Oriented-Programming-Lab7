package pl.edu.pw.fizyka.java.lab7.mojeprogramy.Zadanie1;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.*;
import static java.util.concurrent.TimeUnit.*;

public class DynamicFrame extends JFrame implements Runnable {

	boolean czynny = true;
	
	@Override
	public void run() {
		
		while(czynny) {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
			
		}

	}

	public DynamicFrame() {
		
		
		this.setLayout(new GridLayout(3, 1));
		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JSlider1Runnable s1 = new JSlider1Runnable();
		this.add(s1);

		String[] tekst2 = { "Ten", "opis", "tez", "miga" };
		
		
		JLabel1Runnable l1 = new JLabel1Runnable(tekst2, 100);
		this.add(l1);

		String[] tekst1 = { "Ten",  "guzik", "sobie", "miga", "szybko" };
		
		
		JButton1Runnable b1 = new JButton1Runnable(tekst1, 100);
		this.add(b1);

		ExecutorService exec = Executors.newFixedThreadPool(2);
		Executors.newSingleThreadExecutor();

		exec.execute(b1);
		exec.execute(l1);
		exec.execute(s1);

		exec.shutdown();
	
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
		
		@Override
		public void run() {
			DynamicFrame frame = new DynamicFrame();
			frame.setVisible(true);
		
		
			final ScheduledExecutorService scheduler = Executors
				.newScheduledThreadPool(3);
		
			final ScheduledFuture<?> sc1 = scheduler.scheduleAtFixedRate(
				frame, 1000, 50, MILLISECONDS);
		
			scheduler.schedule(frame, 20, SECONDS);
		
			scheduler.schedule(new Runnable() {
				@Override
				public void run() {
					sc1.cancel(true);
					frame.setVisible(false);
					}
				}, 20, SECONDS);
		
			}

		});
		
	}
}
