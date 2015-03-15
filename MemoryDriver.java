import javax.swing.JOptionPane;

public class MemoryDriver
   {
   public static void main( String[] args )
      {
      Memory game = new Memory( 0,0 );
      int height = 1;
      int width = 1;
      int failure = 0;
      System.out.println( "input the height and width of your desired Table\n" );
      while( (height*width)%2 != 0 )
         {
         String heightNum = JOptionPane.showInputDialog( "Enter Height of Table" );
         String widthNum = JOptionPane.showInputDialog( "Enter Width of Table" );
         height = Integer.parseInt( heightNum );
         width = Integer.parseInt( widthNum );
         if( (height*width)%2 != 0 )
            {
            failure++;
            System.out.println( "There must be an even amount of cards..." );
            } // end if odd
         if( (height*width) >= 200 )
            {
            failure++;
            System.out.println( "The size of the table is too big........" );
            } // end if too large
         if( height <= 0 || width <= 0 )
            {
            failure++;
            System.out.println( "No 0's or negative numbers allowed......" );
            } // end if too small
         if( (height*width)%2 != 0 || (height*width) >= 200 || height <= 0 || width <= 0 )
            {
            System.out.println( "\nPlease input height and width again.....\n" +
                                "number of input failures: " + failure + "\n" );
            height = 1;
            width = 1;
            } // end if mistake
         else
            {
            game = new Memory( height, width );
            } // end else mistake
         } // end while
      
      game.setCards();   
      
      String p1Name = JOptionPane.showInputDialog( "Enter Player 1 Name" );
      String p2Name = JOptionPane.showInputDialog( "Enter Player 2 Name" );
      game.setNames( p1Name, p2Name );
      
      String whosFirst;
      do
         {
         whosFirst = JOptionPane.showInputDialog( "Who goes first?\n" + 
                        game.getName1() + " or " + game.getName2() );
         if(  !whosFirst.equals( game.getName1() ) && !whosFirst.equals( game.getName2() ) )
            {
            System.out.println( "Please input one of the player names... not some... nonsense!" );
            } // end if
         } while( !whosFirst.equals( game.getName1() ) && !whosFirst.equals( game.getName2() ) );
      game.setTurn( whosFirst );
      
      //game.printCards(); // set to private
      //game.printTable(); // set to private
      
      game.playGame();
      game.printWinner();
      } // end method main
   } // end class MemoryDriver