package com.thoughtworks.basic;

import java.util.Set;
/**
 * 
 * @author wqm
 *
 */
public class Schema {
    
	private  Set<FlagSchema> flagSchema;

    public Schema(Set<FlagSchema> flagSchema) {
        this.flagSchema = flagSchema;
    }

    public Object getTypeOf(String flag) {
        return flagSchema.stream().filter(x -> x.equalsWith(flag)).findFirst().get().getType();
    }
}
