package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class RepeatVarCommand extends Command {

    public RepeatVarDeclaration repeatVarDeclaration;
    public Expression E2;
    public Command C;

    public RepeatVarCommand (RepeatVarDeclaration rvdAST, Expression eAST, Command cAST , SourcePosition thePosition){
        super(thePosition);
        repeatVarDeclaration = rvdAST;
        E2 = eAST;
        C = cAST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return null;
    }
}
