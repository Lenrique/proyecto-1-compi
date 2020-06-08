package Triangle.SyntacticAnalyzer;

import Triangle.SyntacticAnalyzer.Scanner;
import Triangle.SyntacticAnalyzer.Token;

public class TestHTML {

    public Token currentToken;



    public TestHTML(Scanner scanner){
        currentToken = scanner.scan();
        while (currentToken.kind != Token.EOT){
            System.out.print(currentToken.spelling+" "+tipoToken(currentToken)+ "\n");
            currentToken = scanner.scan();
        }
        // Saber el tipo de token que viene
/*
        o Palabras reservadas: en color negro y en negrita. Por ejemplo: while, then
        o Identificadores, operadores y separadores: en color negro y sin ningún resaltado. Por ejemplo:
        contador, >=, [
        o Literales (caracteres y numerales): en color azul oscuro. Por ejemplo: 101, 'a'
        o Comentarios: en color verde medio. Por ejemplo: ! Este es un comentario

        */

    }

    String tipoToken(Token token){

        int Iliteral = 0, Fliteral = 1;
        int Ireservada = 4, Freservada = 24;

        if(token.kind >= Iliteral && token.kind <= Fliteral){ //El token es un literal.
            return "<span class=\"literal\">3</span>";
        }else if(token.kind >= Ireservada && token.kind <= Freservada){ //El token es una palabra reservada
            return "<span class=\"reservedword\">"+token.spelling+"</span>";
        }

        return "Otra Cosa";
    }

}
