package main.java;

// Java AWT Toolkit Program
import java.awt.*;
import java.awt.image.BufferStrategy;

// Driver Class
public class BufferDemo {
    // main function
    public static void main(String[] args)
    {
        Frame frame = new Frame("Double Buffering Example");
        frame.setSize(400, 400);
        frame.setVisible(true);

        Canvas canvas = new Canvas();
        frame.add(canvas);

        // Using double buffering
        canvas.createBufferStrategy(2);

        BufferStrategy bufferStrategy
                = canvas.getBufferStrategy();

        while (true) {
            Graphics g = bufferStrategy.getDrawGraphics();

            // Perform drawing operations on the off-screen
            // buffer
            g.setColor(Color.yellow);
            g.fillRect(0, 0, canvas.getWidth(),
                    canvas.getHeight());
            g.setColor(Color.BLUE);
            g.fillRect(50, 50, 100, 100);

            g.dispose();

            bufferStrategy.show();
        }
    }
}
