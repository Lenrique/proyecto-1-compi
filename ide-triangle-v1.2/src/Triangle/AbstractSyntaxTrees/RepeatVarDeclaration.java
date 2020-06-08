package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class RepeatVarDeclaration extends Declaration{

    public Identifier I;
    public Expression E1;

    public RepeatVarDeclaration (Identifier I, Expression eAST, SourcePosition thePosition){
        super(thePosition);
        this.I = I;
        E1 = eAST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return null;
    }
}
