package org.mapleir.asm;

import org.mapleir.stdlib.collections.graph.FastGraphVertex;
import org.mapleir.stdlib.util.IHasJavaDesc;
import org.mapleir.stdlib.util.JavaDesc;

public class MethodNode implements FastGraphVertex, IHasJavaDesc {
    private static int ID_COUNTER = 1;
   	private final int numericId = ID_COUNTER++;

   	public final ClassNode owner;
    public final org.objectweb.asm.tree.MethodNode node;

    public MethodNode(org.objectweb.asm.tree.MethodNode node, ClassNode owner) {
        this.node = node;
        this.owner = owner;
    }

    @Override
    public String getDisplayName() {
        return node.name;
    }

    @Override
    public int getNumericId() {
        return numericId;
    }

    @Override
    public String getOwner() {
        return owner.getName();
    }

    @Override
    public String getName() {
        return node.name;
    }

    @Override
    public String getDesc() {
        return node.desc;
    }

    @Override
    public JavaDesc.DescType getDescType() {
        return JavaDesc.DescType.METHOD;
    }

    @Override
    public JavaDesc getJavaDesc() {
	    return new JavaDesc(owner.getName(), getName(), getDesc(), JavaDesc.DescType.METHOD);
    }
}
