import java.math.BigInteger;
import java.awt.*;
import java.lang.String;
import java.awt.event.*;
import java.applet.Applet;
public class Factorial extends Applet implements ActionListener {
    Button n0;
    TextField t,tt;
    Label l;
    public void init(){
        Panel pro=new Panel();
        pro.setLayout(new GridLayout());
        add(new Label("Enter any Integer vlaue"));
        add(t =new TextField(20));
        add(new Label("Factorial value is:"));
        add(tt =new TextField(20));   
        add(n0 =new Button("Compute"));  
        n0.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        int j,k;
        k=Integer.parseInt(t.getText());
        BigInteger f= BigInteger.ONE;
        for(j=1;j<=k;j++)
            f=f.multiply(BigInteger.valueOf(j));
            tt.setText(String.valueOf(f));
            repaint();
    }
}