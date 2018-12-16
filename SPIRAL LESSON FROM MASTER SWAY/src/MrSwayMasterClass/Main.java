package MrSwayMasterClass;
import javax.swing.*;


public class Main {
    public static void main (String[] args) {
        JFrame window = new JFrame();
        VisualEffects visualEffects = new VisualEffects();
        window.setBounds(10, 10, 1200, 700);
        window.setTitle("Spirals");
        window.setResizable(false);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(visualEffects);
    }
}
