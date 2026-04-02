public class Parser {
    
    public static Instruction parseLine(String line) {
        
        line = line.trim();
        
        
        if (line.startsWith("int ")) {
            line = line.substring(4).trim();
        }

        
        if (line.startsWith("Afisho ")) {
            String varName = line.substring(7).trim();
            return new PrintInstruction(varName);
        } 
        else if (line.startsWith("Lexo ")) {
            String varName = line.substring(5).trim();
            return new ReadInstruction(varName);
        } 
        else if (line.contains("=")) {
            String[] parts = line.split("=");
            String varName = parts[0].trim();
            String expression = parts[1].trim();
            return new AssignmentInstruction(varName, expression);
        }
        
        throw new IllegalArgumentException("Sintaksë e panjohur ne rreshtin: " + line);
    }
}