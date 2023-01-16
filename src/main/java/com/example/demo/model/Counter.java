package com.example.demo.model;

import java.util.Locale;
import java.util.Set;

import org.thymeleaf.context.IContext;

public class Counter implements IContext {
    private int count;

    public Counter(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increment() {
        this.count++;
    }

	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsVariable(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<String> getVariableNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getVariable(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}