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
	private List<Arg> argList;
	
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
		Object value = getValueOfChar(flag);
		Object type = schema.getTypeOf(flag);
		//强制类型转换
		//如果为boolean型
		if(type.equals(Boolean.TYPE)){
			value = Boolean.parseBoolean(value.toString());
		} else if(type.equals(Integer.TYPE)){
			//如果为整型
			value = Integer.parseInt(value.toString());
		} else if(type instanceof java.lang.String){
			//如果为字符串
			value = value.toString();
		}else {
			throw new SchemaExcpetion("输入信息格式错误，请核实后重新输入");
		}
		String checkValue = value.toString();
		Arg arg = new Arg(flag,checkValue);
		try {
			checkFlag(argList,arg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public void checkFlag(List<Arg> args,Arg arg) throws Exception {
        for(Arg a : args){
            if(arg.getFlag().equals(a.getFlag())){
            	throw new SchemaExcpetion("输入flg重复，请核实");
            }
        }
	}
	
	
	public Object getValueOfChar(String flag) {
		List<KeyAndValuePair> KeyAndValuePairs = scan();
		if(ConstantCodeAndValue.CODE_VALUE_NULL.equalsIgnoreCase(flag)) {
			throw new SchemaExcpetion("输入信息格式错误，请核实后重新输入");
		}
		Object value =  KeyAndValuePairs.stream()
              .filter(keyValue -> flag.equals(keyValue.getKey()))
              .findFirst()
              .map(KeyAndValuePair::getValue).orElse(null);
		return value;
	}
}
