package ventanas;

import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

class ImagenPanel extends JPanel{
	
	protected static final long serialVersionUID = 1L;
	protected Image img;
	
	public ImagenPanel(String img) {
		this(new ImageIcon(img).getImage());
	}

	public ImagenPanel(Image image) {
		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(new BorderLayout());
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}
