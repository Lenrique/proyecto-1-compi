package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class LoopCommand extends  Command{

    public Identifier I;
    public Command C;

    public LoopCommand (Identifier identifier, Command cAST, SourcePosition position){
       super(position);
       I = identifier;
       C = cAST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitLoopCommand(this, o);
    }
}
