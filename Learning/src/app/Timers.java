package app;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class Timers implements Runnable {

    @Override
    public void run() {
        Timer timer1 = new Timer(1000, e -> {
            System.out.println("When you hear the sound, will be hour: " + new Date());
            Toolkit.getDefaultToolkit().beep();
        });
        timer1.start();

        Timer timer2 = new Timer(2000,  System.out::println);
        timer2.start();

        JOptionPane.showMessageDialog(null, "Shutdown ?");
        System.exit(0);
    }
}
