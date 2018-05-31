import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Note extends GameObject{
	int yplace;
	int lane;
	public Note(int x, int y){
		yplace = y;
		lane = x;
	}
}