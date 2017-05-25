import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SwingApp {

    public static void main(String args[]) {
        JFrame frame = new JFrame("Swing Controller App");


        JButton btnProgram1 = new JButton("Student Details");
        btnProgram1.setBounds(10,10,150,30);
        frame.add(btnProgram1);
        btnProgram1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Program 1 clicked....");
                try {
                    PrintStudent.main(null);
                }
                catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton btnProgram2 = new JButton("Staff Details");
        btnProgram2.setBounds(170,10,150,30);
        frame.add(btnProgram2);
        btnProgram2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Program 2 clicked....");
                try {
                    Q2a_Staff.main(null);
                }
                catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton btnProgram3 = new JButton("Multithreading");
        btnProgram3.setBounds(330,10,150,30);
        frame.add(btnProgram3);
        btnProgram3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Program 3 clicked....");
                try {
                    Q3b_Multithreading.main(null);
                }
                catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton btnProgram4 = new JButton("QuickSort");
        btnProgram4.setBounds(10,50,150,30);
        frame.add(btnProgram4);
        btnProgram4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Program 4 clicked....");
                try {
                    Q4_QuickSort.main(null);
                }
                catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });


        JButton btnProgram5 = new JButton("MergeSort");
        btnProgram5.setBounds(170,50,150,30);
        frame.add(btnProgram5);
        btnProgram5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Program 5 clicked....");
                try {
                    Q5_MergeSort.main(null);
                }
                catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton btnProgram6 = new JButton("Knapsack");
        btnProgram6.setBounds(330,50,150,30);
        frame.add(btnProgram6);
        btnProgram6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Program 6 clicked....");
                try {
                    Q6_Knapsack.main(null);
                }
                catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });



        JButton btnProgram7 = new JButton("Djikstra");
        btnProgram7.setBounds(10,90,150,30);
        frame.add(btnProgram7);
        btnProgram7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Program 4 clicked....");
                try {
                    Q7_Djikstra.main(null);
                }
                catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });


        JButton btnProgram8 = new JButton("Kruskals");
        btnProgram8.setBounds(170,90,150,30);
        frame.add(btnProgram8);
        btnProgram8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Program 2 clicked....");
                try {
                    Kruskals.main(null);
                }
                catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton btnProgram9 = new JButton("Prims");
        btnProgram9.setBounds(330,90,150,30);
        frame.add(btnProgram9);
        btnProgram9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Program 3 clicked....");
                try {
                    Q9_Prims.main(null);
                }
                catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });



        JButton btnProgram10 = new JButton("Floyds_APSP");
        btnProgram10.setBounds(10,130,150,30);
        frame.add(btnProgram10);
        btnProgram10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Program 4 clicked....");
                try {
                    Q10a_Floyds_APSP.main(null);
                }
                catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });


        JButton btnProgram11 = new JButton("Subset Sum");
        btnProgram11.setBounds(170,130,150,30);
        frame.add(btnProgram11);
        btnProgram11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Program 2 clicked....");
                try {
                    Q11_SubsetSum.main(null);
                }
                catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton btnProgram12 = new JButton("Hamiltonian");
        btnProgram12.setBounds(330,130,150,30);
        frame.add(btnProgram12);
        btnProgram12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Program 3 clicked....");
                try {
                    Q12_Hamiltonian.main(null);
                }
                catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        frame.setSize(490,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
