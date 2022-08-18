public class StaticMethods {
    
    public static void main(String[] args) {

        topPart();
        bottomPart();
        middleLine();

        topPart();
        bottomPart();
        middleLine();
        bottomPart();

        topPart();
        middleLine();
        bottomPart();
    }

    public static void topPart() {
        String topLine = "  _______";
        String middleLine = " /       \\";
        String bottomLine = "/         \\";
        System.out.println(topLine);
        System.out.println(middleLine);
        System.out.println(bottomLine);
    }

    public static void middleLine() {
        String middleLine = "-\"-'-\"-'-\"-";
        System.out.println(middleLine);
    }

    public static void bottomPart() {
        String topLine = "\\         /";
        String bottomLine = " \\_______/";
        System.out.println(topLine);
        System.out.println(bottomLine);
    }
}