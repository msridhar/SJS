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
/**
 * Field read, specialized for skipping vtable lookup
 *
 * @author colin.gordon
 */
package com.samsung.sjs.backend.asts.ir;
public class PredictedFieldRead extends FieldRead {
    protected int box_ptr_offset;

    // for prophetic reads
    protected boolean isdirect;

    public PredictedFieldRead(Expression o, String f, int off) {
        super(o, f);
        this.tag = Tag.PredictedFieldRead;
        box_ptr_offset = off;
        isdirect = false;
    }

    public int getOffset() { return box_ptr_offset; }

    public boolean isDirect() { return isdirect; }
    public void setDirect() {
        isdirect = true;
    }

    @Override
    public String toSource(int x) {
        return "("+o.toSource(0)+"."+f+"<"+box_ptr_offset+">)";
    }
    @Override
    public <R> R accept(IRVisitor<R> v) {
        return v.visitPredictedFieldRead(this);
    }

    @Override
    public boolean isPure() { return o.isPure(); }
 
}
