package crystal.ui.window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import arc.util.*;

import crystal.ui.dialog.*;

@SuppressWarnings("serial")
public class TestWindow extends JPanel {
    JButton log, vd;
    // private static final long serialVersionUID =12;

    public TestWindow() {
        design();
    }

    public void design() {
        log = new JButton("log");
        vd = new JButton("view dialog");

        JPanel new1jp = new JPanel();

        log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Log.info("window.");
            }
        });

        vd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TestDialog();
            }
        });

        new1jp.add(log);
        new1jp.add(vd);

        this.add(new1jp);
    }

    public void draw() {
        TestWindow test = new TestWindow();
        JFrame frame = new JFrame("test");
        frame.getContentPane().add(test);
        frame.setBounds(200, 300, 430, 450);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}