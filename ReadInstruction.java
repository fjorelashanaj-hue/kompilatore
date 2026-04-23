public class ReadInstruction extends Instruction {
    private String varName;

    public ReadInstruction(String varName) {
        this.varName = varName;
    }

    @Override
    public void exec() {
        System.out.print("Vendos vleren per " + varName + ": ");
        int value = Memory.scanner.nextInt();
        Memory.scanner.nextLine(); 
        Memory.variables.put(varName, value);
    }
}