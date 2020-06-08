package Triangle.Test;

import Triangle.AbstractSyntaxTrees.*;

public class XMLConcreteVisitor implements Visitor {

    public String export(Program ast, Object o) {
        StringBuilder sb = new StringBuilder();

        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "\n");
        sb.append(visitProgram(ast,null)).append("\n");
        System.out.println(sb.toString());
        sb.setLength(0);

        return sb.toString();
    }

    @Override
    public Object visitProgram(Program ast, Object o) {
        return "<Program>"+"\n"+
                    ast.C.visit(this,null) + "\n"+
                "</Program>";
    }

    //region Commands READY
    @Override
    public Object visitAssignCommand(AssignCommand ast, Object o) {
        return "<AssignCommand>\n"+
                    ast.V.visit(this,null)+"\n"+
                    ast.E.visit(this,null)+"\n"+
                "</AssignCommand>";
    }

    @Override
    public Object visitCallCommand(CallCommand ast, Object o) {
        return "<CallCommand>\n"+
                    ast.I.visit(this,null)+"\n"+
                    ast.APS.visit(this,null)+"\n"+
                "</CallCommand>";
    }

    @Override
    public Object visitEmptyCommand(EmptyCommand ast, Object o) {
        return "<EmptyCommand/>\n";
    }

    @Override
    public Object visitIfCommand(IfCommand ast, Object o) {
        return "<IfCommand>\n"+
                    ast.E.visit(this,null)+"\n"+
                    ast.C1.visit(this,null)+"\n"+
                    ast.C2.visit(this,null)+"\n"+
                "</IfCommand>";
    }

    @Override
    public Object visitLetCommand(LetCommand ast, Object o) {
        return "<LetCommand>\n"+
                    ast.D.visit(this,null)+"\n"+
                    ast.C.visit(this,null)+"\n"+
                "</LetCommand>";
    }

    @Override
    public Object visitSequentialCommand(SequentialCommand ast, Object o) {
        return "<SequencialCommand>\n"+
                    ast.C1.visit(this,null)+"\n"+
                    ast.C2.visit(this,null)+"\n"+
                "</SequencialCommand>";
    }

    @Override
    public Object visitWhileCommand(WhileCommand ast, Object o) {
        return "<WhileCommand>\n"+
                    ast.E.visit(this,null)+"\n"+
                    ast.C.visit(this,null)+"\n"+
                "</WhileCommand>";
    }

    @Override
    public Object visitUntilCommand(UntilCommand ast, Object o) {
        return "<DoCommand>\n"+
                    ast.C.visit(this,null)+"\n"+
                    ast.E.visit(this,null)+"\n"+
                "</DoCommand>";
    }

    //endregion

    //region Expression READY
    @Override
    public Object visitArrayExpression(ArrayExpression ast, Object o) {
        return "<ArrayExpression>\n"+
                    ast.AA.visit(this,null)+"\n"+
                "</ArrayExpression>";
    }

    @Override
    public Object visitBinaryExpression(BinaryExpression ast, Object o) {
        return "<BinaryExpression>\n"+
                    ast.E1.visit(this,null)+"\n"+
                    ast.O.visit(this,null)+"\n"+
                    ast.E2.visit(this,null)+"\n"+
                "</BinaryExpression>";
    }

    @Override
    public Object visitCallExpression(CallExpression ast, Object o) {
        return "<CallExpression>\n"+
                    ast.I.visit(this,null)+"\n"+
                    ast.APS.visit(this,null)+"\n"+
                "</CallExpression>";
    }

    @Override
    public Object visitCharacterExpression(CharacterExpression ast, Object o) {
        return "<CharacterExpression>\n"+
                    ast.CL.visit(this,null)+"\n"+
                "</CharacterExpression>";
    }

    @Override
    public Object visitEmptyExpression(EmptyExpression ast, Object o) {
        return "<EmptyExpression/>\n";
    }

    @Override
    public Object visitIfExpression(IfExpression ast, Object o) {
        return "<IfExpression>\n"+
                    ast.E1.visit(this,null)+"\n"+
                    ast.E2.visit(this,null)+"\n"+
                    ast.E3.visit(this,null)+"\n"+
                "</IfExpression>";
    }

    @Override
    public Object visitIntegerExpression(IntegerExpression ast, Object o) {
        return "<IntegerExpression>\n"+
                    ast.IL.visit(this,null)+"\n"+
                "</IntegerExpression>";
    }

    @Override
    public Object visitLetExpression(LetExpression ast, Object o) {
        return "<LetExpression>\n"+
                    ast.D.visit(this,null)+"\n"+
                    ast.E.visit(this,null)+"\n"+
                "</LetExpression>";
    }

    @Override
    public Object visitRecordExpression(RecordExpression ast, Object o) {
        return "<RecordExpression>\n"+
                    ast.RA.visit(this,null)+"\n"+
                "</RecordExpression>";
    }

    @Override
    public Object visitUnaryExpression(UnaryExpression ast, Object o) {
        return "<UnaryExpression>\n"+
                    ast.O.visit(this,null)+"\n"+
                    ast.E.visit(this,null)+"\n"+
                "</UnaryExpression>";
    }

    @Override
    public Object visitVnameExpression(VnameExpression ast, Object o) {
        return "<VnameExpression>\n"+
                    ast.V.visit(this,null)+"\n"+
                "</VnameExpression>";
    }

    //endregion

    //region Declaration READY

    @Override
    public Object visitBinaryOperatorDeclaration(BinaryOperatorDeclaration ast, Object o) {

        return "<BinaryOperatorDeclaration>\n"+
                    ast.O.visit(this,null)+"\n"+
                    ast.ARG1.visit(this,null)+"\n"+
                    ast.ARG2.visit(this,null)+"\n"+
                    ast.RES.visit(this,null)+"\n"+
                "</BinaryOperatorDeclaration>";
    }

    @Override
    public Object visitConstDeclaration(ConstDeclaration ast, Object o) {
        return "<ConstantDeclaration>\n"+
                    ast.I.visit(this,null)+"\n"+
                    ast.E.visit(this,null)+"\n"+
                "</ConstantDeclaration>";
    }

    @Override
    public Object visitFuncDeclaration(FuncDeclaration ast, Object o) {
        return "<FunctionDeclaration>\n"+
                    ast.I.visit(this,null)+"\n"+
                    ast.FPS.visit(this,null)+"\n"+
                    ast.T.visit(this,null)+"\n"+
                    ast.E.visit(this,null)+"\n"+
                "</FunctionDeclaration>";
    }

    @Override
    public Object visitProcDeclaration(ProcDeclaration ast, Object o) {
        return "<ProcedureDeclaration>\n"+
                    ast.I.visit(this,null)+"\n"+
                    ast.FPS.visit(this,null)+"\n"+
                    ast.C.visit(this,null)+"\n"+
                "</ProcedureDeclaration>";
    }

    @Override
    public Object visitSequentialDeclaration(SequentialDeclaration ast, Object o) {
        return "<SequentialDeclaration>\n"+
                    ast.D1.visit(this,null)+"\n"+
                    ast.D2.visit(this,null)+"\n"+
                "</SequentialDeclaration>";
    }

    @Override
    public Object visitTypeDeclaration(TypeDeclaration ast, Object o) {
        return "<TypeDeclaration>\n"+
                    ast.I.visit(this,null)+"\n"+
                    ast.T.visit(this,null)+"\n"+
                "</TypeDeclaration>";
    }

    @Override
    public Object visitUnaryOperatorDeclaration(UnaryOperatorDeclaration ast, Object o) {
        return "<UnaryOperatorDeclaration>\n"+
                    ast.O.visit(this,null)+"\n"+
                    ast.ARG.visit(this,null)+"\n"+
                    ast.RES.visit(this,null)+"\n"+
                "</UnaryOperatorDeclaration>";
    }

    @Override
    public Object visitVarDeclaration(VarDeclaration ast, Object o) {
        if(ast.E == null){
            return "<VariableDeclaration>\n"+
                    ast.I.visit(this,null)+"\n"+
                    ast.T.visit(this,null)+"\n"+
                    "</VariableDeclaration>";
        }else{
            return "<VariableDeclaration>\n"+
                    ast.I.visit(this,null)+"\n"+
                    ast.E.visit(this,null)+"\n"+
                    "</VariableDeclaration>";
        }
    }

    //endregion

    //region Aggregates READY

    @Override
    public Object visitMultipleArrayAggregate(MultipleArrayAggregate ast, Object o) {
        return "<MultipleArrayAggregate>\n"+
                    ast.E.visit(this,null)+"\n"+
                    ast.AA.visit(this,null)+"\n"+
                "</MultipleArrayAggregate>";
    }

    @Override
    public Object visitSingleArrayAggregate(SingleArrayAggregate ast, Object o) {
        return "<SimpleArrayAggregate>\n"+
                    ast.E.visit(this,null)+"\n"+
                "</SimpleArrayAggregate>";
    }

    @Override
    public Object visitMultipleRecordAggregate(MultipleRecordAggregate ast, Object o) {
        return "<MultipleRecordAggregate>\n"+
                    ast.I.visit(this,null)+"\n"+
                    ast.E.visit(this,null)+"\n"+
                    ast.RA.visit(this,null)+"\n"+
                "</MultipleRecordAggregate>";
    }

    @Override
    public Object visitSingleRecordAggregate(SingleRecordAggregate ast, Object o) {
        return "<SingleRecordAggregate>\n"+
                    ast.I.visit(this,null)+"\n"+
                    ast.E.visit(this,null)+"\n"+
                "</SingleRecordAggregate>";
    }

    //endregion

    //region Parameter READY

    @Override
    public Object visitConstFormalParameter(ConstFormalParameter ast, Object o) {

        return "<ConstantFormalParameter>"+"\n"+
                    ast.I.visit(this,null)+"\n"+
                    ast.T.visit(this,null)+"\n"+
                "</ConstantFormalParameter>";
    }

    @Override
    public Object visitFuncFormalParameter(FuncFormalParameter ast, Object o) {

        return "<FunctionFormalParameter>"+"\n"+
                    ast.I.visit(this,null)+"\n"+
                    ast.FPS.visit(this,null)+"\n"+
                    ast.T.visit(this,null)+"\n"+
                "</FunctionFormalParameter>";
    }

    @Override
    public Object visitProcFormalParameter(ProcFormalParameter ast, Object o) {

        return "<ProcedureFormalParameter>"+"\n"+
                    ast.I.visit(this,null)+"\n"+
                    ast.FPS.visit(this,null)+"\n"+
                "</ProcedureFormalParameter>";
    }

    @Override
    public Object visitVarFormalParameter(VarFormalParameter ast, Object o) {

        return "<VariableFormalParameter>"+"\n"+
                    ast.I.visit(this,null)+"\n"+
                    ast.T.visit(this,null)+"\n"+
                "</VariableFormalParameter>";
    }

    @Override
    public Object visitEmptyFormalParameterSequence(EmptyFormalParameterSequence ast, Object o) {

        return "</EmptyFormalParameterSequience>\n";
    }

    @Override
    public Object visitMultipleFormalParameterSequence(MultipleFormalParameterSequence ast, Object o) {
        return "<MultipleFormalParameter>"+"\n"+
                    ast.FP.visit(this,null)+"\n"+
                    ast.FPS.visit(this,null)+"\n"+
                "</MultipleFormalParameter>";
    }

    @Override
    public Object visitSingleFormalParameterSequence(SingleFormalParameterSequence ast, Object o) {
        return "<SingleFormalParameter>"+"\n"+
                    ast.FP.visit(this,null)+"\n"+
                "</SingleFormalParameter>";
    }

    //Actual Parameters
    @Override
    public Object visitConstActualParameter(ConstActualParameter ast, Object o) {
        return "<ConstantActualParameter>"+"\n"+
                    ast.E.visit(this,null)+"\n"+
                "</ConstantActualParameter>";
    }

    @Override
    public Object visitFuncActualParameter(FuncActualParameter ast, Object o) {
        return "<FunctionActualParameter>"+"\n"+
                    ast.I.visit(this,null)+"\n"+
                "</FunctionActualParameter>";
    }

    @Override
    public Object visitProcActualParameter(ProcActualParameter ast, Object o) {
        return "<ProcedureActualParameter>"+"\n"+
                    ast.I.visit(this,null)+"\n"+
                "</ProcedureActualParameter>";
    }

    @Override
    public Object visitVarActualParameter(VarActualParameter ast, Object o) {
        return "<VariableActualParameter>"+"\n"+
                    ast.V.visit(this,null)+"\n"+
                "</VariableActualParameter>";
    }

    @Override
    public Object visitEmptyActualParameterSequence(EmptyActualParameterSequence ast, Object o) {
        return "<EmptyActualParameterSequence/>\n";
    }

    @Override
    public Object visitMultipleActualParameterSequence(MultipleActualParameterSequence ast, Object o) {
        return "<MultipleActualParameterSequence>"+"\n"+
                    ast.AP.visit(this,null)+"\n"+
                    ast.APS.visit(this,null)+"\n"+
                "</MultipleActualParameterSequence>";
    }

    @Override
    public Object visitSingleActualParameterSequence(SingleActualParameterSequence ast, Object o) {
        return "<SingleActualParameterSequence>"+"\n"+
                    ast.AP.visit(this,null)+"\n"+
                "</SingleActualParameterSequence>";
    }

    //endregion

    //region Type Denoter READY

    @Override
    public Object visitAnyTypeDenoter(AnyTypeDenoter ast, Object o) {
        return "<Any/>"+"\n";
    }

    @Override
    public Object visitArrayTypeDenoter(ArrayTypeDenoter ast, Object o) {
        return "<ArrayTypeDenoter>"+"\n"+
                    ast.IL.visit(this,null)+"\n"+
                    ast.T.visit(this,null)+"\n"+
                "</ArrayTypeDenoter>";
    }

    @Override
    public Object visitBoolTypeDenoter(BoolTypeDenoter ast, Object o) {
        return "<bool/>"+ "\n";
    }

    @Override
    public Object visitCharTypeDenoter(CharTypeDenoter ast, Object o) {
        return "<char/>"+ "\n";
    }

    @Override
    public Object visitErrorTypeDenoter(ErrorTypeDenoter ast, Object o) {
        return "<error/>"+ "\n";
    }

    @Override
    public Object visitSimpleTypeDenoter(SimpleTypeDenoter ast, Object o) {
        return "<SimpleTypeDenoter>"+"\n"+
                    ast.I.visit(this,null)+"\n"+
                "</SimpleTypeDenoter>";
    }

    @Override
    public Object visitIntTypeDenoter(IntTypeDenoter ast, Object o) {
        return "<error/>"+ "\n";
    }

    @Override
    public Object visitRecordTypeDenoter(RecordTypeDenoter ast, Object o) {
        return "<RecordTypeDenoter>"+"\n"+
                    ast.FT.visit(this,null)+"\n"+
                "</RecordTypeDenoter>";
    }

    @Override
    public Object visitMultipleFieldTypeDenoter(MultipleFieldTypeDenoter ast, Object o) {
        return "<MultipleFieldTypeDenoter>"+"\n"+
                    ast.I.visit(this,null)+"\n"+
                    ast.T.visit(this,null)+"\n"+
                    ast.FT.visit(this,null)+"\n"+
                "</MultipleFieldTypeDenoter>";
    }

    @Override
    public Object visitSingleFieldTypeDenoter(SingleFieldTypeDenoter ast, Object o) {
        return "<SingleFieldTypeDenoter>"+"\n"+
                    ast.I.visit(this,null)+"\n"+
                    ast.T.visit(this,null)+"\n"+
                "</SingleFieldTypeDenoter>";
    }

    //endregion

    //region Literals, Identifiers and Operators READY

    @Override
    public Object visitCharacterLiteral(CharacterLiteral ast, Object o) {
        return "<CharacterLiteral value = "+'"'+ast.spelling+'"'+"/>";
    }

    @Override
    public Object visitIdentifier(Identifier ast, Object o) {
        return "<Identifier value = "+'"'+ast.spelling+'"'+"/>";
    }

    @Override
    public Object visitIntegerLiteral(IntegerLiteral ast, Object o) {
        return "<IntegerLiteral value = "+'"'+ast.spelling+'"'+"/>";
    }

    @Override
    public Object visitOperator(Operator ast, Object o) {
        return "<Operator value = "+'"'+ast.spelling+'"'+"/>";
    }

    //endregion

    //region  values or Variable Names READY

    @Override
    public Object visitDotVname(DotVname ast, Object o) {

        return "<DotVname>"+"\n"+
                    ast.I.visit(this,null) + "\n"+
                    ast.V.visit(this,null) + "\n"+
                "</DotVname>";
    }

    @Override
    public Object visitSimpleVname(SimpleVname ast, Object o) {
        return "<SimpleVname>"+"\n"+
                    ast.I.visit(this,null) + "\n"+
                "</SimpleVname>";
    }

    @Override
    public Object visitSubscriptVname(SubscriptVname ast, Object o) {
        return "<SubscriptVname>"+"\n"+
                    ast.V.visit(this,null) + "\n"+
                    ast.E.visit(this,null) + "\n"+
                "</SubscriptVname>";
    }

    //endregion

}
