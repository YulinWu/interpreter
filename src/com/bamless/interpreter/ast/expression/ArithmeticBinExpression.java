package com.bamless.interpreter.ast.expression;

import com.bamless.interpreter.ast.visitor.GenericVisitor;
import com.bamless.interpreter.ast.visitor.VoidVisitor;

public class ArithmeticBinExpression extends BinaryExpression {
	public static enum ArithmeticBinOperation {
		PLUS, MINUS, MULT, DIV, MOD;
	}
	private ArithmeticBinOperation operation;

	public ArithmeticBinExpression(ArithmeticBinOperation op, Expression left, Expression right) {
		super(left, right);
		this.operation = op;
	}

	public ArithmeticBinOperation getOperation() {
		return operation;
	}

	@Override
	public <A> void accept(VoidVisitor<A> v, A arg) {
		v.visit(this, arg);
	}
	
	@Override
	public <T, A> T accept(GenericVisitor<T, A> v, A arg) {
		return v.visit(this, arg);
	}
	
	@Override
	public String toString() {
		return "(" + getLeft() +" "+ operation +" "+ getRight() + ")";
	}

}
