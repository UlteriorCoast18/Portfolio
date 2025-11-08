
package Libraries;

 import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelTransparente extends JLabel implements Serializable{

public panelTransparente(Color c){
 setBackground(c);
}

@Override
protected void paintComponent(Graphics g) {
 Graphics2D g2 = (Graphics2D) g;
 g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
 RenderingHints.VALUE_INTERPOLATION_BILINEAR);
 AlphaComposite old = (AlphaComposite) g2.getComposite();
 g2.setComposite(AlphaComposite.SrcOver.derive(0.4f));
 super.paintComponent(g);
 g2.setComposite(old);
}

}