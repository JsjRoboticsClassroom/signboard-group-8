package nyc.c4q.ac21.signboard;

import java.io.IOException;
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
        //int middlePosition = width - 76;
        int middlePosition = width - 105;

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

    //Danny Methods
    public static void iceCreamAnimation(SignBoard board, int cycles) {
        int width = board.getWidth();
        int leftPosition = width / 4 - 12;
        int rightPosition = 2 * width / 4 - 7;
        int y = board.getHeight() / 2;

        for (int i = 0; i < cycles; i++) {
            SignBoard.Frame frame = board.newFrame();

            if (i % 5 == 0) {
                frame.setWhite();
                frame.write(leftPosition, y - 2, "IIIII  CCCC EEEEE");
                frame.write(leftPosition, y - 1, "  I   CC    E    ");
                frame.write(leftPosition, y,     "  I   C     EEEE");
                frame.write(leftPosition, y + 1, "  I   CC    E    ");
                frame.write(leftPosition, y + 2, "IIIII  CCCC EEEEE");
            }
            else if (i % 5 == 1){
                setRandomColor(frame);
                frame.write(rightPosition, y - 2, " CCCC  RRR    EEEEE   AAA   M     M");
                frame.write(rightPosition, y - 1, "CC     R  RR  E      A   A  MM   MM");
                frame.write(rightPosition, y,     "C      RRR    EEEE   AAAAA  M M M M");
                frame.write(rightPosition, y + 1, "CC     R  R   E      A   A  M  M  M");
                frame.write(rightPosition, y + 2, " CCCC  R   R  EEEEE  A   A  M     M");
            }
            else if (i % 5 == 2) {
                frame.setWhite();
                frame.write(leftPosition+5, y - 3, "III CCC EEE");
                frame.write(leftPosition+5, y - 2, " I  C   EE ");
                frame.write(leftPosition+5, y - 1, "III CCC EEE");

            }
            else if (i % 5 == 3) {
                frame.setWhite();
                frame.write(rightPosition+10, y - 4, "IIIII  CCCC EEEEE");
                frame.write(rightPosition+10, y - 3, "  I   CC    E    ");
                frame.write(rightPosition+10, y - 2, "  I   C     EEEE");
                frame.write(rightPosition+10, y - 1, "  I   CC    E    ");
                frame.write(rightPosition+10, y,     "IIIII  CCCC EEEEE");

            }
            else if (i % 5 == 4){
                setRandomColor(frame);
                frame.write(rightPosition - 2, y + 1, "CCC  RRR  EEE   A    M   M");
                frame.write(rightPosition - 2, y + 2, "C    RRR  EE   AAA   MM MM");
                frame.write(rightPosition - 2, y + 3, "CCC  R  R EEE A   A  M M M");
            }

            frame.finish(0.25);
        }
    }


    public static void threeConeScene(SignBoard board) {

        int width = board.getWidth();
        int y = board.getHeight() / 2;

        String str0 = "    ,'/ //\\ ";
        String str1 = "   /// // /)";
        String str2 = "  /// // //|";
        String str3 = " (`: // /// ";
        String str4 = "  `;`: ///  ";
        String str5 = "  / /:`:/   ";
        String str6 = " / /  `'    ";
        String str7 = "(_/         ";

        str0 = stringRepeat(str0, 6);
        str1 = stringRepeat(str1, 6);
        str2 = stringRepeat(str2, 6);
        str3 = stringRepeat(str3, 6);
        str4 = stringRepeat(str4, 6);
        str5 = stringRepeat(str5, 6);
        str6 = stringRepeat(str6, 6);
        str7 = stringRepeat(str7, 6);

        int i = 0;
        for (int x = -str1.length(); x <= width; ++x) {
            SignBoard.Frame frame = board.newFrame();

            if (i == 4)
                i = 0;

            if (x >= width)
                break;

            if (x < 0) {
                // Scrolling on to the left side.
                setColor(frame, i+3);
                frame.write(0, y - 4, str0.substring(-x));
                setColor(frame, i+3);
                frame.write(0, y - 3, str1.substring(-x));
                setColor(frame, i+2);
                frame.write(0, y - 2, str2.substring(-x));
                setColor(frame, i+2);
                frame.write(0, y - 1, str3.substring(-x));
                setColor(frame, i+1);
                frame.write(0, y,     str4.substring(-x));
                setColor(frame, i+1);
                frame.write(0, y + 1, str5.substring(-x));
                setColor(frame, i+0);
                frame.write(0, y + 2, str6.substring(-x));
                setColor(frame, i+0);
                frame.write(0, y + 3, str7.substring(-x));
            }
            else if (x + str1.length() <= width) {
                setColor(frame, i+3);
                frame.write(x, y - 4, str0);

                setColor(frame, i+3);
                frame.write(x, y - 3, str1);

                setColor(frame, i+2);
                frame.write(x, y - 2, str2);

                setColor(frame, i+2);
                frame.write(x, y - 1, str3);

                setColor(frame, i+1);
                frame.write(x, y,     str4);

                setColor(frame, i+1);
                frame.write(x, y + 1, str5);

                setColor(frame, i+0);
                frame.write(x, y + 2, str6);
                setColor(frame, i+0);
                frame.write(x, y + 3, str7);
            }

            else {
                // Scrolling off the board.
                setColor(frame, i+3);
                frame.write(x, y - 4, str0.substring(0, width - x));
                setColor(frame, i+3);
                frame.write(x, y - 3, str1.substring(0, width - x));
                setColor(frame, i+2);
                frame.write(x, y - 2, str2.substring(0, width - x));
                setColor(frame, i+2);
                frame.write(x, y - 1, str3.substring(0, width - x));
                setColor(frame, i+1);
                frame.write(x, y,     str4.substring(0, width - x));
                setColor(frame, i+1);
                frame.write(x, y + 1, str5.substring(0, width - x));
                setColor(frame, i+0);
                frame.write(x, y + 2, str6.substring(0, width - x));
                setColor(frame, i+0);
                frame.write(x, y + 3, str7.substring(0, width - x));
            }
            if (-x % 4 == 0)
                i++;
            frame.finish(0.02);
        }


    }

    public static void fallingConeScene(SignBoard board, FrameTextReader scene1, FrameTextReader scene2) {
        int leftPosition = board.getWidth() / 2 - 24;
        int rightPosition = board.getWidth() / 2 + 15;

        //falling cone animation
        int i = 0;
        while (i < scene1.frameList.size()) {
            SignBoard.Frame frame = board.newFrame();
            setRandomColor(frame);

            for (int j = 0; j < 8; j++) {

                frame.write(rightPosition, j, scene1.frameList.get(i));
                i++;
            }

            frame.finish(0.20);
        }

        //one free scoop words after falling cone animation
        int cycles = 4;
        i = 0;
        while (i < scene2.frameList.size()) {
            SignBoard.Frame frame = board.newFrame();
            setRandomColor(frame);
            int k = 8;
            for (int j = 0; j < 8; j++) {
                frame.write(leftPosition, j, scene2.frameList.get(i));

                frame.write(rightPosition, j, scene1.frameList.get(scene1.frameList.size()-k));
                k--;
                i++;

            }

            if (i == scene2.frameList.size() && cycles != 0) {
                i = 0;
                cycles--;
            }

            frame.finish(.30);
        }
    }

    public static void scrollHugeScene(SignBoard board, FrameTextReader scene1) {
        int width = board.getWidth();
        int y = board.getHeight();

        for (int i = 0; i < scene1.frameList.size() + 8; i++) {
            SignBoard.Frame frame = board.newFrame();
            setRandomColor(frame);

            if (i <= 6) {
                //coming in from the bottom
                int h = 7;
                int f = i;
                for (int g = 0; g <= i; g++) {
                    frame.write(0, h, scene1.frameList.get(f));
                    h--;
                    f--;
                }
            }
            else if (i < scene1.frameList.size()) {
                //scrolling fully on the board
                int k = 7;
                for (int j = 0; j < 8; j++) {
                    frame.write(0, j, scene1.frameList.get(i - k));
                    k--;
                }
            }
            else if (i >= scene1.frameList.size()) { //55
                //scrolling out above the board
                int h = 0;
                int k = i - 7; //k = 55      55 - 7 = 48
                for (int j = scene1.frameList.size() + 7; j > i; j--) { //j = 54+7 = 61, 61 > 55,
                    frame.write(0, h, scene1.frameList.get(k));   //h = 0, k = 48
                    h++;
                    k++;
                }
            }
            frame.finish(.02);
        }
    }

    public static void setRandomColor(SignBoard.Frame frame) {
        Random random = new Random();
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

    public static void setColor(SignBoard.Frame frame, int i) {
        if (i % 4 == 0)
            frame.setGreen();
        else if (i % 4 == 1)
            frame.setRed();
        else if (i % 4 == 2)
            frame.setWhite();
        else
            frame.setYellow();
    }

    public static String stringRepeat(String str, int times) {
        String result = "";
        for (int i = 0; i < times; i++)
            result = result + str;
        return result;
    }

    
    public static void DollarSign(SignBoard board) {
        int width = board.getWidth();
        int y = board.getHeight() / 2;

        String str0 = "    _        _        _    ";
        String str1 = " __|_|___ __|_|___ __|_|___";
        String str2 = "(  _____/(  _____/(  _____/";
        String str3 = "| (|_|__ | (|_|__ | (|_|__ ";
        String str4 = "(_____  )(_____  )(_____  )";
        String str5 = "/\\_|_|) |/\\_|_|) |/\\_|_|) |";
        String str6 = "\\_______)\\_______)\\_______)";
        String str7 = "   |_|      |_|      |_|   ";

        for (int i = 0; i < 10; i++) {
            SignBoard.Frame frame = board.newFrame();

            Random random = new Random();

            int color = random.nextInt(4);
            if (color == 0)
                frame.setGreen();
            else if (color == 1)
                frame.setRed();
            else if (color == 2)
                frame.setWhite();
            else
                frame.setYellow();

            frame.write(i, y - 4, str0);
            frame.write(i, y - 3, str1);
            frame.write(i, y - 2, str2);
            frame.write(i, y - 1, str3);
            frame.write(i, y, str4);
            frame.write(i, y + 1, str5);
            frame.write(i, y + 2, str6);
            frame.write(i, y + 3, str7);

            frame.finish(0.065);

        }
    }

    public static void FiveBucks(SignBoard board) {
        int width = board.getWidth();
        int y = board.getHeight() / 2;

        String str0 = "    _       _______    _______  _______ ";
        String str1 = " __|_|___  (  ____ \\  (  __   )(  __   )";
        String str2 = "(  _____/  | (    \\/  | (  )  || (  )  |";
        String str3 = "| (|_|__   | (____    | | /   || | /   |";
        String str4 = "(_____  )  (_____ \\   | (/ /) || (/ /) |";
        String str5 = "/\\_|_|) |        ) )  |   / | ||   / | |";
        String str6 = "\\_______)  /\\____) )_ |  (__) ||  (__) |";
        String str7 = "   |_|     \\______/(_)(_______)(_______)";
        for (int i = 10; i < 25; i++) {
            SignBoard.Frame frame = board.newFrame();


            frame.setGreen();


            frame.write(i, y - 4, str0);
            frame.write(i, y - 3, str1);
            frame.write(i, y - 2, str2);
            frame.write(i, y - 1, str3);
            frame.write(i, y, str4);
            frame.write(i, y + 1, str5);
            frame.write(i, y + 2, str6);
            frame.write(i, y + 3, str7);

            frame.finish(0.065);

        }
    }

    public static void DollarSign2(SignBoard board) {
        int width = board.getWidth();
        int y = board.getHeight() / 2;

        String str0 = "    _        _        _    ";
        String str1 = " __|_|___ __|_|___ __|_|___";
        String str2 = "(  _____/(  _____/(  _____/";
        String str3 = "| (|_|__ | (|_|__ | (|_|__ ";
        String str4 = "(_____  )(_____  )(_____  )";
        String str5 = "/\\_|_|) |/\\_|_|) |/\\_|_|) |";
        String str6 = "\\_______)\\_______)\\_______)";
        String str7 = "   |_|      |_|      |_|   ";

        for (int i = 45; i < 53; i++) {
            SignBoard.Frame frame = board.newFrame();

            Random random = new Random();

            int color = random.nextInt(4);
            if (color == 0)
                frame.setGreen();
            else if (color == 1)
                frame.setRed();
            else if (color == 2)
                frame.setWhite();
            else
                frame.setYellow();

            frame.write(i, y - 4, str0);
            frame.write(i, y - 3, str1);
            frame.write(i, y - 2, str2);
            frame.write(i, y - 1, str3);
            frame.write(i, y, str4);
            frame.write(i, y + 1, str5);
            frame.write(i, y + 2, str6);
            frame.write(i, y + 3, str7);

            frame.finish(0.065);

        }
    }

    public static void Get(SignBoard board) {
        int width = board.getWidth();
        int y = board.getHeight() / 2;

        String str0 = "   ___             _     ";
        String str1 = "  / __|    ___    | |_   ";
        String str2 = " | (_ |   / -_)   |  _|  ";
        String str3 = "  \\___|   \\___|   _\\__|  ";
        String str4 = "_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"| ";
        String str5 = "\"`-0-0-'\"`-0-0-'\"`-0-0-' ";

        for (int i = 0; i < 18; i++) {
            SignBoard.Frame frame = board.newFrame();

            Random random = new Random();

            int color = random.nextInt(4);
            if (color == 0)
                frame.setGreen();
            else if (color == 1)
                frame.setRed();
            else if (color == 2)
                frame.setWhite();
            else
                frame.setYellow();

            frame.write(i, y - 3, str0);
            frame.write(i, y - 2, str1);
            frame.write(i, y - 1, str2);
            frame.write(i, y, str3);
            frame.write(i, y + 1, str4);
            frame.write(i, y + 2, str5);


            frame.finish(0.07);

        }
    }

    public static void Some(SignBoard board) {
        int width = board.getWidth();
        int y = board.getHeight() / 2;

        String str0 = "   ___                              _    ";
        String str1 = "  / __|    ___    _ __     ___     | |   ";
        String str2 = "  \\__ \\   / _ \\  | '  \\   / -_)    |_|   ";
        String str3 = "  |___/   \\___/  |_|_|_|  \\___|   _(_)_  ";
        String str4 = "_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_| \"\"\" | ";
        String str5 = "\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-' ";

        for (int i = 24; i < 39; i++) {
            SignBoard.Frame frame = board.newFrame();

            Random random = new Random();

            int color = random.nextInt(4);
            if (color == 0)
                frame.setGreen();
            else if (color == 1)
                frame.setRed();
            else if (color == 2)
                frame.setWhite();
            else
                frame.setYellow();

            frame.write(i, y - 3, str0);
            frame.write(i, y - 2, str1);
            frame.write(i, y - 1, str2);
            frame.write(i, y, str3);
            frame.write(i, y + 1, str4);
            frame.write(i, y + 2, str5);


            frame.finish(0.07);

        }
    }


    public static void airplaneScene(SignBoard board) {
        int w = board.getWidth();
        int y = board.getHeight() / 2;




        String str0 = " ll------------------------------ll                                  ";
        String str1 = "  ll           o __   ___         ll      __                         ";
        String str2 = "   ll          |(___ (__/_         ll     | ll                       ";
        String str3 = "      >__   __   ___   __   __ __    >----|  ll       ______         ";
        String str4 = "   // (___ |  ' (__/_ (__( |  )  ) //     --- ll_____/**|_|_ll____  |";
        String str5 = "  //       VANILLA  CHOCOLATE     //        ll_______ --------- __>-}";
        String str6 = " //------------------------------//            /  ll_____|_____/   | ";
        String str7 = "                                               *         |           ";

        int i = 0;
        for (int x = -str2.length(); x <= w; ++x) {
            SignBoard.Frame frame = board.newFrame();


            if (x >= w)
                break;
            frame.setRed();
            if (x < 0) {
                // Scrolling on to the left side.

                frame.write(0, y - 4, str0.substring(-x));
                frame.write(0, y - 3, str1.substring(-x));
                frame.write(0, y - 2, str2.substring(-x));
                frame.write(0, y - 1, str3.substring(-x));
                frame.write(0, y, str4.substring(-x));
                frame.write(0, y + 1, str5.substring(-x));
                frame.write(0, y + 2, str6.substring(-x));
                frame.write(0, y + 3, str7.substring(-x));
            } else if (x + str1.length() <= w) {

                frame.setYellow();
                frame.write(x, y - 4, str0);
                frame.write(x, y - 3, str1);
                frame.write(x, y - 2, str2);
                frame.write(x, y - 1, str3);
                frame.write(x, y, str4);
                frame.write(x, y + 1, str5);
                frame.write(x, y + 2, str6);
                frame.write(x, y + 3, str7);
            } else {

                frame.setRed();
                // Scrolling off the board.
                frame.write(x, y - 4, str0.substring(0, w - x));
                frame.write(x, y - 3, str1.substring(0, w - x));
                frame.write(x, y - 2, str2.substring(0, w - x));
                frame.write(x, y - 1, str3.substring(0, w - x));
                frame.write(x, y, str4.substring(0, w - x));
                frame.write(x, y + 1, str5.substring(0, w - x));
                frame.write(x, y + 2, str6.substring(0, w - x));
                frame.write(x, y + 3, str7.substring(0, w - x));
            }

            frame.finish(0.02);
        }
    }

    //THIS IS WHERE METHODS GET ACTIVATED/DEACTIVATED
    public static void main(String[] args) throws IOException {
        SignBoard signBoard = new SignBoard(8);
        FrameTextReader fallingCone = new FrameTextReader("falling_cone.txt");
        FrameTextReader fallingConeText = new FrameTextReader("falling_cone_words.txt");
        FrameTextReader hugeCone = new FrameTextReader("huge_cone.txt");

        // Run the sign board forever.
        while (true) {
            scrollingCream(signBoard); //this scrolling text, left to middle, stop then right
            R2D2(signBoard); //this is R2D2
            iceCreamCones(signBoard); // text w/ two cones on the side

            iceCreamAnimation(signBoard, 16);
            threeConeScene(signBoard);
            fallingConeScene(signBoard, fallingCone, fallingConeText);
            scrollHugeScene(signBoard, hugeCone);

            airplaneScene(signBoard);

            DollarSign(signBoard);
            FiveBucks(signBoard);
            DollarSign2(signBoard);
            Get(signBoard);
            Some(signBoard);
        }
    }
}
