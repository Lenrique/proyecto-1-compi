package Triangle.Test;

import Triangle.AbstractSyntaxTrees.Identifier;
import Triangle.SyntacticAnalyzer.SourcePosition;

public class IdGenerator {

    int counter = 1;

    public Identifier getID(SourcePosition position){
        String id = "#"+counter;
        counter++;
        return new Identifier(id, position);
    }
    public Identifier getDefaultID(SourcePosition position){
        String id = "#0";
        return new Identifier(id, position);
    }

}
