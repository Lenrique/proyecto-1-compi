package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class DoWhileCommand extends Command{

    public Command C;
    public Expression E;

    public DoWhileCommand(Command cAST, Expression eAST, SourcePosition thePosition){
        super (thePosition);
        C = cAST;
        E = eAST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitDoWhileCommand(this,o);
    }
}
