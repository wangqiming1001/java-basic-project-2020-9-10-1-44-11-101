package com.thoughtworks.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author wqm
 *
 */
public class Args {
  
	private String args;
	private Schema schema;

    public Args(String argsTest, Schema schema) {
    	this.args = argsTest;
    	this.schema = schema;
    }

    public List<KeyAndValuePair> scan() {
    	List<String> keyValues = Arrays.asList(args.split("-"));
    	keyValues = keyValues.stream().map(keyValue -> keyValue.trim()).collect(Collectors.toList());
    	keyValues = keyValues.subList(1,keyValues.size());

		List<KeyAndValuePair> KeyAndValuePairs = new ArrayList<KeyAndValuePair>();
		keyValues.forEach(keyValue -> {
			String[] splitKeyValue = keyValue.split(" ");
			String key = splitKeyValue[0];
			String value = splitKeyValue[1];
			KeyAndValuePairs.add(new KeyAndValuePair(key,value));
		});
		return KeyAndValuePairs;
    }

	public Object getValueOf(String flag) {
		List<KeyAndValuePair> KeyAndValuePairs = scan();
		Object value =  KeyAndValuePairs.stream()
              .filter(keyValue -> flag.equals(keyValue.getKey()))
              .findFirst()
              .map(KeyAndValuePair::getValue).orElse(null);

		Object type = schema.getTypeOf(flag);
		//强制类型转换
		//如果为boolean型
		if(type.equals(Boolean.TYPE)){
			value = Boolean.parseBoolean(value.toString());
		}
		//如果为整型
		if(type.equals(Integer.TYPE)){
			value = Integer.parseInt(value.toString());
		}
		return value;
	}
}
