package gameoflife;

// Import the Scanner and File Reader with the Exception Handler so that the file can be looked for and handled if not found.
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class GameOfLife {
    
    // Global Arrays, second way to do 
    public int [][] Arrayin = new int[10][10];      //The First Array which will take the data from ReadFile
    public int [][] ArrayOut = new int[10][10];     //The Second Array which will take the modified Data from Array1

    
    public static void main(String[] args){

        //create an instance of object
        GameOfLife funcObj = new GameOfLife();
        
        //call instance method using object
        funcObj.ReadMethod();
        
        // For loop which will run the Array1 into Array2 and print out the Generation Results
        for(int r = 1; r < 11; r++) {
            // Put Generation Header above the printed data
            System.out.println("\n" + "Generation  "+ r);
            // Calling the Methods
            funcObj.NextGen();
            funcObj.CopyBoard();
        }

    }

    
    public void ReadMethod() {
        int nCell = 0;
        int row = 0;
        int col = 0;
        char c;
        try {
            Scanner read = new Scanner(new FileReader("C:\\Users\\Saad\\Downloads\\data.txt"));
            
            //while (sc.hasNextLine()) { 
            for(row =0 ; row < 10; row++) {
                String line = read.next();
                System.out.println(line);


                    for ( col = 0; col < line.length(); col++) {

                        c = line.charAt(col);
                        nCell = Character.getNumericValue(c);
                        Arrayin[row][col] = nCell;
                        //System.out.println(line.charAt(i));
                        //System.out.println(" Array Row " + row + "ArrayCol: " + col + "=" +  Arrayin[row][col]); Test Procedure

                    }


               }
            read.close();
        
        // Catch for Exception Handling for File Not Found Exception    
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }



    }

    public void NextGen() {
        int nCell = 0;
        int row = 0;
        int col = 0;
        int count;

            for(row =0 ; row < 10; row++) {
                  for ( col = 0; col < 10; col++) {

                      // Case when cell is live - 1
                      count = 0;
                      if (Arrayin[row][col] == 1) {
                          if (col !=0 && row != 0) count = count + Arrayin[row-1][col-1];
                          if (row !=0) count = count + Arrayin[row-1][col] ;
                          if (col != 9 && row != 0) count = count +  Arrayin[row-1][col+1];

                          if (col !=0) count = count + Arrayin[row][col-1];
                          if (col != 9) count = count + Arrayin[row][col + 1];

                          if (col != 0  && row != 9) count = count +  Arrayin[row+1][col-1];
                          if (row !=9) count = count + Arrayin[row+1][col] ;
                          if ( row != 9 && col != 9) count = count + Arrayin[row+1][col+1] ;

                          if (count >=2 && count <=3) {
                              ArrayOut[row][col] = 1;
                          }
                          else ArrayOut[row][col] = 0;
                      }
                      // case when cell is dead  - 0
                      else{
                          // Same out of bounds rules as Living cells
                          if (col !=0 && row != 0) count = count + Arrayin[row-1][col-1];
                          if (row !=0) count = count + Arrayin[row-1][col] ;
                          if (col != 9 && row != 0) count = count +  Arrayin[row-1][col+1];

                          if (col !=0) count = count + Arrayin[row][col-1];
                          if (col != 9) count = count + Arrayin[row][col + 1];

                          if (col != 0  && row != 9) count = count +  Arrayin[row+1][col-1];
                          if (row !=9) count = count + Arrayin[row+1][col] ;
                          if ( row != 9 && col != 9) count = count + Arrayin[row+1][col+1] ;

                          if (count ==3) {
                              ArrayOut[row][col] = 1;
                          }
                          else ArrayOut[row][col] = 0;


                      }

                    //System.out.println(line.charAt(i));
                    //System.out.println(" Array Row " + row + "ArrayCol: " + col + "Array Out =" +  ArrayOut[row][col]);
                      System.out.print(ArrayOut[row][col]);
                      
                }
            //Seperate the Rows into different lines
            System.out.println("   ");

            }



    }
    
    public void CopyBoard() {
        int row = 0;
        int col = 0;
        // For loop is created so that the Arrayin values can be inputs for the ArrayOut
        for (row = 0; row < 10; row++) {
            for (col = 0; col < 10; col++) {
                Arrayin[row][col] = ArrayOut[row][col];

            }
        }
    }
}// end class Game Of Life