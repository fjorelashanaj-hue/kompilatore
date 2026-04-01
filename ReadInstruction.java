import java.util.Scanner;

public class ReadInstruction extends Instruction {
    private String varName;
    
    private static Scanner scanner = new Scanner(System.in);

    public ReadInstruction(String varName) {
        this.varName = varName;
    }

    @Override
    public void exec() {
        System.out.print("Vendos vleren per " + varName + ": ");
        int value = scanner.nextInt();
        
        Memory.variables.put(varName, value);
    }
}