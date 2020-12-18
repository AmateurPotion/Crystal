package crystal.ui.window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import arc.util.*;

import crystal.io.SocketManager;
import crystal.ui.dialog.*;

import static crystal.Vars.*;

public class TestWindow extends JPanel {
    JButton log, vd, socketConnect;
    // private static final long serialVersionUID =12;

    public TestWindow() {
        design();
    }

    public void design() {
        log = new JButton("log");
        vd = new JButton("view dialog");
        socketConnect = new JButton("connect");

        JPanel new1jp = new JPanel();

        log.addActionListener(e -> Log.info("window."));

        vd.addActionListener(e -> new TestDialog());

        socketConnect.addActionListener(e -> new SocketManager().receiver());
        new1jp.add(log);
        new1jp.add(vd);
        if(onlineMode) { new1jp.add(socketConnect); }

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