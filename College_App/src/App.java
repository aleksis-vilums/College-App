import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;

import java.awt.EventQueue;
import java.awt.event.*;

public class App extends JFrame {
    private JLabel userName, userMajor, sort, collegeSchool, costPerSem, majorPlacement, population, acceptanceRate, avgGPA, avgSAT;
    private JLabel[][] colleges = new JLabel[12][7];
    private JTextField userNameTextBox, userMajorTextBox;
    private JButton addButton;
    private JComboBox<String> sortBox;
    public App() {
        initUI();
    }
    
    private void initUI() {
        userName = new JLabel("Name: ");
        userNameTextBox = new JTextField(10);
        userMajor = new JLabel("Major: ");
        userMajorTextBox = new JTextField(10);
        sort = new JLabel("Sort By: ");
        addButton = new JButton("Add new");
        addButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("College Name?");
                College college = new College(name);
                if(colleges[0][0].getText().isEmpty()){
                    colleges[0][0].setText("College Name: " + college.getName());
                    if (userMajorTextBox.getText().isEmpty()){
                        String text = JOptionPane.showInputDialog("Major?");
                        userMajorTextBox.setText(text);
                    }
                    colleges[0][1].setText("Cost Per Semeser: $" + college.getCost());
                    colleges[0][2].setText(userMajorTextBox.getText() + " Placement: " + college.getMajor() + "/50");
                    colleges[0][3].setText("Population: " + Integer.toString(college.getPopulation()));
                    colleges[0][4].setText("Accepatance Rate: " + String.valueOf(college.getAcceptanceRate()) + "%");
                    colleges[0][5].setText("Average GPA: " + String.valueOf(college.getGPA()));
                    colleges[0][6].setText("Average SAT: " + Integer.toString(college.getSAT()));
                } else if (colleges[1][0].getText().isEmpty()){
                    colleges[1][0].setText("College Name: " + college.getName());
                    colleges[1][1].setText("Cost Per Semeser: $" + college.getCost());
                    colleges[1][2].setText(userMajorTextBox.getText() + " Placement: " + college.getMajor() + "/50");
                    colleges[1][3].setText("Population: " + Integer.toString(college.getPopulation()));
                    colleges[1][4].setText("Accepatance Rate: " + String.valueOf(college.getAcceptanceRate()) + "%");
                    colleges[1][5].setText("Average GPA: " + String.valueOf(college.getGPA()));
                    colleges[1][6].setText("Average SAT: " + Integer.toString(college.getSAT()));
                }
            }
        });
        String s[] = {"Cost", "Major", "Population", "SAT Scores", "GPA", "Acceptance Rate"};
        sortBox = new JComboBox<>(s);
        collegeSchool = new JLabel("Name");
        costPerSem = new JLabel("Cost Per Semester");
        majorPlacement = new JLabel("Major Placement");
        population = new JLabel("Population");
        acceptanceRate = new JLabel("Acceptance Rate");
        avgGPA = new JLabel("Average GPA");
        avgSAT = new JLabel("Average SAT");
        for(int i = 0; i < colleges.length; i++){
            for (int x = 0; x < colleges[i].length; x++){
                colleges[i][x] = new JLabel("");
            }
        }

        createLayout(userName, userNameTextBox, userMajor, userMajorTextBox, sort, addButton, sortBox, collegeSchool, costPerSem, majorPlacement, population, acceptanceRate, avgGPA, avgSAT, 
                    colleges[0][0], colleges[0][1], colleges[0][2], colleges[0][3], colleges[0][4], colleges[0][5], colleges[0][6],
                    colleges[1][0], colleges[1][1], colleges[1][2], colleges[1][3], colleges[1][4], colleges[1][5], colleges[1][6]);//Method called to place

        setTitle("College App");
        //      width, height
        setSize(1000, 1000);
        setLocationRelativeTo(null);// Center aline on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// When close is pressed it closes
    }

    private void createLayout(JComponent...args){
        var pane = getContentPane();
        var gl = new GroupLayout(pane);
        pane.setLayout(gl);
        
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true); // Creates gaps

        SequentialGroup college1StatsHorizontal = gl.createSequentialGroup();
        ParallelGroup college1StatsVerticle= gl.createParallelGroup();
        SequentialGroup college2StatsHorizontal = gl.createSequentialGroup();
        ParallelGroup college2StatsVerticle = gl.createParallelGroup();


        //GroupLayout
        gl.setHorizontalGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addGroup(gl.createSequentialGroup()
                .addComponent(args[0])
                .addComponent(args[1])
                .addComponent(args[4])
                .addComponent(args[6]))
            .addGroup(gl.createSequentialGroup()
                .addComponent(args[2])
                .addComponent(args[3])
                .addComponent(args[5]))
            .addGroup(gl.createSequentialGroup()
                .addComponent(args[7])
                .addComponent(args[8])
                .addComponent(args[9])
                .addComponent(args[10])
                .addComponent(args[11])
                .addComponent(args[12])
                .addComponent(args[13]))
            .addGroup(college1StatsHorizontal)
            .addGroup(college2StatsHorizontal));

            for (int i = 14; i <= 20; i++){
                college1StatsHorizontal.addComponent(args[i]);
            }
            
            for (int i = 21; i <= 27; i++){
                college2StatsHorizontal.addComponent(args[i]);
            }
            
        gl.setVerticalGroup(gl.createSequentialGroup()
            .addGroup(gl.createParallelGroup(Alignment.BASELINE)
                .addComponent(args[0])
                .addComponent(args[1])
                .addComponent(args[4])
                .addComponent(args[6]))
            .addGroup(gl.createParallelGroup(Alignment.BASELINE)
                .addComponent(args[2])
                .addComponent(args[3])
                .addComponent(args[5]))
            .addGroup(gl.createParallelGroup()
                .addComponent(args[7])
                .addComponent(args[8])
                .addComponent(args[9])
                .addComponent(args[10])
                .addComponent(args[11])
                .addComponent(args[12])
                .addComponent(args[13]))
            .addGroup(college1StatsVerticle)
            .addGroup(college2StatsVerticle));

            for (int i = 14; i <= 20; i++){
                college1StatsVerticle.addComponent(args[i]);
            }

            for (int i = 21; i <= 27; i++){
                college2StatsVerticle.addComponent(args[i]);
            }

    }

    public static void main(String[] args) {    
        EventQueue.invokeLater(() -> {
            App calc = new App();
            calc.setVisible(true);
        });

        // for(int x = 0; x >= 10; x++) {
        //     College[] RaCollege = new College[x];
        // }
    }
}
