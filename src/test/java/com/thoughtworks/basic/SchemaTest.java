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
		flagSchema.add(new FlagSchema("l",Boolean.TYPE));
		Schema schema = new Schema(flagSchema);
		//when
		Object type = schema.getTypeOf("l");
		//then
		assertEquals(Boolean.TYPE,type);
	    }
}
