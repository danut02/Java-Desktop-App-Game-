import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
 
import java.awt.Rectangle;



public class grafica extends JPanel {
	   public int dimW=20,dimH=20, i,j,X=50,Y=0;

	
       public void paintComponent(Graphics g){
		ImageIcon img1,img2;
		Graphics2D g2 = (Graphics2D) g;
		//img1 = new ImageIcon("img1.png");
        for(i=1;i<50;i++)
		    {
		g2.drawRect(X+i, Y+i, dimW *10 , dimH *10  );
		if(i%4==0)
		g2.setColor(Color.GREEN);
		else
		if(i%7==0) g2.setColor(Color.RED);
		else
		if(i%5==0)
		g2.setColor(Color.ORANGE);
		else
		if(i%6==0)
		g2.setColor(Color.BLUE);
		g2.fillRect(100, 50, 150, 150);
	}
		g2.dispose();

		
          
       }
     
	
	   
 

}