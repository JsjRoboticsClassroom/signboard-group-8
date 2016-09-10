package nyc.c4q.ac21.signboard;

import java.util.Random;

public class Main {


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

    public static void main(String[] args) {
        SignBoard signBoard = new SignBoard(8);

        // Run the sign board forever.
        while (true) {
            //ribbonScene(signBoard, 48);
            //scrollTextScene(signBoard, "###  F A L A F E L  ###");
            //ribbonScene(signBoard, 48);
            //flashFreshHotScene(signBoard, 8);

            DollarSign(signBoard);
            FiveBucks(signBoard);
            DollarSign2(signBoard);
            Get(signBoard);
            Some(signBoard);


        }
    }


}

