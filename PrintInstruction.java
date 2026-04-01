public class PrintInstruction extends Instruction {
    private String varName;

    public PrintInstruction(String varName) {
        this.varName = varName;
    }

    @Override
    public void exec() {
        if (Memory.variables.containsKey(varName)) {
            System.out.println(Memory.variables.get(varName));
        } else {
            System.out.println("Gabim: Variabli '" + varName + "' nuk ka vlerë!");
        }
    }
}