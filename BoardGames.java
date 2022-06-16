import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class BoardGames implements ActionListener {
    private JFrame frame;
    private JPanel title_panel;
    private JPanel button_panel;
    protected JLabel textfield;
    protected JButton[] buttons; 
    protected String game;
    
    //Random random = new Random();
    //Within the frame will be title_panel, button_panel, and within title_panel will be textfield
    public BoardGames(int boardSize){
        frame = new JFrame();
        title_panel = new JPanel();
        button_panel = new JPanel();
        textfield = new JLabel();
        buttons = new JButton[boardSize*boardSize];

        //initialize the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        //initialize the textfield
        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("MV Boli", Font.BOLD, 80));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        //textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);
        //initialize the title_panel
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0, 800, 100);
        //initialize button_panel
        button_panel.setLayout(new GridLayout(boardSize,boardSize));
        button_panel.setBackground(new Color(25, 25, 25)); //drastically different colors to make sure it is added

        for(int i = 0; i < boardSize * boardSize; i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]); //you have to add buttons to the button_panel
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setBackground(Color.BLACK);
            //buttons[i].setForeground(Color.GRAY);
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

         //puts it all together
        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH); 
        frame.add(button_panel);
        //BorderLayout.NORTH sets the title_panel's position inside Jframe object frame
    }

    public BoardGames(){ //there should be 9 buttons by default;
        this(3);
    }

    public abstract void actionPerformed(ActionEvent e); 

}
