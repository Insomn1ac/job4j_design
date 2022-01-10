package ru.job4j.design.lspviolations;

class AviaSimulator2D implements AviaSim {
    private int x;
    private int y;

    public AviaSimulator2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void setCoords(int width, int depth) {
        setX(width);
        setY(depth);
    }

    @Override
    public void setCoords(int width, int depth, int height) {

    }
}

class AviaSimulator3D extends AviaSimulator2D {
    private int z;

    public AviaSimulator3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public void setCoords(int width, int depth, int height) {
        setX(width);
        setY(depth);
        setZ(height);
    }
}

class Fly {
    public static String validation(AviaSim avia) {
        if (avia instanceof AviaSimulator2D) {
            return "2D";
        } else {
            return "3D";
        }
    }

    public static void fly(AviaSim avia) {
        if ("2D".equals(validation(avia))) {
            avia.setCoords(3, 2);
            System.out.println("We're flying in 2D!");
        } else if ("3D".equals(validation(avia))) {
            avia.setCoords(3, 2, 1);
            System.out.println("We're flying in 3D!");
        }
    }

    public static void main(String[] args) {
        AviaSimulator2D correct = new AviaSimulator3D(2, 4, 3);
        fly(correct);
    }
}
