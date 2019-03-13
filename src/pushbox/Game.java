package pushbox;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.Stack;
import java.util.logging.Level;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Game extends JPanel {
	public int level;
	private LoadMap lm;
	private int ditu[][];
	private int manx, many;
	private int lastimg = 2;
	private Stack<Backup> myStack = new Stack<>();
	private Image[] imgs = {
		new ImageIcon(Game.class.getClassLoader().getResource("imgs/0.gif")).getImage(),
		new ImageIcon(Game.class.getClassLoader().getResource("imgs/1.gif")).getImage(),
		new ImageIcon(Game.class.getClassLoader().getResource("imgs/2.gif")).getImage(),
		new ImageIcon(Game.class.getClassLoader().getResource("imgs/3.gif")).getImage(),
		new ImageIcon(Game.class.getClassLoader().getResource("imgs/4.gif")).getImage(),
		new ImageIcon(Game.class.getClassLoader().getResource("imgs/5.gif")).getImage(),
		new ImageIcon(Game.class.getClassLoader().getResource("imgs/6.gif")).getImage(),
		new ImageIcon(Game.class.getClassLoader().getResource("imgs/7.gif")).getImage(),
		new ImageIcon(Game.class.getClassLoader().getResource("imgs/8.gif")).getImage(),
		new ImageIcon(Game.class.getClassLoader().getResource("imgs/9.gif")).getImage()
	};
	public Game(int level) {
		// TODO Auto-generated constructor stub
		this.level = level;
		this.lm = new LoadMap(this.level);
		this.ditu = this.lm.getMap();
		this.setBounds(0, 0, 600, 600);
		this.manx = this.lm.getManx();
		this.many = this.lm.getMany();
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		for(int i = 0; i < 20; i++){
			for(int j = 0; j < 20; j++){
				g.drawImage(imgs[ditu[i][j]], i*30, j*30, null);
			}
		}
	}
	public void yidong(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			Moveup();
			Pass();
			break;
		case KeyEvent.VK_DOWN:
			Movedown();
			Pass();
			break;
		case KeyEvent.VK_LEFT:
			Moveleft();
			Pass();
			break;
		case KeyEvent.VK_RIGHT:
			Moveright();
			Pass();
			break;
		default:
			break;
		}
	}
	private void Pass() {
		if(isPass()){
			this.level = level + 1;
			this.lm = new LoadMap(this.level);
			this.ditu = this.lm.getMap();
			this.manx = this.lm.getManx();
			this.many = this.lm.getMany();
			myStack.clear();
		}
	}
	private boolean isPass() {
		boolean flag = true;
		// TODO Auto-generated method stub
		for(int i = 0; i < 20; i++)
			for(int j = 0; j < 20; j++)
				if(ditu[i][j] == 3)
					flag = false;
		return flag;
	}
	private void Moveright() {
		if(this.ditu[manx + 1][many] == 2 || this.ditu[manx + 1][many] == 4){
			move();
			this.ditu[manx][many] = this.lastimg;
			this.lastimg = this.ditu[manx + 1][many];
			this.ditu[manx + 1][many] = 7;
			this.manx++;
			this.repaint();
		}
		else if (this.ditu[manx + 1][many] == 3 || this.ditu[manx + 1][many] == 9) {
			move();
			if(this.ditu[manx + 2][many] == 2){
				this.ditu[manx][many] = this.lastimg;
				if(this.ditu[manx + 1][many] == 3)
					this.lastimg = 2;
				else this.lastimg = 4;
				this.ditu[manx + 2][many] = 3;
				this.ditu[manx + 1][many] = 7;
				this.manx++;
				this.repaint();
			}
			else if(this.ditu[manx + 2][many] == 4){
				this.ditu[manx][many] = this.lastimg;
				if(this.ditu[manx + 1][many] == 3)
					this.lastimg = 2;
				else this.lastimg = 4;
				this.ditu[manx + 2][many] = 9;
				this.ditu[manx + 1][many] = 7;
				this.manx++;
				this.repaint();
			}
		}
	}
	private void Moveleft() {
		if(this.ditu[manx - 1][many] == 2 || this.ditu[manx - 1][many] == 4){
			move();
			this.ditu[manx][many] = this.lastimg;
			this.lastimg = this.ditu[manx - 1][many];
			this.ditu[manx - 1][many] = 6;
			this.manx--;
			this.repaint();
		}
		else if (this.ditu[manx - 1][many] == 3 || this.ditu[manx - 1][many] == 9) {
			move();
			if(this.ditu[manx - 2][many] == 2){
				this.ditu[manx][many] = this.lastimg;
				if(this.ditu[manx - 1][many] == 3)
					this.lastimg = 2;
				else this.lastimg = 4;
				this.ditu[manx - 2][many] = 3;
				this.ditu[manx - 1][many] = 6;
				this.manx--;
				this.repaint();
			}
			else if(this.ditu[manx - 2][many] == 4){
				this.ditu[manx][many] = this.lastimg;
				if(this.ditu[manx - 1][many] == 3)
					this.lastimg = 2;
				else this.lastimg = 4;
				this.ditu[manx - 2][many] = 9;
				this.ditu[manx - 1][many] = 6;
				this.manx--;
				this.repaint();
			}
		}
	}
	private void Movedown() {
		if(this.ditu[manx][many + 1] == 2 || this.ditu[manx][many + 1] == 4){
			move();
			this.ditu[manx][many] = this.lastimg;
			this.lastimg = this.ditu[manx][many + 1];
			this.ditu[manx][many + 1] = 5;
			this.many++;
			this.repaint();
		}
		else if (this.ditu[manx][many + 1] == 3 || this.ditu[manx][many + 1] == 9) {
			move();
			if(this.ditu[manx][many + 2] == 2){
				this.ditu[manx][many] = this.lastimg;
				if(this.ditu[manx][many + 1] == 3)
					this.lastimg = 2;
				else this.lastimg = 4;
				this.ditu[manx][many + 2] = 3;
				this.ditu[manx][many + 1] = 5;
				this.many++;
				this.repaint();
			}
			else if(this.ditu[manx][many + 2] == 4){
				this.ditu[manx][many] = this.lastimg;
				if(this.ditu[manx][many + 1] == 3)
					this.lastimg = 2;
				else this.lastimg = 4;
				this.ditu[manx][many + 2] = 9;
				this.ditu[manx][many + 1] = 5;
				this.many++;
				this.repaint();
			}
		}
	}
	private void Moveup() {
		if(this.ditu[manx][many - 1] == 2 || this.ditu[manx][many - 1] == 4){
			move();
			this.ditu[manx][many] = this.lastimg;
			this.lastimg = this.ditu[manx][many - 1];
			this.ditu[manx][many - 1] = 8;
			this.many--;
			this.repaint();
		}
		else if (this.ditu[manx][many - 1] == 3 || this.ditu[manx][many - 1] == 9) {
			move();
			if(this.ditu[manx][many - 2] == 2){
				this.ditu[manx][many] = this.lastimg;
				if(this.ditu[manx][many - 1] == 3)
					this.lastimg = 2;
				else this.lastimg = 4;
				this.ditu[manx][many - 2] = 3;
				this.ditu[manx][many - 1] = 8;
				this.many--;
				this.repaint();
			}
			else if(this.ditu[manx][many - 2] == 4){
				this.ditu[manx][many] = this.lastimg;
				if(this.ditu[manx][many - 1] == 3)
					this.lastimg = 2;
				else this.lastimg = 4;
				this.ditu[manx][many - 2] = 9;
				this.ditu[manx][many - 1] = 8;
				this.many--;
				this.repaint();
			}
		}
	}
	public void move(){
		int[][] temp = new int[20][20];
		for(int i = 0; i < 20; i++){
			for(int j = 0; j < 20; j++){
				temp[i][j] = this.ditu[i][j];
			}
		}
		Backup bp = new Backup(manx, many, temp, lastimg);
		myStack.push(bp);
	}
	public void Go(int level) {
		// TODO Auto-generated method stub
		this.lm = new LoadMap(level);
		this.ditu = this.lm.getMap();
		this.manx = this.lm.getManx();
		this.many = this.lm.getMany();
		myStack.clear();
		this.repaint();
		this.requestFocus();
	}
	public void againGame(int level) {
		// TODO Auto-generated method stub
		this.lm = new LoadMap(level);
		this.ditu = this.lm.getMap();
		this.manx = this.lm.getManx();
		this.many = this.lm.getMany();
		myStack.clear();
		this.repaint();
		this.requestFocus();
	}
	public void back() {
		// TODO Auto-generated method stub
		if(!myStack.empty()){
			this.manx = myStack.peek().getBackupmanx();
			this.many = myStack.peek().getBackupmany();
			this.ditu = myStack.peek().getBackupmap();
			this.lastimg = myStack.peek().getBackuplasting();
			myStack.pop();
		}
		this.repaint();
		this.requestFocus();
	}
}
