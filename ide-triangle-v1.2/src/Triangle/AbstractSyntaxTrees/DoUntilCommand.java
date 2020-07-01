package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class DoUntilCommand extends Command{

    public Command C;
    public Expression E;

    public DoUntilCommand(Command cAST, Expression eAST, SourcePosition thePosition){
        super (thePosition);
        C = cAST;
        E = eAST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitDoUntilCommand(this,o);
    }
}
