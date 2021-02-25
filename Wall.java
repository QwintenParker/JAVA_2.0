import java.awt.*;
import java.util.ArrayList;

public class Wall {

    public double x;
    public double y;
    public double width;
    public double height;
    public Character character;
    public long previousWorldUpdateTime;
    public double speedX;
    public double speedY;
    public boolean wallL;
    public boolean wallR;
    public boolean wallU;
    public boolean wallD;

    public Wall(double x, double y, Character character, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.character = character;
        this.speedX = 0.2;
        this.speedY = 0.2;
        this.wallL = false;
        this.wallR = false;
        this.wallU = false;
        this.wallD = false;
        this.previousWorldUpdateTime = System.currentTimeMillis();
    }

    public void checkObjects() {

            if (character.x >= this.x && character.x <= this.x + width && character.y + character.height - 7 >= this.y && character.y + 7 <= this.y + height) {
                character.x = x + width;
                System.out.println("LLLLL");
                character.runningX = 0;
            }

            if (character.x + character.width >= this.x && character.x + character.width <= this.x + width && character.y + character.height - 7 >= this.y && character.y + 7 <= this.y + height) {
                character.x = x - 50;
                character.wallR = true;
                System.out.println("RRRRR");
                this.wallR = true;
            }

            if (character.x + character.width - 7 >= this.x && character.x + 7 <= x + width && character.y >= y && character.y <= y + height) {
                character.y = y + height;
                character.wallU = true;
                this.wallU = true;
                System.out.println("UUUUU");
            }

            if (character.x + character.width - 7 >= this.x && character.x + 7 <= this.x + width && character.y + character.height >= this.y && character.y + character.height <= this.y + height) {
                character.y = y - 50;
                character.wallD = true;
                this.wallD = true;
                System.out.println("DDDDD");
            }
    }

    public void update(long dt) {
        /*if (character.wallL) {
            character.stopRunningLeft();
        } else {
            if (character.worldRunL) {
                character.startRunningLeft();
            } else {
                character.stopRunningLeft();
            }
        }


        if (character.wallR) {
            character.stopRunningRight();
        } else {
            if (character.worldRunR) {
                character.startRunningRight();
            } else {
                character.stopRunningRight();
            }
        }

        if (character.wallU) {
            character.stopRunningUp();
        } else {
            if (character.worldRunU) {
                character.startRunningUp();
            } else {
                character.stopRunningUp();
            }
        }

        if (character.wallD) {
            character.stopRunningDown();
        } else {
            if (character.worldRunD) {
                character.startRunningDown();
            } else {
                character.stopRunningDown();
            }
        }*/

        if (character.worldRunL) {
            character.startRunningLeft();
        } else {
            character.stopRunningLeft();
        }

        if (character.worldRunR) {
            character.startRunningRight();
        } else {
            character.stopRunningRight();
        }

        if (character.worldRunU) {
            character.startRunningUp();
        } else {
            character.stopRunningUp();
        }

        if (character.worldRunD) {
            character.startRunningDown();
        } else {
            character.stopRunningDown();
        }

        x -= character.runningX * dt * speedX;
        y -= character.runningY * dt * speedY;
    }



    public void draw(Graphics g) {
        g.drawRect((int) x, (int) y, (int) width, (int) height);
        this.checkObjects();
    }

}