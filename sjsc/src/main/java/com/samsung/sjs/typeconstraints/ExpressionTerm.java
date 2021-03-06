/* 
 * Copyright 2014-2016 Samsung Research America, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.samsung.sjs.typeconstraints;

import org.mozilla.javascript.ast.AstNode;

import com.samsung.sjs.types.AnyType;
import com.samsung.sjs.types.Type;

/**
 * Used for representing the type of various forms of expressions.
 *
 * @author ftip
 *
 */
public class ExpressionTerm extends ATerm {

	public ExpressionTerm(AstNode n){
		super(n);
		this.type = new AnyType();
	}

	@Override
	public String stringRepresentation(){
        return "|" + getNode().toSource() + "|";
	}

	@Override
	public Type getType(){
		return this.type;
	}

	@Override
	public void setType(Type type){
		this.type = type;
	}

	private Type type;
}
