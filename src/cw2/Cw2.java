package cw2;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
//import java.util.ArrayList;
import javax.swing.*;
import javax.swing.text.JTextComponent;

/**
 *
 * @author MrGunerhanal
 */

interface DieIntf //Interface DieIntf has 4 methods 
{
    ImageIcon getDieImage();
    ImageIcon setImage();
    int getValue();
    void setValue(int v);
}

class Die implements DieIntf //class Die Includes methods to gelp Dice class get and set images and values
{
    private int imageNumber;
    ImageIcon faceValue;    
    
    @Override
    public ImageIcon getDieImage()
    {
        return faceValue;
    }

    @Override
    public ImageIcon setImage()
    {
        int pic = imageNumber;
        faceValue = new ImageIcon(this.getClass().getResource(pic + ".png"));//gets the number image and finds the image file in the directory
        return faceValue;
    }
    @Override
        public void setValue(int v)
    {
        this.imageNumber = v;
    }
    @Override
    public int getValue()
    {
        return imageNumber;
    }
}
class Dice extends Die{
    
    Die d1 = new Die(); //creating variables that will get functions from Die Class
    Die d2 = new Die();
    Die d3 = new Die();
    Die d4 = new Die();
    Die d5 = new Die();
    

    
    int humanScore; //Will hold the score of the player
    int computerScore; //Will hold the score of the computer
    int humanRoll; //will hold the number of rolls for human 
    int computerRoll; //will hold the number of rolls for computer 
    int clickCounter = 0; //this counts the number of presses to throw button
    int usersEnter; // variable will hold the input from user
    int level;//will hold value for tie button
    
     int Dice[];
         public Dice() {
        Dice = new int[5]; //array Dice will hold faces of dice 
    }
    
    JCheckBox chk1 = new JCheckBox(); //this line creates checkbox and assigns it to name 'die1'
    JCheckBox chk2 = new JCheckBox();
    JCheckBox chk3 = new JCheckBox();
    JCheckBox chk4 = new JCheckBox();
    JCheckBox chk5 = new JCheckBox();
    
    JLabel humanMain = new JLabel(); //this line creates label that will hold text in swing
    JLabel computerMain = new JLabel();
    JLabel humanLabel = new JLabel();
    JLabel computerLabel = new JLabel();
    

    String computerName = "Computer";
    String humanName = "Human";
    
         JFrame frame = new JFrame("Dice Game"); //my main frame is created here

         JPanel humanpanel = new JPanel(); //i have 5 different panels which will hold buttons, images and labels
         JPanel computerpanel = new JPanel();
         JPanel menupanel = new JPanel();
         JPanel stats = new JPanel();
         JPanel checkBoxes = new JPanel();
         JPanel tiePanel = new JPanel();
         
         ImageIcon humanOne = new ImageIcon(this.getClass().getResource("empty.png"));//this line creates imageicon
         ImageIcon humanTwo = new ImageIcon(this.getClass().getResource("empty.png"));
         ImageIcon humanThree = new ImageIcon(this.getClass().getResource("empty.png"));
         ImageIcon humanFour = new ImageIcon(this.getClass().getResource("empty.png"));
         ImageIcon humanFive = new ImageIcon(this.getClass().getResource("empty.png"));
         
         ImageIcon computerOne = new ImageIcon(this.getClass().getResource("empty.png"));
         ImageIcon computerTwo = new ImageIcon(this.getClass().getResource("empty.png"));
         ImageIcon computerThree = new ImageIcon(this.getClass().getResource("empty.png"));
         ImageIcon computerFour = new ImageIcon(this.getClass().getResource("empty.png"));
         ImageIcon computerFive = new ImageIcon(this.getClass().getResource("empty.png"));

         JLabel humanPic1 = new JLabel(humanOne); //this lines assigned images of human dice roll to jlabel 
         JLabel humanPic2 = new JLabel(humanTwo);
         JLabel humanPic3 = new JLabel(humanThree);
         JLabel humanPic4 = new JLabel(humanFour);
         JLabel humanPic5 = new JLabel(humanFive);
                
         JLabel computerPic1 = new JLabel(computerOne);//this lines also assiges my images of computer dice roll to jlables
         JLabel computerPic2 = new JLabel(computerTwo);
         JLabel computerPic3 = new JLabel(computerThree);
         JLabel computerPic4 = new JLabel(computerFour);
         JLabel computerPic5 = new JLabel(computerFive);
         
         JButton throwButton = new JButton("Throw");//this line creates buttons
         JButton scoreButton = new JButton("Score");
         JButton newGameButton = new JButton("New Game");
         JButton saveButton = new JButton("Save Game");
         JButton loadButton = new JButton("Load Game");
         
         public void theStartWindow() //this line is called in my main and willl run a simple frame that will have new game button
         {
    
             JPanel firstPanel = new JPanel();
             JButton startButton = new JButton("Start The Game");
             
             frame.setLayout(new FlowLayout());
             frame.setVisible(true);
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

             firstPanel.add(startButton);
             frame.add(firstPanel);
             frame.pack();
             
             startButton.addActionListener(new startGame()); //the button will trigger system to run startGame class 
        }
                 class startGame implements ActionListener{ //this class will direct system to theWindow() method of Dice Class
                    public void actionPerformed (ActionEvent e)
                    {
                        Dice boss = new Dice();
                        boss.theWindow();
                    }
                }

        public void theWindow() {//the main window and gui listed below
            
            usersEnter = Integer.parseInt(JOptionPane.showInputDialog("Set a Final Score"));//this will get users input for score
            
            frame.setLayout(new FlowLayout());
            frame.setVisible(true);
            frame.setSize(1000, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//this line will terminate the program
            
            humanpanel.setLayout(new BoxLayout(humanpanel,BoxLayout.X_AXIS));//this line makes sure the panels are listed as x axis
            computerpanel.setLayout(new BoxLayout(computerpanel,BoxLayout.X_AXIS));
            menupanel.setLayout(new BoxLayout(menupanel,BoxLayout.X_AXIS));
            stats.setLayout(new BoxLayout(stats,BoxLayout.Y_AXIS));
            checkBoxes.setLayout(new BoxLayout(checkBoxes,BoxLayout.X_AXIS));
            tiePanel.setLayout(new BoxLayout(tiePanel,BoxLayout.X_AXIS));
                
                
            JLabel humanlabel = new JLabel("Human ");
            JLabel computerlabel = new JLabel("Computer ");
                
            humanpanel.add(humanlabel);
            humanpanel.add(humanPic1);
            humanpanel.add(humanPic2);
            humanpanel.add(humanPic3);
            humanpanel.add(humanPic4);
            humanpanel.add(humanPic5);
                
            computerpanel.add(computerlabel);
            computerpanel.add(computerPic1);
            computerpanel.add(computerPic2);
            computerpanel.add(computerPic3);
            computerpanel.add(computerPic4);
            computerpanel.add(computerPic5);
                
            menupanel.add(throwButton);
            menupanel.add(scoreButton);
            menupanel.add(newGameButton);
            menupanel.add(saveButton);
            menupanel.add(loadButton);
                
            stats.add(humanMain);
            stats.add(computerMain);
            stats.add(humanLabel);
            stats.add(computerLabel);
            
            checkBoxes.add(chk1);
            checkBoxes.add(chk2);
            checkBoxes.add(chk3);
            checkBoxes.add(chk4);
            checkBoxes.add(chk5);
               
               
            frame.add(humanpanel);
            frame.add(computerpanel);
            frame.add(menupanel);
            frame.add(stats);
            frame.add(checkBoxes);
                

            newGameButton.addActionListener(new restartGame());
            //saveButton.addActionListener(new saveGame());
            //loadButton.addActionListener(new loadGame());
            throwButton.addActionListener( new ActionListener()//throw button will trigger the following lines of code
            {
                @Override
                public void actionPerformed( ActionEvent e){ 
                    
                    Roll();    
                    humanPic1.setIcon(d1.faceValue);//these lines will assign images taken from directory into imageicons
                    humanPic2.setIcon(d2.faceValue);
                    humanPic3.setIcon(d3.faceValue);
                    humanPic4.setIcon(d4.faceValue);
                    humanPic5.setIcon(d5.faceValue);
                    humanRoll = Dice[0] + Dice[1] + Dice[2] + Dice[3] + Dice[4];
                    humanMain.setText("Human Rolls " + humanRoll + "!");
                 
                    Roll(); 
                    computerPic1.setIcon(d1.faceValue);//these lines will assign images taken from directory into imageicons
                    computerPic2.setIcon(d2.faceValue);
                    computerPic3.setIcon(d3.faceValue);
                    computerPic4.setIcon(d4.faceValue);
                    computerPic5.setIcon(d5.faceValue);
                    computerRoll = Dice[0] + Dice[1] + Dice[2] + Dice[3] + Dice[4];
                    computerMain.setText("Computer Rolls " + computerRoll + "!");
                    
                    if(clickCounter == 0 || clickCounter == 6){
                    chk1.setVisible(false);
                    chk2.setVisible(false);
                    chk3.setVisible(false);
                    chk4.setVisible(false);
                    chk5.setVisible(false);
                    }
                    if(clickCounter == 2 || clickCounter == 4){
                    chk1.setVisible(true);
                    chk2.setVisible(true);
                    chk3.setVisible(true);
                    chk4.setVisible(true);
                    chk5.setVisible(true);
                    }
                    if (clickCounter==6){
                        score();

//the following code will run if there is a tie between players

                    }
                }
            });
                
scoreButton.addActionListener( new ActionListener(){
    @Override
    public void actionPerformed( ActionEvent e){
        score();
    }
});
        }
        public void score() //this code defines what actions will be triggered when the user presses Score Button
        {
            humanScore = humanScore + humanRoll;
            humanLabel.setText("Human Grand Total " + humanScore + "!");
            
            computerScore = computerScore + computerRoll;
            computerLabel.setText("Computer Grand Total " + computerScore + "!");
            
            if(humanScore>=usersEnter && computerScore>=usersEnter)
            {
                humanScore = 0;
                computerScore = 0;
                
                JButton tieButton = new JButton("Throw Dice");
                JLabel tieLabel = new JLabel("Rolll dice to decide who wons the Game");
                tiePanel.add(tieLabel);
                tiePanel.add(tieButton);
                
                frame.add(tiePanel);
                
                tieButton.addActionListener( new ActionListener()//throw button will trigger the following lines of code
                {
                @Override
                public void actionPerformed( ActionEvent e)
                {
                    
                    level++;
                    Roll();    
                    humanPic1.setIcon(d1.faceValue);//these lines will assign images taken from directory into imageicons
                    humanPic2.setIcon(d2.faceValue);
                    humanPic3.setIcon(d3.faceValue);
                    humanPic4.setIcon(d4.faceValue);
                    humanPic5.setIcon(d5.faceValue);
                    humanRoll = Dice[0] + Dice[1] + Dice[2] + Dice[3] + Dice[4];
                    humanMain.setText("Human Rolls " + humanRoll + "!");
                 
                    Roll(); 
                    computerPic1.setIcon(d1.faceValue);//these lines will assign images taken from directory into imageicons
                    computerPic2.setIcon(d2.faceValue);
                    computerPic3.setIcon(d3.faceValue);
                    computerPic4.setIcon(d4.faceValue);
                    computerPic5.setIcon(d5.faceValue);
                    computerRoll = Dice[0] + Dice[1] + Dice[2] + Dice[3] + Dice[4];
                    computerMain.setText("Computer Rolls " + computerRoll + "!");
                    
                    if(humanRoll>computerRoll)
                    {
                        gameFinished human = new gameFinished();
                        human.HumanWon();
                    }
                    if(computerRoll>humanRoll)
                    {
                        gameFinished computer = new gameFinished();
                        computer.ComputerWon();
                    }
                    if(computerRoll==humanRoll)
                    {
                        score();
                    }
                    if(level==1)
                    {
                        tieButton.setVisible(false);
                        tieLabel.setVisible(false);
                        
                    }
                }
            }); 
            }
            if(humanScore>=usersEnter)
            {
                gameFinished human = new gameFinished();
                human.HumanWon();
            }
            if(computerScore>=usersEnter)
            {
                gameFinished computer = new gameFinished();
                computer.ComputerWon();
            } 
            clickCounter = 0;
        }
        class restartGame implements ActionListener{
            public void actionPerformed (ActionEvent e)
            {
                frame.removeAll();
                frame.validate();
                frame.setVisible(false);
                
                Dice run = new Dice();
                run.theStartWindow();
            }
        }
        
        public void Roll()
        {
            int MAX = 6;
//if checkbox is true, this continues the rng
            if(!chk1.isSelected()){
                Dice[0]= (int)(Math.random() * MAX) + 1; 
                d1.setValue(Dice[0]);
                d1.setImage();
            }
            else
            {
                if(clickCounter == 4){
//if the user decided to change the roll, this resets it for the next turn
                    chk1.setSelected(true);
                }
            }
            if(!chk2.isSelected()){
                Dice[1] = (int)(Math.random() * MAX) + 1; 
                d2.setValue(Dice[1]);
                d2.setImage();
            }
            else{
                if(clickCounter == 4){
                    chk2.setSelected(true);    
                }
            }
            if(!chk3.isSelected()){
                Dice[2] = (int)(Math.random() * MAX) + 1;
                d3.setValue(Dice[2]);
                d3.setImage();     
            }
            else{
                if(clickCounter == 4){
                    chk3.setSelected(true);
                }
            }
            if(!chk4.isSelected()){
                Dice[3] = (int)(Math.random() * MAX) + 1;
                d4.setValue(Dice[3]);
                d4.setImage(); 
            }
            else{
                if(clickCounter == 4){
                    chk4.setSelected(true);
                }
            }
            if(!chk5.isSelected()){
                Dice[4] = (int)(Math.random() * MAX) + 1;
                d5.setValue(Dice[4]);
                d5.setImage();    
            }
            else{
                if(clickCounter == 4){
                    chk5.setSelected(true);
                }
            }     
            clickCounter++;
        } 
        class gameFinished
        {
            public void HumanWon()
            {
                JFrame gameFinished = new JFrame();
                gameFinished.setVisible(true);
                
                JPanel panel = new JPanel();
                JLabel text = new JLabel(humanName + " Won! Do You Want To Start a New Game?");
                JButton newGame = new JButton("New Game");
                
                panel.add(text);
                panel.add(newGame);
                gameFinished.add(panel);
                gameFinished.pack();
                newGame.addActionListener(new restartGame());
            }
            public void ComputerWon()
            {
                JFrame gameFinished = new JFrame();
                gameFinished.setVisible(true);
                
                JPanel panel = new JPanel();
                JLabel text = new JLabel(computerName + " Won! Do You Want To Start a New Game?");
                JButton newGame = new JButton("New Game");
       
                panel.add(text);
                panel.add(newGame);
                gameFinished.add(panel);
                gameFinished.pack();
                
                newGame.addActionListener(new restartGame());
            }
        }
}
public class Cw2 {

    public static void main(String[] args) {
        
        Dice run = new Dice();
        run.theStartWindow();
        
    } 
}

