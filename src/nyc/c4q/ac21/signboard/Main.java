
        package nyc.c4q.ac21.signboard;

        import java.util.Random;

public class Main {
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

    /**
     * Draws a scene with text scrolling across the screen..
     * @param board
     *   The board on which to draw.
     * @param text
     *   The text to scroll.
     */
    public static void scrollTextScene(SignBoard board, String text) {
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

            frame.finish(0.02);
        }
    }

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
                frame.write(leftPosition, y - 2, "FFFF RRR  EEEE  SSS H  H");
                frame.write(leftPosition, y - 1, "F    R RR E    SS   H  H");
                frame.write(leftPosition, y    , "FFR  RRR  EEE   SS  HHHH");
                frame.write(leftPosition, y + 1, "F    R R  E      SS H  H");
                frame.write(leftPosition, y + 2, "F    R  R EEEE SSS  H  H");
            }
            else {
                frame.write(rightPosition, y - 2, "H  H  OO  TTTT");
                frame.write(rightPosition, y - 1, "H  H O  O  TT ");
                frame.write(rightPosition, y    , "HHHH O  O  TT ");
                frame.write(rightPosition, y + 1, "H  H O  O  TT ");
                frame.write(rightPosition, y + 2, "H  H  OO   TT ");
            }

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




    public static void main(String[] args) {
        SignBoard signBoard = new SignBoard(8);

        // Run the sign board forever.
        while (true) {
//            ribbonScene(signBoard, 48);
//            scrollTextScene(signBoard, "###  F A L A F E L  ###");
//            ribbonScene(signBoard, 48);
//            flashFreshHotScene(signBoard, 8);

            airplaneScene(signBoard);
        }
    }
}
