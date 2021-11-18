import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
public class TictoeGUI extends JFrame 
{
	char turn='X';
	JButton b[] = new JButton[9];
	String mark;
	public TictoeGUI()
	{
		buttonInitialize();
		this.setSize(500,400);
		this.setLayout(new GridLayout(3,3));
		this.setResizable(false);
		this.setTitle("WELCOME TO TIC TAC TOE");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(350,100,500,500);	//(x coordinate,y coordinate, int width, int height)
		ImageIcon logo= new ImageIcon("src/mylogo.png"); 	//create an imageicon
		this.setIconImage(logo.getImage());		// change icon of frame
		
	}
	public void buttonInitialize()
	{
		
		for(int a=0;a<9;a++)
		{
			b[a]= new JButton();
			b[a].setText("*");
			b[a].setBackground(Color.WHITE);
			b[a].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e)
				{
					JButton buttonClicked= (JButton) e.getSource();
					buttonClicked.setText(String.valueOf(turn));
					if(turn=='X')
					{	
						turn='O';
						buttonClicked.setBackground(new Color(123,100,180)); //RGB customized color
					}
					else {
						turn='X';
						buttonClicked.setBackground(Color.CYAN);
					}
					showwinner();
				}
				
			});
			
			add(b[a]);
			 
					
		}
	}
	public boolean Checkingwinner()
	{
		if(checkrows()==true || checkcol()==true || checkdiagonals()==true)
			return true;
		else
			return false;
	}
	public boolean checkrows()
	{
		int i=0;
		for(int j=0;j<3;j++)
		{
			if(b[i].getText().equals(b[i+1].getText()) && b[i].getText().equals(b[i+2].getText()) && b[i].getText().charAt(0)!='*')
			{
				return true;
			}
			i+=3;
		}
		return false;
	}
	public boolean checkcol()
	{
		int i=0;
		for(int j=0;j<3;j++)
		{
			if(b[i].getText().equals(b[i+3].getText()) && b[i].getText().equals(b[i+6].getText()) && b[i].getText().charAt(0)!='*')
			{
				return true;
			}
			i++;
		}
		return false;
	}
	public boolean checkdiagonals()
	{
		
		if(b[0].getText().equals(b[4].getText()) && b[0].getText().equals(b[8].getText()) && b[0].getText().charAt(0)!='*')
		{
			return true;
		}
		else if (b[2].getText().equals(b[4].getText()) && b[2].getText().equals(b[6].getText()) && b[2].getText().charAt(0)!='*')
		{
			return true;
		}
		else 
			return false;
	}
	public void showwinner()
	{
		if(Checkingwinner()==true)
		{
			if(turn=='X')
				turn='O';
			else
				turn='X';
			JOptionPane pane = new JOptionPane();
			int dialogResult= JOptionPane.showConfirmDialog(pane, "Game Over. "+turn+ " wins Would u like to play again","Game Over",
					JOptionPane.YES_NO_OPTION);
			if(dialogResult==JOptionPane.YES_OPTION) resetthebuttons();
			else
				System.exit(0);
		}
		else if(checkDraw()==true)
		{
			JOptionPane pane = new JOptionPane();
			int dialogResult= JOptionPane.showConfirmDialog(pane, "Draw. Play again?","Game Over",JOptionPane.YES_NO_OPTION) ;
			if(dialogResult==JOptionPane.YES_OPTION) resetthebuttons();
			else System.exit(0);
		}
	}
	private void resetthebuttons()
	{
			for(int i=0;i<9;i++)
			{
				turn='X';
				b[i].setText("*");
				b[i].setBackground(Color.white);
				
			}
	}
	public boolean checkDraw()
	{
		boolean full=true;
		for(int i=0;i<9;i++)
		{
			if(b[i].getText().charAt(0)=='*')
			{
				full=false;
			}
		}
		return full;
	}
}