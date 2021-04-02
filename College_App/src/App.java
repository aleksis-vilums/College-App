import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import java.awt.EventQueue;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

public class App extends JFrame {
    private JLabel userName, userMajor, sort, collegeSchool, costPerSem, majorPlacement, population, acceptanceRate, avgGPA, avgSAT;
    private JLabel[][] colleges = new JLabel[3][7];
    private JTextField userNameTextBox, userMajorTextBox;
    private JButton addButton;
    private JComboBox<String> sortBox;
    private ArrayList<College> collegeList = new ArrayList<College>();

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
                if(colleges[0][0].getText().isEmpty()){
                    String name = JOptionPane.showInputDialog("College Name?");
                    if(name.equals("")){
                        name = JOptionPane.showInputDialog("You didn't put a Name. Please enter one.");
                    }
                    College college = new College(name);
                    colleges[0][0].setText("College Name: " + college.getName());
                    if (userMajorTextBox.getText().isEmpty()){
                        String text = JOptionPane.showInputDialog("Major?");
                        userMajorTextBox.setText(text);
                    }
                    colleges[0][1].setText("Cost Per Semester: $" + college.getCost());
                    colleges[0][2].setText(userMajorTextBox.getText() + " Placement: " + college.getMajor() + "/50");
                    colleges[0][3].setText("Population: " + Integer.toString(college.getPopulation()));
                    colleges[0][4].setText("Accepatance Rate: " + String.valueOf(college.getAcceptanceRate()) + "%");
                    colleges[0][5].setText("Average GPA: " + String.valueOf(college.getGPA()));
                    colleges[0][6].setText("Average SAT: " + Integer.toString(college.getSAT()));
                    collegeList.add(college);
                } else if (colleges[1][0].getText().isEmpty()){
                    String name = JOptionPane.showInputDialog("College Name?");
                    if(name.equals("")){
                        name = JOptionPane.showInputDialog("You didn't put a Name. Please enter one.");
                    }
                    College college = new College(name);
                    colleges[1][0].setText("College Name: " + college.getName());
                    colleges[1][1].setText("Cost Per Semester: $" + college.getCost());
                    colleges[1][2].setText(userMajorTextBox.getText() + " Placement: " + college.getMajor() + "/50");
                    colleges[1][3].setText("Population: " + Integer.toString(college.getPopulation()));
                    colleges[1][4].setText("Accepatance Rate: " + String.valueOf(college.getAcceptanceRate()) + "%");
                    colleges[1][5].setText("Average GPA: " + String.valueOf(college.getGPA()));
                    colleges[1][6].setText("Average SAT: " + Integer.toString(college.getSAT()));
                    collegeList.add(college);
                } else if (colleges[2][0].getText().isEmpty()){
                    String name = JOptionPane.showInputDialog("College Name?");
                    if(name.equals("")){
                        name = JOptionPane.showInputDialog("You didn't put a Name. Please enter one.");
                    }
                    College college = new College(name);
                    colleges[2][0].setText("College Name: " + college.getName());
                    colleges[2][1].setText("Cost Per Semester: $" + college.getCost());
                    colleges[2][2].setText(userMajorTextBox.getText() + " Placement: " + college.getMajor() + "/50");
                    colleges[2][3].setText("Population: " + Integer.toString(college.getPopulation()));
                    colleges[2][4].setText("Accepatance Rate: " + String.valueOf(college.getAcceptanceRate()) + "%");
                    colleges[2][5].setText("Average GPA: " + String.valueOf(college.getGPA()));
                    colleges[2][6].setText("Average SAT: " + Integer.toString(college.getSAT()));
                    collegeList.add(college);
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry, there is a limit of 3 colleges.");
                }
            }
        });

        String s[] = {"Cost (Cheapest First)", "Major", "Population", "SAT Scores", "GPA", "Acceptance Rate"};
        sortBox = new JComboBox<>(s);
        sortBox.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String option = String.valueOf(sortBox.getSelectedItem());
                switch (option){
                    case "Cost (Cheapest First)": 
                        for(int i = 0; i < colleges.length; i++){
                            int min = i;
                            for(int x = i; x < colleges.length; x++){
                                if (collegeList.get(x).getCost() < collegeList.get(i).getCost()){
                                    min = x;
                                }
                            }

                            Collections.swap(collegeList, i, min);
                        }
                        arrayListToRowsAndCol(collegeList);
                    case "Major":
                        for(int i = 0; i < colleges.length; i++){
                            int min = i;
                            for(int x = i; x < colleges.length; x++){
                                if (collegeList.get(x).getMajor() < collegeList.get(i).getMajor()){
                                    min = x;
                                }
                            }

                            Collections.swap(collegeList, i, min);
                        }
                        arrayListToRowsAndCol(collegeList);
                    case "Population":
                        for(int i = 0; i < colleges.length; i++){
                            int min = i;
                            for(int x = i; x < colleges.length; x++){
                                if (collegeList.get(x).getPopulation() < collegeList.get(i).getPopulation()){
                                    min = x;
                                }
                            }

                            Collections.swap(collegeList, i, min);
                        }
                        arrayListToRowsAndCol(collegeList);
                    case "SAT Scores":
                        for(int i = 0; i < colleges.length; i++){
                            int min = i;
                            for(int x = i; x < colleges.length; x++){
                                if (collegeList.get(x).getSAT() < collegeList.get(i).getSAT()){
                                    min = x;
                                }
                            }

                            Collections.swap(collegeList, i, min);
                        }
                        arrayListToRowsAndCol(collegeList);
                    case "GPA":
                        for(int i = 0; i < colleges.length; i++){
                            int min = i;
                            for(int x = i; x < colleges.length; x++){
                                if (collegeList.get(x).getGPA() < collegeList.get(i).getGPA()){
                                    min = x;
                                }
                            }

                            Collections.swap(collegeList, i, min);
                        }
                        arrayListToRowsAndCol(collegeList);
                    case "Acceptace Rate":
                        for(int i = 0; i < colleges.length; i++){
                            int min = i;
                            for(int x = i; x < colleges.length; x++){
                                if (collegeList.get(x).getAcceptanceRate() < collegeList.get(i).getAcceptanceRate()){
                                    min = x;
                                }
                            }

                            Collections.swap(collegeList, i, min);
                        }
                        arrayListToRowsAndCol(collegeList);

                }
            }
        });

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
                    colleges[1][0], colleges[1][1], colleges[1][2], colleges[1][3], colleges[1][4], colleges[1][5], colleges[1][6],
                    colleges[2][0], colleges[2][1], colleges[2][2], colleges[2][3], colleges[2][4], colleges[2][5], colleges[2][6]);//Method called to place

        setTitle("College App");
        //      width, height
        setSize(1000, 1000);
        setLocationRelativeTo(null);// Center aline on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// When close is pressed it closes
    }

    public void arrayListToRowsAndCol(ArrayList<College> collegeList){
        for(int i = 0; i < collegeList.size(); i++){
            colleges[i][0].setText("College Name: " + collegeList.get(i).getName());
            colleges[i][1].setText("Cost Per Semester: $" + collegeList.get(i).getCost());
            colleges[i][2].setText(userMajorTextBox.getText() + " Placement: " + collegeList.get(i).getMajor() + "/50");
            colleges[i][3].setText("Population: " + Integer.toString(collegeList.get(i).getPopulation()));
            colleges[i][4].setText("Accepatance Rate: " + String.valueOf(collegeList.get(i).getAcceptanceRate()) + "%");
            colleges[i][5].setText("Average GPA: " + String.valueOf(collegeList.get(i).getGPA()));
            colleges[i][6].setText("Average SAT: " + Integer.toString(collegeList.get(i).getSAT()));
        }
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
        SequentialGroup college3StatsHorizontal = gl.createSequentialGroup();
        ParallelGroup college3StatsVerticle = gl.createParallelGroup();

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
            .addGroup(college2StatsHorizontal)
            .addGroup(college3StatsHorizontal));

            for (int i = 14; i <= 20; i++){
                college1StatsHorizontal.addComponent(args[i]);
            }
            
            for (int i = 21; i <= 27; i++){
                college2StatsHorizontal.addComponent(args[i]);
            }
            
            for (int i = 28; i <= 34; i++){
                college3StatsHorizontal.addComponent(args[i]);
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
            .addGroup(college2StatsVerticle)
            .addGroup(college3StatsVerticle));

            for (int i = 14; i <= 20; i++){
                college1StatsVerticle.addComponent(args[i]);
            }

            for (int i = 21; i <= 27; i++){
                college2StatsVerticle.addComponent(args[i]);
            }

            for (int i = 28; i <= 34; i++){
                college3StatsVerticle.addComponent(args[i]);
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
