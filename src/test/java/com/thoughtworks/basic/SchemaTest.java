package com.thoughtworks.basic;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
/**
 * 
 * @author wqm
 *
 */
public class SchemaTest {

	@Test
	public void should_return_boolean_when_get_type_given_flag(){
		//given
		Set<FlagSchema> flagSchema = new HashSet<>();
		flagSchema.add(new FlagSchema(ConstantCodeAndValue.CODE_FLAG_L,Boolean.TYPE));
		Schema schema = new Schema(flagSchema);
		//when
		Object type = schema.getTypeOf(ConstantCodeAndValue.CODE_FLAG_L);
		//then
		assertEquals(Boolean.TYPE,type);
	    }
	
	@Test
	public void should_return_Integer_when_get_type_given_flag(){
		//given
		Set<FlagSchema> flagSchema = new HashSet<>();
		flagSchema.add(new FlagSchema(ConstantCodeAndValue.CODE_FLAG_P,Integer.TYPE));
		Schema schema = new Schema(flagSchema);
		//when
		Object type = schema.getTypeOf(ConstantCodeAndValue.CODE_FLAG_P);
		//then
		assertEquals(Integer.TYPE,type);
	    }
	
}
