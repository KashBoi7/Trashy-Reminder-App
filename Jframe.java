import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Jframe extends JFrame  implements ActionListener, Serializable {
    JButton button;
//    String reminder=scanner.next();
    JTextField textField;
    Date date;
//    Scanner scanner=new Scanner(.get);

    Jframe() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        button=new JButton("Submit");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(100,35));
        button.setFocusable(false);
        button.setBackground(Color.green);
        textField=new JTextField();
        textField.setPreferredSize(new Dimension(250,40));
        this.add(button);
        this.add(textField);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
        date=new Date();
//        Serialable serial =new Serializable()





//        ImageIcon icon = new ImageIcon("unnamed.jpg");
//        setFont(new Font("Comic Sans", 1, 11));
//        textField.addActionListener(this);
//        this.button = new JButton();
//        this.setSize(750, 750);
//        this.setIconImage(icon.getImage());
//        this.button.addActionListener(this);
//        this.button.setText("Submit");
//        this.button.setFont(new Font("Comic Sans", 0, 15));
//        this.button.setFocusable(false);
//        this.button.setHorizontalTextPosition(0);
//        this.button.setVerticalTextPosition(3);
//        this.button.setBackground(new Color(0, 200, 7));
//        this.button.setForeground(Color.BLACK);
//        this.button.setBorder(BorderFactory.createEtchedBorder());
//        this.add(this.button);
//        this.add(textField);
//        this.setLocationRelativeTo((Component) null);
//        this.button.setBounds(300, 300, 100, 50);



    }
//    public void actionPreformed(ActionEvent arg0) {
//        System.out.println("Hello");
//        new Timer(1000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Goodbye");
//            }
//        }).start();
//    }


//    public void actionPerformed(ActionEvent f) {
//        try {
//            Thread.sleep(50000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }


    @Override
    public void actionPerformed(ActionEvent e){

        if (e.getSource() == button) {
//            try {
////                TimeUnit.SECONDS.sleep(4);
//            } catch (InterruptedException interruptedException) {
//                interruptedException.printStackTrace();
//            }
            button.setEnabled(true);

            try {
                SystemTray tray = SystemTray.getSystemTray();

                Image image = Toolkit.getDefaultToolkit().createImage("some-icon.png");
                TrayIcon trayIcon = new TrayIcon(image, "");
                trayIcon.setImageAutoSize(true);
                trayIcon.setToolTip("");
                tray.add(trayIcon);
                trayIcon.displayMessage(textField.getText(), "Reminder", TrayIcon.MessageType.INFO);
            }catch(Exception ex){
                System.err.print(ex);
            }

        }
        }
//    public int delay = 100; //milliseconds
//    public ActionListener taskPerformer = new ActionListener() {
//        public void actionPerformed(ActionEvent evt) {
//            if (evt.getSource() == button) {
//                try {
//                    TimeUnit.SECONDS.sleep(4);
//                } catch (InterruptedException interruptedException) {
//                    interruptedException.printStackTrace();
//                }
////                button.setEnabled(true);
//
//                try {
//                    SystemTray tray = SystemTray.getSystemTray();
//
//                    Image image = Toolkit.getDefaultToolkit().createImage("some-icon.png");
//                    TrayIcon trayIcon = new TrayIcon(image, "");
//                    trayIcon.setImageAutoSize(true);
//                    trayIcon.setToolTip("");
//                    tray.add(trayIcon);
//                    trayIcon.displayMessage(textField.getText(), "Reminder", TrayIcon.MessageType.INFO);
//                }catch(Exception ex){
//                    System.err.print(ex);
//                }
//
//            }        }
//    };

//  new Timer(delay, taskPerformer).start();

    }
