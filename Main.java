public class Main {
    public static void main(String[] args) {

        System.out.println("Gjuha Ime Interaktive");
        System.out.println("Shkruaj komandat (p.sh: a = 5, b = a * 2, Afisho b).");
        System.out.println("Shkruaj 'Mbyll' per te perfunduar.\n");

        while (true) {
            System.out.print(">> ");
            String rresht = Memory.scanner.nextLine().trim();

            if (rresht.equalsIgnoreCase("Mbyll")) {
                break;
            }

            if (rresht.isEmpty()) {
                continue;
            }

            try {
                if (rresht.endsWith(";")) {
                    rresht = rresht.substring(0, rresht.length() - 1);
                }

                Instruction instruksioni = Parser.parseLine(rresht);
                instruksioni.exec();

            } catch (Exception e) {
                System.out.println("Gabim Sintakse: " + e.getMessage());
            }
        }

        System.out.println("\nProgrami perfundoi");
    }
}