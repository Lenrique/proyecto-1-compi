package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class RestIfCommand extends Command{

    ElsifCommand eAST;
    Command cAST;

    public RestIfCommand(SourcePosition thePosition){
        super(thePosition);
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return null;
    }
}
