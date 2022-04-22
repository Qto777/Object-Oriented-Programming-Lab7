package pl.edu.pw.fizyka.java.lab7.mojeprogramy.Zadanie1;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class JButton1Runnable extends JButton implements Runnable {

	String[] tekst = { "TEN", "PRZYCISK", "MIGA", "PRZEZ", "20", "SEKUND" };
	int pauza = 1000;
	boolean czynny = true;

	JButton1Runnable() {
		super();
	}

	JButton1Runnable(String[] arg1, int arg2) {
		tekst = arg1;
		pauza = arg2;
	}

	@Override
	public void run() {

		int i = 0;

		while (czynny) {

			if (i < tekst.length - 1)
				i++;
			else
				i = 0;

			setText(tekst[i]);
			setBackground(new Color((float)Math.random(),(float)Math.random(),(float)Math.random()));

			try {
				Thread.sleep(pauza);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

/*	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame f = new JFrame();
				f.setLayout(new GridLayout(2, 1));
				f.setSize(600, 400);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				JButton1Runnable b1 = new JButton1Runnable();
				f.add(b1);

				String[] innyTekst = { "A", "ten guzik", "miga", "nawet", "szybciej" };
				
				
				JButton1Runnable b2 = new JButton1Runnable(innyTekst, 100);
				f.add(b2);

				ExecutorService exec = Executors.newFixedThreadPool(2);
				Executors.newSingleThreadExecutor();

				exec.execute(b1);
				exec.execute(b2);

				exec.shutdown();

				f.setVisible(true);
			}
		});

	}*/

}
