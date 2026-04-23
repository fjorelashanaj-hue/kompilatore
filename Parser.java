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

        
        else if (line.matches(".*[+\\-*/]=[^=].*")) {
            
            for (String op : new String[]{"+=", "-=", "*=", "/="}) {
                int idx = line.indexOf(op);
                if (idx != -1) {
                    String varName   = line.substring(0, idx).trim();
                    String rightSide = line.substring(idx + 2).trim();
                    
                    String expandedExpr = varName + " " + op.charAt(0) + " " + rightSide;
                    return new AssignmentInstruction(varName, expandedExpr);
                }
            }
        }

        
        else if (line.contains("=")) {
            int eqIdx = line.indexOf('=');
            String varName   = line.substring(0, eqIdx).trim();
            String expression = line.substring(eqIdx + 1).trim();
            return new AssignmentInstruction(varName, expression);
        }

        throw new IllegalArgumentException("Sintaksë e panjohur ne rreshtin: " + line);
    }
}