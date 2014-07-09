package com.jag.gui;
import java.awt.AWTEvent;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import com.jag.graphics.PolyLine;


/**
 * This custom component allows the user to scribble, and retains the scribbles
 * so that they can be redrawn when needed.  It uses the PolyLine custom Shape
 * implementation defined elsewhere in this book, and demonstrates event
 * handling with low-level event processing methods.
 */
public class ScribblePane extends JComponent {
    List lines;             // The PolyLines that comprise this scribble
    PolyLine currentLine;   // The PolyLine currently being drawn
    Stroke stroke;          // How to draw the lines

    public ScribblePane( ) {
        setPreferredSize(new Dimension(450,200)); // We need a default size
        lines = new ArrayList( );                  // Initialize a list of lines
        stroke = new BasicStroke(3.0f);           // Lines are 3 pixels wide

        // Register interest in mouse button and mouse motion events, so
        // that processMouseEvent( ) and processMouseMotionEvent( ) will be 
        // invoked, even if no event listeners are registered.
        enableEvents(AWTEvent.MOUSE_EVENT_MASK |
                     AWTEvent.MOUSE_MOTION_EVENT_MASK);
    }

    /** We override this method to draw ourselves. */
    public void paintComponent(Graphics g) {
        // Let the superclass do its painting first
        super.paintComponent(g);

        // Make a copy of the Graphics context so we can modify it
        // We cast it at the same time so we can use Java2D graphics
        Graphics2D g2 = (Graphics2D) (g.create( )); 

        // Our superclass doesn't paint the background, so do this ourselves.
        g2.setColor(getBackground( ));
        g2.fillRect(0, 0, getWidth( ), getHeight( ));

        // Set the line width and color to use for the foreground
        g2.setStroke(stroke);
        g2.setColor(this.getForeground( ));

        // Now loop through the PolyLine shapes and draw them all
        int numlines = lines.size( );
        for(int i = 0; i < numlines; i++)
            g2.draw((PolyLine)lines.get(i));
    }

    /**
     * Erase all lines and repaint.  This method is for the convenience of
     * programs that use this component.
     */
    public void clear( ) {
        lines.clear( );
        repaint( );
    }

    /**
     * We override this method to receive notification of mouse button events.
     * See also the enableEvents( ) call in the constructor method.
     */
    public void processMouseEvent(MouseEvent e) {
        // If the type and button are correct, then process it.
        if (e.getButton( ) == MouseEvent.BUTTON1) {
            if (e.getID( ) == MouseEvent.MOUSE_PRESSED) {
                // Start a new line on mouse down
                currentLine = new PolyLine(e.getX( ), e.getY( ));
                lines.add(currentLine);
                e.consume( );
            }
            else if (e.getID( ) == MouseEvent.MOUSE_RELEASED) {
                // End the line on mouse up
                currentLine = null;
                e.consume( );
            }
        }

        // The superclass method dispatches to registered event listeners
        super.processMouseEvent(e);
    }

    /**
     * We override this method to receive notification of mouse motion events.
     */
    public void processMouseMotionEvent(MouseEvent e) {
        if (e.getID( ) == MouseEvent.MOUSE_DRAGGED && // If we're dragging
            currentLine != null) {                   // and a line exists
            currentLine.addSegment(e.getX( ), e.getY( ));  // Add a line segment
            e.consume( );

            // Redraw the whole component.
            // Exercise: optimize this by passing the bounding box
            // of the region that needs redrawing to the repaint( ) method.
            // Don't forget to take line width into account, however.
            repaint( );
        }

        super.processMouseMotionEvent(e);
    }
}
