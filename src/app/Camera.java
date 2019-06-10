package app;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Camera implements KeyListener {
    public double xPos, yPos, xDir, yDir, xPlane, yPlane;
    public boolean left, right, forward, back;
    public final double MOVE_SPEED = 0.08;
    public final double ROTATION_SPEED = 0.045;

    public Camera(double x, double y, double xd, double yd, double xp, double yp) {
        xPos = x;
        yPos = y;
        xDir = xd;
        yDir = yd;
        xPlane = xp;
        yPlane = yp;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO: Add your code
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO: Add your code
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    public void update(int[][] map) {
        if(forward) {
            // TODO: Add your code
        }
        if(back) {
            // TODO: Add your code
        }
        /*
        For Left and Right, we have to rotate the character
        To do this, we use the rotation matrix (multiply)
        [ cos(ROTATION_SPEED) -sin(ROTATION_SPEED) ]
        [ sin(ROTATION_SPEED)  cos(ROTATION_SPEED) ]
        */
        if(right) {
            // Rotate View
            double oldxDir = xDir;
            xDir = xDir * Math.cos(-ROTATION_SPEED) - yDir * Math.sin(-ROTATION_SPEED);
            yDir = oldxDir * Math.sin(-ROTATION_SPEED) + yDir * Math.cos(-ROTATION_SPEED);

            // Update Viewport Area
            double oldxPlane = xPlane;
            xPlane = xPlane * Math.cos(-ROTATION_SPEED) - yPlane * Math.sin(-ROTATION_SPEED);
            yPlane = oldxPlane * Math.sin(-ROTATION_SPEED) + yPlane * Math.cos(-ROTATION_SPEED);
        }
        if(left) {
            // Rotate View
            double oldxDir=xDir;
            xDir=xDir*Math.cos(ROTATION_SPEED) - yDir*Math.sin(ROTATION_SPEED);
            yDir=oldxDir*Math.sin(ROTATION_SPEED) + yDir*Math.cos(ROTATION_SPEED);

            // Update Viewport Area
            double oldxPlane = xPlane;
            xPlane=xPlane*Math.cos(ROTATION_SPEED) - yPlane*Math.sin(ROTATION_SPEED);
            yPlane=oldxPlane*Math.sin(ROTATION_SPEED) + yPlane*Math.cos(ROTATION_SPEED);
        }
    }
}