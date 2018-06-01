import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;

public class Lane extends GameObject{
	LinkedQueue d = new LinkedQueue();
	LinkedQueue f = new LinkedQueue();
	LinkedQueue j = new LinkedQueue();
	LinkedQueue k = new LinkedQueue();

	String line = null;
	int[][] whole = new int[300][5];
	int line_number=0;

	Note current = null;

	public Lane(){
		try{
			BufferedReader bufferedReader = new BufferedReader(new FileReader("file.txt"));

			String[] per_line=new String[5];
	        while((line = bufferedReader.readLine()) != null) {
	        	per_line = line.split(" ");
	            for(int i=0;i<4;i++){
	            	whole[line_number][i] = Integer.parseInt(per_line[i]);
	            }
	            line_number+=1;
	            //System.out.println(line);
	        }

	        bufferedReader.close();
	    }
	    catch(FileNotFoundException ex) {}
        catch(IOException ex) {}
        for(int i=0;i<line_number;i++){
        	for(int z=0;z<4;z++){
        		if(z==0&&whole[i][z]==1){
        			Note n = new Note(77,-50-50*i);
					d.enqueue(n);
        		}
        		if(z==1&&whole[i][z]==1){
        			Note n = new Note(127,-50-50*i);
					f.enqueue(n);
        		}
        		if(z==2&&whole[i][z]==1){
        			Note n = new Note(177,-50-50*i);
					j.enqueue(n);
        		}
        		if(z==3&&whole[i][z]==1){
        			Note n = new Note(227,-50-50*i);
					k.enqueue(n);
        		}
        	}
        }
	}
	public void paint(Graphics2D g){
		d.visualizeQueue(g);
		f.visualizeQueue(g);
		j.visualizeQueue(g);
		k.visualizeQueue(g);
	}
	public void run(){
		while(true){
			MarioWindow.delay(5);
			d.fall();
			f.fall();
			j.fall();
			k.fall();
		}
	}
	public void keyPressed(String key) {
		if(key.equals("D")){
			current = d.peek();
			if(current!=null&&current.yplace>=450&&current.yplace<=600){
				d.dequeue();
			}
		}
		if(key.equals("F")){
			current = f.peek();
			if(current!=null&&current.yplace>=450&&current.yplace<=600){
				f.dequeue();
			}
		}
		if(key.equals("J")){
			current = j.peek();
			if(current!=null&&current.yplace>=450&&current.yplace<=600){
				j.dequeue();
			}
		}
		if(key.equals("K")){
			current = k.peek();
			if(current!=null&&current.yplace>=450&&current.yplace<=600){
				k.dequeue();
			}
		}
    }
}