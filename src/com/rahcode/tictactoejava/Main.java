//                      .                    .                           
//                 :-:--=:-:::.             :=-**##*=:                   
//                  :=----------.         .-%@@@@@@@@@%:                 
//                 :-------------:        :@@@@@@@@@@@@%.                
//                :-=-----------==:       +@@@@@@@@@@@@@#                
//              .------------=------.     =@@@@@@@@@@@@@#                
//               :=-=-------===-=--      .+%@@@@@@@@@@@#=                
//                --=--------==-=-.       -*%@@@@@@@@@*-.                
//                   ::----===+-             .#%@@@@*.                   
//                      -+++=: .               :+##+                     
//                     -+=====.              .=%@@%%%#=                  
//                  :-----------:.        :+#%%%@@@@@%@%+-               
//                -----------------      -%%%%%@@@%@@%%@%%*              
//               .-==----------==--:     #%%%@%@@@@@@@@@@%%.             
//               :-=+----------*=---    =%%%@@%%@@@%%@@@%%%=             
//               ---=----------*----:  .#%%%@@%%@@@%@%@@%%%%             
//              :-===----------+=---=  -#%%%@@%%@%@%@%@@%%%%=            
//                --=----------=#==+.   ==+%@@%%@@@%@%@@*++.             
//                --=-----------*=---  :===#@@%%@@@%@%%%--=              
//                -==-----------++--=  ---:#@%@@@%%%@@@%--=              
//                -=------------=:--=. =-- %@%%%%%%@%%%@=-=              
//               .-+-------------.:---.--: %%%%%%%%@%%@@+==              
//               :-++*++++++*+***. --=+--  *###########**-=              
//               --*+++++++++*+++: :--*-: :------=------*-=              
//               =-*++++++++*+***- .--*-. :-------------+-=              
//              .--*+++=+*++*+***+ :==*=: -------=------===:             
//              :=+++++==+++*++**+ -*++=. -------+-------+=:             
//               -++++=+==**+++***  :-:   -------+-------+.              
//                -+++=++=****+**#        -------+=------=               
//                .++==*=---=*+**+        =------+*------=               
//                 ----=    :---=          ====-.::+====                 
//            :**#==---=:   ----= ..   .:::=--=+*%#*--=+***. .--:..      
//            .=+**#=--==   :=--=%@*:.-=+%%*--=: ::+=--+***+=#@%*-=-::.  
//                :+=--=. :::=--=:.-*#%*--=*---+-+**=--=--=+**+*=**%@%=  
//                  =--= .#%%=--=.  +*#%#= +---#%++#=---.+%@%+  .+++*+-  
//                  ====   .:+===:   -==+= :===*+: -==== .--:.      ..   
//                  =--=     ----:         .----   :=---                 
//                  ----     :---:         .=---   .=---                 
//                  ----     :---:         .=---    =---                 
//                  ---:     :---:         .=---    +---                 
//                  +##%.    =*##-         -%%#:    %%%#                 
//                 :@@@@-    #@@@+         %@@@*   :@@@%:                
//                 .====.    -++=:         =+==-    --==.                

// @milosnowcat

package com.rahcode.tictactoejava;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class Main extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    String turn = "X";
    JLabel[] sqrs = new JLabel[9];
    int[][] win = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9},
        {1, 4, 7},
        {2, 5, 8},
        {3, 6, 9},
        {1, 5, 9},
        {3, 5, 7},
    };
    JLabel[] turns = new JLabel[3];
    boolean play = true;

    static final String TURN_STRING = " turn";
    static final String FONT_STRING = "Dialog";
    static final Font SQR_FONT = new Font(FONT_STRING, Font.BOLD, 40);
    static final Font POINTS_FONT = new Font(FONT_STRING, Font.BOLD, 25);

    public void press(int square) {
        if (sqrs[square - 1].getText().equals("") && play) {
            sqrs[square - 1].setText(turn);
            turn = turn.equals("X")? "O" : "X";
            turns[0].setText(turn + TURN_STRING);
            checkWinner();
        }
    }

    public void checkWinner() {
        for (int i = 0; i < win.length; i++) {
            if (sqrs[win[i][0] - 1].getText().equals("X") &&
                sqrs[win[i][1] - 1].getText().equals("X") &&
                sqrs[win[i][2] - 1].getText().equals("X"))
            {
                sqrs[win[i][0] - 1].setBackground(Color.green);
                sqrs[win[i][1] - 1].setBackground(Color.green);
                sqrs[win[i][2] - 1].setBackground(Color.green);

                turn = "X";
                turns[0].setText(turn + " won!");
                turns[1].setText(Integer.toString(Integer.parseInt(turns[1].getText()) + 1));

                play = false;
            }

            if (sqrs[win[i][0] - 1].getText().equals("O") &&
                sqrs[win[i][1] - 1].getText().equals("O") &&
                sqrs[win[i][2] - 1].getText().equals("O"))
            {
                sqrs[win[i][0] - 1].setBackground(Color.green);
                sqrs[win[i][1] - 1].setBackground(Color.green);
                sqrs[win[i][2] - 1].setBackground(Color.green);

                turn = "O";
                turns[0].setText(turn + " won!");
                turns[2].setText(Integer.toString(Integer.parseInt(turns[2].getText()) + 1));

                play = false;
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Main frame = new Main();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Main() {
        setTitle("Tic Tac Toe");
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.desktop);
        panel.setBounds(100, 100, 300, 300);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblTicTacToe1 = new JLabel("");
        lblTicTacToe1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                press(1);
            }
        });
        lblTicTacToe1.setFont(SQR_FONT);
        lblTicTacToe1.setOpaque(true);
        lblTicTacToe1.setBackground(SystemColor.window);
        lblTicTacToe1.setHorizontalAlignment(SwingConstants.CENTER);
        lblTicTacToe1.setForeground(SystemColor.windowText);
        lblTicTacToe1.setBounds(5, 5, 90, 90);
        panel.add(lblTicTacToe1);
        
        JLabel lblTicTacToe2 = new JLabel("");
        lblTicTacToe2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                press(2);
            }
        });
        lblTicTacToe2.setOpaque(true);
        lblTicTacToe2.setHorizontalAlignment(SwingConstants.CENTER);
        lblTicTacToe2.setForeground(SystemColor.windowText);
        lblTicTacToe2.setFont(SQR_FONT);
        lblTicTacToe2.setBackground(SystemColor.window);
        lblTicTacToe2.setBounds(105, 5, 90, 90);
        panel.add(lblTicTacToe2);
        
        JLabel lblTicTacToe3 = new JLabel("");
        lblTicTacToe3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                press(3);
            }
        });
        lblTicTacToe3.setOpaque(true);
        lblTicTacToe3.setHorizontalAlignment(SwingConstants.CENTER);
        lblTicTacToe3.setForeground(SystemColor.windowText);
        lblTicTacToe3.setFont(SQR_FONT);
        lblTicTacToe3.setBackground(SystemColor.window);
        lblTicTacToe3.setBounds(205, 5, 90, 90);
        panel.add(lblTicTacToe3);
        
        JLabel lblTicTacToe4 = new JLabel("");
        lblTicTacToe4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                press(4);
            }
        });
        lblTicTacToe4.setOpaque(true);
        lblTicTacToe4.setHorizontalAlignment(SwingConstants.CENTER);
        lblTicTacToe4.setForeground(SystemColor.windowText);
        lblTicTacToe4.setFont(SQR_FONT);
        lblTicTacToe4.setBackground(SystemColor.window);
        lblTicTacToe4.setBounds(5, 105, 90, 90);
        panel.add(lblTicTacToe4);
        
        JLabel lblTicTacToe5 = new JLabel("");
        lblTicTacToe5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                press(5);
            }
        });
        lblTicTacToe5.setOpaque(true);
        lblTicTacToe5.setHorizontalAlignment(SwingConstants.CENTER);
        lblTicTacToe5.setForeground(SystemColor.windowText);
        lblTicTacToe5.setFont(SQR_FONT);
        lblTicTacToe5.setBackground(SystemColor.window);
        lblTicTacToe5.setBounds(105, 105, 90, 90);
        panel.add(lblTicTacToe5);
        
        JLabel lblTicTacToe6 = new JLabel("");
        lblTicTacToe6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                press(6);
            }
        });
        lblTicTacToe6.setOpaque(true);
        lblTicTacToe6.setHorizontalAlignment(SwingConstants.CENTER);
        lblTicTacToe6.setForeground(SystemColor.windowText);
        lblTicTacToe6.setFont(SQR_FONT);
        lblTicTacToe6.setBackground(SystemColor.window);
        lblTicTacToe6.setBounds(205, 105, 90, 90);
        panel.add(lblTicTacToe6);
        
        JLabel lblTicTacToe7 = new JLabel("");
        lblTicTacToe7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                press(7);
            }
        });
        lblTicTacToe7.setOpaque(true);
        lblTicTacToe7.setHorizontalAlignment(SwingConstants.CENTER);
        lblTicTacToe7.setForeground(SystemColor.windowText);
        lblTicTacToe7.setFont(SQR_FONT);
        lblTicTacToe7.setBackground(SystemColor.window);
        lblTicTacToe7.setBounds(5, 205, 90, 90);
        panel.add(lblTicTacToe7);
        
        JLabel lblTicTacToe8 = new JLabel("");
        lblTicTacToe8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                press(8);
            }
        });
        lblTicTacToe8.setOpaque(true);
        lblTicTacToe8.setHorizontalAlignment(SwingConstants.CENTER);
        lblTicTacToe8.setForeground(SystemColor.windowText);
        lblTicTacToe8.setFont(SQR_FONT);
        lblTicTacToe8.setBackground(SystemColor.window);
        lblTicTacToe8.setBounds(105, 205, 90, 90);
        panel.add(lblTicTacToe8);
        
        JLabel lblTicTacToe9 = new JLabel("");
        lblTicTacToe9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                press(9);
            }
        });
        lblTicTacToe9.setOpaque(true);
        lblTicTacToe9.setHorizontalAlignment(SwingConstants.CENTER);
        lblTicTacToe9.setForeground(SystemColor.windowText);
        lblTicTacToe9.setFont(SQR_FONT);
        lblTicTacToe9.setBackground(SystemColor.window);
        lblTicTacToe9.setBounds(205, 205, 90, 90);
        panel.add(lblTicTacToe9);

        sqrs[0] = lblTicTacToe1;
        sqrs[1] = lblTicTacToe2;
        sqrs[2] = lblTicTacToe3;
        sqrs[3] = lblTicTacToe4;
        sqrs[4] = lblTicTacToe5;
        sqrs[5] = lblTicTacToe6;
        sqrs[6] = lblTicTacToe7;
        sqrs[7] = lblTicTacToe8;
        sqrs[8] = lblTicTacToe9;
        
        JButton btnNewButton = new JButton("Reset");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (int i = 0; i < sqrs.length; i++) {
                    sqrs[i].setText("");
                    sqrs[i].setBackground(SystemColor.window);
                }
                turns[0].setText(turn + TURN_STRING);
                play = true;
            }
        });
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setBounds(283, 37, 117, 25);
        contentPane.add(btnNewButton);
        
        JLabel lblTurn = new JLabel(turn + TURN_STRING);
        lblTurn.setFont(new Font(FONT_STRING, Font.BOLD, 20));
        lblTurn.setBounds(100, 37, 142, 28);
        contentPane.add(lblTurn);

        turns[0] = lblTurn;
        
        JLabel lblX = new JLabel("X:");
        lblX.setFont(POINTS_FONT);
        lblX.setBounds(114, 424, 38, 34);
        contentPane.add(lblX);
        
        JLabel lblPointsX = new JLabel("0");
        lblPointsX.setFont(POINTS_FONT);
        lblPointsX.setBounds(153, 424, 38, 34);
        contentPane.add(lblPointsX);
        
        JLabel lblPointsO = new JLabel("0");
        lblPointsO.setFont(POINTS_FONT);
        lblPointsO.setBounds(359, 424, 38, 34);
        contentPane.add(lblPointsO);
        
        JLabel lblO = new JLabel("O:");
        lblO.setFont(POINTS_FONT);
        lblO.setBounds(320, 424, 38, 34);
        contentPane.add(lblO);

        turns[1] = lblPointsX;
        turns[2] = lblPointsO;
    }
}
