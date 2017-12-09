package com.bamless.interpreter.ast.statement;

import com.bamless.interpreter.ast.Position;
import com.bamless.interpreter.ast.expression.Expression;
import com.bamless.interpreter.visitor.GenericVisitor;
import com.bamless.interpreter.visitor.VoidVisitor;

public class ForStatement extends Statement {
	private Expression init;
	private Expression cond;
	private Expression act;
	
	private Statement body;

	public ForStatement(Position start, Expression init, Expression cond, Expression act, Statement body) {
		super(start);
		this.init = init;
		this.cond = cond;
		this.act = act;
		this.body = body;
	}

	@Override
	public <T, A> T accept(GenericVisitor<T, A> v, A arg) {
		return v.visit(this, arg);
	}

	@Override
	public <A> void accept(VoidVisitor<A> v, A arg) {
		v.visit(this, arg);
	}

	public Expression getInit() {
		return init;
	}

	public Expression getCond() {
		return cond;
	}

	public Expression getAct() {
		return act;
	}
	
	public Statement getBody() {
		return body;
	}
	
}
