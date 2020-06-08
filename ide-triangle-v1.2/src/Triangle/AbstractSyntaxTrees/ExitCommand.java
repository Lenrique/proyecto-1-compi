package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ExitCommand extends Command {

    Identifier I;

    public ExitCommand (Identifier iAST, SourcePosition position){
        super (position);
        I = iAST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return null;
    }
}
