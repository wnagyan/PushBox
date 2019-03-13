package pushbox;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	private int width = 800;
	private int height = 600;
	private Game game;
	int x = Toolkit.getDefaultToolkit().getScreenSize().width;
	int y = Toolkit.getDefaultToolkit().getScreenSize().height;
	JPanel jp;
	public MainFrame() {
		// TODO Auto-generated constructor stub
		this.setTitle("推箱子");
		this.setBounds((x - width) / 2, (y - height) / 2, width, height);
		jp = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				ImageIcon img = new ImageIcon(MainFrame.class.getClassLoader().getResource("imgs/backgroundImg.png"));
				g.drawImage(img.getImage(), 0, 0, this);
			}
		};
		jp.setLayout(null);
		JButton jbstart = new JButton("开始游戏");
		jbstart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				startGame();
			}
		});
		JButton jbend = new JButton("结束游戏");
		jbend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(1);
			}
		});
		JButton jbhelp = new JButton("游戏帮助");
		jbhelp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "人物移动：方向键上下左右"+"\r\n后退一步：空格键");
			}
		});
		jbstart.setBounds(630, 350, 100, 30);
		jbend.setBounds(630, 400, 100, 30);
		jbhelp.setBounds(630, 450, 100, 30);
		jp.add(jbstart);
		jp.add(jbend);
		jp.add(jbhelp);
		this.add(jp);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}
	public void startGame() {
		// TODO Auto-generated method stub
		this.remove(jp);
		this.setLayout(null);
		JPanel jp1 = new JPanel(){
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon img = new ImageIcon(MainFrame.class.getClassLoader().getResource("imgs/toolImg.png"));
				g.drawImage(img.getImage(), 0, 0, this);
			}
		};
		jp1.setBounds(600, 0, 200, 600);
		this.add(jp1);
		jp1.setLayout(null);
		
		JButton jb = new JButton("后退一步");
		jb.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				game.back();
			}
		});
		jp1.add(jb);
		jb.setBounds(50, 200, 100, 30);
		
		JButton jb1 = new JButton("上一关");
		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(game.level > 1)
					game.Go(--game.level);
				game.repaint();
				game.requestFocus();
			}
		});
		jp1.add(jb1);
		jb1.setBounds(50, 250, 100, 30);
		
		JButton jb2 = new JButton("下一关");
		jb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(game.level < 50)
					game.Go(++game.level);
				game.repaint();
				game.requestFocus();
			}
		});
		jp1.add(jb2);
		jb2.setBounds(50, 300, 100, 30);
		
		JButton jb3 = new JButton("选关");
		jp1.add(jb3);
		jb3.setBounds(50, 350, 100, 30);
		
		JButton jb4 = new JButton("重新开始");
		jb4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				game.againGame(game.level);
				
			}
		});
		jp1.add(jb4);
		jb4.setBounds(50, 400, 100, 30);
		
		JButton jb5 = new JButton("退出游戏");
		jb5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(1);
			}
		});
		jp1.add(jb5);
		jb5.setBounds(50, 450, 100, 30);
		this.game = new Game(1);
		this.add(game);
		this.game.addKeyListener(new MykeListener());
		this.game.requestFocus();
		repaint();
	}
	class MykeListener extends KeyAdapter{
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			super.keyReleased(e);
			game.yidong(e);
		}
	}
}
