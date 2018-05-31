import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class bg extends GameObject{
	BufferedImage b;
	public bg(){
		b = MarioWindow.getImage("1.png");
	}
	public void paint(Graphics2D g){
		g.drawImage(b,0,0,null);
	}
}