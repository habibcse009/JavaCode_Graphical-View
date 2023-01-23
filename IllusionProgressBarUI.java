

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.plaf.basic.BasicProgressBarUI;


public class IllusionProgressBarUI extends BasicProgressBarUI {

    private int numFrames = 200;

    public enum AnimationDirection {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    private AnimationDirection direction = AnimationDirection.RIGHT_TO_LEFT;

    public IllusionProgressBarUI() {
        startAnimationTimer();
    }

   
    private BufferedImage barImage = createRippleImage(Color.blue.darker(), Color.white);

    // Create an image with alternating light and dark patterns
    protected BufferedImage createRippleImage(Color darkColor, Color lightColor) {
        int width = 40;
        int height = 40;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();

        GradientPaint darkToLight = new GradientPaint(new Point2D.Double(0,0), darkColor, new Point2D.Double(width/2, 0), lightColor);
        GradientPaint lightToDark = new GradientPaint(new Point2D.Double(width/2,0), lightColor, new Point2D.Double(width, 0), darkColor);
        g2.setPaint(darkToLight);
        g2.fillRect(0, 0, width/2, height);
        g2.setPaint(lightToDark);
        g2.fillRect(width/2, 0, width/2, height);
        return image;
    }

    public AnimationDirection getDirection() {
        return direction;
    }

    public void setDirection(AnimationDirection direction) {
        this.direction = direction;
    }


    protected void incrementAnimationIndex() {
        int newValue = getAnimationIndex() + 1;
        if (newValue < numFrames) {
            setAnimationIndex(newValue);
        } else {
            setAnimationIndex(0);
        }
    }

    protected void paintDeterminate(Graphics g, JComponent c) {
        // We are only going to deal with horizontal painting
        if (progressBar.getOrientation() != JProgressBar.HORIZONTAL) {
            super.paintDeterminate(g, c);
            return;
        }

    
        Insets b = progressBar.getInsets(); // area for border
        int barRectWidth = progressBar.getWidth() - (b.right + b.left);
        int barRectHeight = progressBar.getHeight() - (b.top + b.bottom);

        if (barRectWidth <= 0 || barRectHeight <= 0) {
            return;
        }

        int amountFull = getAmountFull(b, barRectWidth, barRectHeight);


        g.setClip(b.left, b.top, amountFull, barRectHeight);


        int offset = 0;
        if (direction == AnimationDirection.RIGHT_TO_LEFT) {
            offset = (int) (map(getAnimationIndex(), 0, numFrames, barImage.getWidth(), 0));
        }
        else {
            offset = (int) (map(getAnimationIndex(), 0, numFrames, 0, barImage.getWidth()));
        }

        // How many repetitions of the image need to be drawn to ensure that
        // a full progress bar has no gaps in the image?
        int numRepetitions = progressBar.getWidth() / barImage.getWidth();
        // ensure both sides have full coverage just to be safe
        numRepetitions += 2;

        for (int i = 0; i < numRepetitions; i++) {
         
            int xOffset = (i - 1) * barImage.getWidth() + offset;
            g.drawImage(barImage, xOffset, 0, null);
        }
    }

    public static double map(double value, double low1, double high1, double low2, double high2) {

        double diff = value - low1;
        double proportion = diff / (high1 - low1);

        return lerp(low2, high2, proportion);
    }

    /** Linearly interpolate between two values */
    public static double lerp(double value1, double value2, double amt) {
        return ((value2 - value1) * amt) + value1;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel() {
            {
                JProgressBar bar = new JProgressBar();
                bar.setBorder(BorderFactory.createEtchedBorder());
                bar.setForeground(Color.red);
                final IllusionProgressBarUI ui = new IllusionProgressBarUI();
                bar.setUI(ui);
                bar.setValue(75);
                add(bar);

                JRadioButton leftToRight = new JRadioButton(new AbstractAction("Left to right") {
                    public void actionPerformed(ActionEvent e) {
                        ui.setDirection(AnimationDirection.LEFT_TO_RIGHT);
                    }
                });
                JRadioButton rightToLeft = new JRadioButton(new AbstractAction("Right to left") {
                    public void actionPerformed(ActionEvent e) {
                        ui.setDirection(AnimationDirection.RIGHT_TO_LEFT);
                    }
                });

                ButtonGroup mutuallyExclusiveButtons = new ButtonGroup();
                mutuallyExclusiveButtons.add(leftToRight);
                mutuallyExclusiveButtons.add(rightToLeft);
                rightToLeft.setSelected(true);


                add(leftToRight);
                add(rightToLeft);

            }
        };
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}