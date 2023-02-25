import java.util.Scanner;
import javax.swing.border.Border;
import java.util.Timer;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.geom.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.stream.ImageInputStream;
import javax.lang.model.util.ElementScanner6;
import javax.sound.sampled.spi.AudioFileReader;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JComponent;
import javax.sound.sampled.*;



public class App extends JFrame implements KeyListener
{
	public String text;
	JLabel label2= new JLabel();
    public JFrame frame2 = new JFrame();
	JButton button = new JButton();
	JLabel label3= new JLabel();
	JPanel panou = new JPanel ();
	grafica graphics = new grafica();
	JFrame frame3 = new JFrame();
	ImageIcon img1,img2,icon_menu,icon_game;
	public int X;
	public int Y;
    public int WIDTH = 1920;
	public int HEIGHT = 1080;
	public int lives = 5;
    graphics2 grafica2 = new graphics2();
    public int cnt_esc=0;
    public int level=1;
	public int ok=0;
	JFrame frame = new JFrame();
	void music1() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		File file = new File ("C:\\muzica date\\java1\\start.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();


	}
	void music2() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		File file = new File ("C:\\muzica date\\java1\\joaca.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
        


	}

	void music_die() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		File file = new File ("C:\\muzica date\\java1\\die.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		
	}
	void music_collision() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		File file = new File ("C:\\muzica date\\java1\\collision.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		
	}
	void music_finish(int ok) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		File file = new File ("C:\\muzica date\\java1\\finish.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		if(ok==1)
		clip.start();
		else
		clip.stop();
	}
	void music_esc() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		
		if(ok==0){
		ok = 1;
		File file = new File ("C:\\muzica date\\java1\\esc.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);  
		clip.start();}
	}
	void music_esc1() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		
		File file = new File ("C:\\muzica date\\java1\\esc.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);  
		clip.start();
	}
	
	


	
      public App() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
		 
		
		music_esc1();

	    String menu = "\n \n \n Some Hints : \n Use 'W' or 🡹 to move up, use 'S' or 🢃 to move down, use 'D' or 🢂 " +
		" to move right, use 'A' or 🢀 to move left, use 'R' to respawn, use 'SPACEBAR' to jump, use 'ESC' to pause the game, " + 
		" press 'ESC' twice to exit the game. \n Your purpose is to stay in your lane and stay away of the corners and spikes, else " +
		 " you will lose one life (1 HP), if you lose all your 5 lives you die.";
		JLabel welcome = new JLabel("WELCOME");
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setFont(new Font("",Font.TYPE1_FONT,20));
		JLabel label = new JLabel();
		label.setText("<html>" + menu.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
	    
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    img1 = new ImageIcon("img1.png");
		img2= new ImageIcon ("img2.png");
	//	icon_menu = new ImageIcon("menu.png");
		icon_game = new ImageIcon("game.png");
	
		
		frame.setSize(WIDTH,HEIGHT);
	    frame.setIconImage(icon_game.getImage());
		frame.setTitle("Menu");
		frame2.setIconImage(icon_game.getImage());
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panou.setSize(50, 50);
		panou.setBackground(Color.ORANGE);
		frame.setVisible(true);
	    label.setBounds(80,300,1220,450);
	    label2.setIcon(new ImageIcon("C:\\muzica date\\design java\\img1.png"));
		label3.setIcon(new ImageIcon("C:\\muzica date\\design java\\cloud1.jpg"));
	    
		JButton buton2 = new JButton ();
		JButton buton3 = new JButton ();
		JButton buton4 = new JButton ();
		buton2.setBackground(Color.RED);
        buton3.setBackground(Color.YELLOW);
		buton4.setBackground(Color.BLUE);
        
		buton2.setBounds(100,200,240,100);
		buton3.setBounds(500,200,240,100);
		buton4.setBounds (900,200,240,100);
		button.setBounds(670,200,200,60);
		buton2.setText("Windowed  (720 x 480) ");
		buton3.setText("HD ( 1280 x 720 )");
		buton4.setText("Full HD ( 1920 x 1080 )");
		button.setText("Play!");
		button.setBackground(Color.GREEN);
		button.add(label);
	    
		button.addActionListener(e -> button.setBackground(Color.RED));
		button.addActionListener(e -> button.setVisible(false));
		button.addActionListener(e -> label.setText("CHOSE YOUR RESOLUTION "));
		button.addActionListener(e-> label.setVerticalAlignment(SwingConstants.NORTH));
		button.addActionListener(e-> welcome.setVisible(false));
		button.addActionListener(e -> label.add(buton2));
		button.addActionListener(e -> label.add(buton3));
		button.addActionListener(e -> label.add(buton4));
		button.addActionListener(e -> buton2.setVisible(true));
		
		
		button.addActionListener(e -> {
			try {
				music1();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		buton2.addActionListener(e -> frame2.add(label3));
		buton3.addActionListener(e -> frame2.add(label3));
		buton4.addActionListener(e -> frame2.add(label3));
		buton2.addActionListener(e -> {
			try {
				music2();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		buton3.addActionListener(e -> {
			try {
				music2();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		buton4.addActionListener(e -> {
			try {
				music2();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	
		

		

        frame2.addKeyListener(this);
		buton2.addActionListener(e -> frame2.setVisible(true) );
		buton2.addActionListener(e -> frame2.setSize(WIDTH, HEIGHT) );
		buton2.addActionListener(e -> WIDTH = 720 );
		buton2.addActionListener(e -> HEIGHT = 480 );
	
		buton3.addActionListener(e -> frame2.setVisible(true) );
		buton3.addActionListener(e -> frame2.setSize(WIDTH, HEIGHT) );
		buton3.addActionListener(e -> WIDTH = 1280 );
		buton3.addActionListener(e -> HEIGHT = 720 );

		buton4.addActionListener(e -> frame2.setVisible(true));
		buton4.addActionListener(e -> frame2.setSize(WIDTH, HEIGHT) );
		buton4.addActionListener(e -> WIDTH = 1920 );
		buton4.addActionListener(e -> HEIGHT = 1080 );
		
		
		
		
		
		
        frame2.getContentPane().setBackground(Color.MAGENTA);
		
	

		
		frame.getContentPane().setBackground(Color.CYAN);
		frame.add(button);
	
		frame.add(label);
		label.setHorizontalAlignment(JLabel.CENTER);
		label3.setSize(WIDTH, HEIGHT);
		
		label3.setVisible(true);
	
		graphics.setVisible(true);
	    frame.add(welcome);
		frame2.add(graphics);
		frame2.setTitle("HP : 5");
		
    
		
	 }
	 
			



	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		App app1 = new App();
		
		
		
		
	}
	
	

	@Override
	public void keyPressed(KeyEvent e) {
     

		if(graphics.getX()>=834 && graphics.getX()<=852 && graphics.getY()>=130 && graphics.getY()<=185){
		   try {
			music_esc();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frame2.setTitle("Waiting...");
		try{
			Thread.sleep(800);
		  }
		  catch(InterruptedException b){

		  }
		  frame2.setTitle("Waiting..");
		  try{
			Thread.sleep(1000);
		  }
		  catch(InterruptedException b){

		  }frame2.setTitle("Waiting.");
		}
	
		

	 if(graphics.getX()==913 && graphics.getY()==528)
		frame2.setTitle("Press 'D' ");
	if(graphics.getY()==528 && graphics.getX()==997)
		  frame2.setTitle("Press 'SPACEBAR' "); 
 

		if(graphics.getX()>=834 && graphics.getX()<=852 && graphics.getY()==147)
		{
			
		   try{
             Thread.sleep(2000);
		   }
		   catch(InterruptedException b){

		   }
		   graphics.setLocation(913, 528);
		}


		if( graphics.getY()>=550|| graphics.getX() <-50 || graphics.getX()>=1242 || graphics.getY()< 0 || graphics.getX() == 30 && 
	graphics.getY() == 0  ||  graphics.getX() == 33 && graphics.getY() %3 == 0 && graphics.getY() <=33 ||  graphics.getX() == 18 &&
	 graphics.getY() %3 == 0 && graphics.getY() >=33 && graphics.getY() <=510 || graphics.getX() >= 225 && graphics.getX() <= 291
	&&  graphics.getY() == 507  || graphics.getX() == 417  && graphics.getY() >=0 && graphics.getY() <=340 
	|| graphics.getX() == 456  && graphics.getY() >=33 && graphics.getY() <=340 || graphics.getX() == 435 && graphics.getY()>=501
	&& graphics.getY() <= 546 || graphics.getX()>=480 && graphics.getX()<=744 && graphics.getY()==15 || graphics.getY()>=87 && 
	graphics.getY()<=339 && graphics.getX()==831 || graphics.getY() >=483 && graphics.getY()<=546 && graphics.getX()==885 || 
	graphics.getY()<=117 && graphics.getX()==858
	 ){
			
			graphics.setLocation(getX(),getY()); 
			lives--;

			try {
				music_collision();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(lives<0)      
		lives=0;
		text = Integer.toString(lives);
		
        frame2.setTitle("HP : "+text);	
		}
		
			if(lives==0){
			frame2.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
			graphics.setVisible(false);
			frame2.setTitle("Game Over");
			label3.setText("                               Game Over");
			label3.setHorizontalTextPosition(label3.HORIZONTAL);
			label3.setFont(new Font(" ",Font.CENTER_BASELINE,40));
			label3.setBackground(Color.GREEN);
		    try {
				music_die();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}    
		
			
        
			}
		
		
		
		
		// TODO Auto-generated method stub
	
		switch(e.getKeyCode()){
            
			case KeyEvent.VK_ESCAPE :
			graphics.setVisible(false);
			label3.setVisible(false);
		    cnt_esc++;
			JLabel label_esc = new JLabel();
		    label_esc.setText("Are you sure you want to quit?  Press 'ESC' again to do it.");
			label_esc.setVerticalTextPosition(label_esc.CENTER);
			label_esc.setFont(new Font(" ",Font.ITALIC,50));
		
			if(cnt_esc==1){
	        frame2.add(label_esc);
	
			}
			
			if(cnt_esc==2){
		       frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
			   frame2.setVisible(false);
			   frame.setVisible(false);
			  }
			break;
			case KeyEvent.VK_UP :
			graphics.setLocation(graphics.getX(),graphics.getY()-3);
			break;

			case KeyEvent.VK_DOWN :
			graphics.setLocation(graphics.getX(),graphics.getY()+3);
			break;
			case KeyEvent.VK_LEFT :
			graphics.setLocation(graphics.getX()-3,graphics.getY());
		   break;

		   case KeyEvent.VK_RIGHT :
		   graphics.setLocation(graphics.getX()+3,graphics.getY());
		   break; }
		}
		

	  
		
	

	@Override
	public void keyTyped(KeyEvent e) {



		
          if(graphics.getX()>=913 && graphics.getX()<=994 &&  graphics.getY()==528)

		switch(e.getKeyChar()){
               case 'd' :   graphics.setLocation(graphics.getX()+3,graphics.getY());
			   break;

		}
		else  
		if(graphics.getY()==528 && graphics.getX()==997 || graphics.getX()==1042 && graphics.getY()==507  )
		switch(e.getKeyChar()){
			   case ' ' : graphics.setLocation(graphics.getX()+45, graphics.getY()-21); 
			   break;
		}
		else 
		if(graphics.getX()==1087 && graphics.getY()==486 )
		switch(e.getKeyChar()){
			 case ' ' : graphics.setLocation(graphics.getX()+39,graphics.getY()-48);
			 break;
		}
		else  
		if(graphics.getX()==1126 && graphics.getY()==438 )
		switch(e.getKeyChar()){
         
			case ' ' : graphics.setLocation(1174, 405);
			break;

		}
		else 
		if(graphics.getX()==1174 && graphics.getY()==405)
		switch(e.getKeyChar()){
		   case ' ' : graphics.setLocation(1234, 372);
		   break;
		}

		else 

		
		   switch(e.getKeyChar()){
			   
		
		
			   case 'r':
			  graphics.setLocation(10, 20);
		        case 'a':
			   
				 graphics.setLocation(graphics.getX()-3,graphics.getY());
				    break;
			case 'w' :  graphics.setLocation(graphics.getX(),graphics.getY()-3);
			          break;
			case 's' : 
			  graphics.setLocation(graphics.getX(),graphics.getY()+3);
		        	break;
			case 'd' :
			       
			
				  graphics.setLocation(graphics.getX()+3,graphics.getY());
				  break;
			  
			  
			
			
		   }

		   if(label2.getX()==-201 || label2.getX()==-200 ||label2.getX()==-197 || label2.getX()==-198 ){
		   switch(e.getKeyChar()){
			       case 'e' : label2.setLocation(label2.getX()-10,label2.getY()-10);
			          break;

		   }
		}


	}



	@Override
	public void keyReleased(KeyEvent e) {
		if(graphics.getX()==219 && graphics.getY()>=510 && graphics.getY()<=546){
		try {
			music_esc1();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}


	
		if(graphics.getX()==1234 && graphics.getY()==372)
		{

			if(cnt_esc==0)
			try {
				music_finish(1);
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else
		
			try {
				music_finish(0);
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			

			try{
				Thread.sleep(2000);
			  }
			  catch(InterruptedException b){
   
			  }
		   graphics.setVisible(false);
		   label3.setText("                           You won!");
		   label3.setHorizontalTextPosition(label3.HORIZONTAL);
		   label3.setFont(new Font(" ",Font.CENTER_BASELINE,40));
		   frame2.setTitle("Congrats, you won!");
 
		 
		  
		}
	

	
		switch(e.getKeyChar()){

		
			case ' ' : label2.setLocation(0,0);
			   break;
		}
		   System.out.println("apesi tasta : " + e.getKeyChar() + " cu codul : " + e.getKeyCode());
		   System.out.println("Coordonate: ("+ graphics.getX() + ", " + graphics.getY() + ")");
	
}
			}
	

			


