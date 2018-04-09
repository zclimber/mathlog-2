package com.company;

import com.company.grammar.gramParser;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DeductionWriter {
    enum ProofType {
        Axiom, ModusPonens, Self, ForallInference, ExistsInference
    }

    private static Map<ProofType, List<String>> proofs = new HashMap<>();

    static {
        try {
            proofs.put(ProofType.Axiom, Files.lines(Paths.get("res/axiom.txt")).collect(Collectors.toList()));
            proofs.put(ProofType.ModusPonens, Files.lines(Paths.get("res/mp.txt")).collect(Collectors.toList()));
            proofs.put(ProofType.Self, Files.lines(Paths.get("res/self.txt")).collect(Collectors.toList()));
            proofs.put(ProofType.ForallInference, Files.lines(Paths.get("res/forall.txt")).collect(Collectors.toList()));
            proofs.put(ProofType.ExistsInference, Files.lines(Paths.get("res/exists.txt")).collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private boolean write = false;
    private final String targetString;
    private final PrintStream out;

    public DeductionWriter(gramParser.ExpressionContext target, PrintStream out) {
        this.out = out;
        this.targetString = target == null ? null : mask(target.getText());
    }

    public void reset() {
        write = false;
    }

    private String mask(String str) {
        return "(" + str + ")";
    }

    public void printMP(gramParser.ExpressionContext context) {
        if (write || targetString == null) {
            return;
        }
        write = true;
        String fromStr = mask(context.disj().getText());
        String toStr = mask(context.expression().getText());
        for (String string : proofs.get(ProofType.ModusPonens)) {
            out.println(string
                    .replace("_A", fromStr)
                    .replace("_B", toStr)
                    .replace("_T", targetString));
        }
    }

    public void printSelf() {
        if (write || targetString == null) {
            return;
        }
        write = true;
        for (String string : proofs.get(ProofType.Self)) {
            out.println(string
                    .replace("_T", targetString));
        }
    }

    public void printInfer(ProofType type, ParserRuleContext from, ParserRuleContext to, String variable) {
        if (write || targetString == null) {
            return;
        }
        write = true;
        String fromStr = mask(from.getText());
        String toStr = mask(to.getText());
        for (String string : proofs.get(type)) {
            out.println(string
                    .replace("_A", fromStr)
                    .replace("_B", toStr)
                    .replace("_d", variable)
                    .replace("_T", targetString));
        }
    }

    public void print(gramParser.RootExpressionContext context) {
        if (write) {
            return;
        }
        write = true;
        if (targetString == null) {
            out.println(context.getText());
        } else {
            String str = "(" + context.getText() + ")";
            for (String string : proofs.get(ProofType.Axiom)) {
                out.println(string
                        .replace("_A", str)
                        .replace("_T", targetString));
            }
        }
    }
}
