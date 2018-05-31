public class game{
	public static void main(String[] args){
		Lane l = new Lane();
		bg b = new bg();
		final MarioWindow m = new MarioWindow();
		m.add(b);
		m.add(l);
		(new Thread(){
			public void run(){
				m.startGame();
			}
		}).start();
		m.delay(10000);
	}
}