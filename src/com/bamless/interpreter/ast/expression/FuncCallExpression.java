package com.bamless.interpreter.ast.expression;

import java.util.Collections;
import java.util.List;

import com.bamless.interpreter.ast.Identifier;
import com.bamless.interpreter.ast.visitor.GenericVisitor;
import com.bamless.interpreter.ast.visitor.VoidVisitor;

public class FuncCallExpression extends Expression {
	private Identifier funcName;
	private List<Expression> args;
	
	public FuncCallExpression(Identifier funcName, List<Expression> args) {
		super(funcName.getPosition());
		this.args = args;
		this.funcName = funcName;
	}

	@Override
	public <T, A> T accept(GenericVisitor<T, A> v, A arg) {
		return v.visit(this, arg);
	}

	@Override
	public <A> void accept(VoidVisitor<A> v, A arg) {
		v.visit(this, arg);
	}
	
	public Identifier getFuncName() {
		return funcName;
	}
	
	public List<Expression> getArgs() {
		return Collections.unmodifiableList(args);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(funcName.getVal() + "(");
		if(args != null) {
			for(int i = 0; i < args.size(); i++) {
				sb.append(args.get(i));
				if(i < args.size() - 1) sb.append(", ");
			}
		}
		sb.append(")");
		return sb.toString();
	}
}
