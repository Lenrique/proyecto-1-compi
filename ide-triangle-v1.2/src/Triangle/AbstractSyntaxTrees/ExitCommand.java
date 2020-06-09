package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ExitCommand extends Command {

    public Identifier I;

    public ExitCommand (Identifier iAST, SourcePosition position){
        super (position);
        I = iAST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitExitCommand(this, o);
    }
}
