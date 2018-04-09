package com.company;

import com.company.grammar.gramLexer;
import com.company.grammar.gramParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.atn.PredictionMode;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    private InputStream is;

    private PrintStream out;

    public Main(InputStream is, PrintStream out) {
        this.is = is;
        this.out = out;
    }

    public static void main(String[] args) {
        InputStream is = null;
        PrintStream ps = null;
        String[] args2 = {"input.in", "output.out"};
        if (args.length == 0) {
            args = args2;
        }
        if (args.length == 0) {
            System.err.println("Reading from stdin");
            is = System.in;
        } else {
            System.err.println("Reading from " + args[0]);
            try {
                is = Files.newInputStream(Paths.get(args[0]));
            } catch (IOException e) {
                System.err.println("Cannot read from " + args[0] + ":" + e.getMessage());
                System.exit(-1);
            }
        }
        if (args.length <= 1) {
            ps = System.out;
        } else {
            System.err.println("Writing to " + args[1]);
            try {
                ps = new PrintStream(Files.newOutputStream(Paths.get(args[1])));
            } catch (IOException e) {
                System.err.println("Cannot write to " + args[1] + ":" + e.getMessage());
                System.exit(-1);
            }
        }
        try {
            new Main(is, ps).parseAll();
            is.close();
            ps.flush();
            ps.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseAll() throws IOException {
        Lexer lexer = new gramLexer(CharStreams.fromStream(is));
        gramParser parser = new gramParser(new CommonTokenStream(lexer));
        parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
        parser.addParseListener(new MyGramListener(out));
        parser.file();
    }
}
