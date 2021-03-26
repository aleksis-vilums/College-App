import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.EventQueue;

public class App extends JFrame {
    private JLabel name, major, sort;
    private JTextField nameTextBox, majorTextBox;
    private JButton addButton;
    private JComboBox<String> sortBox;
    
    public App() {
        initUI();
    }
    
    private void initUI() {
        name = new JLabel("Name: ");
        nameTextBox = new JTextField(10);
        major = new JLabel("Major: ");
        majorTextBox = new JTextField(10);
        sort = new JLabel("Sort By: ");
        addButton = new JButton("Add new");
        String s[] = {"Cost", "Major", "Population", "SAT Scores", "GPA", "Acceptance Rate"};
        sortBox = new JComboBox<>(s);
        
        createLayout(name, nameTextBox, major, majorTextBox, sort, addButton, sortBox);//Method called to place

        setTitle("College App");
        //      width, height
        setSize(1080, 1920);
        setLocationRelativeTo(null);// Center aline on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// When close is pressed it closes
    }

    private void createLayout(JComponent...args){
        var pane = getContentPane();
        var gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true); // Creates gaps
        //GroupLayout
        gl.setHorizontalGroup(gl.createSequentialGroup()
            .addGroup(gl.createParallelGroup()
                .addComponent(args[0])
                .addComponent(args[2]))
            .addGroup(gl.createParallelGroup()
                .addComponent(args[1])
                .addComponent(args[3]))
            .addGroup(gl.createParallelGroup()
                .addComponent(args[4])
                .addComponent(args[5]))
            .addGroup(gl.createParallelGroup()
                .addComponent(args[6])));

        
        gl.setVerticalGroup(gl.createSequentialGroup()
            .addGroup(gl.createParallelGroup(Alignment.BASELINE)
                .addComponent(args[0])
                .addComponent(args[1])
                .addComponent(args[4])
                .addComponent(args[6]))
                .addGroup(gl.createParallelGroup(Alignment.BASELINE)
                .addComponent(args[2])
                .addComponent(args[3])
                .addComponent(args[5])));

    }

    public static void main(String[] args) {    
        EventQueue.invokeLater(() -> {
            App calc = new App();
            calc.setVisible(true);
        });
    }
}
