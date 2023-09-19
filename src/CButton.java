import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CButton extends JButton implements MouseListener {
    private Point imageStartLocation;
    private  Color backgroundColor;
    private String buttonText;
    private final int arc;
    private boolean hasText = false;
    private ImageIcon imageIcon;

    private CButton(Color backgroundColor, int arc){
        this.backgroundColor = backgroundColor;
        this.arc = arc;
        this.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.addMouseListener(this);
    }
    public CButton(ImageIcon imageIcon, Point imageStartLocation, Color backgroundColor, int arc){
        this( backgroundColor, arc);
        this.imageIcon = imageIcon;
        this.imageStartLocation = imageStartLocation;
    }
    public CButton(int buttonNumber, Color backgroundColor, int arc){
        this(backgroundColor, arc);
        this.buttonText = String.valueOf(buttonNumber);
        this.setText(this.buttonText);
        this.hasText = true;
        this.setBorder(new EmptyBorder(19, 43,0,0));
    }
    /*public CButton(String buttonText, Point textStartLocation, Color backgroundColor, int arc){
        this(backgroundColor, arc);
        this.buttonText = buttonText;
        this.hasText = true;
        this.setBorder(new EmptyBorder(textStartLocation.y,textStartLocation.x,0,0));
    }
*/
    @Override
    public void mouseClicked(MouseEvent e) {
        this.backgroundColor = this.backgroundColor.darker();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.backgroundColor = this.backgroundColor.brighter();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        this.backgroundColor = this.backgroundColor.darker(); // Glitch occurs
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.backgroundColor = this.backgroundColor.darker();
//        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.backgroundColor = this.backgroundColor.brighter();
//        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        graphics2D.setPaint(backgroundColor);
        graphics2D.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), arc, arc);

        if (hasText){
            graphics2D.setPaint(new Color(0x1A1A1A));
            graphics2D.drawString(buttonText, getInsets().left, graphics.getFontMetrics().getMaxAscent() + getInsets().top);
        }else
            graphics2D.drawImage(imageIcon.getImage(), imageStartLocation.x, imageStartLocation.y, null);
    }
    @Override
    protected void paintBorder(Graphics g) {
        // Do nothing to prevent painting the default border
    }
}
