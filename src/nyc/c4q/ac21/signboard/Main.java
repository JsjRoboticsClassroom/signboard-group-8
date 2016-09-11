package nyc.c4q.ac21.signboard;

import java.util.Random;

public class Main {

    //Color method that can be used in other methods
    public static void colorAdd (SignBoard.Frame frame) {

        Random random = new Random ();
        int color = random.nextInt(4);
        if (color == 0)
            frame.setGreen();
        else if (color == 1)
            frame.setRed();
        else if (color == 2)
            frame.setWhite();
        else
            frame.setYellow();

    }


    //CODE BELOW IS NOT BEING USED
    /**
     * Draws a scene with a scrolling multicolor zig-zag ribbon.
     * @param board
     *   The board on which to draw.
     * @param numCycles
     *   The number of cycles to draw for.
     */
    public static void ribbonScene(SignBoard board, int numCycles) {
        int width = board.getWidth();
        int height = board.getHeight();
        for (int i = 0; i < numCycles; ++i) {
            SignBoard.Frame frame = board.newFrame();

            for (int x = -2; x < width; ++x) {
                int y = (2 * height - 2 + x + i) % (2 * height - 2);
                if (y >= height)
                    y = 2 * height - y - 2;
                if (0 < x) {
                    frame.setYellow();
                    frame.write(x, y, "*");
                }
                if (0 < x + 1 && x + 1 < width) {
                    frame.setGreen();
                    frame.write(x + 1, y, "*");
                }
                if (x + 2 < width) {
                    frame.setRed();
                    frame.write(x + 2, y, "*");
                }
            }

            frame.finish(0.02);
        }
    }


    //SCROLLING ONE LINER TEXT
    /**
     * Draws a scene with text scrolling across the screen..
     * @param board
     *   The board on which to draw.
     * @param text
     *   The text to scroll.
     */
    public static void simpleText(SignBoard board, String text) {
        int width = board.getWidth();
        int y = board.getHeight() / 2;
        for (int x = -text.length(); x <= width; ++x) {
            SignBoard.Frame frame = board.newFrame();

            if (x >= width)
                break;

            if (x < 0)
                // Scrolling on to the left side.
                frame.write(0, y, text.substring(-x));
            else if (x + text.length() <= width)
                // Fully on the board.
                frame.write(x, y, text);
            else
                // Scrolling off the board.
                frame.write(x, y, text.substring(0, width - x));

            frame.finish(0.10);
        }
    }

    //R2D2 IMAGE
    public static void R2D2(SignBoard board) {

        String txt1 = "     .---.          \"meep moop, meep moop\"   ";
        String txt2 = "   .'_:___\".                                 ";
        String txt3 = "   |__ --==|      (must get out of endless   ";
        String txt4 = "   [  ]  :[|       dessert and get ice cream)";
        String txt5 = "   |__| I=[|                                 ";
        String txt6 = "   / / ____|                                 ";
        String txt7 = "  |-/.____.'                                 ";
        String txt8 = " /___\\ /___\\                                 ";

        int width = board.getWidth();
        int y = board.getHeight() / 2;
        for (int x = -txt8.length(); x <= width; ++x) {
            SignBoard.Frame frame = board.newFrame();

            if (x >= width)
                break;

            if (x < 0) {
                // Scrolling on to the left side.
                frame.write(0, y/2 - 2, txt1.substring(-x));
                frame.write(0, y/2 - 1, txt2.substring(-x));
                frame.write(0, y/2, txt3.substring(-x));
                frame.write(0, y/2 + 1, txt4.substring(-x));
                frame.write(0, y/2 + 2, txt5.substring(-x));
                frame.write(0, y/2 + 3, txt6.substring(-x));
                frame.write(0, y/2 + 4, txt7.substring(-x));
                frame.write(0, y/2 + 5, txt8.substring(-x));
            }
            else if (x + txt8.length() <= width) {
                // Fully on the board.
                frame.write(x, y/2 - 2, txt1);
                frame.write(x, y/2 - 1, txt2);
                frame.write(x, y/2, txt3);
                frame.write(x, y/2 + 1, txt4);
                frame.write(x, y/2 + 2, txt5);
                frame.write(x, y/2 + 3, txt6);
                frame.write(x, y/2 + 4, txt7);
                frame.write(x, y/2 + 5, txt8);
            }
            else {
                // Scrolling off the board.
                frame.write(x, y/2 - 2, txt1.substring(0, width - x));
                frame.write(x, y/2 - 1, txt2.substring(0, width - x));
                frame.write(x, y/2, txt3.substring(0, width - x));
                frame.write(x, y/2 + 1, txt4.substring(0, width - x));
                frame.write(x, y/2 + 2, txt5.substring(0, width - x));
                frame.write(x, y/2 + 3, txt6.substring(0, width - x));
                frame.write(x, y/2 + 4, txt7.substring(0, width - x));
                frame.write(x, y/2 + 5, txt8.substring(0, width - x));
            }
            frame.finish(0.07);
        }
    }

    //THIS CODE NOT BEING USED
    /**
     * Draws a scene which flashes the words "FRESH" and "HOT".
     * @param board
     *   The board on which to draw.
     * @param cycles
     *   The number of cycles to draw for.
     */
    public static void flashFreshHotScene(SignBoard board, int cycles) {
        Random random = new Random();
        int width = board.getWidth();
        int leftPosition = width / 4 - 12;
        int rightPosition = 3 * width / 4 - 7;
        int y = board.getHeight() / 2;

        for (int i = 0; i < cycles * 2; ++i) {
            SignBoard.Frame frame = board.newFrame();

            // Choose a color at random.
            int color = random.nextInt(4);
            if (color == 0)
                frame.setGreen();
            else if (color == 1)
                frame.setRed();
            else if (color == 2)
                frame.setWhite();
            else
                frame.setYellow();
            // Write a word.
            if (i % 2 == 0) {
                frame.write(leftPosition, y - 2, "  __    ___  ____  ");
                frame.write(leftPosition, y - 1, " (  )  / __)(  __)");
                frame.write(leftPosition, y    , "  )(  ( (__  ) _) ");
                frame.write(leftPosition, y + 1, " (__)  \\ ___)(____)");
                //frame.write(leftPosition, y + 2, "F    R  R EEEE SSS  H  H");
            }
            else {
                frame.write(rightPosition, y - 2, "  ___  ____  ____   __   _  _      ");
                frame.write(rightPosition, y - 1, " / __)(  _ \\ (  __) / _\\  ( \\ / )  ");
                frame.write(rightPosition, y    , "( (__  )   / ) _) /    \\ / \\ / \\   ");
                frame.write(rightPosition, y + 1, " \\ ___)(__\\ _)(____)\\ _/\\ _/\\ _)(_/");
                //frame.write(rightPosition, y + 2, "H  H  OO   TT ");
            }

            frame.finish(1.20);
        }
    }

    //ICE CREAM TEXT W/ ICE CREAM CONES ON THE SIDE
    public static void iceCreamCones (SignBoard board) {

        Random random = new Random();
        int width = board.getWidth();
        int y = board.getHeight() / 2;
        int middlePosition = width - 76;

        String Str0 = "    .-\"`\'\"-. ";
        String Str1 = "  /          \\ ";
        String Str2 = "  \\          / ";
        String Str3 = "  / '---'--` \\ ";
        String Str4 = "  \\_.--.__.-./ ";
        String Str5 = "    [=-=-=-] ";
        String Str6 = "     |=-=-| ";
        String Str7 = "     '-==-' ";

        String Txt1 = "   __    ___  ____ ";
        String Txt2 = "  (  )  / __)(  __) ";
        String Txt3 = "   )(  ( (__  ) _) ";
        String Txt4 = "  (__)  \\___)(____) ";
        String Txt5 = "   ___  ____  ____   __   _  _ ";
        String Txt6 = "  / __)(  _ \\(  __) / _\\ ( \\/ ) ";
        String Txt7 = " ( (__  )   / ) _) /    \\/ \\/ \\ ";
        String Txt8 = "  \\___)(__\\_)(____)\\_/\\_/\\_)(_/ ";

        //int i = 0;
        for (int i = 0 ; i < 20; i++) {

            SignBoard.Frame frame = board.newFrame();

            colorAdd(frame);

                    //ice cream on left
                    frame.write(0, y/2 - 2, Str0);
                    frame.write(0, y/2 - 1, Str1);
                    frame.write(0, y/2, Str2);
                    frame.write(0, y/2 + 1, Str3);
                    frame.write(0, y/2 + 2, Str4);
                    frame.write(0, y/2 + 3, Str5);
                    frame.write(0, y/2 + 4, Str6);
                    frame.write(0, y/2 + 5, Str7);

                    //ice cream on right
                    frame.write(width - 15, y/2 - 2, Str0);
                    frame.write(width - 15, y/2 - 1, Str1);
                    frame.write(width - 15, y/2, Str2);
                    frame.write(width - 15, y/2 + 1, Str3);
                    frame.write(width - 15, y/2 + 2, Str4);
                    frame.write(width - 15, y/2 + 3, Str5);
                    frame.write(width - 15, y/2 + 4, Str6);
                    frame.write(width - 15, y/2 + 5, Str7);

            frame.setWhite();
                    //ice cream text in middle
                    frame.write(middlePosition, y/2 - 2, Txt1);
                    frame.write(middlePosition, y/2 - 1, Txt2);
                    frame.write(middlePosition, y/2, Txt3);
                    frame.write(middlePosition, y/2 + 1, Txt4);
                    frame.write(middlePosition, y/2 + 2, Txt5);
                    frame.write(middlePosition, y/2 + 3, Txt6);
                    frame.write(middlePosition, y/2 + 4, Txt7);
                    frame.write(middlePosition, y/2 + 5, Txt8);

            frame.finish(.2);
        }

    }

    //Scrolling Ice Cream Text, bottom to top
    public static void scrollingCream(SignBoard board) {

        Random random = new Random();


        String txt1 = " 88    ,ad8888ba,   88888888888        ,ad8888ba,   88888888ba   88888888888         db         88b           d88 ";
        String txt2 = " 88   d8\"'    `\"8b  88                d8\"'    `\"8b  88      \"8b  88                 d88b        888b         d888 ";
        String txt3 = " 88  d8'            88               d8'            88      ,8P  88                d8'`8b       88`8b       d8'88 ";
        String txt4 = " 88  88             88aaaaa          88             88aaaaaa8P'  88aaaaa          d8'  `8b      88 `8b     d8' 88 ";
        String txt5 = " 88  88             88\"\"\"\"\"          88             88\"\"\"\"88'    88\"\"\"\"\"         d8YaaaaY8b     88  `8b   d8'  88 ";
        String txt6 = " 88  Y8,            88               Y8,            88    `8b    88             d8\"\"\"\"\"\"\"\"8b    88   `8b d8'   88 ";
        String txt7 = " 88   Y8a.    .a8P  88                Y8a.    .a8P  88     `8b   88            d8'        `8b   88    `888'    88 ";
        String txt8 = " 88    `\"Y8888Y\"'   88888888888        `\"Y8888Y\"'   88      `8b  88888888888  d8'          `8b  88     `8'     88 ";

        int width = board.getWidth();
        int y = board.getHeight() / 2;
        for (int x = -txt8.length(); x <= width; ++x) {
            SignBoard.Frame frame = board.newFrame();

            //color
            int color = random.nextInt(4);
            if (color == 0)
                frame.setGreen();
            else if (color == 1)
                frame.setRed();
            else if (color == 2)
                frame.setWhite();
            else
                frame.setYellow();

            if (x >= width)
                break;

            if (x < 0) {
                // Scrolling on to the left side.
                frame.write(0, y/2 - 2, txt1.substring(-x));
                frame.write(0, y/2 - 1, txt2.substring(-x));
                frame.write(0, y/2, txt3.substring(-x));
                frame.write(0, y/2 + 1, txt4.substring(-x));
                frame.write(0, y/2 + 2, txt5.substring(-x));
                frame.write(0, y/2 + 3, txt6.substring(-x));
                frame.write(0, y/2 + 4, txt7.substring(-x));
                frame.write(0, y/2 + 5, txt8.substring(-x));
                frame.finish(.04);
            }
            else if (x + txt8.length() <= width) {
                // Fully on the board.
                frame.write(x, y/2 - 2, txt1);
                frame.write(x, y/2 - 1, txt2);
                frame.write(x, y/2, txt3);
                frame.write(x, y/2 + 1, txt4);
                frame.write(x, y/2 + 2, txt5);
                frame.write(x, y/2 + 3, txt6);
                frame.write(x, y/2 + 4, txt7);
                frame.write(x, y/2 + 5, txt8);
                if (x + txt8.length() == width-3)
                    frame.finish(1.00);
                else
                    frame.finish(.04);
            }
            else {
                // Scrolling off the board.
                frame.write(x, y/2 - 2, txt1.substring(0, width - x));
                frame.write(x, y/2 - 1, txt2.substring(0, width - x));
                frame.write(x, y/2, txt3.substring(0, width - x));
                frame.write(x, y/2 + 1, txt4.substring(0, width - x));
                frame.write(x, y/2 + 2, txt5.substring(0, width - x));
                frame.write(x, y/2 + 3, txt6.substring(0, width - x));
                frame.write(x, y/2 + 4, txt7.substring(0, width - x));
                frame.write(x, y/2 + 5, txt8.substring(0, width - x));
                frame.finish(.04);
            }

        }
    }

    //THIS IS WHERE METHODS GET ACTIVATED/DEACTIVATED
    public static void main(String[] args) {
        SignBoard signBoard = new SignBoard(8);

        // Run the sign board forever.
        while (true) {
            scrollingCream(signBoard); //this scrolling text, left to middle, stop then right
            R2D2(signBoard); //this is R2D2
            iceCreamCones(signBoard); // text w/ two cones on the side
        }
    }
}
