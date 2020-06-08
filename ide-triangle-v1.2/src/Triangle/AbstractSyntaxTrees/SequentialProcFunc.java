package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class SequentialProcFunc extends Declaration{

    public Declaration dAST0;
    public Declaration dAST1;

    public SequentialProcFunc (Declaration dAST0, Declaration dAST1, SourcePosition position){
        super(position);
        this.dAST0 = dAST0;
        this.dAST1 = dAST1;
    }


    @Override
    public Object visit(Visitor v, Object o) {
        return null;
    }
}
