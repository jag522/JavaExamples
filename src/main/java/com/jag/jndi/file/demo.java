package com.jag.jndi.file;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

class demo {
    public static void main(String[] args) {

	Hashtable env = new Hashtable();
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
    "com.sun.jndi.fscontext.FSContextFactory");

	try {
	    Context ctx = new InitialContext(env);
	    System.out.println(ctx.lookup("file:///d:/NotePad.txt"));
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}