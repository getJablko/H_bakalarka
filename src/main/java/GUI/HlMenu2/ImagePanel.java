package GUI.HlMenu2;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.Image;

public class ImagePanel extends JPanel {
    private ImageIcon backgroundImage;

    public ImagePanel(ImageIcon backgroundImage) {
        this.backgroundImage = resizeImageIcon(backgroundImage, 785, 460); // Set desired width and height
        setPreferredSize(new Dimension(this.backgroundImage.getIconWidth(), this.backgroundImage.getIconHeight()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage.getImage(), 0, 0, this);
        }
    }

    private ImageIcon resizeImageIcon(ImageIcon imageIcon, int width, int height) {
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }
}