package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class NextCommand extends Command {

    Identifier I;

    public NextCommand (Identifier iAST, SourcePosition position){
        super (position);
        I = iAST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return null;
    }
}