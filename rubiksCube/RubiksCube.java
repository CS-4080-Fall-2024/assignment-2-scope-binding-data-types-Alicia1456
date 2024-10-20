package rubiksCube;

public class RubiksCube {

    // enum of colors
    public enum Color {W, Y, B, G, O, R}

    // 2D arrays to represent the faces
    private Color[][] frontFace;
    private Color[][] backFace;
    private Color[][] upperFace;
    private Color[][] rightFace;
    private Color[][] leftFace;
    private Color[][] downFace;
    private int size;

    // Create the faces
    public RubiksCube(int size) {
        this.size = size;
        frontFace = new Color[size][size];
        backFace = new Color[size][size];
        upperFace = new Color[size][size];
        rightFace = new Color[size][size];
        leftFace = new Color[size][size];
        downFace = new Color[size][size];
        
        createFace(size);
    }

    public int getSize() {
        return size;
    }

    // Fills in the 2D arrays with their corresponding color
    // Will start off as a solved cube
    private void createFace(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                frontFace[i][j] = Color.R;
                backFace[i][j] = Color.O;
                upperFace[i][j] = Color.W;
                rightFace[i][j] = Color.G;
                leftFace[i][j] = Color.B;
                downFace[i][j] = Color.Y;

            }
        }
    }

    // Print out what the Rubik's Cube looks like unfolded
    public void printRubik() {

        printFace(upperFace);
        System.out.println("");
        printAdjacentFaces();
        System.out.println("");
        printFace(downFace);
    }

    // Prints a single face
    private void printFace(Color[][] face) {
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                System.out.print("  ");
            }
            for (int j = 0; j < size; j++) {
                System.out.print(face[i][j] + " ");
            }

            if (i != size - 1) {
                System.out.println("");
            } 
                
        }
    }

    // Prints out the faces that are next to each other when unfolded (i.e. left, front, right, and back)
    private void printAdjacentFaces() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(leftFace[i][j] + " ");
            }
            for (int j = 0; j < size; j++) {
                System.out.print(frontFace[i][j] + " ");

            }
            for (int j = 0; j < size; j++) {
                System.out.print(rightFace[i][j] + " ");
            }
            for (int j = 0; j < size; j++) {
                System.out.print(backFace[i][j] + " ");
            }
            
            if (i != size - 1) {
                System.out.println("");
            } 
        }
    }


}