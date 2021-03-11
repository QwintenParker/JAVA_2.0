import java.awt.*;
import java.awt.event.MouseEvent;

public class Door {

    public double x1;
    public double y1;
    public double width;
    public double height;
    public double x2;
    public double y2;
    public int nX;
    public int nY;
    public Character character;
    public int doorPart;
    public boolean door1;
    public boolean door2;

    public Door(double x1, double y1, double width, double height, double x2, double y2, int nX, int nY, Character character) {
        this.x1 = x1;
        this.y1 = y1;
        this.width = width;
        this.height = height;
        this.x2 = x2;
        this.y2 = y2;
        this.character = character;
        this.nX = nX;
        this.nY = nY;
        this.doorPart = 0;
    }

    public void checkObjects() {

        if (character.x >= this.x1 && character.x <= this.x1 + width && character.y + character.height - 7 >= this.y1 && character.y + 7 <= this.y1 + height) {
            character.x = x1 + width;
            doorPart = 1;
            door1 = true;
        }

        if (character.x >= this.x2 && character.x <= this.x2 + width && character.y + character.height - 7 >= this.y2 && character.y + 7 <= this.y2 + height) {
            character.x = x2 + width;
            doorPart = 1;
            door2 = true;
        }

        if (character.x + character.width >= this.x1 && character.x + character.width <= this.x1 + width && character.y + character.height - 7 >= this.y1 && character.y + 7 <= this.y1 + height) {
            character.x = x1 - 50;
            doorPart = 3;
            door1 = true;
        }

        if (character.x + character.width >= this.x2 && character.x + character.width <= this.x2 + width && character.y + character.height - 7 >= this.y2 && character.y + 7 <= this.y2 + height) {
            character.x = x2 - 50;
            doorPart = 3;
            door2 = true;
        }

        if (character.x + character.width - 7 >= this.x1 && character.x + 7 <= x1 + width && character.y >= y1 && character.y <= y1 + height) {
            character.y = y1 + height;
            doorPart = 2;
            door1 = true;
        }

        if (character.x + character.width - 7 >= this.x2 && character.x + 7 <= x2 + width && character.y >= y2 && character.y <= y2 + height) {
            character.y = y2 + height;
            doorPart = 2;
            door2 = true;
        }

        if (character.x + character.width - 7 >= this.x1 && character.x + 7 <= this.x1 + width && character.y + character.height >= this.y1 && character.y + character.height <= this.y1 + height) {
            character.y = y1 - 50;
            doorPart = 4;
            door1 = true;
        }

        if (character.x + character.width - 7 >= this.x2 && character.x + 7 <= this.x2 + width && character.y + character.height >= this.y2 && character.y + character.height <= this.y2 + height) {
            character.y = y2 - 50;
            doorPart = 4;
            door2 = true;
        }
    }

    public void openDoor(MouseEvent e) {
        if (e.getX() >= x1 && e.getX() <= x1 + width && e.getY() >= y1 && e.getY() <= y1 + height) {
            if (character.x >= x1 - character.width - 5 && character.x + character.width <= x1 + width + character.width + 5 && character.y >= y1 - character.height - 5 && character.y + character.height <= y1 + height + character.height + 5) {
                character.changeL = true;
                character.nX = nX;
                character.nY = nY;
            } else {
                doorPart = 0;
                door1 = false;
            }
        }

        if (e.getX() >= x2 && e.getX() <= 2 + width && e.getY() >= y2 && e.getY() <= y2 + height) {
            if (character.x >= x2 - character.width - 5 && character.x + character.width <= x2 + width + character.width + 5 && character.y >= y2 - character.height - 5 && character.y + character.height <= y2 + height + character.height + 5) {
                character.changeL = true;
                character.nX = nX;
                character.nY = nY;
            } else {
                doorPart = 0;
                door2 = false;
            }
        }
    }

    public void changeLocation(int x) {
            if (x == 1) {
                this.y1 = this.y1 + 1000;
                this.y2 = this.y2 + 1000;
            } else if (x == 2) {
                this.x1 = this.x1 - 1000;
                this.x2 = this.x2 - 1000;
            } else if (x == 3) {
                this.y1 = this.y1 - 1000;
                this.y2 = this.y2 - 1000;
            } else if (x == 4) {
                this.x1 = this.x1 + 1000;
                this.x2 = this.x1 + 1000;
        }
    }

    public void changeNLocation(int nX, int nY) {
        x1 = x1 + 1000 * nX;
        y1 = y1 + 1000 * nY;
        x2 = x2 + 1000 * nX;
        y2 = y2 + 1000 * nY;

        if (door1) {
            if (doorPart == 1) {
                character.x = x2 + width;
                character.y = y2;
            } else if (doorPart == 2) {
                character.x = x2;
                character.y = y2 + height;
            } else if (doorPart == 3) {
                character.x = x2 - 50;
                character.y = y2;
            } else if (doorPart == 4) {
                character.x = x2;
                character.y = y2 - 50;
            }
        }

        if (door2) {
            if (doorPart == 1) {
                character.x = x1 + width;
                character.y = y1;
            } else if (doorPart == 2) {
                character.x = x1;
                character.y = y1 + height;
            } else if (doorPart == 3) {
                character.x = x1 - 50;
                character.y = y1;
            } else if (doorPart == 4) {
                character.x = x1;
                character.y = y1 - 50;
            }
        }
    }

    public void draw(Graphics g) {
        g.setColor(new Color(0x11EF13));
        g.fillRect((int) x1, (int) y1, (int) width, (int) height);
        g.fillRect((int) x2, (int) y2, (int) width, (int) height);
        g.setColor(new Color(0));
        this.checkObjects();
    }
}
