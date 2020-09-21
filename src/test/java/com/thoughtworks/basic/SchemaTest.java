package com.thoughtworks.basic;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
/**
 * 
 * @author wqm
 *
 */
public class SchemaTest {
	
	public Schema schema;
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
	
	
	//java.lang.String
	@Test
	public void should_return_String_when_get_type_given_flag(){
		//given
		Set<FlagSchema> flagSchema = new HashSet<>();
		flagSchema.add(new FlagSchema(ConstantCodeAndValue.CODE_FLAG_D,String.class));
		Schema schema = new Schema(flagSchema);
		//when
		Object type = schema.getTypeOf(ConstantCodeAndValue.CODE_FLAG_D);
		//then
		assertEquals(String.class,type);
	    }
	
	
	@Test
	public void should_return_true_when_get_type_given_flag_l(){
		//given
		Args args = new Args("-l true",schema);
		//when
		Object type = args.getValueOfChar(ConstantCodeAndValue.CODE_FLAG_L);
        //then
		assertEquals(ConstantCodeAndValue.CODE_VALUE_TRUE,type);
	    }	
	
	@Test
	public void should_return_8080_when_get_type_given_flag_p(){
		//given
		Args args = new Args("-l true -p 8080",schema);
		//when
		Object type = args.getValueOfChar(ConstantCodeAndValue.CODE_FLAG_P);
        //then
		assertEquals(ConstantCodeAndValue.CODE_VALUE_INTEGER,type);
	    }	
	
	@Test
	public void should_return_string_when_get_type_given_flag_d(){
		//given
		Args args = new Args("-l true -p 8080 -d /usr/log",schema);
		//when
		Object type = args.getValueOfChar(ConstantCodeAndValue.CODE_FLAG_D);
        //then
		assertEquals("/usr/log",type);
	    }
}
