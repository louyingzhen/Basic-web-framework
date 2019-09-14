package timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

class TimePrinter implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent event) {
        Date now = new Date();
        System.out.println("At the tone,the time is"+now);
        Toolkit.getDefaultToolkit().beep();
    }
}
