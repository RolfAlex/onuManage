/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.javacourse.clock;

/**
 *
 * @author Alex
 */
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
 
public class StartStopClock extends JFrame implements ActionListener
{
    private static final String START = "START";
    private static final String STOP = "STOP";
    
    private final JLabel clockLabel = new JLabel();
    private ClockThread clockThread = null;
    
    public StartStopClock() {
        // Установить заголовок
        setTitle("ClockThread");
 
        // Выравнять метку по горизонтали - есть такой метод у Label
        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);
 
        // Установить размер шрифта для метки  - есть такой метод у Label
        // Для эт ого создаем шрифт и сразу его отдаем методу setFont
        Font f = new Font("Default", Font.BOLD + Font.ITALIC, 24);
        clockLabel.setFont(f);
 
        // Добавить метку на основную панель окна
        add(clockLabel);
        
        // Добавить кнопку для старта
        JButton start = new JButton(START);
        start.setActionCommand(START);
        start.addActionListener(this);
        add(start, BorderLayout.NORTH);
        
        // Добавить кнопку для становки
        JButton stop = new JButton(STOP);
        stop.setActionCommand(STOP);
        stop.addActionListener(this);
        add(stop, BorderLayout.SOUTH);
 
        // Установить размеры окна
        setBounds(400, 300, 300, 200);
 
    }
    
    public void setTime() {
        // Более корректный вызов в отдельном потоке, который отвечает за графику
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                clockLabel.setText(df.format(Calendar.getInstance().getTime()));
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(START.equals(ae.getActionCommand())) {
            if(clockThread == null) {
                clockThread = new ClockThread(this);
                clockThread.start();
            }
        }
        if(STOP.equals(ae.getActionCommand())) {
            if(clockThread != null) {
                clockThread.stopClock();
                clockThread = null;
            }
        }
    }
 
    public static void main(String[] args) {
        StartStopClock cl = new StartStopClock();
        cl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cl.setVisible(true);
    }
}
 
 
class ClockThread extends Thread {
 
    private StartStopClock clock;
    private volatile boolean isRunning = true;
 
    public ClockThread(StartStopClock clock) {
        this.clock = clock;
    }
    
    public void stopClock() {
        isRunning = false;
    }
 
    @Override
    public void run() {
        while (isRunning) {
            clock.setTime();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
}